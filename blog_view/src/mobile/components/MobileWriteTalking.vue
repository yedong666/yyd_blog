<template>
  <div class="container">
    <div>
      <input type="text" placeholder="标题">
      <textarea placeholder="请输入内容"></textarea>
      <ul>
        <li>
          <img src="../../assets/图片.png" alt="">
        </li>
        <li>
          <img src="../../assets/表情.png" alt="">
        </li>
      </ul>
      <el-button>发布</el-button>
    </div>
  </div>
</template>

<script>

export default {
    data(){
        return{
            article:'',
        }
    },
  mounted() {}
   
  }
</script>

<style scoped>

*{
  margin: 0;
  padding: 0;
  border: 0;
}

.container{
    display: flex;
    flex-direction: column;
    justify-content: center;
    height: 100vh;
    width: 98%;
    margin: auto;
    margin-top: 2vh;
}

li{
  list-style: none;
}

.container ul{
  display: flex;
  background: #f5fcfd;
 
  margin-top: -1vh;
}

.container ul li{
  width: 50%;
  margin: 0;
  border: 0;
  display: flex;
}

.container ul li img{
  width: 50px;
  height: 50px;
  margin: auto;
}

.container input{
  width: 98%;
  line-height: 5vh;
  padding-left: 5px;
  color: #8590a6;
  border: 0;
  border-bottom: 2px solid #f0f2f7;
  font-size: 20px;
}

.container textarea{
  width: 98%;
  height: 80vh;
  padding-left: 5px;
  padding-top: 20px;
  border: 0;
  font-size: 18px;
  color: #8590a6;
  margin-bottom: 0;
}

.el-button{
  width: 100%;
  height: 7vh;
  background: #0199ff;
  font-size: 20px;
  color: white;
}

</style>
