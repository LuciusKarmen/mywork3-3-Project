// utils/request.ts
import axios, { type AxiosRequestConfig, type AxiosResponse } from 'axios'

// 1. 定义后端返回结构（允许 data 为 null）
interface Result<T = any> {
  code: number
  message: string
  data: T | null
}

// 2. 创建实例
const service = axios.create({
  timeout: 5000,
  baseURL: '/api', // 所有请求自动加 /api 前缀
})

// 3. 响应拦截器：自动解包 + 错误处理
service.interceptors.response.use(
  (response: AxiosResponse<Result<any>>) => {
    const res = response.data
    if (res.code === 200) {
      return res.data // ✅ 只返回 data 部分
    } else {
      // 抛出错误，可在组件中 catch
      throw new Error(res.message || '请求失败')
    }
  },
  (error) => {
    console.error('请求异常:', error)
    return Promise.reject(error)
  },
)

// 4. 导出 request，返回 T（即 data 的类型）
export default function request<T = any>(config: AxiosRequestConfig): Promise<T> {
  return service(config)
}
