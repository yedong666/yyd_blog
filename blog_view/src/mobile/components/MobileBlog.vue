<template>
  <div class="home">
    <div class="articleHead">
      <h1>{{ article.title }}</h1>
      <div>{{ article.author }}</div>
      <div v-if="article.tags">
        <el-tag style="left: 14px">{{ article.tags[0] }}</el-tag>
        <el-tag type="success" style="left: 74px">{{ article.tags[1] }}</el-tag>
        <el-tag type="info" style="left: 144px">{{ article.tags[2] }}</el-tag>
      </div>
    </div>
    <div class="articleContent" v-html="article.content" v-highlight>
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
        <el-button style="width: 100%; margin-top: 5px; font-size: 20px" type="primary" @click="publishComment"
          >确认发表</el-button
        >
      </div>
        <div  class="nullMsg" v-if="comments.length == 0">
                <img src="../../assets/noComments.png" alt="">
                <span>
                  还没有人对本文发表过评论哦
                </span>
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
  </div>
</template>

<script>
import { getArticleByIdFromBack } from '@/apis/articles.js'
import { getCommentByArticleIdFromBack, addCommentToBack } from '@/apis/comments.js'
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
    //小于10的拼接上0字符串
    addZero(s) {
      return s < 10 ? '0' + s : s
    },

    getNowDate() {
      var date = new Date()
      //年 getFullYear()：四位数字返回年份
      var year = date.getFullYear() //getFullYear()代替getYear()
      //月 getMonth()：0 ~ 11
      var month = date.getMonth() + 1
      //日 getDate()：(1 ~ 31)
      var day = date.getDate()
      //时 getHours()：(0 ~ 23)
      var hour = date.getHours()
      //分 getMinutes()： (0 ~ 59)
      var minute = date.getMinutes()
      //秒 getSeconds()：(0 ~ 59)
      var second = date.getSeconds()

      var time =
        year +
        '-' +
        this.addZero(month) +
        '-' +
        this.addZero(day) +
        ' ' +
        this.addZero(hour) +
        ':' +
        this.addZero(minute) +
        ':' +
        this.addZero(second)
      return time
    },

    publishComment() {
      if (this.comment.length == 0) {
        alert('评论不可以为空哦')
      } else {
        if (this.$store.state.userData == null) {
          alert('需要登录后才可以评论')
        } else {
          let comment = {
            content: this.comment,
            observerId: JSON.parse(this.$store.state.userData).id,
            articleId: this.id,
            //评论的replyId属性都为0
            replyId: 0,
            date: this.getNowDate(),
            numberOfLike: 0,
            numberOfReply: 0,
            numberOfView: 0,
          }
          addCommentToBack(comment)
            .then((response) => {
              alert(response.data.data)
              location.reload()
            })
            .catch((error) => {
              console.log(error)
              alert('发布评论失败')
            })
        }
      }
    },
  },

  components: {
  
  },
}
</script>

<style scoped>

.articleHead{
  margin-top: 30px;
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

.articleContent {
  font-size: 20px;
  text-align: left;
  letter-spacing: 5px;
  line-height: 150%;
  padding-bottom: 10px;
}

.articleContent img{
  margin: auto;
}

.articleContent p {
  margin-top: 10px;
  font-family: sans-serif;
}

.articleMessages {
  display: flow-root;
  font-size: 15px;
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

.nullMsg{
  display: flex;
  flex-direction: column;
  width: 100%;
  height: 220px;
}

.nullMsg img{
  margin: 0 auto;
  width: 100px;
  height: 100px;
  margin-top: 50px;
}

.nullMsg span{
  color: #8590a6;
}

</style>
