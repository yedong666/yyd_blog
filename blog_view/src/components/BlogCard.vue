<template>
  <div class="blogCardContainer">
    <el-container>
      <el-aside width="35%" v-if="flag">
         <div class="categories" style="float: top">
                  <el-tag>{{tags[0]}}</el-tag>
                  <el-tag type="success">{{tags[1]}}</el-tag>
                  <el-tag type="info">{{tags[2]}}</el-tag>
            </div>
          <el-image :src="this.$server.path + article.coverImage" style="float: top" v-if="article.coverImage != null">

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
            <label for="" @click="clickOrCancelLike" :style="likeStyle"><i class="el-icon-thumb"></i> {{article.numberOfLike}}</label>
            <label for=""><i class="el-icon-chat-dot-square"></i> {{article.numberOfComment}}</label>
            <el-link style="float: right; margin-right: 20px" @click="jumpToArticleView">阅读全文</el-link>
        </el-footer>
      </el-container>
    </el-container>
  </div>
</template>

<script>

import {clickLike, cancelLike} from '@/apis/articles'

export default {
    name: 'BlogCard',
    data(){
        return{
          flag: true,
          likeFlag: false,
          likeStyle: '',
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
      },
      clickOrCancelLike(){
        let userId = this.$store.state.user == null ? 0 : this.$store.state.user.id
        let articleId = this.article.id;
        if(!this.likeFlag){
          this.likeFlag = true
          this.likeStyle = "color:#68a5e1"
          clickLike(userId, articleId)
          this.article.numberOfLike += 1
        }else{
          this.likeStyle = ""
          cancelLike(userId, articleId)
          this.article.numberOfLike -= 1
          this.likeFlag = false
        }
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
      box-shadow: 5px 5px 5px 5px gray;
      border-radius: 15px;
      margin: 40px 40px;
      margin-top: 20px;
      width: 90%;
  }

  .blogCardContainer .el-main{
    font-size: 15px;
  }

  .blogCardContainer .el-header, .el-footer {
    border-radius: 0 15px 0 0;
    background-color: white;
    border: 1px solid #f0f2f7;
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
    background-color: white;
    border: 1px solid #f0f2f7;
    border-right: 0;
    color: #333;
    text-align: center;
    height: 310px;
    padding: 0;
    overflow: hidden;
}
  
 .blogCardContainer .el-main {
    background-color: white;
    color: #333;
    text-align: left;
    border-right: 1px solid rgb(143, 167, 182);
    border-left: 1px solid #f0f2f7;
    line-height: 30px;
    height: 180px;
}

.blogCardContainer .el-main p{
  overflow: hidden;
}

  .blogCardContainer .el-image{
    border-radius: 10px;
    width: 96%;
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

</style>
