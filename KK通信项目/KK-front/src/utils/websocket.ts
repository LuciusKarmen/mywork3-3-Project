import type { Message } from '@/types/message'

type WsMessage = {
  data: Message
}

type WsEventListener = (message: WsMessage) => void

type WsOptions = {
  reconnectInterval?: number
  maxReconnectAttempts?: number
}

class WebSocketService {
  private ws: WebSocket | null = null
  private url: string
  private listeners: WsEventListener[] = []
  private reconnectAttempts = 0
  private options: WsOptions

  constructor(url: string, options: WsOptions = {}) {
    this.url = url
    this.options = {
      reconnectInterval: 3000,
      maxReconnectAttempts: 5,
      ...options,
    }
  }

  connect(): void {
    if (
      this.ws &&
      (this.ws.readyState === WebSocket.CONNECTING || this.ws.readyState === WebSocket.OPEN)
    ) {
      console.warn('WebSocket 已连接或正在连接中')
      return
    }

    this.ws = new WebSocket(this.url)

    this.ws.onopen = () => {
      console.log('WebSocket 连接已建立')
      this.reconnectAttempts = 0
    }

    this.ws.onmessage = (event) => {
      try {
        const data = JSON.parse(event.data)
        this.listeners.forEach((listener) => listener({ data }))
      } catch (error) {
        console.error('WebSocket 消息解析失败:', error)
      }
    }

    this.ws.onclose = () => {
      console.log('WebSocket 连接已关闭')
      this.handleReconnect()
    }

    this.ws.onerror = (error) => {
      console.error('WebSocket 发生错误:', error)
      this.ws?.close()
    }
  }

  private handleReconnect(): void {
    if (this.reconnectAttempts >= (this.options.maxReconnectAttempts || Infinity)) {
      console.warn('达到最大重试次数，停止重连')
      return
    }

    setTimeout(() => {
      console.log(`第 ${this.reconnectAttempts + 1} 次重连...`)
      this.reconnectAttempts++
      this.connect()
    }, this.options.reconnectInterval)
  }

  onMessage(callback: WsEventListener): void {
    this.listeners.push(callback)
  }

  sendMessage(message: Message): void {
    if (this.ws && this.ws.readyState === WebSocket.OPEN) {
      this.ws.send(JSON.stringify(message))
    } else {
      console.warn('WebSocket 未连接，消息未发送:', message)
    }
  }

  disconnect(): void {
    if (this.ws) {
      this.ws.close()
      this.ws = null
      console.log('WebSocket 已手动断开')
    }
  }
}

export default WebSocketService
