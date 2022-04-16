<template>
  <div id="app">
      <router-view></router-view>
      <GoTop></GoTop>
  </div>
</template>

<script>

import GoTop from '@/components/GoTop.vue'

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

body{
  /**/
  background: url('./assets/gif-bg1.gif');
  background-repeat: no-repeat;
  background-size: cover;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;

}
</style>
