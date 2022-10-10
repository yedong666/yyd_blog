<template>
  <div class="container">
      <div class="top">
          <img :src="this.$server.path + article.coverImage" v-if="article.coverImage != null">
      </div>
      <div class="middle">
          <ul class="title">
              <li>
                  {{article.title}}
              </li>
          </ul>
          <ul class="tags">
              <li><el-button type="primary" plain>生活随笔</el-button></li>
              <li><el-button type="success" plain>技术分享</el-button></li>
              <li><el-button type="info" plain>知识总结</el-button></li>
          </ul>
          <ul class="msg">
              <li><i class="el-icon-s-check"></i>作者: 佚名</li>
              <li><i class="el-icon-s-order"></i>发表于: 2022-40-24 14:58</li>
          </ul>
      </div>
      <div class="bottom">
        <p>
         {{article.summarize}}
        </p>
        <div class="data">
            <el-button :type="typeOfThumb" icon="el-icon-thumb" plain @click="clickThumb">{{article.numberOfLike}}</el-button>
            <el-button type="info" icon="el-icon-view" plain>{{article.numberOfView}}</el-button>
            <el-button type="info" icon="el-icon-chat-dot-square" plain>{{article.numberOfComment}}</el-button>
            <el-button class="read" :type="infoOfRead" icon="el-icon-reading" plain @click="readArticle">阅读全文</el-button>
        </div>
      </div>

  </div>
</template>

<script>
export default {
    name: 'MobileBlogCard',
    data(){
        return{
            typeOfThumb: 'info',
            infoOfRead: 'primary',
        }
    },
    props:{
      article: Object,
    },
    methods:{
        clickThumb(){
            this.typeOfThumb = 'primary'
        },
        readArticle(){
            this.$router.push({
                path: '/mobile/blog',
                query:{
                    articleId:Number( this.article.id)
                },
            })
        }
    }
}
</script>

<style scoped>
*{
    margin: 0;
    padding: 0;
    border: 0;
}

li{
    list-style: none;
}

.container{
    width: 90%;
    margin: auto;
    margin-top: 2vh;
    margin-bottom: 4vh;
    overflow: hidden;
    box-shadow: 5px 5px 5px #888888;
    border: 5px solid #f3f4f7;
    background: #f3f4f7;
    border-radius: 10px;
}

.top{
    display:flex;
    height: 24vh;
    margin-top: 0;
}

.top img{
    height: 100%;
    width: 100%;
}

.middle{
    display: flex;
    flex-direction: column;
    background: #f3f4f7;

}

.middle ul{
    display: flex;
    width: 100%;
    flex-direction:row;
}

.middle ul li{
   text-align:center;
   color: black;
   margin: auto 4px;
}



.middle .title li{
    width: 100%;
    font-size: 25px;
}

.tags{
    display: flex;
    justify-content: center;
    font-size: 20px;
    margin-top: 6px;
}

.middle .tags li{
    max-width: 20vw;
}

.middle .tags li .el-button{
    width: 100%;
    line-height: 15px;
    padding: 2px;
}

.middle .msg{
    display: flex;
    justify-content: center;
    font-size: 15px;
    margin-top: 10px;
}

.middle .msg li{
    color: #9f9fa3;
}

.bottom{
    display: flex;
    flex-direction: column;
    justify-content: space-around;
    padding: 5px;
    color: #4d4f53;
    text-align: left;
    text-indent:4vw;
    min-height: 15vh;
}

.bottom p{
   word-break: break-all;
  overflow: hidden;
   text-overflow: ellipsis;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 4;  
}

.bottom .data{
    display: flex;
    margin-top: auto
}

.read{
    margin-left: auto;
}



</style>