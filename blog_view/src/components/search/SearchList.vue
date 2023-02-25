<template>
  <div class="container">   
    <div class="resultClassify">
        <span v-for="(classify, index) in classifies" :key="index" :style="classify.style" @click="selectClassify(index)">
            <p>{{classify.name}}</p>
        </span>
    </div>
    <el-divider></el-divider>
    <div class="resultSort">
        <el-button v-for="(sortWay, index) in sortWays" :key="index" @click="selectSortWay(index)" :style="sortWay.style">
           {{sortWay.name}}
        </el-button>
    </div>
    <el-divider></el-divider>
    <div class="searchList">
       <router-view></router-view>
    </div>
  </div>
</template>

<script>
export default {
  name: 'SearchList',
  data() {
    return {
        searchKeyword: '',
        nowClassifyId: 0,
        nowSortWayId: 0,
        classifies: [
            {
                id: 1,
                name: '博客',
                isClicked: true,
                style: 'border-bottom: 2px solid blue',
                isShowed: 'display: block',
                searchUrl: '/home/search/searchBlogList',
    
            },
             {
                id: 2,
                name: '标签',
                isClicked: false,
                style: '',
                isShowed: 'display: none',
                 searchUrl: '/home/search/searchTagList',
            },
             {
                id: 3,
                name: '用户',
                isClicked: false,
                style: '',
                isShowed: 'display: none',
                 searchUrl: '/home/search/searchUserList',
            },
             {
                id: 4,
                name: '资源',
                isClicked: false,
                style: '',
                 isShowed: 'display: none',
                  searchUrl: '/home/search/searchUserList',
            },
        ],
        sortWays: [
             {
                id: 1,
                name: '最匹配',
                isClicked: true,
                style: 'background: #dff6fd; color: #00b3f0;'
            },
             {
                id: 2,
                name: '最多访问',
                isClicked: false,
                style: ''
            },
             {
                id: 3,
                name: '最热门',
                isClicked: false,
                style: ''
            },
             {
                id: 4,
                name: '最新发布/上传/注册',
                isClicked: false,
                style: ''
            },
        ],
    }
  },

    mounted(){
         this.searchKeyword = this.$route.query.keyword
         this.jump()
    },

  methods:{

    jump(){
        this.$router.push({
            path: this.classifies[this.nowClassifyId].searchUrl,
            query:{
              sortWayId:Number( this.nowSortWayId),
              keyword: this.searchKeyword,  
            }
        })
    },

    selectClassify(index){
        this.nowClassifyId = index
        for(let i = 0; i < this.classifies.length; i++){
            if(i == index){
                this.classifies[i].style = 'border-bottom: 2px solid blue'
                this.classifies[i].isClicked = true
                this.classifies[i].isShowed = 'display: block'

            }else{
                this.classifies[i].style = ''
                this.classifies[i].isClicked = false
                this.classifies[i].isShowed = 'display: none'
            }
        }
        this.jump()
        
    },
    selectSortWay(index){
        this.nowSortWayId = index
        for(let i = 0; i < this.sortWays.length; i++){
            if(i == index){
                this.sortWays[i].style = 'background: #dff6fd; color: #00b3f0;'
            }else{
                this.sortWays[i].style = ''
            }
        }
        this.jump()
    }
  }
}
</script>

<style scoped>

.el-divider{
    margin: 5px 0px;
}



.container {
  width: 100%;
  height: 100%;
  background: #b8ddf7;
}

.resultClassify{
    margin-left: 20px;
    display: flex;
    justify-content: left;
}

.resultClassify span{
    margin: 10px 10px;
    height: 40px;
    min-width: 80px;
}

.resultClassify span p{
    line-height: 40px;
    font-size: 18px;
    text-align: center;
    color: #61688e;
}

.resultSort{
    margin-left: 20px;
     display: flex;
     justify-content: left;
}

.resultSort .el-button{
    margin: 10px 10px;
    background: #b8ddf7;
    border: 0;
}

.searchList{
    width: 100%;
    min-height: 500px;
}


</style>
