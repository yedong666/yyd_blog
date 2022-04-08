<template>
  <div class="nav">
    <div class="user">
      <el-button style="margin: 10px" @click="jumpToLogin">
        {{ userMessage }}
      </el-button>
      <el-button :style="logoutButtonStyle" @click="jumpToLogout"> 退出 </el-button>
    </div>
    <div class="menuContainer">
      <el-menu
        :default-active="activeIndex2"
        class="el-menu-nav"
        mode="horizontal"
        @select="handleSelect"
        background-color="#b2cce1"
        text-color="black"
        active-text-color="#ffd04b"
      >
        <el-menu-item @click="jumpToHome" style="font-size: 25px">首页</el-menu-item>
        <el-submenu index="2">
          <template slot="title"><p style="font-size: 25px" @click="jumpToArticle">博客</p></template>
          <el-menu-item index="2-1">生活分享</el-menu-item>
          <el-menu-item index="2-2">文艺创作</el-menu-item>
          <el-submenu index="2-3">
            <template slot="title"><p style="font-size: 20px">技术分享</p></template>
            <el-menu-item index="2-3-1" style="font-size: 15px">Java</el-menu-item>
            <el-menu-item index="2-3-2" style="font-size: 15px">前端</el-menu-item>
            <el-menu-item index="2-3-3" style="font-size: 15px">算法</el-menu-item>
          </el-submenu>
        </el-submenu>
        <el-menu-item index="3" disabled>消息中心</el-menu-item>
        <el-menu-item index="4" @click="jumpToWrite" style="font-size: 25px">写点啥</el-menu-item>
        <el-menu-item index="5"><a href="https://www.ele.me" target="_blank">后台管理</a></el-menu-item>
      </el-menu>
    </div>
    <el-input placeholder="请输入内容" v-model="searchInput" class="input-with-select">
      <el-button slot="append" icon="el-icon-search"></el-button>
    </el-input>
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
  height: 65px;
  background: #b2cce1;
  /* opacity: 90%; */
}

.el-menu-item {
  font-size: 20px;
}

.user {
  position: absolute;
  left: 10px;
}

.menuContainer {
  position: absolute;
  left: 250px;
}

.el-input {
  margin-top: 10px;
  margin-left: 1250px;
  border-radius: 0;
  width: 200px;
  height: 40px;
  font-size: 20px;
}

.el-button {
  background: #80b7de;
  color: aqua;
  font-size: 20px;
}

.el-button:hover {
  background: #409eff;
}

.el-submenu .el-menu-item{
  z-index: 1;
}
</style>
