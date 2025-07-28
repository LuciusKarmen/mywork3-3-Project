import type { User } from '@/types/user'
import request from '../../utils/request'

export const getLogin = (username: string, password: string) =>
  request<User>({
    method: 'post',
    url: '/user/login',
    data: {
      username,
      password,
    },
  })
export function getRegister(data: FormData) {
  return request({
    url: '/user/register',
    method: 'post',
    data,
  })
}
