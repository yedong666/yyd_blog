<template>
  <div class="formContainer">
    <el-form label-position="left" ref="form" :model="user" class="loginForm" :rules="rules">
      <h2 style="margin-bottom: 10px; color: rgb(0, 195, 255">注册</h2>
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
     <el-tooltip class="item" effect="dark" content="注册成功后账号将发送至您的邮箱" placement="top" >
        <el-button  @click="doReginster('form')">注册</el-button>
      </el-tooltip>
    </el-form>
  </div>
</template>

<script>
// import background from '../components/background.vue'
export default {
  name: 'Reginster',
  data() {
    return {
      user: {
        name: '',
        password: '',
        passwords: '',
        phoneNumber: '',
        email: '',
      },
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
            { required: true, message: '请输入昵称', trigger: 'blur' },
            { min: 6, max: 12, message: '请输入正确的邮箱', trigger: 'blur' }
          ],
      },
    }
  },
  methods: {
    doReginster(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            alert('submit!');
          } else {
            console.log('error submit!!');
            return false;
          }
        })
      },
    changeCodeImg() {},
  },
}
</script>

<style>
.formContainer{
    position: absolute;
    width: 100%;
    height: 100%;
    top: 0;
    margin: 0 auto;
    background-image: url( '../assets/gif-bg1.gif');
}

el-input{
    background: linear-gradient(to right, #facabb , );;
}

el-button{
    background: linear-gradient(to right, #facabb , );;
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
