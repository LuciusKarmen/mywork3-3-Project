import request from '@/utils/request'
import type { User } from '@/types/user'
export const getRegister = (FormData: FormData) =>
  request({
    url: '/user/reg',
    method: 'post',
    data: FormData,
  })
