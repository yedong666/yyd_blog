import Vue from 'vue'
import App from './App.vue'


import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'
import hljs from 'highlight.js'
import 'highlight.js/styles/idea.css';
import store from './store'
import router from './router/index'
// import requestConfig from './config/index.js'

const server = {
  path: '/backend'
}

Vue.use(ElementUI)
Vue.prototype.$server = server
Vue.config.productionTip = false

Vue.directive('highlight', function(el){
  const blocks = el.querySelectorAll('pre code')
  blocks.forEach((block)=>{
    console.log(block)
    block.style.background = '#f5f2f0'
    block.style.margin = '10px 1vw'
    block.style.borderRadius= '10px' 
    hljs.highlightBlock(block)
  })
})


new Vue({
  render: h => h(App),
  router,
  store,  
}).$mount('#app')
