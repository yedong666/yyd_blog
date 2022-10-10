import request from '@/request'

export function searchArticle(keyword){
    return request({
        url: '/searchArticle',
        method: 'get',
        headers: {
          'Content-Type': 'application/json'
        },
        params:{
            keyword: keyword
        },
      })
}