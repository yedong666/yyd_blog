import Vue from 'vue'
import Vuex from 'vuex'
import {setUserData, getUserData} from '@/request/token'
import {loginToBack} from '@/apis/user.js'

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    id: '',
    account: '',
    password: '',
    nickname: '',
    status: '', 
    userData: getUserData(),
  },
  mutations: {
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

    

  }

})
