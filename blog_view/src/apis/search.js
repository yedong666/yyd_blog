import request from '@/request'

export function searchArticle(keyword, sortWay, resourceType){
    return request({
        url: '/searchArticle',
        method: 'get',
        headers: {
          'Content-Type': 'application/json'
        },
        params:{
            keyword: keyword,
            sortWay: sortWay,
            resourceType: resourceType,
        },
      })
}