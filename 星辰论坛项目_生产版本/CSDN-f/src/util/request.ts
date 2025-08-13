import axios, { type AxiosRequestConfig } from 'axios'

// 定义后端统一返回的结构
interface Result<T = any> {
  code: number
  message: string
  data: T
}

// 创建 axios 实例
const service = axios.create({
  baseURL: '/api',
})

// 请求拦截器（说实话写了没什么用）
service.interceptors.request.use(
  (config) => {
    return config
  },
  (error) => {
    return Promise.reject(error)
  },
)

// 响应拦截器
service.interceptors.response.use(
  (response) => {
    const res = response.data as Result
    if (res.code !== 200) {
      alert(res.message || '请求失败')
      return Promise.reject(new Error(res.message || 'Error'))
    }
    return res.data
  },
  (error) => {
    console.error('网络错误:', error)
    alert('网络连接失败，请检查您的网络')
    return Promise.reject(error)
  },
)

// 统一请求方法，支持泛型
export default function request<T>(config: AxiosRequestConfig): Promise<T> {
  return service(config)
}
