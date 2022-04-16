import Vue from 'vue'
import Vuex from 'vuex'
import {setUserData, getUserData, removeToken} from '@/request/token'
import {loginToBack, logoutFromBack} from '@/apis/user.js'

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    id: '',
    account: '',
    password: '',
    nickname: '',
    status: '', 
    articles: [],
    userData: getUserData(),
  },
  mutations: {
    saveArticles(state, articles){
      state.articles = articles
    },
    SET_TOKEN: (state, token) => {
      state.userData = token;
    },
    SET_ACCOUNT: (state, account) => {
      state.account = account
    },
    SET_PASSWORD: (state, password) =>{
        state.password = password
    },
    SET_NAME: (state, nickname) => {
      state.nickname = nickname
    },
    SET_STATUS: (state, status) => {
      state.status = status
    },
    SET_ID: (state, id) => {
      state.id = id
    }
  },
  actions: {

    //登录
    login({commit}, user) {
      return new Promise((resolve, reject) => {
        loginToBack(user.account, user.password).then(response => {
          commit('SET_TOKEN', response.data)
          console.log(response.data.data)
          setUserData(response.data.data)
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
          commit('SET_TOKEN', '')
          commit('SET_ACCOUNT', '')
          commit('SET_NAME', '')
          commit('SET_ID', '')
          removeToken()
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },

    

  }

})
