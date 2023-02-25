import request from '@/request'

export function loginToBack(account, password) {
    const data = {
      account,
      password
    }
    return request({
      url: '/login',
      method: 'get',
      headers: {
        'Content-Type': 'application/json'
      },
      params: data,
    })
}

export function getUsers(){
  return request({
    url: '/getUsers',
    method: 'get',
    headers: {
      'Content-Type': 'application/json'
    }
  })
}

export function getUserByIdFromBack(userId){
  return request({
    url: '/getUserById',
    method: 'get',
    headers: {
      'Content-Type': 'application/json'
    },
    params:{
        id: userId,
    },
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
    data:state,
  })
}

export function getUserData(id){
  return request({
    url: '/getUserHomeData',
    method: 'get',
    headers: {
      'Content-Type': 'application/json'
    },
    data:id,
  })
}

export function setUserData(userData){
  return request({
    url: '/setUserHomeData',
    method: 'post',
    headers: {
      'Content-Type': 'application/json'
    },
    data:userData,
  })
}