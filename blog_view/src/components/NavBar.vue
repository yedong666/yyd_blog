<template>
  <div class="nav">
    <div class="user" @mouseover="showMenu(true)">
      <el-button style="margin: 10px; margin-left: 38px;" @click="jumpToLogin">
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
        <el-menu-item @click="jumpToHome" style="font-size: 25px">首页</el-menu-item>
        <el-menu-item style="font-size: 25px">博客</el-menu-item>
        <el-menu-item index="3" disabled>消息中心</el-menu-item>
        <el-menu-item style="font-size: 25px">书架</el-menu-item>
        <el-menu-item style="font-size: 25px">音乐吧</el-menu-item>
        <el-menu-item style="font-size: 25px">影视区</el-menu-item>
        <el-menu-item index="4" @click="jumpToWrite" style="font-size: 25px">写博客</el-menu-item>
        <el-menu-item index="5"><a href="https://www.ele.me" target="_blank">后台管理</a></el-menu-item>
      </el-menu>
    </div>

    <div class="searchBar">
      <el-input placeholder="请输入内容" v-model="searchInput" class="input-with-select">
          <el-button  slot="append" icon="el-icon-search"></el-button>
          </el-input>
    </div>
    
  </div>
</template>

<script>
import { getUserData } from '@/request/token.js'
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

  mounted() {
    if (getUserData() != null) {
      console.log(JSON.parse(getUserData()))
      this.user = JSON.parse(getUserData())
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
  position: relative;
  width: 100%;
  height: 100%;
  background: #b8ddf7;
  /* opacity: 90%; */
}

.nav .el-menu-item {
  font-size: 20px;
}

.nav .user {
  position: absolute;
  left: 10px;
}

.nav .menuContainer {
  position: absolute;
  left: 190px;
  overflow: hidden;
}

.nav .el-input {
  margin: auto;
  width: 200px;
  height: 40px;
  font-size: 20px;
}

.nav .el-input .el-button:hover{
  background: rgb(46, 155, 219);
  border-left: 0px;
  border-right: 0;

}



.nav .el-submenu .el-menu-item{
  z-index: 1;
}

.searchBar{
  float: right;
  margin: auto 120px;
  margin-top: 10px;
  background: chartreuse;
}


</style>
