import type { Tip } from '../tip'
import request from '../../util/request'

export const getTips = () =>
  request<Tip[]>({
    method: 'get',
    url: '/tip/getTips',
  })
