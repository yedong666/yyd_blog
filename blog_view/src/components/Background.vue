<template>
  <div class="backgroundContainer">
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
    @media screen and (max-width: 768px){
        .backgroundContainer{
        width: 100%;
        height: 100%;
        }

        .backgroundContainer h1{  
           display: block;
           line-height: 100px;
           font-size: 25px;
        }

    }

    @media screen and (min-width: 1200px){
       .backgroundContainer{
        width: 100%;
        height: 100%;
        background-repeat:repeat;
    }

    .backgroundContainer h1{  
      line-height: 100px;
       font-size: 40px;
            background-image: linear-gradient(135deg,rgb(0, 195, 255),rgb(176, 176, 202));
            background-clip:text;
            -webkit-background-clip:text;
            color: transparent;
    }
    }
   

</style>
