module.exports = {
  devServer: {
    proxy: {
      '/': {
        target: 'http://localhost:8888',
        ws: true,
        changeOrigin: true
      },
    }
  }
}