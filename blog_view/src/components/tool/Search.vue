<template>
  <div class="container">
    <div class="bar" id="bar">
      <input v-model="keyword" type="text" placeholder="请输入搜索内容" @focus="showMsg" @blur="closeMsg" />
      <span @click="search">
        <img src="../../assets/search.png" />
      </span>
    </div>
    <div class="msg" v-if="isShow">
     <div class="record">
        <p>搜索历史</p>
         <ul>
            <li>
                java相关
            </li>
             <li>
                小说推荐
            </li>
             <li>
                数据结构
            </li>
             <li>
                前端
            </li>
        </ul>
      </div>
      <div class="hot">
        <p>热搜</p>
        <ul>
            <li>
                1.Spring5
            </li>
             <li>
                2.程序员35岁危机
            </li>
             <li>
                3.培训班or自学
            </li>
             <li>
                4.前后端分离项目
            </li>
        </ul>
      </div>
     
    </div>
  </div>
</template>

<script>
export default {
  name: 'Search',
  data() {
    return {
      isShow: false,
      keyword: '',
    }
  },
  methods: {
    showMsg() {
      this.isShow = true
      document.getElementById('bar').style.borderRadius = '10px 10px 0 0'
      document.getElementById('bar').style.borderBottom="0px"
    },
    closeMsg() {
      this.isShow = false
      document.getElementById('bar').style.borderRadius = '10px'
      document.getElementById('bar').style.borderBottom="2px solid #3399ff"
    },
    search(){
      this.$router.push({
        path: '/home/search',
        query:{
              keyword: this.keyword,
            }
      }).then(()=>{
        this.$router.go(0)
      })
      
    }
  },
}
</script>

<style scoped>

ul li{
    list-style: none;
}

li:hover{
    background: #f6f7f8;
}

.container {
  display: flex;
  flex-direction: column;
}

.bar {
  overflow: hidden;
  background: #b8ddf7;
  width: 340px;
  border-radius: 10px;
  margin: 10px auto;
  margin-bottom: 0;
  border: 2px solid #3399ff;
}

.bar input {
  float: left;
  width: 250px;
  height: 30px;
  padding-left: 5px;
  font-size: 15px;
  border-radius: 5px;
  outline: none;
  margin: 5px;
  margin-left: 15px;
  margin-right: 0;
  background: #b8ddf7;
}

input:focus {
  background: #f6f6f6;
}

.bar span {
  float: left;
  display: flex;
  width: 60px;
  height: 30px;
  border-radius: 5px;
  background: #b8ddf7;
  margin: 5px;
}

span:hover {
  background: #00aeef;
}

.bar span img {
  width: 25px;
  height: 25px;
  margin: auto;
}

.msg {
  width: 340px;
  margin: auto;
  background: #b8ddf7;
  border-radius: 0 0 10px 10px;
  border: 2px solid #3399ff;
  border-top: 0;
  z-index: 1;
  min-height: 250px;
  max-height: 350px;
}

.msg p{
    font-size: 18px;
    text-align: left;
    text-indent: 15px;
}

.hot {
    margin-top: 20px;
    overflow: hidden;
}

.hot ul{
    display: flex;
    align-content: space-around;
    width: 100%;
     flex-wrap: wrap;
     margin: 10px 0;
}

.hot ul li{
    height: 30px;
    width: 50%;
    text-align: left;
    text-indent: 20px;
    line-height: 30px;
}

.record {
    margin-top: 10px;
}

.record ul{
     display: flex;
    align-content: space-around;
    width: 100%;
    flex-wrap: wrap;
      margin: 10px;
}

.record ul li{
    height: 25px;
    margin: 5px;
    padding: 5px;
    border-radius: 5px;
    background: #f6f7f8;
}

.record ul li:hover{
    color: #00aeef;
}


</style>
