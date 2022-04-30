<template>
  <div class="container">
       <mobile-blog-card v-for="item, i in articles" :key="i" :article = "item">

       </mobile-blog-card>
  </div>
</template>

<script>
import MobileBlogCard from '@/mobile/components/MobileBlogCard.vue'
import {getAllArticlesFromBack} from '@/apis/articles'

export default {
    name:'MobileBlogList',
    components:{
        MobileBlogCard,
    },
     mounted(){
        let that = this
        alert("sd")
         getAllArticlesFromBack().then(response=>{
             that.articles =  response.data.data
             this.$store.commit('saveArticles', that.articles)
         }).catch(error => { 
          console.log(error)
        })
    },
     data(){
        return{
            articles: [],
        }
    }
}
</script>

<style scoped>
.container{
    min-height: 52vh;
}

</style>