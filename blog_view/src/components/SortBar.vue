<template>
  <div class="sortBar-container">
    <div class="link-container">
      <h2>最热文章--------实时热点聚焦</h2>
      <el-divider></el-divider>
      <div class="sortLink" v-for="(link, index) in hotArticles" :key="index">
        <p @click="gotoArticle(link.id)">
          <span>{{ index + 1 }}</span> {{ link.title }}
        </p>
      </div>
    </div>
    <div class="link-container">
      <h2>最新文章--------新鲜事快速发现</h2>
      <el-divider></el-divider>
      <div class="sortLink" v-for="(link, index) in newArticles" :key="index">
        <p @click="gotoArticle(link.id)"> 
          <span>{{ index + 1 }}</span> {{ link.title }}
        </p>
      </div>
    </div>
  </div>
</template>

<script>
import { getHotArticles, getNewArticles } from '@/apis/articles'

export default {
  name: 'SortBar',
  data() {
    return {
      hotArticles: [],
      newArticles: [],
    }
  },
  mounted() {
    let that = this
    getHotArticles().then((response) => {
      that.hotArticles = response.data.data
    })

    getNewArticles().then((response) => {
      that.newArticles = response.data.data
    })
  },
  methods: {
    gotoArticle(articleId) {
      this.$router
        .push({
          path: '/blogview',
          query: {
            articleId: Number(articleId),
          },
        })
        .then(() => {
          this.$router.go(0)
        })
    },
  },
}
</script>

<style scoped>

h2{
  font-size: 20px;
  padding-left: 50px;
  text-align: left;
}
.sortLink {
  width: 80%;
  margin: 10px auto;
}
.sortLink p {
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  text-align: left;
  font-size: 18px;
}

.sortLink p:hover{
  color: #1296db;
}

.sortLink p span {
  float: left;
  text-align: center;
  display: block;
  color: white;
  background: #f3514c;
  margin: auto 5px;
  width: 25px;
}

.sortBar-container {
  /* position: absolute;
  right: 150px;
  top: 820px; */
  width: 90%;
  margin: auto;
  margin-top: 20px;
  /* opacity: 90%; */
}

.sortBar-container h2 {
  margin-top: 20px;
}

.sortBar-container .link-container {
  width: 100%;
  background: #b8ddf7;
  margin-bottom: 20px;
  overflow: hidden;
}

.sortBar-container .el-row {
  margin-top: 20px;
}
.sortBar-container .el-link {
  font-size: 25px;
}
</style>
