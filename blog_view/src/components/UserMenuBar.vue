<template>
    <div class="UserMenuBarContainer">
        <el-menu
      default-active="2"
      class="el-menu-vertical-demo"
      @open="handleOpen"
      @close="handleClose"
      background-color="#b8ddf7"
      text-color="black"
      >
      <el-menu-item index="1" >
        <i class="el-icon-menu"></i>
        <span slot="title">设置&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
      </el-menu-item>
      <el-menu-item index="2">
        <i class="el-icon-setting"></i>
        <span slot="title">退出&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
      </el-menu-item>
       
       <el-menu-item index="3"> 
            <i class="el-icon-location"></i>
          <span>个人中心</span>
       </el-menu-item>
         
      
      <el-menu-item index="4">
        <i class="el-icon-document"></i>
        <span slot="title">后台管理</span>
      </el-menu-item>
      <el-menu-item index="5" @click="closeMenu">
        <i class="el-icon-document"></i>
        <span slot="title">收起菜单</span>
      </el-menu-item>
      
    </el-menu>
    </div>
</template>

<script>
export default {
    name: 'UserMenuBar',
    data(){
        return{
            emptyData: '',
        }
    },
    methods:{
        closeMenu(){
            this.$emit("closeMenu", false)
        }
    }

}
</script>

<style scoped>
.UserMenuBarContainer{
    margin-top: 20px;
    width: 120px;
}
.el-menu{
    width:140px;
    margin-left: 15px;
}



</style>