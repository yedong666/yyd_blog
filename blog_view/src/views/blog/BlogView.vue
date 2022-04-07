<template>
  <div class="home">
    <el-container>
      <el-container>
        <el-header height="100px"><Background></Background> </el-header>
        <el-footer style="padding: 0" height="60px"><NavBar></NavBar></el-footer>
      </el-container>
      <el-container>
        <el-main>
          <el-card>
            <div class="articleHead">
              <h1>文章标题</h1>
              <div>作者</div>
              <div>
                <el-tag style="left: 14px">{{ article.categories[0] }}</el-tag>
                <el-tag type="success" style="left: 74px">{{ article.categories[1] }}</el-tag>
                <el-tag type="info" style="left: 144px">{{ article.categories[2] }}</el-tag>
              </div>
            </div>
            <div class="articleContent">
              <p>
                诶，这不就到了我擅长的领域了。先说结论：是尤其是那些信息闭塞，被宣传的科研精神洗脑进而报了天坑专业的小镇做题家们。
                他们大多没什么职业规划，大学做的活动就是科研，如果gpa较高有了保研名额，那就继续麻木三年或者六年，再接受社会的毒打，
                倘若没有保研名额，就只能被迫工作。然后他们就会悲哀的发现，这个社会，似乎不需要自己。校招计算机相关的岗位一抓一大把，
                生化环材呢？没多少，工资低，环境还不好。
              </p>
              <p>
                他们无法接受自己从天之骄子变成月薪几千，每天要在工厂忍受脏乱差的低级劳动力，
                这样的人生，你敢说不是牛马吗？接着他们会陷入深深地自我怀疑，他们每一步都走的很辉煌，为什么最后是这个样子？
                然后一部分人在抑郁中突破自我，考上了计算机或者金融的研究生，开始了打工人的生活。还有一部分人，可能一辈子最辉煌的时候，
                就是高考完的那个暑假，最终彻底变成了孔乙己般的人。若干年后，他们或许儿孙绕膝，明明一事无成，却颇有一番风骨，
                说的都是“985/211”一类的字眼，徒惹人发笑罢了。
              </p>

              <p>
                那么，那些计算机和金融专业的人，就不是牛马了吗？他们当然也是牛马，
                就拿计算机举例，为什么他敢开出那么高的薪资，因为这个人创造的价值，远高于公司开出的薪资。醒醒吧，资本家不是慈善家，
                一年几十万的工资，不都是用自己的身体换来的吗。所以计算机有35危机，所以计算机行业薪资吊挂。因为你老了，干不动了，
                年轻人一天能干13h，你只能干9h，资本家凭什么要你？牛老了，挤不出奶了，是会被杀掉的。都是牛马，毫无疑问，
                计算机过的比天坑好，毕竟说到伤身体，生化环材有毒试剂挡在前面，同样的工作强度下（指某些实验室8116的作息），
                计算机也真甘拜下风。
              </p>
              <p>
                搞金融的家人告诉我，这几年经济形势不好，中国人口又多，内卷是必然的，除了那些含着金汤匙出生的，谁又不是牛马呢？
                我们用几十年走完了欧洲几百年才走完的路，谁，又不是燃料呢？
              </p>
            </div>
            <div class="articleFooter">
              <div class="articleMessages">
                <label for=""><i class="el-icon-view"></i> {{ article.numberOfBorwse }}</label>
                <label for=""><i class="el-icon-thumb"></i> {{ article.thumbUpFor }}</label>
                <label for=""><i class="el-icon-chat-dot-square"></i> {{ article.comments }}</label>
                <label style=""><i class="el-icon-bell"></i>2022-3-22 15:39</label>
                <label style="float: right"><i class="el-icon-date"></i>发表评论</label>
              </div>
              <div class="writeComment">
                  <el-input type="textarea" icon="el-icon-bell" placeholder="留下你的评论..."
                v-model="comment"
                   maxlength="100"
                   :rows="3" 
                   show-word-limit
                   style="font-size: 20px; "
                   ></el-input>
                  <el-button style="width: 100%; margin-top: 5px; font-size: 20px;"
                    type="primary"
                  >确认发表</el-button>
              </div>
              <div class="comments">
                <div class="comment">
                  <div class="commenter">
                    <el-avatar icon="el-icon-user-solid"></el-avatar>
                    <p class="commentName">评论者名字</p>
                  </div>
                  <div class="commentContent">
                    <p>
                      生化环材单单看就业率也好找工作，就业率95%以上，
                      不过大多数是工厂工地，月薪几千，你不愿意去罢了[惊喜]
                    </p>
                  </div>
                  <div class="commentMessages">
                    <label for=""><i class="el-icon-view"></i> {{ article.numberOfBorwse }}</label>
                    <label for=""><i class="el-icon-thumb"></i> {{ article.thumbUpFor }}</label>
                    <label for=""><i class="el-icon-chat-dot-square"></i> {{ article.comments }}</label>
                    <label><i class="el-icon-date"></i>2022-3-22 15:39</label>
                     <label style="float: right"><i class="el-icon-top-left"></i>回复</label>
                  </div>
                </div>
                <div class="comment">
                  <div class="commenter">
                    <el-avatar icon="el-icon-user-solid"></el-avatar>
                    <p class="commentName">评论者名字</p>
                  </div>
                  <div class="commentContent">
                    <p style="text-al">
                      生化环材单单看就业率也好找工作，就业率95%以上，
                      不过大多数是工厂工地，月薪几千，你不愿意去罢了[惊喜]
                    </p>
                  </div>
                  <div class="commentMessages">
                    <label for=""><i class="el-icon-view"></i> {{ article.numberOfBorwse }}</label>
                    <label for=""><i class="el-icon-thumb"></i> {{ article.thumbUpFor }}</label>
                    <label for=""><i class="el-icon-chat-dot-square"></i> {{ article.comments }}</label>
                    <label><i class="el-icon-date"></i>2022-3-22 15:39</label>
                     <label style="float: right"><i class="el-icon-top-left"></i>回复</label>
                  </div>
                </div>
                <div class="comment">
                  <div class="commenter">
                    <el-avatar icon="el-icon-user-solid"></el-avatar>
                    <p class="commentName">评论者名字</p>
                  </div>
                  <div class="commentContent">
                    <p>
                      生化环材单单看就业率也好找工作，就业率95%以上，
                      不过大多数是工厂工地，月薪几千，你不愿意去罢了[惊喜]
                    </p>
                  </div>
                  <div class="commentMessages">
                    <label for=""><i class="el-icon-view"></i> {{ article.numberOfBorwse }}</label>
                    <label for=""><i class="el-icon-thumb"></i> {{ article.thumbUpFor }}</label>
                    <label for=""><i class="el-icon-chat-dot-square"></i> {{ article.comments }}</label>
                    <label><i class="el-icon-date"></i>2022-3-22 15:39</label>
                    <label style="float: right"><i class="el-icon-top-left"></i>回复</label>
                  </div>
                </div>
              </div>
            </div>
          </el-card>
        </el-main>
        <el-aside width="640px"><MeShow></MeShow> <SortBar></SortBar></el-aside>
      </el-container>
      <el-footer height="50px"><FootBar></FootBar></el-footer>
    </el-container>

    <el-backtop target=".home" :bottom="100"></el-backtop>
  </div>
</template>

<script>
import Background from '@/components/Background.vue'
import NavBar from '@/components/NavBar.vue'
import MeShow from '@/components/MeShow.vue'
import SortBar from '@/components/SortBar.vue'
import FootBar from '@/components/FootBar.vue'

export default {
  data() {
    return {
      article: {
        categories: ['分享生活', '技术交流', '项目分析'],
        comments: 10,
        thumbUpFor: 45,
        numberOfBorwse: 19,
        image: 'https://img1.baidu.com/it/u=3857894473,1215456774&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=334',
      },
      circleUrl: 'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
      comment: '',
    }
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
  },
}
</script>

<style scoped>
.el-header {
  padding: 0;
}

.el-card {
  margin-left: 140px;
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

.articleContent p{
    margin-top: 10px;
    font-family:sans-serif;
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

.el-input{
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

.comment .commentContent{
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

.writeComment{
    background: #b2cce1;
}

.writeComment .el-button :hover{
    color: brown;
}

.writeComment .el-input{
    line-height: 80px;
}
</style>
