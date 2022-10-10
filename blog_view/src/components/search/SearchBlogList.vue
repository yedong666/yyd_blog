<template>
  <div class="container">
    <div class="blog" v-for="(blog, index) in blogList" :key="index">
      <div class="title" v-html="blog.articleTitle">
      </div>
      <div class="content" v-html="blog.articleContent">
      </div>
      
      <div class="data">
        <label for=""><i class="el-icon-view"></i>{{blog.numberOfView}} </label>
        <label for=""><i class="el-icon-thumb"></i> {{blog.numberOfLike}}</label>
        <label for=""><i class="el-icon-chat-dot-square"></i> {{blog.numberOfComment}}</label>
        <label for=""><i class="el-icon-date"></i> {{blog.createTime}} </label>
        <label for="" @click="jumpToArticleView(blog.id)"> 阅读全文 <i class="el-icon-arrow-down"></i></label>
      </div>
    </div>
    <div>
      <el-pagination @current-change="handleCurrentChange" :page-size="2" :hide-on-single-page="false" background layout="prev, pager, next" :total="blogList.length"> </el-pagination>
    </div>
  </div>
</template>

<script>

import {searchArticle} from '@/apis/search'

export default {
  name: 'SearchBlogList',
  data() {
    return {
      blogList: [],
      searchKeyword: '',
    }
  },
  mounted(){
    this.searchKeyword = this.$route.query.keyword
    let that = this
    searchArticle(this.searchKeyword).then(response=>{
      that.blogList = response.data.data
    })
  },
  methods:{
     handleCurrentChange(val) {
        alert(val);
      },
      jumpToArticleView(blogId){
        this.$router.push({
            path: '/blogview',
            query:{
              articleId:Number(blogId)
            }
          })
      }
  }
}
</script>

<style scoped>
.blog {
  width: 90%;
  background: #b8dbf7;
  border: 1px solid #68a5e1;
  margin: 10px auto;
  border-radius: 5px;
}
.blog div {
  padding: 0px 20px;
}

.title {
  height: 40px;
  font-size: 18px;
  line-height: 40px;
  text-align: left;
}

.content {
  font-size: 16px;
  padding: 0;
  text-indent: 30px;
  overflow: hidden;
  word-break: break-all;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 2;
  text-overflow: ellipsis;
}

.content:hover{
  color: #68a5e1;
}

.data {
  height: 40px;
  display: flex;
  justify-content: left;
}

.data label {
  margin: 10px;
  line-height: 20px;
}

.data label:hover{
  color: #68a5e1;
}

.data label:nth-child(4){
  margin-right: auto;
}

</style>
