import type { User } from '@/types/user'
import type { Friends } from '../../types/friends'
import request from '../../utils/request'

export function getFriendList(id: string) {
  return request<User[]>({
    url: '/friends/selectFriends',
    method: 'get',
    params: {
      id,
    },
  })
}
