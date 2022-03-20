<template>
  <div class="blogCard">
    <el-container>
      <el-aside style="width:220px;">
          <el-image :src='article.image'>

          </el-image>
            <div class="categories">
                  <el-tag style="left: 14px;">{{article.categories[0]}}</el-tag>
                  <el-tag type="success" style="left: 74px;">{{article.categories[1]}}</el-tag>
                  <el-tag type="info" style="left: 144px;">{{article.categories[2]}}</el-tag>
            </div>
      </el-aside>
      <el-container style="width: 400px">
        <el-header>
            <h3>
                {{article.title}}
            </h3>
        </el-header>
        <el-main >
            <p>
                {{article.content}}
            </p>
        </el-main>
        <el-footer>
            <label for=""><i class="el-icon-view"></i> {{article.numberOfBorwse}}</label>
            <label for=""><i class="el-icon-thumb"></i> {{article.thumbUpFor}}</label>
            <label for=""><i class="el-icon-chat-dot-square"></i> {{article.comments}}</label>
            <el-link style="float: right; margin-right: 20px">阅读全文</el-link>
        </el-footer>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
    name: 'BlogCard',
    data(){
        return{
            article: {
                title: 'Java的前世今生',
                content: 'Java是一门面向对象编程语言，不仅吸收了C++语言的各种优点，还摒弃了C++里难以理解的多继承、指针等概念,' +
                           'Java语言作为静态面向对象编程语言的代表，' +
                            '极好地实现了面向对象理论，允许程序员以优雅的思维方式进行复杂的编程。Java具有简单性、面向对象、' +
                            '分布式、健壮性、安全性、平台独立与可移植性、多线程、动态性等特点......',
                categories: ['分享生活', '技术交流', '项目分析'],
                comments: 10,
                thumbUpFor: 45,
                numberOfBorwse: 19,
                image: 'https://img1.baidu.com/it/u=3857894473,1215456774&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=334',
            }
        }
    }
}
</script>

<style scoped>
  .blogCard{
      box-shadow: 10px 10px 10px 10px gray;
      border-radius: 15px;
      margin-top: 20px;
      margin-bottom: 60px;
      margin-left: auto;
      margin-right: auto;
      width: 1000px;
  }
  .el-header, .el-footer {
    border-radius: 0 15px 0 0;
    background-color: #E9EEF3;
    border: 1px solid rgb(83, 53, 53);
    color: #333;
    text-align: center;
    line-height: 60px;
}

.el-footer{
    border-radius: 0 0 15px 0;
}

.el-footer label{
    float: left;
    margin-left: 10px;
}
  
  .el-aside {
    position: relative;
    border-radius: 15px 0 0 15px;
    background-color: #E9EEF3;
    border: 1px solid gray;
    border-right: 0;
    color: #333;
    text-align: center;
    height: 310px;
    padding: 0;
    overflow: hidden;
}
  
  .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: left;
    border-right: 1px solid gray;
    border-left: 1px solid gray;
    line-height: 30px;
    height: 180px;
}

  .el-image{
      border-radius: 10px;
    width: 180px;
    height: 250px;
    margin: 50px auto;
  }

  .categories{
      position: absolute;
      top: 0;
      left: 0;
      margin: 0;
      padding: 0;
      width: 200px;
      height: 200px;
  }

  .el-tag{
      position: absolute;
      top: 10px;
      width: 60px; 
      opacity: 60%;
  }

  label{
    margin-right: 5px;
  }


  
  /* body > .el-container {
    margin-bottom: 40px;
  }
  
  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 260px;
  }
  
  .el-container:nth-child(7) .el-aside {
    line-height: 320px;
  } */
</style>
