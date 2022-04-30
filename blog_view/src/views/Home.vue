<template>
  <div class="home">
    <el-container>
      <el-container class="head">
          <el-header height="100px"><Background></Background> </el-header>
          <el-footer style="padding: 0;" height="60px" v-if="flag"><NavBar @show="showUserMenuBar"></NavBar></el-footer>
      </el-container>
      <el-container class="main">
        <el-aside width="11%"  v-if = "isShow"><UserMenuBar @closeMenu="showUserMenuBar"></UserMenuBar></el-aside>
        <el-main ><BlogShow></BlogShow></el-main>
        <el-aside width="29%" v-if="flag"><MeShow></MeShow> <SortBar></SortBar></el-aside>
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
import UserMenuBar from '@/components/UserMenuBar.vue'


export default {
  data() {
    return {
      user:{},
      isShow: false,
      flag: true,
    }
  },

  mounted(){
    if (document.body.clientWidth < 780){
      this.flag = false
      this.$router.push({
                path: '/mobile',
              })
    }
  },

  // created(){
  //   location.reload()
  // },
  // created(){
  //   this.user = this.$route.query.user
  // },
  methods:{
    showUserMenuBar(isShow){
      this.isShow = isShow
    },

  },

  components: {
    Background,
    NavBar,
    BlogShow,
    MeShow,
    SortBar,
    FootBar,
    UserMenuBar,
  },
}
</script>

<style scoped>
  .home{
    width: 100%;
    height: 100%;
  }

  .home .main{
    width: 100%;
  }

  .home .main .el-main{
    overflow: hidden;
  }

  .home .main .el-aside{
    overflow: hidden;
  }

  @media screen and(max-width: 375px){
    .main .el-aside{
      display: none;
    }
  }
  

</style>
