<template>
  <div class="mobileHome" @mousewheel="mouseWheel" @touchmove="touchmove" @touchstart='touchstart'>
    <mobile-nav-bar :navStyle="navStyle" :navColor="colorStyle" @changeStyle="styleDown"> </mobile-nav-bar>

    <div class="space">
      <img src="../../assets/nav_bg.jpg" alt="" />
    </div>

    <router-view> </router-view>
    <mobile-footer> </mobile-footer>
  </div>
</template>

<script>
import MobileNavBar from '@/mobile/components/MobileNavBar.vue'
import MobileFooter from '@/mobile/components/MobileFooter.vue'

export default {
  components: {
    MobileNavBar,
    MobileFooter,
  },
  data() {
    return {
      array: [0, 1, 2, 3],
      navStyle: {},
      colorStyle: {},
      startX: Number,
      startY: Number,
      moveX: Number,
      moveY: Number,
    }
  },
  methods: {

     touchstart (e) {
	// 如果你要阻止点击事件，请反注释下一行代码
    // e.preventDefault()
     this.startX = e.touches[0].clientX
     this.startY = e.touches[0].clientY
   },

    touchmove(e) {
      // e.preventDefault()
      this.moveX = e.touches[0].clientX
      this.moveY = e.touches[0].clientY
      this.startX - this.moveX <= 0 ? console.log('你在往右滑') : console.log('你在往左滑')
      if (this.startY - this.moveY <= -20) {
        this.styleDown()
      }
      if(this.startY - this.moveY >= 20){
        this.styleUp()
      }
    },

    styleUp() {
      this.navStyle = {
        display: 'none',
      }
      if (window.scrollY < 400) {
        this.navStyle = {
          display: 'block',
        }
        this.colorStyle = {
          color: '#39c5d2',
        }
      }
    },
    styleDown() {
      this.navStyle = {
        backgroundImage: 'linear-gradient(141deg,#9fb8ad 0%,#1fc8db 51%,#2cb5e8 75%)',
        boxShadow: '0px 5px 5px #888888',
      }
      this.colorStyle = {
        color: 'black',
      }
    },
    mouseWheel(e) {
      e = e || window.event
      if (e.wheelDelta) {
        //判断浏览器IE，谷歌滑轮事件
        if (e.wheelDelta > 0) {
          //当滑轮向上滚动时
          this.styleUp()
        }
        if (e.wheelDelta < 0) {
          //当滑轮向下滚动时
          this.styleDown()
        }
      } else if (e.detail) {
        //Firefox滑轮事件
        if (e.detail > 0) {
          //当滑轮向上滚动时
          alert('滑轮向上滚动')
        }
        if (e.detail < 0) {
          //当滑轮向下滚动时
          alert('滑轮向下滚动')
        }
      }
    },
  },
}
</script>

<style scoped>
* {
  margin: 0;
  padding: 0;
  border: 0;
}
.mobileHome {
  display: flex;
  flex-direction: column;
  overflow: scroll;
}

.space {
  height: 30vh;
}

.space img {
  width: 100%;
  height: 100%;
  box-shadow: 0px 5px 5px #888888;
}
</style>
