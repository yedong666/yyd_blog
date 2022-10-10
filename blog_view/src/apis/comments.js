import request from '@/request'

export function getCommentByArticleIdFromBack(articleId){
    return request({
        url: '/getCommentsByArticleId',
        method: 'get',
        headers: {
          'Content-Type': 'application/json'
        },
        params:{
            articleId: articleId,
        },
      })
}

export function addCommentToBack(comment){
  return request({
    url: '/addComment',
    method: 'post',
    headers: {
      'Content-Type': 'application/json'
    },
    data: JSON.stringify(comment),
  })
}