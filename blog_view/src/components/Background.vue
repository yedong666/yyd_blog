<template>
  <div class="block">
      <h1>用文字记录生活，用记忆追寻时光</h1>
  </div>
</template>

<script>
export default {
  name: 'Background',
  data() {
    return {
    }
  },
}
</script>
<style scoped>
    .block{
        width: 100%;
        height: 100px;
        background-repeat:repeat;
    }

    .block h1{  
      line-height: 100px;
       font-size: 40px;
            background-image: linear-gradient(135deg,rgb(0, 195, 255),rgb(176, 176, 202));
            background-clip:text;
            -webkit-background-clip:text;
            color: transparent;
    }

</style>
