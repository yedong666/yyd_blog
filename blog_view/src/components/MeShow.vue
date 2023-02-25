<template>
  <div class="me-container">
    <el-container>
      <el-main>
        <div class="pictShow"> 
            <!-- 可通过fit确定图片如何适应到容器框 -->
           <el-image
   
      :src="avater"
    ></el-image>
        </div>
        <div class="wordShow">
          <p>男，单身，在校大学生</p>
          <p>好吃但不懒做，没钱也没颜</p>
          <p>不喜欢唱跳但喜欢打篮球</p>
        </div>
      </el-main>
      <el-footer>
        <el-row :gutter="gutter">
          <el-col :span="12">
            <div>
              <img src="..\assets\icon_QQ.png" alt="" style="margin-left: 5px">
              <p>2050333453</p>
            </div>
          </el-col>
          <el-col :span="12">
            <div>
              <img src="..\assets\wechat.png" alt="">
              <p>yyd97851</p>

            </div>
          </el-col>

        </el-row>
        <el-row :gutter="gutter">
           <el-col :span="12">
           <div>
            <img src="..\assets\电话.png" alt="" style="margin-left: 5px">
            <p>17685735239</p>
           </div>

          </el-col>

          <el-col :span="12">
            <div>
              <img src="..\assets\github-fill.png" alt="" >
              <p>Yjedo</p>
            </div>
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
          gutter: 20,
          avater:'https://img2.baidu.com/it/u=1451684198,866874194&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=625',
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
    background: #b8ddf7;
  border: 2px solid white;

    width: 90%;
    height: 550px;
    margin: auto;
    margin-top: 20px;
     /* opacity: 90%; */
  }

  .me-container .el-image{
    width: 50%;
    height: 150px;
    border-radius: 100%;
  }
  .me-container .wordShow{
    width: 100%;
    height: 150px;
    border-bottom: solid 2px gray;
    margin-top: 20px;
    padding: 0;
  }

  .me-container .wordShow p{
    width: 100%;
     color: slategrey;
     font-size: 18px;
     text-align: center;
    margin-top: 5px;
  }

  .me-container img{
    width: 50px;
    height: 50px;
  }
  .me-container .el-col div p{
    text-align: left;
    color: grey;
    font-size:18px;
    line-height: 50px;
    padding: 5px;
  }

  .el-col div{
    display: flex;
    flex-direction: row;
  }
 
  .el-col div img{
     margin-left: 20px;
  }

</style>