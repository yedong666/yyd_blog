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