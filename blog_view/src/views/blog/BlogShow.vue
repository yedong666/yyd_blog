<template>
    <div class="blogs">
        <BlogCard v-for="i in array" :key="i">

        </BlogCard>
    </div>
     
</template>

<script>

import BlogCard from '@/components/BlogCard.vue'

export default {
    data(){
        return{
            array: [1, 2, 3, 4, 5],
        }
    },

    components:{
        BlogCard,
    }
}
</script>


<style scoped>
    .blogs{
        /* position: absolute; */
        /* top: 180px;
        left: 150px; */
        padding-top: 10px;
        padding-bottom: 10px;
        width: 1100px;
        background: #b8ddf7;
        margin-left: 100px;
        /* opacity: 90%; */
    }
</style>

