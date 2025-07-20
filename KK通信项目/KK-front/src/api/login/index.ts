import type { User } from '@/types/user'
import service from '../axios'

export const getLogin = (data: User) =>
  service({
    url: '/user/login',
    method: 'post',
    data,
  })
