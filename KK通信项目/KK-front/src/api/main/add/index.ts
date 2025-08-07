import type { User } from '@/types/user'
import request from '@/utils/request'

export const getNewFriend = (name: String) =>
  request<User>({
    url: '/user/selectnew',
    method: 'get',
    params: { name },
  })
export const addFriend = (user_id: string, friend_id: string) =>
  request<User>({
    url: '/friends/add',
    method: 'post',
    params: {
      user_id,
      friend_id,
    },
  })
