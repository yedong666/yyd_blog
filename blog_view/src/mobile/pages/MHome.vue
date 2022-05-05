<template>
    <div class="mobileHome" @mousewheel = "mouseWheel">
        <mobile-nav-bar :style="navStyle" :color="colorStyle">

        </mobile-nav-bar>

        <div class="space">
            <img src="../../assets/nav_bg.jpg" alt="">
        </div>
        
        <router-view>
         
        </router-view>
        <mobile-footer>

        </mobile-footer>
    </div>
</template>

<script>
import MobileNavBar from '@/mobile/components/MobileNavBar.vue'
import MobileFooter from '@/mobile/components/MobileFooter.vue'

export default {
    components:{
        MobileNavBar,
        MobileFooter,
    },
    data(){
        return{
            array: [0, 1, 2, 3],
            navStyle:{},
            colorStyle:{}
        }
    },
  methods:{
      mouseWheel(e) {
      e = e || window.event;
      if (e.wheelDelta) {  //判断浏览器IE，谷歌滑轮事件
        if (e.wheelDelta > 0) { //当滑轮向上滚动时
           this.navStyle = {
              display: 'none'
           }
           if(window.scrollY  < 100){
               this.navStyle = {
               display: 'block'
              }
              this.colorStyle = {
               color: '#39c5d2',

           }
           }
         
        }
        if (e.wheelDelta < 0) { //当滑轮向下滚动时
          
           this.navStyle = {
               backgroundImage: 'linear-gradient(141deg,#9fb8ad 0%,#1fc8db 51%,#2cb5e8 75%)',
               boxShadow: '0px 5px 5px #888888',
           }
           this.colorStyle = {
               color: 'black',

           }
        }
      }
      else if (e.detail) {  //Firefox滑轮事件
        if (e.detail> 0) { //当滑轮向上滚动时
          alert("滑轮向上滚动");
        }
        if (e.detail< 0) { //当滑轮向下滚动时
          alert("滑轮向下滚动");
        }
      }
 
      },
  }
    
}
</script>

<style scoped>
*{
    margin: 0;
    padding: 0;
    border: 0;
}
.mobileHome{
    display: flex;
    flex-direction:column;
    overflow: scroll;
}

.space{
    height: 30vh;
    
}

.space img{
    width: 100%;
    height: 100%;
    box-shadow: 0px 5px 5px #888888;
}

</style>