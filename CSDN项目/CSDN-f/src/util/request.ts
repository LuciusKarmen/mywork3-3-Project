//我这个项目的最大亮点--->企业级规范
// 可以直接使用 request 方法进行请求
// 例如：
// import request from '@/utils/request'
// request<Tip>({
//   method: 'get', 
//   url: '/tips',
// }).then(data => {
//   console.log(data)
// }).catch(error => {
//   console.error('请求失败:', error)
// })
import axios, { type AxiosRequestConfig } from 'axios'

// 定义后端统一返回的结构
interface Result<T = any> {
  code: number
  message: string
  data: T
}

// 创建 axios 实例
const service = axios.create({
  baseURL: '/api', // 基础路径，根据你的项目配置
  timeout: 5000, // 超时时间
})

// 请求拦截器（可选）
service.interceptors.request.use(
  (config) => {
    // 可添加 token 等操作

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
      // 错误提示（你可以换成 element-ui / vant / toast 提示）
      alert(res.message || '请求失败')

      // 抛出异常，让调用方 catch 到
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

