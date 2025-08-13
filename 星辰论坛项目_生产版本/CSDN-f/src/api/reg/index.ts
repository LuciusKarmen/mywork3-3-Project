import request from '@/util/request'

export const registerUser = (data: FormData) =>
  request({
    method: 'post',
    url: '/user/register',
    data,
    headers: { 'Content-Type': 'multipart/form-data' },
  })
