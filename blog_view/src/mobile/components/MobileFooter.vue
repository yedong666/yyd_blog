<template>
  <div class="container">
          <ul>
              <li>
                  <img src="..\..\assets\邮箱.png" alt="">
              </li>
              <li>
                  <img src="..\..\assets\qq.png" alt="">
              </li>
              <li>
                    <img src="..\..\assets\微信.png" alt="">
              </li>
              <li>
                    <img src="..\..\assets\github-fill.png" alt="">
              </li>
          </ul>
     <span>
         Copyright © 2022叶栋个人博客
     </span>
  </div>
</template>

<script>
export default {
    name: 'MobileFooter',
    data(){
        return{
            
        }
    },
    methods:{

    }
}
</script>

<style scoped>
.container{
    display: flex;
    flex-direction: column;
    height: 15vh;
    width: 100%;
    padding: 0;
    margin-top: 1vh;
    margin-bottom: 1vh;
    background-image: linear-gradient(141deg,#9fb8ad 0%,#1fc8db 51%,#2cb5e8 75%);
    
}

ul{
    margin-top: 5vh;
    display: flex;
    flex-direction: row;
    justify-content: space-around;
}

li{
    list-style: none;
    width: 10%;
    height: 5vh;
}

img{
    width: 100%;
    height: 100%;
}

span{
    margin-top: 20px;
    width: 100%;
}

</style>