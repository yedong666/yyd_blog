# 个人博客(yyd_blog)
## 一、系统技术架构
### 1. 前端技术架构
    使用了Vue2 + Vue-Cli + element-ui + Axios在此不过多叙述
### 2. 后端技术架构
#### (1) 使用编程语言: Java
#### (2) 使用的框架技术: SpringBoot(包含Spring和SpringMvc)、SpringSecurity(权限控制)、Mybatis-Plus(持久层ORM框架)、LogBack(日志框架)
#### (3) 使用数据库: Mysql
#### (4) 中间件: Redis、RabbitMQ、ES
#### (5) 文档生成工具: Swagger
#### (6) 使用框架或技术完成的一些核心的功能
    1. 使用Mybayis-Plus完成一些基本的增删改查任务, 在此贴出一份具有代表性的SQL语句,其功能是根据热度查询文章
         <select id="getArticlesOrderByHot" parameterType="Integer" resultMap="BaseResultMap">
            SELECT id, title, (a.numberOfLike*10 + a.numberOfComment*10 + a.numberOfView) as hotValue FROM yyd_blog.article as a order by hotValue desc limit #{num};
         </select>  

    2. 使用Redis和RabbitMQ同步文章点赞数、浏览数到数据库; 具体逻辑如下:   
        - 当用户浏览一篇文章或者进行了点赞亦或是取消点赞操作时，便会产生对应操作记录存与Redis中，同时将所操作的文章Id也存入Redis的一个Set中
        - 定时向RabbitMQ发送一条同步数据的Message, MQ监听器执行对应同步数据操作, 这里主要起到一个流量削峰的作用
        - 首先需要获取Redis中所有操作记录和被操作文章的Id集，然后从数据库获取对应文章列表存于一个HashMap里(以ID为键)
        - 遍历所有操作记录, 根据操作类型修改对应Id的文章属性，然后将Map转为List批量更新(这里查询文章集和更新文章集都是批量操作，也就是说应当只发生了两次数据库连接)  

    3. 使用ES、Mysql、Redis实现了三种不同的搜索功能
        - 使用ES对应接口进行搜索
        - 使用Mysql模糊查询进行搜索
        - 使用Redis的Set进行交集操作查找对应关键词集合的文章集合; 具体流程如下:  
            - 对所有文章进行分词(当数据量过大时仅仅对热门文章分词), 以词语为键, Set为值, Set里存储具有该词语的文章Id
            - 使用中文分词工具对用户输入关键词字符串进行分词，获取到对应关键词的几个Set, 在对这几个Set进行交集操作，获取到对应搜索的文章
            - 这种方法，就速度而言应当是比Mysql模糊查询要快的，之所以选择这种方式，一个主要的原因是云服务器内存太小，ES经常奔溃
        -最后使用策略模式和Spring的Map注入，达到根据配置来选择不同的搜索模式:
        `
           public class MySearchContext{
                 @Autowired
                 private Map<String, MySearchStrategy> mySearchStrategyMap;
           }
            MySearchStrategy为一个搜索策略接口，有上述三种不同的实现类  
            MySearchContext持有策略集
        `  

    4、使用了SpringSecurity + Jwt来实现用户认证授权操作
        - 在此系统中主要包含4中用户等级包括：游客、普通用户、管理员、站长(root)
        - 主要通过过滤器来实现登录校验，使用SpringSecurity提供的注解来实现接口的权限控制  

    5. 使用Docker搭建ELK日志收集与可视化平台
 
## 二、系统部署架构
### 1. 使用的物理设备: 1核2G云服务器1台; 2核4G云服务器1台
### 2. 2个Mysql服务，一主一从
### 3. Redis、MQ、ES、Logstash、Kibana各有一个实例
### 4. 1个Nginx服务, 用于部署前端项目，同时进行负载均衡
### 5. 4个后端项目实例， 打成Jar包运行
### 6. 系统架构图：
![这是图片](img.png "Magic Gardens")
