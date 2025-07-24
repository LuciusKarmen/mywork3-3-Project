import type { Tip } from '../tip'
import request from '../../util/request'
import type { Message } from 'postcss'
export const getTip = (id: string) =>
  request<Tip>({
    method: 'get',
    url: `/tip/getTip/${id}`,
  })

export const getTipComments = (id: string) =>
  request<Message[]>({
    method: 'get',
    url: `/message/getTipMessages/${id}`,
  })
