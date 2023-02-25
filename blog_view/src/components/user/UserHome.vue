<template>
  <div class="userhome">
    <div class="menuCon">
      <div class="child1" @click="jumpTo('user_article')">
        <div class="tagCon">
          <div>
            <img src="..\..\assets\创作者中心.png" alt="" />
          </div>
          <p>创作中心</p>
        </div>
      </div>
      <div class="child2"  @click="jumpTo('userdata')">
        <div class="tagCon">
          <div>
            <img src="..\..\assets\个人信息.png" alt="" />
          </div>
          <p>个人信息</p>
        </div>
      </div>
      <div class="child3"  @click="jumpTo('user_followList')">
        <div class="tagCon">
          <div>
            <img src="..\..\assets\我的关注.png" alt="" />
          </div>
          <p>关注列表</p>
        </div>
      </div>
      <div class="child4"  @click="jumpTo('user_history')">
        <div class="tagCon">
          <div>
            <img src="..\..\assets\历史.png" alt="" />
          </div>
          <p>操作历史</p>
        </div>
      </div>
      <div class="child5"  @click="jumpTo('user_message')">
        <div class="tagCon">
          <div>
            <img src="..\..\assets\消息中心.png" alt="" />
          </div>
          <p>我的消息</p>
        </div>
      </div>
    </div>
    <div class="userview">
        <router-view></router-view>
    </div>
  </div>
</template>

<script>
export default {
  name: 'UserHome',
  data() {
    return {}
  },
  methods: {
    jumpTo(path) {
      this.$router.push({
        path: '/home/user/' + path,
      })
    },
  },
}
</script>

<style scoped>
img {
  width: 100px;
  height: 100px;
  margin: auto;
  background-size: cover;
  background-repeat: no-repeat center;
}

p {
  text-align: center;
  font-size: 20px;
}

.userhome {
  background: #b8ddf7;
  border: 2px solid white;
}

.menuCon {
  display: flex;
  flex-direction: row;
  width: 100%;
  padding-top: 10px;
  padding-bottom: 10px;
  justify-content: space-around;
}

.menuCon div {
  height: 200px;
  display: flex;
}

.tagCon {
  display: flex;
  width: 160px;
  margin: auto;
  flex-direction: column;
  
}

.tagCon:hover{
    background: #52565e;
    border: 2px solid #00bce4;
    border-radius: 10px;
    color: #00bce4;
}

.tagCon div {
  overflow: hidden;
  width: 160px;
  height: 160px;
}

.child1 {
  background: #ff4f81;
  border-radius: 10px;
}

.child2 {
  background: gold;
  border-radius: 10px;
}

.child3 {
  background: #74d2e7;
  border-radius: 10px;
}

.child4 {
  background: palegreen;
  border-radius: 10px;
}

.child5 {
  background: #dbebfa;
  border-radius: 10px;
}

.userview{
    border-top: 2px solid white;
    margin-bottom: 20px;
    padding: 0;
    height: 1150px;
}

</style>
