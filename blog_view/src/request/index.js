import axios from 'axios'
import store from '@/store'
import { Message } from 'element-ui'

const service = axios.create({
  baseURL: 'http://localhost:8888',
  timeout: 10000,
})

//request拦截器
service.interceptors.request.use(
  function (config) {
    // 在发送请求之前做些什么
    // alert(store.state.token)
    if(store.state.token != ""){
      // alert("store不为空")
      config.headers = {
        'Content-Type': 'application/json',
        'Authorization':store.state.token
      }
    }
    return config
  },
  function (error) {
    // 对请求错误做些什么
    Message({
      type: 'warning',
      showClose: true,
      message: '请求发送失败',
    })
    return Promise.reject(error)
  }
)

// respone拦截器
service.interceptors.response.use(function (response) {
    // 对响应数据做点什么
    return response;
  }, error => {
    /***** 接收到异常响应的处理开始 *****/
    if (error && error.response) {
      // 1.公共错误处理
      // 2.根据响应码具体处理
      switch (error.response.status) {
        case 400:
          error.message = '错误请求(400)'
          break;
        case 401:
          error.message = '未授权，请重新登录(401)'
          break;
        case 403:
          error.message = '权限不够,拒绝访问(403)'
          break;
        case 404:
          error.message = '请求网址域名错误,未找到该网页资源(404 not found)'
          // window.location.href = "/NotFound"
          break;
        case 405:
          error.message = '请求类型未允许(405 Method not allowed)'
          break;
        case 406:
          error.message = '(请求不接受 406)无法使用请求的内容特性响应请求的网页'
          break;
        case 407:
          error.message = '该IP服务被禁止(407),请开启代理授权'
          break;
        case 408:
          error.message = '请求超时(408)'
          break;
        case 409:
          error.message = '(服务器冲突 409) 服务器在完成请求时发生冲突。服务器必须在响应中包含有关冲突的信息'
          break;
        case 410:
          error.message = '（服务器资源不存在 410）请求的资源已永久删除'
          break;
        case 411:
          error.message = '(需要有效长度 411） 服务器不接受不含有效内容长度标头字段的请求'
          break;
        case 412:
          error.message = '(未满足前提条件 412） 服务器未满足请求者在请求中设置的其中一个前提条件'
          break;
        case 413:
          error.message = '（请求实体过大 413） 服务器无法处理请求，因为请求实体过大，超出服务器的处理能力'
          break;
        case 414:
          error.message = '（请求的URI过长 414） 请求的URI过长，服务器无法处理。'
          break;
        case 415:
          error.message = '（不支持的媒体类型 415） 请求的格式不受请求页面的支持'
          break;
        case 416:
          error.message = '（请求范围不符合要求 416） 如果页面无法提供请求的范围，则服务器会返回此状态代码'
          break;
        case 417:
          error.message = '（未满足期望值 417） 服务器未满足”期望”请求标头字段的要求'
          break;
        case 500:
          error.message = '服务器端出错(500)'
          break;
        case 501:
          error.message = '服务器不具备完成请求的功能(501)'
          break;
        case 502:
          error.message = '网络错误,服务器端无响应(502)'
          break;
        case 503:
          error.message = '服务不可用(503)'
          break;
        case 504:
          error.message = '网关超时(504)'
          break;
        case 505:
          error.message = '(HTTP版本不受支持 505)服务器不支持请求中所用的HTTP协议版本'
          break;
        default:
          error.message = `连接错误${error.response.status}`
      }
    } else {
      // 超时处理
      if (JSON.stringify(error).includes('timeout')) {
        Message.error('服务器响应超时，请刷新当前页')
      }
      error.message = '连接服务器失败'
    }
  
    Message.error(error.message)
    return Promise.resolve(error.response)
  });


export default service
