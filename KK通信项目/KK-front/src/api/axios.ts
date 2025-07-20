import axios from 'axios'

const service = axios.create({
  timeout: 5000,
  headers: {
    'Content-Type': 'application/json;charset=utf-8',
  },
})

// 请求拦截器（可选）
service.interceptors.request.use(
  (config) => {
    // 可以在这里添加 token、loading 等
    return config
  },
  (error) => {
    return Promise.reject(error)
  },
)

// 响应拦截器
service.interceptors.response.use(
  (response) => {
    const res = response.data

    // 根据你后端 Result<T> 的结构处理
    if (res.code !== 200) {
      console.error(res.message || '请求失败')
      return Promise.reject(new Error(res.message || 'Error'))
    } else {
      return res.data // 自动提取 data
    }
  },
  (error) => {
    console.error('网络错误:', error)
    return Promise.reject(error)
  },
)

export default service
