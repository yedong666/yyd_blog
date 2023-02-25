<template>
  <div class="con">
    <div class="userCard">
      <div class="userAvatar">
        <el-image :src="src"></el-image>
      </div>
      <div class="userData">
        <div style="width: 90%">
          <p>
            <i class="el-icon-user" style="margin-right: 20px"></i>{{form.nickname  }}<i class="el-icon-female" style="margin-left: 5px"></i>
            <el-button type="info" style="padding: 5px">普通用户</el-button>
          </p>
          <p><i class="el-icon-date" style="margin-right: 20px"></i>2002-12-23</p>
          <el-input v-model="form.signature" style="opacity: 0.2" suffix-icon="el-icon-edit"></el-input>
          <div><span>无痕浏览</span><el-switch v-model="form.incognito"></el-switch></div>
        </div>
      </div>
    </div>
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="用户昵称">
        <el-input v-model="form.nickname"></el-input>
      </el-form-item>
      <el-form-item label="用户性别">
        <el-select v-model="form.gender" style="width: 100%">
          <el-option label="男性" value="1"></el-option>
          <el-option label="女性" value="0"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="出生日期">
        <el-date-picker type="date" v-model="form.birthdate" style="width: 100%"></el-date-picker>
      </el-form-item>
      <el-form-item label="手机号码">
        <el-input v-model="form.phoneNumber"></el-input>
      </el-form-item>
      <el-form-item label="邮箱地址">
        <el-input v-model="form.email"></el-input>
      </el-form-item>

      <el-form-item label="用户状态">
        <el-radio-group v-model="form.status">
          <el-radio :label="1">在线</el-radio>
          <el-radio :label="2">开心</el-radio>
          <el-radio :label="3">孤独</el-radio>
          <el-radio :label="4">沧桑</el-radio>
          <el-radio :label="5">忙碌</el-radio>
          <el-radio :label="6">忙碌</el-radio>
          <el-radio :label="7">勿扰</el-radio>
          <el-radio :label="8">隐身</el-radio>
        </el-radio-group>
      </el-form-item>

      <el-form-item label="兴趣标签">
        <el-checkbox-group v-model="form.tags">
          <el-checkbox label="IT技术" ></el-checkbox>
          <el-checkbox label="生活随笔" ></el-checkbox>
          <el-checkbox label="新闻热点" ></el-checkbox>
          <el-checkbox label="文学名著" ></el-checkbox>
          <el-checkbox label="网络热文" ></el-checkbox>
          <el-checkbox label="情感分享" ></el-checkbox>
        </el-checkbox-group>
      </el-form-item>

      <el-form-item label="个人介绍">
        <el-input type="textarea" v-model="form.desc"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">保存</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
export default {
  name: 'UserData',
  data() {
    return {
      form: {
        nickname: '云烟成雨',
        role: 1,
        phoneNumber: '17585629859',
        email: 'yedong@163.com',
        birthdate: '2002-2-13',
        gender: '1' ,
        //个性签名
        signature: '趁着年轻生猛，我要再和生活死磕几年。',
        //个人介绍
        desc: ' 忠实诚信,讲原则，说到做到，决不推卸责任；',
        status: 5,
        tags: ["IT技术", "网络热文"],
        //无痕浏览
        incognito:false,
      },
      src: 'https://tse3-mm.cn.bing.net/th/id/OIP-C.VQV_HgDF4a1iYzTbkqtEYwAAAA?w=210&h=210&c=7&r=0&o=5&dpr=1.3&pid=1.7',
    }
  },
  methods: {
    onSubmit() {
      console.log('submit!')
    },
  },
}
</script>
<style scoped>
.con {
  display: flex;
  flex-direction: column;
}

.el-form {
  width: 90%;
  margin: auto;
}

.userCard {
  display: flex;
  width: 100%;
  flex-direction: row;
  margin-bottom: 20px;
  background-image: linear-gradient(135deg, rgb(145, 204, 222), #9fa6a7);
}

.userAvatar {
  padding: 20px;
}

.userData {
  width: 75%;
  color: #2d3334;
  text-align: left;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  padding: 20px 5px;
}

.userData p {
  margin: 10px;
}

.userData div {
  margin: 10px;
}

.el-image {
  width: 200px;
  height: 200px;
  margin: auto;
  border: 1px solid white;
  border-radius: 50%;
}
</style>
