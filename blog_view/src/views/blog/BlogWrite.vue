<template>
  <div class="home">
    <div class="shadow" id="shadow" >
      <div class="formCard">
        <el-form :model="article" :rules="rules" ref="article" label-width="130px" class="article">
          <el-form-item label="文章概述" prop="summary">
            <el-input
              type="textarea"
              v-model="article.summary"
              :autosize="{ minRows: 2, maxRows: 4 }"
              style="width: 450px"
            ></el-input>
          </el-form-item>
          <el-form-item label="选择创作类型" prop="type">
            <el-radio-group v-model="article.type">
              <el-radio label="原创" name="type"></el-radio>
              <el-radio label="转载" name="type"></el-radio>
              <el-radio label="翻译" name="type"></el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="选择标签" prop="tags">
            <el-checkbox-group v-model="article.tags">
              <el-checkbox label="知识总结" name="type"></el-checkbox>
              <el-checkbox label="生活随笔" name="type"></el-checkbox>
              <el-checkbox label="技术分享" name="type"></el-checkbox>
              <el-checkbox label="项目讨论" name="type"></el-checkbox>
            </el-checkbox-group>
          </el-form-item>
          <el-form-item label="添加文章封面" prop="resource">
            <el-upload
              class="avatar-uploader"
              action="http://localhost:8888/uploadCoverImg"
              :show-file-list="true"
              :on-success="handleAvatarSuccess"
              :before-upload="beforeAvatarUpload"
            >
             <img v-if="imageUrl" :src="article.coverImage" class="avatar" />
              <span v-else style="border: 1px solid black;">
                  <i  class="el-icon-plus avatar-uploader-icon"></i>
              </span>
             
            </el-upload>
          </el-form-item>
          <el-form-item label="是否所有人可见" prop="resource">
            <el-radio-group v-model="article.isView">
              <el-radio v-model="article.isView" :label="true" >是</el-radio>
              <el-radio v-model="article.isView" :label="false">否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="是否开放评论区" prop="resource">
            <el-radio-group v-model="article.isPublicCommentArea">
              <el-radio v-model="article.isPublicCommentArea" :label="true" >是</el-radio>
              <el-radio v-model="article.isPublicCommentArea" :label="false">否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="是否允许转载" prop="resource">
            <el-radio-group v-model="article.isAllowedTurn">
             <el-radio v-model="article.isAllowedTurn" :label="true" >是</el-radio>
              <el-radio v-model="article.isAllowedTurn" :label="false">否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item lable="校验信息">
            <el-button type="primary" @click="submitForm('article')">确认发布</el-button>
            <el-button @click="resetForm('article')">重置数据</el-button>
            <el-button @click="cancelPublish">取消发布</el-button>
          </el-form-item>
        </el-form>
      </div>
    </div>
    <el-container id="contant">
      <el-container>
        <el-header height="100px"><Background></Background> </el-header>
        <el-footer style="padding: 0" height="60px"><NavBar ></NavBar></el-footer>
      </el-container>
      <el-container style="z-index: 1">
        <el-header height="50px" style="margin-top: 10px">
          <el-input
            v-model="article.title"
            placeholder="请在此输入标题"
            size="large"
            style="margin-top: 10px; width: 60%; margin-bottom: 0px"
          ></el-input>
        </el-header>
        <el-main style="margin-top: 10px; padding: 0; margin-bottom: 5px">
          <el-card id="writeContainer">
            <p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>
          </el-card>
          <el-card>
            <div id="textShow" style="height: 100%"></div>
          </el-card>
        </el-main>
        <el-footer style="background: white; margin: auto; width: 98%; margin-bottom: 10px; padding: 0" height="40px">
          <el-button type="primary" style="width: 100%" @click="showForm">发布</el-button>
        </el-footer>
      </el-container>
      <el-footer height="50px"><FootBar></FootBar></el-footer>
    </el-container>
    <el-backtop target=".home" :bottom="100"></el-backtop>
  </div>
</template>

<script>
import Background from '@/components/Background.vue'
import NavBar from '@/components/NavBar.vue'
import FootBar from '@/components/FootBar.vue'
import E from 'wangeditor'
import {addArticleToBack} from '@/apis/articles.js'
import { getUserData } from '@/request/token.js'
// import $ from 'jquery'

export default {
  data() {
    return {
      user: {},
      imageUrl: '',
      input: '',
      article: {
        title: '',
        content: '',
        summarize: '',
        author: '', 
        coverImage: '',
        type: '',
        tags: [],
        numberOfComment: 0,
        numberOfLike: 0,
        numberOfView: 0,
        isView: true,
        isPublicCommentArea: true,
        isAllowedTurn: true,
      },
      rules: {
        summarize: [
          { required: true, message: '请输入文章概览', trigger: 'blur' },
          { min: 60, max: 100, message: '长度在 60 到 100 个字符', trigger: 'blur' },
        ],
        type: [{ required: true, message: '请选择文章类型', trigger: 'change' }],
        tags: [{ type: 'array', required: true, message: '请至少选择一个标签', trigger: 'change' }],
      },
    }
  },

  mounted() {
    const editor = new E('#writeContainer')
    editor.config.height = 800
    //  const $text1 = $('#textShow')
    editor.config.placeholder = '请在此输入内容'
    editor.config.focus = false
    let that = this
    editor.config.onchange = function (html) {
      // 第二步，监控变化，同步更新到 textarea
      document.getElementById('textShow').innerHTML = html
      that.article.content = html
    }
    //  $text1.innerHTML = editor.txt.html()
    editor.create()
  },

  components: {
    Background,
    NavBar,
    FootBar,
  },

  methods: {
    submitForm(formName) {
      let that = this
      this.$refs[formName].validate((valid) => {
        if (valid) {
          alert('submit!')
          that.readyPublish()
          console.log(that.article)
          addArticleToBack(that.article)

        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm(formName) {
      this.$refs[formName].resetFields()
    },
    handleAvatarSuccess(res, file) {
      this.article.coverImage = URL.createObjectURL(file.raw)
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === 'image/jpeg'
      const isLt2M = file.size / 1024 / 1024 < 2

      if (!isJPG) {
        this.$message.error('上传头像图片只能是 JPG 格式!')
      }
      if (!isLt2M) {
        this.$message.error('上传头像图片大小不能超过 2MB!')
      }
      return isJPG && isLt2M
    },

    showForm() {
        alert("ad")
      document.getElementById('shadow').style.display = 'block'
      document.getElementById('contant').style.opacity = '0.6'
    },

    cancelPublish(){
         document.getElementById('shadow').style.display = 'none'
         document.getElementById('contant').style.opacity = '1'
    },

    readyPublish(){
        this.article.author = JSON.parse(getUserData()).id
        this.article.tags = this.article.tags.toString()
    }

  },
}
</script>

<style scoped>
.el-header {
  padding: 0;
}

.el-card {
  float: left;
  width: 49%;
  height: 800px;
  margin-left: 10px;
  text-align: left;
}

.article {
  margin-top: 10px;
}

.avatar {
    width: 378px;
    height: 198px;
    display: block;
  }

.avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }  

.shadow {
  position: absolute;
  display: none;
  background: rgba(0, 0, 0, 0.7);
  width: 100%;
  height: 120%;
  z-index: 1;
}

.formCard {
  /* display: none; */
  position: absolute;
  background: rgba(255, 255, 255, 1);
  top: 200px;
  left: 31%;
  width: 38%;
  padding-top: 20px;
  border-radius: 10px;
  box-shadow: 10px 10px 5px #888888;
}

.el-form {
  width: 90%;
}
</style>
