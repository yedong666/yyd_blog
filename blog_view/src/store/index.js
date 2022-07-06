import Vue from 'vue'
import Vuex from 'vuex'
import {setUserData, removeToken, getToken, setToken} from '@/request/token'
import {loginToBack, logoutFromBack} from '@/apis/user.js'

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    user:{},
    articles: [],
    token: getToken()==null ? "" : getToken(),
  },
  mutations: {
    SET_ARTICLES(state, articles){
      state.articles = articles
    },
    SET_USER: (state, token) => {
      if(token != null){
        state.user.id = token.id;
        state.user.account = token.account;
        state.user.nickname = token.nickname;
        state.user.status = token.status;
      }
    },
  },
  actions: {

    //登录
    login({commit}, user) {
      return new Promise((resolve, reject) => {
        loginToBack(user.account, user.password).then(response => {
          commit('SET_USER', response.data.data["user"])
          //存储用户信息至浏览器缓存
          console.log(response.data)
          setUserData(response.data.data["user"])
          setToken(response.data.data["token"])
          resolve()
        }).catch(error => { 
          reject(error)
        })
      })
    },

    //退出
    logout({commit}, state) {
      console.log(state)
      return new Promise((resolve, reject) => {
        logoutFromBack(state).then(data => {
          console.log(data)
          commit('SET_USER', null)
          removeToken()
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },

    

  }

})
