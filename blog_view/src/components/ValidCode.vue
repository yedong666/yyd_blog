<template>
  <div class="ValidCode disabled-select" :style="`width:${width}; height:${height}`" @click="refreshCode">
    <span v-for="(item, index) in codeList" :key="index" :style="getStyle(item)">{{item.code}}</span>
  </div>
</template>

<script>
export default {
  name: 'ValidCode',
  props: {
    width: {
      type: String,
      default: '150px'
    },
    height: {
      type: String,
      default: '40px'
    },
    length: {
      type: Number,
      default: 4
    }
  },
  data () {
    return {
      codeList: []
    }
  },
  mounted () {
    this.createdCode()
    this.getCode()
  },
  methods: {
    refreshCode () {
      this.createdCode()
      this.getCode()
    },
    createdCode () {
      let len = this.length,
        codeList = [],
        chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz0123456789',
        charsLen = chars.length
      // 生成
      for (let i = 0; i < len; i++) {
        let rgb = [Math.round(Math.random() * 220), Math.round(Math.random() * 240), Math.round(Math.random() * 200)]
        codeList.push({
          code: chars.charAt(Math.floor(Math.random() * charsLen)),
          color: `rgb(${rgb})`,
          fontSize: `${Math.floor(Math.random()*30) + 20}px`,
          padding: `${[Math.floor(Math.random() * 10)]}px`,
          border: '${1}px',
          transform: `rotate(${Math.floor(Math.random() * 90) - Math.floor(Math.random() * 90)}deg)`
        })
      }
      // 指向
      this.codeList = codeList
      // 将当前数据派发出去
      this.$emit('update:value', codeList.map(item => item.code).join(''))
    },
    getStyle (data) {
      return `color: ${data.color}; font-size: ${data.fontSize}; padding: ${data.padding}; transform: ${data.transform}`
    },

    getCode(){
      let code = ''
      for(let item of this.codeList){
        code += item.code
      }
      if (code.length != 4){
        this.$message({message: '验证码出错了('+code+')', type: 'error', showClose: true})
      }
      this.$emit('listen', code)
    }

  }
}
</script>

<style scoped lang="scss">
  .ValidCode{
    background: white;
    border-radius: 5px;
    display: flex;
    justify-content: center;
    align-items: center;
    overflow: hidden;
    cursor: pointer;
    span{
      display: inline-block;
    }
  }
</style>