import Vue from 'vue'
import App from './App.vue'


import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'
import hljs from 'highlight.js'
import 'highlight.js/styles/idea.css';
import store from './store'
import router from './router/index'
// import requestConfig from './config/index.js'


Vue.use(ElementUI)

Vue.config.productionTip = false

Vue.directive('highlight', function(el){
  const blocks = el.querySelectorAll('pre code')
  blocks.forEach((block)=>{
    console.log(block)
    block.style.background = '#f5f2f0'
    hljs.highlightBlock(block)
  })
})

// requestConfig()

new Vue({
  render: h => h(App),
  router,
  store,
}).$mount('#app')
