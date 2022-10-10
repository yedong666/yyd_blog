<template>
  <div class="reginsterContainer">
    <el-form label-position="left" ref="form" :model="user" class="loginForm" :rules="rules">
      <h2 style="margin-bottom: 10px; color: rgb(0, 195, 255)">注册</h2>
      <el-form-item prop="name">
        <el-input type="text" auto-complete="false" placeholder="昵称" v-model="user.name"></el-input>
      </el-form-item>
      <el-form-item prop="password">
        <el-input type="password" auto-complete="false" placeholder="密码" v-model="user.password"></el-input>
      </el-form-item>
      <el-form-item prop="passwords">
        <el-input type="password" auto-complete="false" placeholder="确认密码" v-model="user.passwords"></el-input>
      </el-form-item>
      <el-form-item prop="phoneNumber">
        <el-input type="text" auto-complete="false" placeholder="手机号码" v-model="user.phoneNumber"></el-input>
      </el-form-item>
      <el-form-item prop="email">
        <el-input type="text" auto-complete="false" placeholder="邮箱" v-model="user.email"></el-input>
      </el-form-item>
      <el-form-item prop="code">
        <el-input
          type="text"
          auto-complete="false"
          placeholder="验证码"
          v-model="user.code"
          style="width: 188px; float: left; margin-right: 10px"
        ></el-input>
        <valid-code @listen="getCode"></valid-code>
      </el-form-item>
      <el-button @click="test()">test</el-button>
      <el-tooltip class="item" effect="dark" content="注册成功后账号将发送至您的邮箱" placement="top">
        <el-button @click="doReginster('form')">注册</el-button>
      </el-tooltip>
    </el-form>
  </div>
</template>

<script>
// import background from '../components/background.vue'
import ValidCode from '@/components/ValidCode.vue'
import {registerToBack} from '@/apis/user.js'

export default {
  name: 'Register',
  components:{
    ValidCode,
  },
  data() {
    return {
      user: {
        name: '',
        password: '',
        passwords: '',
        phoneNumber: '',
        email: '',
        code: '',
      },
      code: '',
      rules:{
           name: [
            { required: true, message: '请输入昵称', trigger: 'blur' },
            { min: 6, max: 12, message: '长度在 6 到 12 个字符', trigger: 'blur' }
          ],
          password: [
            { required: true, message: '请输入密码', trigger: 'change' },
            { min: 4, max: 8, message: '长度在 4 到 8 个字符', trigger: 'blur' }
          ],
          passwords: [
            { required: true, message: '请确认密码', trigger: 'change' },
            { min: 4, max: 8, message: '长度在 4 到 8 个字符', trigger: 'blur' }
          ],
           phoneNumber: [
            { required: true, message: '请输入电话号码', trigger: 'blur' },
            { min: 11, max: 11, message: '请输入正确的电话号码', trigger: 'blur' }
          ],
          email: [
            { required: true, message: '请输入邮箱账号', trigger: 'blur' },
            { min: 6, max: 12, message: '请输入正确的邮箱', trigger: 'blur' }
          ],
          code: [
            { required: true, message: '请输入验证码', trigger: 'blur' },
            { min: 4, max: 4, message: '请输入正确的验证码', trigger: 'blur' }
          ],
      },
    }
  },
  methods: {
    doReginster(formName) {
      let that = this
        this.$refs[formName].validate((valid) => {
          if (valid && that.checkReginsterData(that.user.phoneNumber, that.user.email, that.user.code)) {
            registerToBack({
              password: that.user.password,
              nickname: that.user.name,
              phoneNumber: that.user.phoneNumber,
              email: that.user.email,
            }).then(response=>{
                that.$message({message: "账号注册成功", type: "success", showClose: true})
                alert("你的账号是" + response.data.data.account)
            })

          } else {
            console.log('error submit!!');
            return false;
          }
        })
      },

      test(){
        registerToBack({
              account: '20223025',
              password: '1234',
              nickname: 'tyojd',
              phoneNumber: 'dadwda',
              email: 'dadda',
            })
      },

    checkReginsterData(phonenumber, email, code){
      if (!(/^\d+$/).test(phonenumber)){
        //电话号码中存在数字以外的字符
          this.$message({message: '电话号码格式错误', type: 'error', showClose: true})
          return false
      }
      if (!(new RegExp('.*@.*\\.com').test(email))){
        this.$message({message: '邮箱格式错误', type: 'error', showClose: true})
        return false
      }
      if (code != this.code || code == ''){
        this.$message({message: '验证码错误', type: 'error', showClose: true})
        return false
      }
      return true
    },

    getCode(code){
      this.code = code
    }

  },
}
</script>

<style scoped>
.reginsterContainer {
  position: absolute;
  width: 100%;
  height: 100%;
  top: 0;
  margin: 0 auto;
  background-image: url('../assets/reginster_bg.jpg');
  background-repeat: no-repeat;
  background-size: cover;
}

.reginsterContainer .el-input {
  border: 1px solid rgb(182, 170, 170);
}

.reginsterContainer el-button {
  background: linear-gradient(to right, #facabb);
}

.reginsterContainer .loginForm {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 100px auto;
  box-shadow: 0 0 10px gray;
  width: 350px;
  padding: 15px 35px 15px 35px;
  border: 1px solid gray;
}
</style>
