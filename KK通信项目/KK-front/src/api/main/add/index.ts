import type { User } from '@/types/user'
import request from '@/utils/request'

export const getNewFriend = (name: String) => {
  return request<User>({
    url: '/user/selectnew',
    method: 'get',
    params: { name },
  })
}
