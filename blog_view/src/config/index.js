import axios from 'axios'

export const requestConfig = () => {
  axios.defaults.baseURL = 'http://localhost:8080'
  axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded'

  // 添加请求拦截器
  axios.interceptors.request.use(
    function (config) {
      // 在发送请求之前做些什么
      alert("开始发送请求")
      return config
    },
    function (error) {
      // 对请求错误做些什么
      alert("请求出错了")
      return Promise.reject(error)
    }
  )

  // 添加响应拦截器
  axios.interceptors.response.use(
    function (response) {
      // 对响应数据做点什么
      alert("已接收到响应数据")
      return response
    },
    function (error) {
      // 对响应错误做点什么
      alert("响应数据出错了")
      return Promise.reject(error)
    }
  )

  console.log('请求配置完毕')
}
