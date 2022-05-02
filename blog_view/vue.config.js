module.exports = {
  publicPath: './', //这个路径根据自己的情况定，默认就填"./",因为我静态资源的路径必须要在static文件夹下，所以才修改的。
  assetsDir:"static",
  outputDir:"dist",
  // css:{extract:false, sourceMap:false},

  devServer: {
    proxy: {
      '/': {
        target: 'http://localhost:8888',
        ws: true,
        changeOrigin: true
      },
    },

  },

  
    
  

}