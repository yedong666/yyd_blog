<template>
  <div class="container">
    

      <div class="user" v-for="(user, index) in users" :key="index">
        <div class="avatar">
           <el-image
            :src="avatarUrl"
            :fit="fit">
            </el-image>
        </div>

        <div class="introduction">
          
          <div class="nickname">
            <b>无敌暴龙战士</b> <i class="el-icon-user-solid"></i>
          </div>

          <div class="msg" style="height: 60px">
            <div class="str">因为爱，所以爱</div>  
            <div ><span>粉丝: 15</span> <span>文章: 23</span></div>         
          </div>

          <div class="follow">
            <span>关注</span>
          </div>

        </div>

      </div>

  </div>
</template>

<script>
export default {
  data(){
    return{
      avatarUrl: "https://img0.baidu.com/it/u=1940128480,2968277638&fm=253&fmt=auto&app=138&f=JPEG?w=400&h=400",
      users: [1,2, 3, 4, 5, 6, 7]
    }
  }
}
</script >

<style scoped>

.container{
  display: flex;
  flex-wrap: wrap;
  justify-content: left;
}

.user{
  width: 47%;
  margin: 20px 0 30px 3%;
  height: 130px;
  display: flex;
}

.avatar{
  height: 100%;
  border-radius: 100%;
  overflow: hidden;
}

.avatar .el-image{
  width: 100%;
  height: 100%;
}

.introduction{
  height: 100%;
  width: 70%;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}

.introduction div{
  margin: 0 auto;
  width: 90%;
  height: 30px;
  line-height: 30px;
}

.nickname{
  font-size: 18px;
  text-align: left;
}

.msg {
  display: flex;
  flex-wrap: wrap;
  color: #898989;
  margin-bottom: 10px;

}

.msg div{
  text-align: left;
  width: 100%;
  height: 50%;
  font-size: 16px;
  overflow: hidden;
}

.msg div span{
  margin-right: 10px;
  font-size: 14px;
}

.msg .str{
  display:-webkit-box;
  text-overflow: ellipsis;/*隐藏后添加省略号*/
  -webkit-box-orient:vertical; 
  -webkit-line-clamp:1;
  color: black;
}

.follow{
  display: flex;
  justify-content: left;
}


.follow span{
  font-size: 18px;
  padding: 0 20px;
  text-align: center;
  background: #00aeec;
  color: white;
  border-radius: 10px;
}







</style>