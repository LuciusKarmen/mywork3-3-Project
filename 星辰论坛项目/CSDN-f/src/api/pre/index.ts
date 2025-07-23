import type { Tip } from '../tip'
import request from '../../util/request'
export const getTip = (id: string) =>
  request<Tip>({
    method: 'get',
    url: `/tip/getTip/${id}`,
  })
