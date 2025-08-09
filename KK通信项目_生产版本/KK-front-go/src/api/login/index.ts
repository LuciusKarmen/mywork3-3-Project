import type { User } from '@/types/user'
import request from '../../utils/request'

export const getLogin = (username: string, password: string) =>
  request<User>({
    method: 'post',
    url: '/user/login',
    params: {
      username,
      password,
    },
  })
