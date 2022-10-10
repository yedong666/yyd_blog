<template>
  <div>
    <div class="container">
      <canvas id="myChart"></canvas>
    </div>
  </div>
</template>

<script>
import Chart from 'chart.js/auto'

export default {
  name: 'DataView',

  data() {
    return {
    }
  },

  mounted() {
    Chart.defaults.font.size = 16
    Chart.defaults.color = 'black'
    var ctx = document.getElementById('myChart').getContext('2d')
    new Chart(ctx, {
      type: 'line',
      data: {
        labels: [
          'January',
          'February',
          'March',
          'April',
          'May',
          'June',
          'July',
          'August',
          'September',
          'October',
          'November',
          'December',
        ],
        datasets: [
          {
            label: '2022年',
            tension: 0,
            backgroundColor: 'white',
            borderColor: 'white',
            borderWidth: 3,
            pointStrokeColor: 'black',
            pointStyle: 'crossRot',
            bodyFontSize: 20,
            data: [65, 59, 0, 81, 56, 10, 40, 22, 32, 54, 10, 30],
            // cubicInterpolationMode: 'monotone',
            spanGaps: 'false',
            fill: 'false',
          },
          {
            label: '2020年',
            backgroundColor: 'red',
            borderColor: 'red',
            borderWidth: 3,
            pointStrokeColor: 'black',
            pointStyle: 'crossRot',
            bodyFontSize: 16,
            data: [35, 69, 8, 21, 76, 30, 44, 29, 22, 84, 40, 38],
            // cubicInterpolationMode: 'monotone',
            spanGaps: 'false',
            fill: 'false',
          },
          {
            label: '2021年',
            backgroundColor: 'blue',
            borderColor: 'blue',
            borderWidth: 3,
            pointStrokeColor: 'black',
            pointStyle: 'crossRot',
            bodyFontSize: 16,
            data: [75, 19, 10, 21, 46, 19, 48, 52, 12, 74, 60, 80],
            // cubicInterpolationMode: 'monotone',
            spanGaps: 'false',
            fill: 'false',
          },
        ],
      },
      options: {
        scales:{
            y:{
                 grid: {
                    color: 'black',
                    borderColor: 'green'
                }
            },
            x:{
                 grid: {
                    color: 'black',
                    borderColor: 'green'
                }
            }    
        },
        plugins: {
          title: {
            display: true,
            text: '2022年网站访问统计（单位：次）',
            color: 'red',
            font: {
              size: 20,
            },
          },

          legend: {
            labels: {
              font: {
                size: 18,
              },
              color: "white",
            },
          },
        },
      },
    })
  },
}
</script>

<style scoped>
.container {
  width: 100%;
  margin: 0;
  padding: 0;
  /* background: white; */
}
</style>
