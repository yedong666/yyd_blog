<template>
  <div class="blogCardContainer">
    <el-container>
      <el-aside width="35%" v-if="flag">
         <div class="categories" style="float: top">
                  <el-tag>{{tags[0]}}</el-tag>
                  <el-tag type="success">{{tags[1]}}</el-tag>
                  <el-tag type="info">{{tags[2]}}</el-tag>
            </div>
          <el-image :src="article.coverImage" style="float: top" v-if="article.coverImage != null">

          </el-image>
           
      </el-aside>
      <el-container>
        <el-header>
            <h3>
                {{article.title}}
            </h3>
        </el-header>
        <el-main >
            <p>
                {{article.summarize}}
            </p>
        </el-main>
        <el-footer>
            <label for=""><i class="el-icon-view"></i> {{article.numberOfView}}</label>
            <label for=""><i class="el-icon-thumb"></i> {{article.numberOfLike}}</label>
            <label for=""><i class="el-icon-chat-dot-square"></i> {{article.numberOfComment}}</label>
            <el-link style="float: right; margin-right: 20px" @click="jumpToArticleView">阅读全文</el-link>
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
          flag: true,
            // article: {
            //     title: 'Java的前世今生',
            //     content: 'Java是一门面向对象编程语言，不仅吸收了C++语言的各种优点，还摒弃了C++里难以理解的多继承、指针等概念,' +
            //                'Java语言作为静态面向对象编程语言的代表，' +
            //                 '极好地实现了面向对象理论，允许程序员以优雅的思维方式进行复杂的编程。Java具有简单性、面向对象、' +
            //                 '分布式、健壮性、安全性、平台独立与可移植性、多线程、动态性等特点......',
            //     categories: ['分享生活', '技术交流', '项目分析'],
            //     comments: 10,
            //     thumbUpFor: 45,
            //     numberOfBorwse: 19,
            //     image: 'https://img1.baidu.com/it/u=3857894473,1215456774&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=334',
            // }
            tags: [],
        }
    },
    props:{
      article: Object,
    },
    mounted(){
     
    if (document.body.clientWidth < 480){
      this.flag = false
    }
  
      console.log(this.article)
      this.tags = this.article.tags.split(',')
      this.article.tags = this.tags
    },
    methods:{
      jumpToArticleView(){
        this.$router.push({
            path: '/blogview',
            query:{
              articleId:Number( this.article.id)
            }
          })
      }
    }
   

}
</script>

<style scoped>
  @media screen and (max-width: 768px) {
    .blogCardContainer{
      width: 98%;
      margin: auto;
    }
  }

  @media screen and (min-width: 1200px){
     .blogCardContainer{
      box-shadow: 10px 10px 10px 10px gray;
      border-radius: 15px;
      margin: 50px 50px;
      margin-top: 20px;
      width: 90%;
  }

  .blogCardContainer .el-main{
    font-size: 15px;
  }

  .blogCardContainer .el-header, .el-footer {
    border-radius: 0 15px 0 0;
    background-color: #E9EEF3;
    border: 1px solid rgb(83, 53, 53);
    color: #333;
    text-align: center;
    line-height: 60px;
}

.blogCardContainer .el-footer{
    border-radius: 0 0 15px 0;
}

.blogCardContainer .el-footer label{
    float: left;
     margin-right: 5px;
    margin-left: 10px;
}
  
  .blogCardContainer .el-aside {
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
  
 .blogCardContainer .el-main {
    background-color: #E9EEF3;
    color: #333;
    text-align: left;
    border-right: 1px solid gray;
    border-left: 1px solid gray;
    line-height: 30px;
    height: 180px;
}

.blogCardContainer .el-main p{
  overflow: hidden;
}

  .blogCardContainer .el-image{
    border-radius: 10px;
    width: 180px;
    height: 250px;
    margin: 10px auto;
  }

  .blogCardContainer .categories{
      top: 0;
      left: 0;
      margin: 0;
      padding: 0;
      width: 100%;
  }

  .blogCardContainer .el-tag{
      top: 10px;
      width: 60px;
      margin-right: 5px; 
      margin-top: 5px;
  }
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
