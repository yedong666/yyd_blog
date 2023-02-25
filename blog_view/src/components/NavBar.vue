<template>
  <div class="nav">
    <div class="user" @mouseover="showMenu(true)">
      <el-button style="margin: 10px auto" @click="jumpToLogin">
        {{ userMessage }}
      </el-button>
      <!-- <el-button :style="logoutButtonStyle" @click="jumpToLogout"> 退出 </el-button> -->
    </div>
    <div class="menuContainer">
      <el-menu
        :default-active="activeIndex2"
       
        class="el-menu-nav"
        mode="horizontal"
        @select="handleSelect"
        background-color="#b8ddf7"
        text-color="black"
        active-text-color="#ffd04b"
      >
        <el-menu-item @click="jumpTo('/home')" >首页</el-menu-item>
        <el-menu-item  @click="jumpTo('/home/blogclassify')">博客分类</el-menu-item>
        <el-menu-item index="4"  @click="jumpTo('/blogwrite')">写博客</el-menu-item>
        <el-menu-item index="5"  @click="jumpTo('/blogwrite')">资源中心</el-menu-item>
        <el-menu-item index="6"  @click="jumpTo('/manage')">后台管理</el-menu-item>
        <el-menu-item index="7" @click="jumpTo('/home/about')">关于博主</el-menu-item>
      </el-menu>
    </div>

    <div class="searchBar">
      <search></search>
    </div>
    
  </div>
</template>

<script>
import { getUserData } from '@/request/token.js'
import Search from '@/components/tool/Search.vue'


export default {
  name: 'Navbar',
  data() {
    return {
      searchInput: '',
      activeIndex2: '1',
      userMessage: '登录/注册',
      logoutButtonStyle: 'margin: 10px; display: none',
      user: {},
    }
  },

  components:{
    Search,
  },

  mounted() {
    if (getUserData() != null) {
      console.log(JSON.parse(getUserData()))
      this.user = JSON.parse(getUserData())
      this.$store.commit('SET_USER', this.user)
      this.userMessage = this.user.nickname
      this.changeLogoutStyle()
    }
  },

  methods: {
    handleSelect(key, keyPath) {
      console.log(key, keyPath)
    },

    jumpToLogout() {
      let that = this
      console.log(this.user)
      this.$store
        .dispatch('logout', this.user)
        .then(() => {
          alert('退出成功')
          that.$router.go(0)
        })
        .catch((error) => {
          alert(error)
        })
    },

    jumpTo(path){
      this.$router.push({
        path: path,
      })
    },

    jumpToLogin() {
      this.$router.push({ path: '/login' })
    },

    jumpToHome(){
      this.$router.push({ path: '/' })
    },

     jumpToWrite(){
      this.$router.push({ path: '/blogwrite' })
    },

     jumpToArticle(){
      this.$router.push({ path: '/blogview' })
    },

    showMenu(isShow){
      this.$emit('show', isShow)
    },
    


    changeLogoutStyle() {
      if (this.logoutButtonStyle == 'margin: 10px; display: none') {
        this.logoutButtonStyle = 'margin: 10px; display: block'
      } else {
        this.logoutButtonStyle = 'margin: 10px; display: none'
      }
    },
  },
}
</script>

<style scoped>
.nav {
  width: 100%;
  height: 100%;
  background: #b8ddf7;
  border-bottom: 2px solid white;
  border-top: 2px solid white;
  /* opacity: 90%; */
}

.nav .el-menu-item {
  font-size: 25px;
}

.nav .user {
  float: left;
  width: 11%;
}

.nav .menuContainer {
  float: left;
  margin: auto;
}

.con{
  margin: 10px auto;
}

.nav .con .el-input {
  float: left;
  border-radius: 0px;
  width: 200px;
  height: 40px;
  font-size: 20px;
}

.nav .con .el-button{
  border-radius: 0px;
  float: left;
}

.nav .con .el-button :hover{
  background: #c4dff6;
}

.nav .el-submenu .el-menu-item{
  z-index: 1;
}

.searchBar{
  float: right;
  height: 100%;
  width: 29%;
}


</style>
