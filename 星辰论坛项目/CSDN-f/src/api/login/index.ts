import type { User } from '../user'
import request from '@/util/request'

export const getLogin = (username: string, password: string) =>
  request<User>({
    method: 'post',
    url: '/user/login',
    params: { username, password },
  })

export const getPic = (name: string) =>
  request<User | null>({
    method: 'get',
    url: `/user/getUserPic/${name}`,
  })
