<template>
    <div class="blogs">
        <BlogCard v-for="article, i in articles" :key="i" :article = "article">

        </BlogCard>

      <el-pagination @current-change="handleCurrentChange" :current-page.sync="pageNum" :page-size="5" :hide-on-single-page="false" background layout="prev, pager, next" :total="articlesCount"> </el-pagination>

    </div>
     
</template>

<script>

import BlogCard from '@/components/BlogCard.vue'

import {getPageArticles, getArticlesCount} from '@/apis/articles'

export default {
    data(){
        return{
            array: [1, 2, 3, 4, 5],
            articles: [],
            articlesCount: 0,
            pageNum: this.$route.query.pageNum,
        }
    },

     mounted(){
        let that = this

        if(this.$route.query.pageNum != null){
            this.pageNum = this.$route.query.pageNum
        }

        getArticlesCount().then(response=>{
             that.articlesCount =  response.data.data
         }).catch(error => { 
          console.log(error)
        })

         getPageArticles(this.pageNum).then(response=>{
             that.articles =  response.data.data
         }).catch(error => { 
          console.log(error)
        })

    },

    components:{
        BlogCard,
    },

    methods:{
     handleCurrentChange(val) {
        this.$router.push({
            path: '/home/bloglist',
            query:{
              pageNum: val
            }
          }).then(()=>{
            this.$router.go(0)
          })
      },
  }
}
</script>


<style scoped>
    @media screen and (max-width: 768px){
        .blogs{
            width: 100%;
        }
    }
    .blogs{
        /* position: absolute; */
        /* top: 180px;
        left: 150px; */
        width: 100%;
        padding-top: 10px;
        padding-bottom: 10px;
        margin:auto;
        background: #b8ddf7;
        overflow: hidden;
        /* opacity: 90%; */
    }
</style>

