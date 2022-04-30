<template>
    <div class="blogs">
        <BlogCard v-for="article, i in articles" :key="i" :article = "article">

        </BlogCard>
    </div>
     
</template>

<script>

import BlogCard from '@/components/BlogCard.vue'

import {getAllArticlesFromBack} from '@/apis/articles'

export default {
    data(){
        return{
            array: [1, 2, 3, 4, 5],
            articles: []
        }
    },

     mounted(){
        let that = this
         getAllArticlesFromBack().then(response=>{
             that.articles =  response.data.data
             this.$store.commit('saveArticles', that.articles)
         }).catch(error => { 
          console.log(error)
        })
    },

    components:{
        BlogCard,
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
        width: 96%;
        padding-top: 10px;
        padding-bottom: 10px;
        margin:auto;
        background: #b8ddf7;
        overflow: hidden;
        /* opacity: 90%; */
    }
</style>

