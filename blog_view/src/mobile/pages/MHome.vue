<template>
    <div class="mobileHome">
        <mobile-nav-bar>

        </mobile-nav-bar>

        <div class="space">
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
        }
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
    height: 5vh;
}

</style>