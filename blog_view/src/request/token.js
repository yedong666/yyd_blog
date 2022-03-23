//从浏览器缓存中获取token(获取用户信息)
export function getUserData() {
    return localStorage.user
}

//向浏览器缓存中存入token数据(登录)
export function setUserData(user) {

    return localStorage.user = JSON.stringify(user)
}

//从浏览器缓存中移除用户缓存数据(注销)  
export function removeToken() {
    return localStorage.removeItem('user')
}