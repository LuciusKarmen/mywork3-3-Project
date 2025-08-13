import type { Message } from '@/api/message'
import request from '@/util/request'
export const getMessages = (name: string) =>
  request<Message[]>({
    method: 'get',
    url: `/message/getMessages/${name}`,
  })
