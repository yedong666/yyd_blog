import request from '@/request'

export function addArticleToBack(article){
    return request({
      url: '/addArticle',
      method: 'post',
      headers: {
        'Content-Type': 'application/json'
      },
      data: JSON.stringify(article),
    })
  }

  export function getAllArticlesFromBack(){
    return request({
      url: '/articles',
      method: 'get',
      headers: {
        'Content-Type': 'application/json'
      }
    })
  }

  export function getArticleByIdFromBack(id){
    return request({
      url: '/getArticleById',
      method: 'get',
      headers: {
        'Content-Type': 'application/json'
      },
      params:{
        id: id,
      }
    })
  }  