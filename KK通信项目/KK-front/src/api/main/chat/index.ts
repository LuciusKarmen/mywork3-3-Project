import request from '@/utils/request'
import type { Message } from '@/types/message'

export const getMessage = (user_id: string, friend_id: string) => {
  return request<Message[]>({
    url: '/message/select',
    method: 'get',
    params: {
      user_id,
      friend_id,
    },
  })
}
