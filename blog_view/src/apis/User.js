import request from '@/request'

export default function loginToBack(account, password) {
    alert(account, password)
    const data = {
      account,
      password
    }
    return request({
      url: '/login',
      method: 'post',
      params: data,
    })
}