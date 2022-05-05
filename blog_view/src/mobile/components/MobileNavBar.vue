<template>
    <div class="container" :style="style">
        <div class="bar" :style="color">
            <ul>
                <li class="a" @click="openMenu">
                   <i class="el-icon-s-fold" :style="color"></i>
                </li >
                <li class="b">
                   YEDONG
                </li>
                <li class="c" @click="goLogin">
                   <i class="el-icon-s-custom" :style="color"></i>登录
                </li>
            </ul>
        </div>
        <div class="menu" v-if="isOpen">
            <ul>
                <li class="a">
                    <div class="item">
                       <el-input placeholder="请输入内容">
                            <el-button  slot="append" icon="el-icon-search"></el-button>
                        </el-input>
                    </div>
                </li>
                 <li class="b">
                      <div class="item">
                        <i class="el-icon-s-home"></i>
                        <span>主页</span>
                    </div>
                </li>
                 <li class="c">
                      <div class="item">
                        <i class="el-icon-s-management"></i>
                        <span>博客</span>
                    </div>
                </li>
                 <li class="d">
                      <div class="item">
                        <i class="el-icon-s-tools"></i>
                        <span>设置</span>
                    </div>
                </li>
                 <li class="d" @click="writeTalking">
                      <div class="item">
                        <i class="el-icon-edit-outline"></i>
                        <span>写说说</span>
                    </div>
                </li>
                
                
                 <li class="d">
                      <div class="item">
                        <i class="el-icon-user-solid"></i>
                        <span>个人中心</span>
                    </div>
                </li>
                
                 <li class="d">
                      <div class="item">
                        <i class="el-icon-s-platform"></i>
                        <span>后台管理</span>
                    </div>
                </li>

                 <li class="d">
                      <div class="item">
                        <i class="el-icon-s-help"></i>
                        <span>关于站长</span>
                    </div>
                </li>
                 <li class="d" @click="closeMenu">
                      <div class="final_item">
                        <i class="el-icon-arrow-up"></i>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</template>

<script>
export default {
    name: 'MobileNavBarVue',
    data(){
        return{
            isOpen: false, 
        }
    },
    props:{
        style: String,
        color: String,
    },
    methods:{
        writeTalking(){
            this.$router.push({
                path:'/mobile/writeBlog'
            })
        },
        openMenu(){
            this.isOpen = true
        },
        closeMenu(){
            this.isOpen = false
        },
        goLogin(){
            this.$router.push({
                path: '/login',
            })
        }

    }

}
</script>

<style scoped>

*{
    padding: 0;
    margin: 0;
    border: 0;
}

.container{
    position: fixed;
    /* background-image: linear-gradient(141deg,#9fb8ad 0%,#1fc8db 51%,#2cb5e8 75%); */
    width: 100%;
    top: 0;
    z-index: 3;
    /* box-shadow: 5px 5px 5px #888888; */
}

.bar{
    width: 100%;
    color: #39c5d2;
}

.bar i{
    color: #39c5d2;
}

ul li{
     list-style: none;
}


.container .bar ul li{
   
    float: left;
    line-height: 50px;
    font-size: 18px; 
    
}

.container .bar ul .a{
    width: 15%;
}

.container .bar ul .b{
    width: 65%;
}

.container .bar ul .c{
    width: 20%;
    
}

.container .menu{
    width: 100%;
    background-image: linear-gradient(141deg,#9fb8ad 0%,#1fc8db 51%,#2cb5e8 75%);
}

.container .menu ul li{
    width: 100%;
    line-height: 40px;
}

.item{
    margin: auto 1%;
    width: 98%;
    border-bottom: solid 2px #f3f4f7;
}

.item i{
    float: left;
    line-height: 40px;
    margin-left: 4%;
}

.item span{
    float: left;
     margin: auto 0;
    margin-left: 1%;
}

.item::after{
    content:"";
    display:block;
    clear: both;
}

.item:hover{
    background-color: #74d2e7;
}

.el-input{
    width: 80%;
    margin-top: 10px;
    margin-bottom: 10px;
    background: #0085ad;
}

.final_item{
    margin: auto;
}

</style>