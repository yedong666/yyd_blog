<template>
  <div class="me-container">
    <el-container>
      <el-main>
        <div class="pictShow"> 
            <!-- 可通过fit确定图片如何适应到容器框 -->
            <el-image  src="https://img0.baidu.com/it/u=1242273181,3992362129&fm=26&fmt=auto" >

            </el-image>
        </div>
        <div class="wordShow">
          <p>男，单身，在校大学生，</p>
          <p>好吃但不懒做，没钱也没颜，</p>
          <p>不喜欢唱跳但喜欢打篮球.</p>
        </div>
      </el-main>
      <el-footer>
        <el-row :gutter="gutter">
          <el-col :span="4">
            <img src="..\assets\icon_QQ.png" alt="">
          </el-col>
          <el-col :span="8">
            <p>2050333453</p>
          </el-col>
          <el-col :span="4">
            <img src="..\assets\电话.png" alt="">
          </el-col>
          <el-col :span="8">
            <p>17585629859</p>
          </el-col>
        </el-row>
        <el-row :gutter="gutter">
             <el-col :span="4">
            <img src="..\assets\github-fill.png" alt="">
          </el-col>
          <el-col :span="8">
            <p>Yjedo</p>
          </el-col>
          <el-col :span="4">
            <img src="..\assets\微信.png" alt="">
          </el-col>
          <el-col :span="8">
              <p>yyd97851</p>
          </el-col>
        </el-row>
      </el-footer>
    </el-container>
    
  </div>
</template>

<script>
export default {
    name: 'MeShow',
    data(){
        return{
          gutter: 5,
            // qq: "..\assets\qq轻聊.png",
            // phone: "..\assets\电话.png",
            // githup: "..\assets\github-fill.png",
            // wechat: "..\assets\微信.png",
        }
    }
}
</script>

<style scoped>
  .me-container{
    /* position: absolute;
    right: 150px;
    top: 180px; */
    background: #b8ddf7;
    width: 530px;
    height: 600px;
    margin: auto;
    margin-top: 20px;
    margin-left: 50px;
     /* opacity: 90%; */
  }

  .el-image{
    width: 200px; 
    height: 200px;
    border-radius: 100%;
  }
  .wordShow{
    width: 400px;
    height: 150px;
    font-size: 20px;
    border-bottom: solid 2px gray;
    margin: auto;
    margin-top: 20px;
  }

  .wordShow p{
     color: slategrey;
    font-size: 25px;
  }

  img{
    width: 50px;
    height: 50px;
    margin: 15px auto;
  }
  .el-col p{
    text-align: left;
    color: grey;
    font-size: 25px;
    line-height: 80px;
  }
</style>