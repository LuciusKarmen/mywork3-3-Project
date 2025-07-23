import type { User } from '../user'
import request from '@/util/request'

export const getLogin = (username: string, password: string) =>
  request<User>({
    method: 'post',
    url: '/user/login',
    params: { username, password },
  })
