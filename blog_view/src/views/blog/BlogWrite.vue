<template>
  <div class="blogWriteContainer">
    <div class="shadow" id="shadow" :style="heightStyle">
      <div class="formCard">
        <el-form :model="article" :rules="rules" ref="article" label-width="130px" class="article">
          <el-form-item label="文章概述" prop="summary">
            <el-input
              type="textarea"
              v-model="article.summarize"
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
            <div>
                 <el-button v-for="(tag, i) in article.tags" :type="getType(i)" :key="i" plain>{{tag}}</el-button>
                 <el-button type="primary" icon="el-icon-plus" @click="controlTagMenu" style="margin-top:10px">{{isOpen ? '收起标签栏' : '添加标签'}}</el-button>
            </div>
            <div v-if="isOpen" style="height: 200px;" class="tagCon">
                <div v-for="(tags, index) in allTags" :key="index">
                  <p style="text-align:left"><b>{{tags.classify}}:</b></p>
                  <el-checkbox-group v-model="article.tags" size="small"  max="3">
                    <el-checkbox  v-for="(tag, i) in tags.tagList" :key="i" :label="tag.name" border ></el-checkbox>
                  </el-checkbox-group>
               </div>
            </div>
          </el-form-item>
          <el-form-item label="添加文章封面" prop="resource">
            <el-upload
              class="avatar-uploader"
              :action="requestPath"
              :show-file-list="true"
              :on-success="handleAvatarSuccess"
              :before-upload="beforeAvatarUpload"
            >
              <img v-if="article.coverImage" :src="this.$server.path + article.coverImage" class="avatar" />
              <span v-else style="border: 1px solid black">
                <i class="el-icon-plus avatar-uploader-icon"></i>
              </span>
            </el-upload>
          </el-form-item>
          <el-form-item label="是否所有人可见" prop="resource">
            <el-radio-group v-model="article.isView">
              <el-radio v-model="article.isView" :label="true">是</el-radio>
              <el-radio v-model="article.isView" :label="false">否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="是否开放评论区" prop="resource">
            <el-radio-group v-model="article.isPublicCommentArea">
              <el-radio v-model="article.isPublicCommentArea" :label="true">是</el-radio>
              <el-radio v-model="article.isPublicCommentArea" :label="false">否</el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="是否允许转载" prop="resource">
            <el-radio-group v-model="article.isAllowedTurn">
              <el-radio v-model="article.isAllowedTurn" :label="true">是</el-radio>
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
        <el-footer style="padding: 0" height="60px"><NavBar></NavBar></el-footer>
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
        <div id="toolbar-container" style="padding: 0; margin: 10px 1% 0px 1%; width: 98%; "></div>
        <el-main style="padding: 0; margin: 0px 1% 10px 1%; width: 98%;">
          <el-card id="writeContainer" style="min-height: 840px; ">
            <div id="editor-container" ></div>
          </el-card>
           <el-card id="textShow" v-html="article.content"  style="min-height: 840px; " v-highlight>
              
           </el-card>
           
        </el-main>
        <el-footer style="background: white; margin: auto; width: 98%; margin-bottom: 10px; padding: 0" height="40px">
          <el-button type="primary" style="width: 100%" @click="showForm">发布</el-button>
        </el-footer>
      </el-container>
      <el-footer height="50px"><FootBar></FootBar></el-footer>
    </el-container>
    <!-- <el-backtop target=".home" :bottom="100"></el-backtop> -->
  </div>
</template>

<script>
import Background from '@/components/Background.vue'
import NavBar from '@/components/NavBar.vue'
import FootBar from '@/components/FootBar.vue'
import '@wangeditor/editor/dist/css/style.css'
import { createEditor, createToolbar} from '@wangeditor/editor'
import { addArticleToBack } from '@/apis/articles.js'
import { getUserData } from '@/request/token.js'
import { getTagsByClassify } from '@/apis/tags'

// import $ from 'jquery'

export default {
  data() {
    return {
      requestPath: this.$server.path + "/uploadCoverImg",
      heightStyle: "height: " + document.body.scrollHeight + "px",
      isOpen: false,
      user: {},
      imageUrl: '',
      input: '',
      allTags:[],
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

     let that = this
    getTagsByClassify().then((response) => {
      console.log(response.data.data)
      that.allTags = response.data.data
    })


    const editorConfig  = {}
    editorConfig.placeholder = '请输入内容'
    editorConfig.onChange = (editor) => {
      // 当编辑器选区、内容变化时，即触发
    // const content = editor.children
    // const contentStr = JSON.stringify(content)
    // document.getElementById('textarea-1').value = contentStr
   

    const html = editor.getHtml()
    that.article.content = html
    }

    // 创建编辑器
    const editor = createEditor({
      selector: '#editor-container',
      config: editorConfig,
      mode: 'default', // 或 'simple' 参考下文
    })
    // 创建工具栏
    createToolbar({
      editor,
      selector: '#toolbar-container',
      mode: 'default', // 或 'simple' 参考下文
    })
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
        if (valid && getUserData() != null) {
          alert('submit!')
          that.readyPublish()
          console.log(that.article)
          addArticleToBack(that.article)
          that.$router.push({
            path: '/',
          })
        } else {
          console.log('error submit!!')
          return false
        }
      })
    },
    resetForm(formName) {
      this.article.coverImage = null
      this.$refs[formName].resetFields()
    },
    handleAvatarSuccess(res) {
      console.log(res)
      this.article.coverImage = res.data
      console.log(this.article)
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
      document.getElementById('shadow').style.display = 'block'
      document.getElementById('contant').style.opacity = '0.6'
      this.heightStyle = "height: " + document.body.scrollHeight + "px"
    },

    cancelPublish() {
      document.getElementById('shadow').style.display = 'none'
      document.getElementById('contant').style.opacity = '1'
    },

    readyPublish() {
      this.article.author = JSON.parse(getUserData()).id
      this.article.tags = this.article.tags.toString()
    },

    controlTagMenu(){
      if(this.isOpen == true) this.isOpen = false
      else this.isOpen = true
    },

    getType(i){
      if(i == 0) return "primary"
      else if(i == 1) return "success"
      else return "danger"
    }
  },
}
</script>

<style scoped>
.el-header {
  padding: 0;
}

.el-main{
  display: flex;
}

.el-card {
  margin: 0;
  padding: 0;
  width: 50%;
  /* height: 800px; */
  border-radius: 0;
  text-align: left;
  font-size: 16px;
}

::v-deep #textShow p{
   text-align: left;
   font-size: 18px;
   margin: 25px;
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
  height: 1140px;
  z-index: 1;
}

.formCard {
  /* display: none; */
  position: absolute;
  background: rgba(255, 255, 255, 1);
  top: 200px;
  left: 31%;
  width: 40%;
  padding-top: 20px;
  border-radius: 10px;
  box-shadow: 10px 10px 5px #888888;
}

.el-form {
  width: 90%;
}

#textShow{
  font-size: 20px;
}

.tagCon{
  display: flexbox;
  flex-wrap: wrap;
  overflow:scroll;
  overflow-x: hidden;
  margin-top: 10px;
  border: 2px solid #f0f2f7;
  width: 100%;
}

.tagCon::-webkit-scrollbar {/*滚动条整体样式*/
        width: 10px;     /*高宽分别对应横竖滚动条的尺寸*/
        height: 1px;
    }
.tagCon::-webkit-scrollbar-thumb {/*滚动条里面小方块*/
        border-radius: 10px;
         -webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);
        background: #caccd1;
    }
.tagCon::-webkit-scrollbar-track {/*滚动条里面轨道*/
        -webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);
        border-radius: 10px;
        background: #EDEDED;
    }

.el-checkbox{
  margin: 10px;
}

</style>
