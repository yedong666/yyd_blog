<template>
  <div class="sortBar-container">
    <div class="link-container">
      <h2>最热文章</h2>
      <el-row v-for="(link, index) in links" :key="index">
        <el-col :span="24"
          ><el-link type="primary">{{ link }}</el-link></el-col
        >
      </el-row>
      <el-row>
        <el-col :span="24"
          ><el-link type="info">详情</el-link></el-col
        >
      </el-row>
    </div>
    <div  class="link-container">
      <h2>最热文章</h2>
      <el-row v-for="(link, index) in links" :key="index">
        <el-col :span="24"
          ><el-link type="primary">{{ link }}</el-link></el-col
        >
      </el-row>
       <el-row>
        <el-col :span="24"
          ><el-link type="info">详情</el-link></el-col
        >
      </el-row>
    </div>
  </div>
</template>

<script>
export default {
  name: 'SortBar',
  data() {
    return {
      links: ['Java编程语言', 'Java编程语言', 'Java编程语言', 'Java编程语言', 'Java编程语言'],
    }
  },
}
</script>

<style scoped>
.sortBar-container {
  /* position: absolute;
  right: 150px;
  top: 820px; */
  background: #e0f6ff;
  width: 530px;
  margin: auto;
  margin-top: 20px;
   margin-left: 50px;
    /* opacity: 90%; */
}

h2 {
  margin-top: 20px;
}

.link-container {
  width: 100%;
  background: #b8ddf7;
  margin-bottom: 20px;
  overflow: hidden;;
}

.el-row {
  margin-top: 20px;
}
.el-link {
  font-size: 25px;
}
</style>
