import request from '@/request'

export function addArticleToBack(article){
 
    return request({
      url: '/addArticle',
      method: 'post',
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
  
  export function getHotArticles(){
    return request({
      url: '/getHotArticles',
      method: 'get',
      headers: {
        'Content-Type': 'application/json'
      }
    })
  }

  export function getNewArticles(){
    return request({
      url: '/getNewArticles',
      method: 'get',
      headers: {
        'Content-Type': 'application/json'
      }
    })
  }

  export function getPageArticles(pageNum){
    return request({
      url: '/getPageArticles',
      method: 'get',
      headers: {
        'Content-Type': 'application/json'
      },
      params:{
        pageNum: pageNum
      }
    })
  }

  export function getArticlesCount(){
    return request({
      url: '/getArticlesCount',
      method: 'get',
      headers: {
        'Content-Type': 'application/json'
      },
    })
  }

  export function clickLike(userId, articleId){
    return request({
      url: '/clickLike',
      method: 'get',
      headers: {
        'Content-Type': 'application/json'
      },
      params:{
        userId: userId,
        articleId:articleId,
      }
    })
  }

  export function cancelLike(userId, articleId){
    return request({
      url: '/cancelLike',
      method: 'get',
      headers: {
        'Content-Type': 'application/json'
      },
      params:{
        userId: userId,
        articleId:articleId,
      }
    })
  }

  export function readArticle(userId, articleId){
    return request({
      url: '/readArticle',
      method: 'get',
      headers: {
        'Content-Type': 'application/json'
      },
      params:{
        userId: userId,
        articleId:articleId,
      }
    })
  }

  