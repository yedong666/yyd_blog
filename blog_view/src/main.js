import Vue from 'vue'
import App from './App.vue'
import ElementUI from 'element-ui';
import store from './store'
import 'element-ui/lib/theme-chalk/index.css';
import router from './router/index'
// import requestConfig from './config/index.js'


Vue.config.productionTip = false
Vue.use(ElementUI)

// requestConfig()

new Vue({
  render: h => h(App),
  router,
  store,
}).$mount('#app')
