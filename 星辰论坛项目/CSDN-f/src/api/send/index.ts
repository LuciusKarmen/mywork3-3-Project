import type { Tip } from '../tip'
import request from '../../util/request'
export const sendTip = (data: FormData) =>
  request({
    method: 'post',
    url: '/tip/addTip',
    data,
    headers: { 'Content-Type': ' multipart/form-data' },
  })
