import request from '@/request'

export function getTagsByClassify(){
    return request({
      url: '/getTags',
      method: 'get',
      headers: {
        'Content-Type': 'application/json'
      }
    })
  }