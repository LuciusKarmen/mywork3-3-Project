import type { Apply } from '@/types/apply'
import type { Friends } from '@/types/friends'
import type { User } from '@/types/user'
import request from '@/utils/request'

export const getNewFriend = (name: String) =>
  request<User>({
    url: '/user/selectnew',
    method: 'get',
    params: { name },
  })
//获取信息
export const getFriendInfo = (id: string) =>
  request<User>({
    url: '/user/select',
    method: 'get',
    params: { id },
  })
export const addFriend = (user_id: string, friend_id: string) =>
  request<User>({
    url: '/friends/sendnew',
    method: 'post',
    params: {
      user_id,
      friend_id,
    },
  })

export const getFriendRequests = (id: string) =>
  request<Friends[]>({
    url: '/friends/getFriendRequests',
    method: 'get',
    params: {
      id,
    },
  })
export const updateFriendRequest = (user_id: string, status: string) =>
  request<String>({
    url: '/friends/updateFriendRequest',
    method: 'post',
    params: {
      user_id,
      status,
    },
  })
