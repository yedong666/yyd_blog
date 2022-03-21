<template>
  <div class="formContainer">
    <el-form
      label-position="left"
      ref="form"
      :model="user"
      class="loginForm"
      :rules="rules"
    >
      <h2 style="margin-bottom: 10px; color: rgb(0, 195, 255">欢迎访问叶栋的个人博客</h2>
      <el-form-item prop="account">
        <el-input
          type="text"
          auto-complete="false"
          placeholder="账号"
          v-model="user.account"
        ></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input
          type="password"
          auto-complete="false"
          placeholder="密码"
          v-model="user.password"
        ></el-input>
      </el-form-item>
      <el-form-item prop="code">
        <el-input
          class="codeInput"
          type="text"
          placeholder="验证码"
          v-model="user.code"
          style="width: 250px; float: left; margin-right: 10px"
        ></el-input>
        <el-image
          :src="codeImgUrl"
          @click="changeCodeImg"
          style="width: 90px; height: 40px;  float: left"
        ></el-image>
      </el-form-item>
      <el-tooltip
        class="item"
        effect="dark"
        content="登录后才能获得完整权限"
        placement="top"
      >
        <el-button @click="login('form')">登录</el-button>
      </el-tooltip>
      <el-tooltip
        class="item"
        effect="dark"
        content="点击注册账号"
        placement="top"
      >
        <el-button @click="reginster">注册</el-button>
      </el-tooltip>
      <el-tooltip
        class="item"
        effect="dark"
        content="游客模式下不可以评论和留言哦"
        placement="top"
      >
        <el-button @click="test">游客访问</el-button>
      </el-tooltip>
    </el-form>
  </div>
</template>

<script>
// import background from '../components/background.vue'
// import loginToBack from '../apis/user.js'
// import * as setToken from '@/request/token.js' 
export default {
  name: "Login",
  data() {
    return {
      user: {
        account: "",
        password: "",
        code: "",
      },
      rules: {
        account: [
          { required: true, message: "请输入账号", trigger: "blur" },
          {
            min: 6,
            max: 12,
            message: "长度在 6 到 12 个字符",
            trigger: "blur",
          },
        ],
        password: [
          { required: true, message: "请输入密码", trigger: "change" },
          { min: 4, max: 8, message: "长度在 4 到 8 个字符", trigger: "blur" },
        ],
        code: [{ required: true, message: "请输入验证码", trigger: "change" }],
      },
      codeImgUrl:
        "https://img0.baidu.com/it/u=3060508493,2267137751&fm=253&fmt=auto&app=138&f=JPEG?w=400&h=213",
    };
  },
  methods: {
    login(formName) {
      let that = this
      let userData = this.user
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert("submit!");
          that.$store.dispatch('login', userData).then(() => {
              that.$router.push({
                path: "/",
              });    
            }).catch((error) => {
              alert(error)
              if (error !== 'error') {
                that.$message({message: "出错了", type: 'error', showClose: true});
              }
            })
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },

    test(){
      // loginToBack("20223020", "12345678").then(response=>{
      //   console.log(response)
      // })
      let that = this
      let userData = {
        account: '20223020',
        password: '12345678',
      }
      // setToken({name: "zhangsan", age: 18})
      // localStorage.zhangsan = JSON.stringify({name: "zhangsan", age: 18})
      // alert("存储成功")
      this.$store.dispatch('login', userData).then(() => {
              that.$router.push({
                path: "/",
              });    
            }).catch((error) => {
              alert(error)
              if (error !== 'error') {
                that.$message({message: "出错了", type: 'error', showClose: true});
              }
            })
    },

    reginster() {
      this.$router.push({
        path: "/reginster",
      });
    },

    changeCodeImg() {},
  },
};
</script>

<style>
.formContainer {
  position: absolute;
  width: 100%;
  height: 100%;
  top: 0;
  margin: 0 auto;
  background-image: url("../assets/gif-bg1.gif");
}

el-input {
  background: linear-gradient(to right, #facabb);
}

el-button {
  background: linear-gradient(to right, #facabb);
}

.loginForm {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 288px auto;
  box-shadow: 0 0 10px gray;
  width: 350px;
  padding: 15px 35px 15px 35px;
  border: 1px solid gray;
}
</style>
