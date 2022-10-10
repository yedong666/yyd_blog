<template>
  <div>
    <div class="type" v-for="tag in tags" :key="tag">
      <div class="name">
        <b>微<span style="color: red">服务</span></b>
      </div>
      <div class="typebox">
        <div class="imgbox">
          <el-image :src="testUrl"></el-image>
        </div>
        <div class="desbox">
          <div class="descontent">
          一种软件开发技术- 面向服务的体系结构（SOA）
          架构样式的一种变体，它提倡将单一应用程序划分成一组小的<span style="color: red">服务</span>，
          服务之间互相协调、互相配合，为用户提供最终价值。
          每个服务运行在其独立的<span style="color: red">进程</span>中，服务与服务间采用轻量级的<span style="color:red">通信机制</span>互相沟通（通常是基于HTTP的RESTful API）。每个服务都围绕着具体业务进行构建，并且能够独立地部署到生产环境、类生产环境等。另外，应尽量避免统一的、集中式的服务管理机制，对具体的一个服务而言，应根据上下文，选择合适的语言、工具对其进行构建。
        </div>
        <div class="readdes">
          详情 <i class="el-icon-arrow-down"></i>
        </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data(){
    return{
      tags:[1, 2, 3, 4, 5],
      testUrl: 'https://img2.baidu.com/it/u=2162475733,3064124080&fm=253&fmt=auto&app=138&f=PNG?w=1520&h=500',
    }
  }
}
</script>

<style scoped>

.type{
  width: 90%;
  margin: 20px auto;
  border: 1px solid #3399ff;
  padding: 10px;
}

.name{
  height: 40px;
  font-size: 18px;
  line-height: 40px;
  text-align: left;
  width: 100%;
}

.typebox{
  width: 100%;
  height: 110px;
  display: flex;
  justify-content:space-between;
}

.imgbox{
  width: 20%;
  height: 100%;
}

.imgbox .el-image{
  width: 100%;
  height: 100%;
}

.desbox{
  width: 78%;
  height: 100%;
}

.descontent{
  width: 100%;
  padding: 0;
  overflow: hidden;
  word-break: break-all;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 4;
  text-overflow: ellipsis;
}

.readdes{
  height: 20%;
  text-align: right;
  margin-top: 5px;
  color: #3399ff;
  padding-right: 10px;
}




</style>
