<template>
  <div id="app">
      <router-view></router-view>
       <!-- 回到顶部 -->
      <GoTop class="goTop"></GoTop>
  </div>
</template>

<script>

import GoTop from '@/components/GoTop.vue'

//git2
export default {
  name: 'App',
  components: {
    GoTop,
  }
}
</script>

<style >
*{
  margin: 0;
  padding: 0;
  border: 0;
}

@media screen and (min-width: 800px){
   body{
  /**/
  background-image: linear-gradient(141deg,rgb(212, 217, 207) 0%,rgb(19, 176, 203) 51%,#b579cb 75%);
  background-repeat: no-repeat;
  background-size: cover;
}
}

@media screen and (max-width: 700px){
   body{
  /**/
    background-color: #1fc8db;
    background-image: linear-gradient(141deg,#9fb8ad 0%,#1fc8db 51%,#2cb5e8 75%);
    opacity: 0.95;
    }

}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;

}
</style>
