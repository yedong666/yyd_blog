<template>
  <div class="container">
    <div class="headtype">
        <p class="headdes">学习心得:</p>
        <div class="types">
            <div class="type" v-for="(i) in array" :key="i">
                <p>学习java{{i}}</p>
                <div class="typebox">
                    <div class="imgbox">
                        <el-image :src="url"></el-image>
                    </div>
                    <div class="desbox">
                        Java语言是一门纯面向对象的语言，其功能强大用途广泛 
                    </div>
                </div>
            </div>
        </div>
    </div>
  </div>
</template>

<script>
export default {
    data(){
        return{
            url: 'https://img0.baidu.com/it/u=1266622655,1796618539&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500',
            array: [1, 2, 3, 4, 5, 6, 7, 8],
        }
    }
}
</script>

<style scoped>
.container{
    width: 100%;
    background: #b8ddf7;
    display: flex;
    flex-direction: column;
    align-content: space-between;
}

.headtype{
    display: flexbox;
    width: 98%;
    margin: auto;
}

.headtype .headdes{
    width: 100%;
    font-size: 25px;
    color:#00bce4;
    text-align: left;
    text-indent: 10px;
}

.headtype .types{
    width: 100%;
    display: flex;
    justify-content: space-around;
    flex-wrap: wrap;
}

.headtype .types .type{
    width: 20%;
    height: 130px;
    margin: 10px;
    overflow: hidden;
    border: 1px solid #f3f4f7;
    background: white;
}

.headtype .types .type p{
    height: 20px;
    font-size: 18px;
}

.headtype .types .type .typebox{
    width: 100%;
    height: 90px;
    margin-top: 10px;
    margin-bottom: 10px;
}

.headtype .types .type .typebox .imgbox{
    width: 35%;
    height: 100%;
    margin-left: 5px;
    float: left;
}

.headtype .types .type .typebox .imgbox .el-image{
    height: 100%;
}

.headtype .types .type .typebox .desbox{
    width: 55%;
    height: 100%;
    color: #a8aaac;
    font-size: 14px;
    text-align: left;
    margin-left: 5px;
    float: left;
}

</style>