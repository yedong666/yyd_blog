<template>
  <div class="topCon">
    <div class="container" style="border-right: 2px solid #dcdfe6;">
        <h1>用户年龄分布</h1>
        <div style="width: 100%;">
            <canvas id="myChart2"></canvas>
        </div>
    </div>
    <div class="container" >
      <div class="con" style="width: 60%; margin: auto">
        <canvas id="myChart1"></canvas>
        <h1 style="margin:10px auto">用户角色分布</h1>
      </div>
      <el-divider></el-divider>
      <div class="con">
        <canvas id="myChart3"></canvas>
      </div>
    </div>
  </div>
</template>

<script>
import Chart from 'chart.js/auto'

export default {
  name: 'UserDataView',
  data() {
    return {
      chart1Data: {
        labels: ['普通用户', '管理员', '站长'],
        datasets: [
          {
            label: 'My First Dataset',
            data: [10, 3, 1],
            backgroundColor: ['rgb(255, 99, 132)', 'rgb(54, 162, 235)', 'rgb(255, 205, 86)'],
            hoverOffset: 4,
          },
        ],
      },
      chart2Data: {
        labels: ['12岁以下', '12-18岁', '18-22岁', '22-35岁', '35岁以上'],
        datasets: [
          {
            label: '用户年龄分布',
            data: [11, 16, 7, 3, 14],
            backgroundColor: [
              'rgb(255, 99, 132)',
              'rgb(75, 192, 192)',
              'rgb(255, 205, 86)',
              'rgb(201, 203, 207)',
              'rgb(54, 162, 235)',
            ],
          },
        ],
      },

      chart3Data: {
        labels: ['January', 'February', 'March', 'April', 'May', 'June', 'July',   'August',
          'September',
          'October',
          'November',
          'December',],
        datasets: [
          {
            label: '2021年注册用户统计',
            data: [65, 59, 80, 81, 56, 55, 40, 65, 49, 70, 81, 56, 45, 32],
            backgroundColor: [
              'rgba(255, 99, 132, 0.7)',
              'rgba(255, 159, 64, 0.7)',
              'rgba(255, 205, 86, 0.7)',
              'rgba(75, 192, 192, 0.7)',
              'rgba(54, 162, 235, 0.7)',
              'rgba(153, 102, 255, 0.7)',
              'rgba(201, 203, 207, 0.7)',
               'rgba(255, 159, 64, 0.7)',
              'rgba(255, 205, 86, 0.7)',
              'rgba(75, 192, 192, 0.7)',
              'rgba(153, 102, 255, 0.7)',
              'rgba(201, 203, 207, 0.7)',
            ],
            borderColor: [
              'rgb(255, 99, 132)',
              'rgb(255, 159, 64)',
              'rgb(255, 205, 86)',
              'rgb(75, 192, 192)',
              'rgb(54, 162, 235)',
              'rgb(153, 102, 255)',
              'rgb(201, 203, 207)',
              'rgb(255, 159, 64 )',
              'rgb(255, 205, 86)',
              'rgb(75, 192, 192)',
              'rgb(153, 102, 255)',
              'rgb(201, 203, 207)',
            ],
            borderWidth: 1,
          },
        ],
      },
    }
  },
  mounted() {
    Chart.defaults.color = 'black'
    var ctx1 = document.getElementById('myChart1').getContext('2d')
    var ctx2 = document.getElementById('myChart2').getContext('2d')
    var ctx3 = document.getElementById('myChart3').getContext('2d')
    new Chart(ctx1, {
      type: 'pie',
      data: this.chart1Data,
    })
    new Chart(ctx2, {
      type: 'polarArea',
      data: this.chart2Data,
    })
    new Chart(ctx3, {
      type: 'bar',
      data: this.chart3Data,
      options: {
      
      }
    })
  },
}
</script>

<style scoped>

h1{
    text-align: center;
    font-size: 25px;
    padding: 0;
    height: 40px;
    margin: 30px auto;
    margin-bottom: 20px;
    background-image: linear-gradient(135deg,#e4002b, rgb(0, 195, 255));
            background-clip:text;
            -webkit-background-clip:text;
            color: transparent;
}

.topCon {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-around;
  width: 100%;
  height: 100%;
}
.container {
  display: flex;
  align-content: flex-start;
  width: 49%;
  height: 800px;
  margin-top: 10px;
  flex-wrap: wrap;

}

.con {
  width: 100%;
  height: 50%;
  margin: auto;
}
</style>
