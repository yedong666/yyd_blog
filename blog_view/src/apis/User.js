import request from '@/request'

export function loginToBack(account, password) {
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

export function registerToBack(user){
  alert("开始注册")
  return request({
    url: '/register',
    method: 'post',
    headers: {
      'Content-Type': 'application/json'
    },
    data: JSON.stringify(user),
  })
}  

export function logoutFromBack(state){
  console.log(state)
  return request({
    url: '/logout',
    method: 'post',
    headers: {
      'Content-Type': 'application/json'
    },
    data: JSON.stringify(state),
  })
}