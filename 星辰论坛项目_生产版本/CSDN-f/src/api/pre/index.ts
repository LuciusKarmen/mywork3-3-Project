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

export const sendComment = (data: FormData) =>
  request({
    method: 'post',
    url: '/message/addMessage',
    data,
    headers: { 'Content-Type': 'application/json' },
  })
export const addTipGood = (id: string) =>
  request({
    method: 'post',
    url: `/tip/addTipGood`,
    params: { id },
  })
export const addTipMessage = (id: string) =>
  request({
    method: 'post',
    url: '/tip/addTipMessage',
    params: { id },
  })
