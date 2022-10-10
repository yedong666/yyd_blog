<template>
  <div class="container">
    <!-- <el-button @click="test">test</el-button> -->
    <div class="headtype" v-for="(tags, index) in tagsList" :key="index">
      <p class="headdes">{{ tags.classify }}</p>
      <div class="types">
        <div class="type" v-for="(tag, i) in tags.tagList" :key="i">
          <p>{{ tag.name }}</p>
          <div class="typebox">
            <div class="imgbox">
              <el-image :src="server + tag.imgUrl"></el-image>
            </div>
            <div class="desbox">{{ tag.description }}</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { getTagsByClassify } from '@/apis/tags'

export default {
  data() {
    return {
      url: 'https://img0.baidu.com/it/u=1266622655,1796618539&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500',
      array: [1, 2, 3, 4, 5, 6, 7, 8],
      tagsList: [],
      server: this.$server.path,
    }
  },
  mounted() {
    let that = this
    getTagsByClassify().then((response) => {
      console.log(response.data.data)
      that.tagsList = response.data.data
    })
  },

  methods: {
    test() {
      this.data = Object.values(this.map)
    },
  },
}
</script>

<style scoped>
.container {
  width: 100%;
  background: #b8ddf7;
  display: flex;
  flex-direction: column;
  align-content: space-between;
  padding: 0;
}

.headtype {
  display: flexbox;
  width: 98%;
  margin: auto;
}

.headtype .headdes {
  width: 100%;
  font-size: 25px;
  color: #00bce4;
  text-align: left;
  text-indent: 10px;
}

.headtype .types {
  width: 100%;
  display: flex;
  /* justify-content: space-around; */
  flex-wrap: wrap;
  margin-bottom: 30px;
}

.headtype .types .type {
  border-radius: 5px;
  border: 1px solid #50bdcc;
  width: 20%;
  height: 130px;
  color: #708090;
  margin-left: 4%;
  margin-top: 20px;
  overflow: hidden;
  background: #c2def3;
}

.headtype .types .type:hover{
    color: #00bce4;
    background: #d8e9f6;
}

.headtype .types .type p {
  height: 20px;
  font-size: 20px;
}

.headtype .types .type .typebox {
  width: 100%;
  height: 90px;
  margin-top: 10px;
  margin-bottom: 10px;
}

.headtype .types .type .typebox .imgbox {
  width: 35%;
  height: 100%;
  margin-left: 5px;
  float: left;
}

.headtype .types .type .typebox .imgbox .el-image {
  height: 100%;
}

.headtype .types .type .typebox .desbox {
  width: 55%;
  height: 100%;
  overflow: hidden;
  font-size: 17px;
  text-align: left;
  margin-left: 5px;
  max-width: 55%;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 4;
  text-overflow: ellipsis;
  float: left;
}


</style>
