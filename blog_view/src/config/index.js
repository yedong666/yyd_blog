import axios from 'axios'

export const requestConfig = ()=>{
    axios.defaults.baseURL = 'http://localhost:8080';
    axios.defaults.headers.common['Authorization'] = AUTH_TOKEN;
    axios.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded';
    console.log("请求配置完毕")
}