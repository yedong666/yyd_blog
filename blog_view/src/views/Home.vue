<template>
  <div class="home">
    <el-container>
      <el-container>
          <el-header height="100px"><Background></Background> </el-header>
          <el-footer style="padding: 0;" height="60px"><NavBar></NavBar></el-footer>
      </el-container>
      <el-container>
        <el-main><BlogShow></BlogShow></el-main>
        <el-aside width="640px"><MeShow></MeShow> <SortBar></SortBar></el-aside>
      </el-container>
      <el-footer height="50px"><FootBar></FootBar></el-footer>
    </el-container>

    <el-backtop target=".home" :bottom="100"></el-backtop>
  </div>
</template>

<script>
import Background from '@/components/Background.vue'
import NavBar from '@/components/NavBar.vue'
import BlogShow from '@/views/blog/BlogShow.vue'
import MeShow from '@/components/MeShow.vue'
import SortBar from '@/components/SortBar.vue'
import FootBar from '@/components/FootBar.vue'

export default {
  data() {
    return {}
  },

  components: {
    Background,
    NavBar,
    BlogShow,
    MeShow,
    SortBar,
    FootBar,
  },
}
</script>

<style scoped>
.el-header{
    padding: 0;
}
.el-aside{
}
.el-main{
}
.el-footer {
}
</style>
