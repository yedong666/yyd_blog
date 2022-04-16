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