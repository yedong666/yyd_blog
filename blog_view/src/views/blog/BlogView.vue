<template>
  <div class="home">
    <el-container>
      <el-container>
        <el-header height="100px"><Background></Background> </el-header>
        <el-footer style="padding: 0" height="60px"><NavBar @show="showUserMenuBar"></NavBar></el-footer>
      </el-container>
      <el-container>
        <el-aside width="11%" v-if="isShow"><UserMenuBar @closeMenu="showUserMenuBar"></UserMenuBar></el-aside>
        <el-main>
          <el-card v-if="article != null">
            <div class="articleHead">
              <h1>{{ article.title }}</h1>
              <div>{{ article.author }}</div>
              <div v-if="article.tags">
                <el-tag style="left: 14px">{{ article.tags[0] }}</el-tag>
                <el-tag type="success" style="left: 74px">{{ article.tags[1] }}</el-tag>
                <el-tag type="info" style="left: 144px">{{ article.tags[2] }}</el-tag>
              </div>
            </div>
            <div class="articleContent" v-html="article.content">
              {{ article.content }}
            </div>
            <div class="articleFooter">
              <div class="articleMessages">
                <label for=""><i class="el-icon-view"></i> {{ article.numberOfView }}</label>
                <label for=""><i class="el-icon-thumb"></i> {{ article.numberOfLike }}</label>
                <label for=""><i class="el-icon-chat-dot-square"></i> {{ article.numberOfComment }}</label>
                <label style=""><i class="el-icon-bell"></i>2022-3-22 15:39</label>
                <label style="float: right"><i class="el-icon-date"></i>发表评论</label>
              </div>
              <div class="writeComment">
                <el-input
                  type="textarea"
                  icon="el-icon-bell"
                  placeholder="留下你的评论..."
                  v-model="comment"
                  maxlength="100"
                  :rows="3"
                  show-word-limit
                  style="font-size: 20px"
                ></el-input>
                <el-button style="width: 100%; margin-top: 5px; font-size: 20px" type="primary">确认发表</el-button>
              </div>
              <div class="comments" v-if="comments">
                <div class="comment" v-for="(comment, i) in comments" :key="i">
                  <div class="commenter">
                    <el-avatar icon="el-icon-user-solid"></el-avatar>
                    <p class="commentName" v-if="users[i]">{{ users[i].nickname }}</p>
                  </div>
                  <div class="commentContent">
                    <p>
                      {{ comment.content }}
                    </p>
                  </div>
                  <div class="commentMessages">
                    <label for=""><i class="el-icon-view"></i> {{ comment.numberOfView }}</label>
                    <label for=""><i class="el-icon-thumb"></i> {{ comment.numberOfLike }}</label>
                    <label for=""><i class="el-icon-chat-dot-square"></i> {{ comment.numberOfReply }}</label>
                    <label><i class="el-icon-date"></i>2022-3-22 15:39</label>
                    <label style="float: right"><i class="el-icon-top-left"></i>回复</label>
                  </div>
                </div>
              </div>
            </div>
          </el-card>
        </el-main>
        <el-aside width="30%"><MeShow></MeShow> <SortBar></SortBar></el-aside>
      </el-container>
      <el-footer height="50px"><FootBar></FootBar></el-footer>
    </el-container>
  </div>
</template>

<script>
import Background from '@/components/Background.vue'
import NavBar from '@/components/NavBar.vue'
import MeShow from '@/components/MeShow.vue'
import SortBar from '@/components/SortBar.vue'
import FootBar from '@/components/FootBar.vue'
import UserMenuBar from '@/components/UserMenuBar.vue'
import { getArticleByIdFromBack } from '@/apis/articles.js'
import { getCommentByArticleIdFromBack } from '@/apis/comments.js'
import { getUserByIdFromBack } from '@/apis/user.js'

export default {
  data() {
    return {
      id: Number,
      article: {},
      comments: [],
      users: [],
      comment: '',
      isShow: false,
    }
  },

  mounted() {
    let that = this
    this.id = Number(this.$route.query.articleId)

    //异步从服务器获取文章对象
    getArticleByIdFromBack(this.id).then((response) => {
      this.article = response.data.data
      this.article.tags = this.article.tags.split(',')
    })

    //异步从服务器获取当前文章的所有评论
    getCommentByArticleIdFromBack(this.id)
      .then((reponse) => {
        this.comments = reponse.data.data
        return reponse.data.data
      })
      .then((response) => {
        //异步获取每个评论的评论者对象
        response.forEach((element) => {
          getUserByIdFromBack(Number(element.observerId)).then((response) => {
            that.users.push(response.data.data)
          })
        })
      })
  },

  computed: {
    // getName(observerId){
    // }
  },

  methods: {
    showUserMenuBar(isShow) {
      this.isShow = isShow
    },

    // async getObserverName(observerId, callback){
    //   //let that = this
    //   // let name
    //   // let that = this
    //   let res = await getUserByIdFromBack(observerId)
    //   // alert(res.data.data.nickname)
    //   this.users.push(res.data.data)
    //   callback(res.data.data.nickname)
    // },

    // returnName(name){
    //   return name
    // }
  },

  // created(){
  //   this.user = this.$route.query.user
  // },

  components: {
    Background,
    NavBar,
    MeShow,
    SortBar,
    FootBar,
    UserMenuBar,
  },
}
</script>

<style scoped>
.el-header {
  padding: 0;
}

.el-card {
  margin-left: 10px;
  background: #b8ddf7;
}

.articleHead {
}

.articleHead h1 {
  font-size: 30px;
}

.articleHead * {
  margin-bottom: 5px;
  margin-top: 5px;
}

.el-tag {
  font-size: 15px;
  margin-left: 5px;
  margin-bottom: 10px;
}

.articleFooter {
}

.articleContent {
  font-size: 20px;
  text-align: left;
  text-indent: 50px;
  letter-spacing: 5px;
  line-height: 150%;
  padding-bottom: 10px;
}

.articleContent p {
  margin-top: 10px;
  font-family: sans-serif;
}

.articleMessages {
  display: flow-root;
  font-size: 20px;
  margin-top: 10px;
  margin-bottom: 10px;
  padding: 10px;
  border-bottom: solid 2px grey;
}

label {
  float: left;
  margin-right: 10px;
  margin-left: 5px;
}

.el-input {
  height: 200px;
}

.comments {
}

.comment {
  margin-top: 20px;
  display: flow-root;
  padding: 5px;
  border: 1px solid rgb(128, 154, 194);
}

.commenter {
  display: flow-root;
}

.comment .commentContent {
  text-align: left;
  margin: 10px;
  text-indent: 10px;
}

.el-avatar {
  float: left;
  margin-left: 5px;
  height: 40px;
}

.commentName {
  float: left;
  line-height: 40px;
  font-size: 20px;
  margin-left: 10px;
}

.commentMessages {
  margin-left: 5px;
  margin-top: 10px;
}

.writeComment {
  background: #b2cce1;
}

.writeComment .el-button :hover {
  color: brown;
}

.writeComment .el-input {
  line-height: 80px;
}
</style>
