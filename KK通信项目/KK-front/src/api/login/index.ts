import type { User } from '@/types/user'
import service from '../axios'

export const getLogin = (data: User) =>
  service({
    url: '/api/user/login',
    method: 'post',
    data,
  })
export const getRegister = (data: User) =>
  service({
    url: '/api/user/register',
    method: 'post',
    data,
  })

export const getUserInfo = (name: string) =>
  service({
    url: `/api/user/${name}`,
    method: 'get',
  })
