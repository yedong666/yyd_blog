<template>
  <div class="container">
   
      <div class="block">
        <p class="demonstration"><b>博主照片分享</b></p>
        <el-carousel height="450px">
          <el-carousel-item v-for="(img, index) in imgs" :key="index">
            <el-image :src="img"></el-image>
          </el-carousel-item>
        </el-carousel>
      </div>
      
    <el-descriptions
      class="margin-top"
      title="基本信息"
      :column="1"
      :size="size"
      border
    >
      <el-descriptions-item :contentStyle="{'background': '#b8ddf7'}" :labelStyle="{'background': '#c4dff6'}">
        <template slot="label">
          <i class="el-icon-user"></i>
          姓名
        </template>
        叶栋
      </el-descriptions-item>
      <el-descriptions-item :contentStyle="{'background': '#b8ddf7'}" :labelStyle="{'background': '#c4dff6'}">
        <template slot="label">
          <i class="el-icon-mobile-phone"></i>
          性别
        </template>
        男
      </el-descriptions-item>
      <el-descriptions-item :contentStyle="{'background': '#b8ddf7'}" :labelStyle="{'background': '#c4dff6'}">
        <template slot="label">
          <i class="el-icon-mobile-phone"></i>
          年龄
        </template>
        20
      </el-descriptions-item>
      <el-descriptions-item :contentStyle="{'background': '#b8ddf7'}" :labelStyle="{'background': '#c4dff6'}">
        <template slot="label">
          <i class="el-icon-mobile-phone"></i>
          兴趣爱好
        </template>
        篮球、游戏、电影、阅读
      </el-descriptions-item>
      <el-descriptions-item :contentStyle="{'background': '#b8ddf7'}" :labelStyle="{'background': '#c4dff6'}">
        <template slot="label">
          <i class="el-icon-mobile-phone"></i>
          情感状态
        </template>
        单身20年
      </el-descriptions-item>
      <el-descriptions-item :contentStyle="{'background': '#b8ddf7'}" :labelStyle="{'background': '#c4dff6'}">
        <template slot="label">
          <i class="el-icon-mobile-phone"></i>
          手机号
        </template>
        18100000000
      </el-descriptions-item>
      <el-descriptions-item :contentStyle="{'background': '#b8ddf7'}" :labelStyle="{'background': '#c4dff6'}">
        <template slot="label">
          <i class="el-icon-location-outline"></i>
          居住地
        </template>
        安徽省宣城市
      </el-descriptions-item>
      <el-descriptions-item :contentStyle="{'background': '#b8ddf7'}" :labelStyle="{'background': '#c4dff6'}">
        <template slot="label">
          <i class="el-icon-tickets"></i>
          备注
        </template>
        <el-tag size="small">大二在读</el-tag>
      </el-descriptions-item >
      <el-descriptions-item :contentStyle="{'background': '#b8ddf7'}" :labelStyle="{'background': '#c4dff6'}">
        <template slot="label">
          <i class="el-icon-office-building"></i>
          联系地址
        </template>
        合肥工业大学宣城校区学生公寓3号楼601寝室
      </el-descriptions-item>
    </el-descriptions>
    <div class="skills">
      <p><b>掌握技能</b></p>
      <div class="skilldes">
        <span class="name">JAVA:</span>
        <span class="value">
          <el-progress
            :text-inside="true"
            :stroke-width="26"
            :percentage="40"
          ></el-progress>
        </span>
      </div>
      <div class="skilldes">
        <span class="name">C++:</span>
        <span class="value">
          <el-progress
            :text-inside="true"
            :stroke-width="26"
            :percentage="25"
            status="success"
          ></el-progress>
        </span>
      </div>
      <div class="skilldes">
        <span class="name">数据库:</span>
        <span class="value">
          <el-progress
            :text-inside="true"
            :stroke-width="26"
            :percentage="20"
            status="warning"
          ></el-progress>
        </span>
      </div>
      <div class="skilldes">
        <span class="name">前端:</span>
        <span class="value">
          <el-progress
            :text-inside="true"
            :stroke-width="26"
            :percentage="30"
            status="success"
          ></el-progress>
        </span>
      </div>
      <div class="skilldes">
        <span class="name">Linux:</span>
        <span class="value">
          <el-progress
            :text-inside="true"
            :stroke-width="26"
            :percentage="10"
            status="warning"
          ></el-progress>
        </span>
      </div>
      <div class="skilldes">
        <span class="name">爬虫:</span>
        <span class="value">
          <el-progress
            :text-inside="true"
            :stroke-width="26"
            :percentage="20"
            status="exception"
          ></el-progress>
        </span>
      </div>
      <div class="skilldes">
        <span class="name">算法:</span>
        <span class="value">
          <el-progress
            :text-inside="true"
            :stroke-width="26"
            :percentage="15"
            status="warning"
          ></el-progress>
        </span>
      </div>
    </div>
    <div class="other">
      <p><b>性格介绍</b></p>
      <div class="word">
        <p>
          <b>憨厚老实: </b>做事比较认真，勤勤恳恳，话比较少，很少和别人发生争执
        </p>
      </div>
      <div class="word">
        <p>
          <b>乐观向上: </b>不管在困难还是遇到失败，都保持一颗积极向上的心，
        </p>
      </div>
      <div class="word">
        <p>
          <b>活泼好动: </b>很爱运动健身，属于外向性，胆大，热情，不喜欢呆封闭的环境里，不喜欢别人约束自己的行为。
        </p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "About",
  data(){
    return{
      imgs:['https://img0.baidu.com/it/u=2745859833,284606210&fm=253&fmt=auto&app=138&f=JPEG?w=667&h=500',
            'https://img0.baidu.com/it/u=933780911,3987469357&fm=253&fmt=auto&app=138&f=JPEG?w=406&h=500',
           'https://img1.baidu.com/it/u=4168728954,888396052&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=889',
            'https://img2.baidu.com/it/u=725573908,3518372667&fm=253&fmt=auto&app=138&f=JPEG?w=426&h=640']
    }
  }
};
</script>

<style scoped>


.el-descriptions {
  margin-top: 40px;
}



.container {
  background: #b8ddf7;
  padding-left: 5px;
  padding-top: 10px;

}

.block{
  width: 100%;
}

.skills {
  margin-top: 40px;
  height: 320px;
}

.skills p {
  color: #373133;
  font-size: 15px;
  text-align: left;
  margin-bottom: 20px;
}

.demonstration{
  text-align: left;
}

.skilldes {
}

.name {
  width: 10%;
  height: 40px;
  float: left;
}
.value {
  width: 90%;
  height: 40px;
  float: left;
}

.other {
  height: 150px;
  margin-top: 40px;
}

.other p {
  text-align: left;
}

.word p {
  text-align: left;
  text-indent: 20px;
  margin-top: 10px;
  color: #909399;
  margin-bottom: 10px;
}
</style>