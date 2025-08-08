<template>
  <div class="all">
    <div ref="chatContainer" class="chat">
      <div
        v-for="item in props.Messages"
        :key="item.id"
        :class="['message', item.from_id == userid ? 'message-right' : 'message-left']"
      >
        <div class="message-content-text">
          {{ item.content }}
        </div>
        <div class="message-content-time">
          {{ item.time }}
        </div>
      </div>
    </div>

    <div class="input">
      <el-input
        v-model="textarea"
        :rows="7"
        type="textarea"
        placeholder="请输入消息"
        @keydown.enter="handleEnter"
      />
      <el-button type="primary" @click="sendMessage" class="send-button">发送</el-button>
    </div>
  </div>
</template>

<script lang="ts" setup>
import type { Message } from '../types/message'
import { ref, onMounted, onUnmounted, nextTick, defineProps, defineEmits, watch } from 'vue'
defineOptions({
  name: 'Chat',
})
const userid = localStorage.getItem('userid')
const friendid = ref<string | null>(null)

const props = defineProps<{
  Messages: Message[]
}>()

const emit = defineEmits(['newMessage'])

const textarea = ref('')
const chatContainer = ref<HTMLElement | null>(null)
const ws = ref<WebSocket | null>(null)

const WS_URL = 'ws://localhost:8080/ws/chat'

// 格式化时间为 HH:mm
const formatTime = (date: Date): string => {
  return date.toTimeString().slice(0, 5)
}

const sendMessage = () => {
  const content = textarea.value.trim()
  const toId = localStorage.getItem('friendid')

  // 基本校验
  if (!content || !toId || !userid) return

  // 构造消息（前端临时 ID，后端会覆盖）
  const message: Message = {
    id: '', // 后端生成
    from_id: userid,
    to_id: toId,
    content,
    time: formatTime(new Date()),
    read: false,
  }

  // 只要 WebSocket 是 OPEN 状态，就尝试发送
  if (ws.value && ws.value.readyState === WebSocket.OPEN) {
    ws.value.send(JSON.stringify(message))
    // 立即更新聊天界面（乐观更新）
    emit('newMessage', message)
    textarea.value = ''
    nextTick(scrollToBottom)
  }
  // 如果 WebSocket 未连接，也**不提示**，静默失败（或可选：存草稿）
  // 当前需求是“不提示”，所以什么都不做
}

const handleEnter = (e: KeyboardEvent) => {
  if (!e.shiftKey) {
    e.preventDefault()
    sendMessage()
  }
}

const scrollToBottom = () => {
  if (chatContainer.value) {
    chatContainer.value.scrollTop = chatContainer.value.scrollHeight
  }
}

// 监听 friendid 变化
const handleStorageChange = (e: StorageEvent) => {
  if (e.key === 'friendid' && e.newValue !== e.oldValue) {
    friendid.value = e.newValue

    // 关闭旧连接
    if (ws.value) {
      ws.value.close()
      ws.value = null
    }

    if (friendid.value) {
      connectWebSocket()
    }
  }
}

const connectWebSocket = () => {
  if (!userid || !friendid.value) return

  const url = `${WS_URL}?userid=${userid}`
  ws.value = new WebSocket(url)

  ws.value.onopen = () => {
    console.log('✅ WebSocket connected:', userid)
  }

  ws.value.onmessage = (event) => {
    try {
      const receivedMsg = JSON.parse(event.data)
      // 确保是当前聊天对象的消息才显示
      if (
        receivedMsg.to_id === localStorage.getItem('friendid') ||
        receivedMsg.from_id === localStorage.getItem('friendid')
      ) {
        // 确保所有字段都是正确的类型
        const msg: Message = {
          id: String(receivedMsg.id),
          from_id: String(receivedMsg.from_id),
          to_id: String(receivedMsg.to_id),
          content: String(receivedMsg.content),
          time: String(receivedMsg.time),
          read: Boolean(receivedMsg.read),
        }
        emit('newMessage', msg)
      }
    } catch (err) {
      console.error('解析消息失败:', err)
    }
  }

  ws.value.onclose = () => {
    console.log('❌ WebSocket closed')
  }

  ws.value.onerror = (err) => {
    console.error('WebSocket 错误:', err)
    // 不弹窗提示
  }
}

// 监听消息变化滚动到底部
watch(
  () => props.Messages,
  () => {
    nextTick(scrollToBottom)
  },
  { deep: true },
)

onMounted(() => {
  friendid.value = localStorage.getItem('friendid')
  window.addEventListener('storage', handleStorageChange)

  if (friendid.value) {
    connectWebSocket()
  }
})

onUnmounted(() => {
  if (ws.value) {
    ws.value.close()
  }
  window.removeEventListener('storage', handleStorageChange)
})
</script>

<style lang="scss" scoped>
.all {
  width: 80vw;
  height: 93vh;
  display: flex;
  flex-direction: column;
  .chat {
    width: 80vw;
    height: 73vh;
    background: #b1b1b1;
    padding: 20px;
    overflow-y: auto;
    box-sizing: border-box;
    display: flex;
    flex-direction: column;
    gap: 10px;

    .message {
      max-width: 50%;
      padding: 10px;
      border-radius: 10px;
      display: flex;
      flex-direction: column;

      &.message-right {
        align-self: flex-end;

        .message-content-text {
          color: #000;
          background: rgb(149, 236, 105);
          border-radius: 10px;
          padding: 10px;
          word-break: break-all;
        }

        .message-content-time {
          text-align: right;
        }
      }

      &.message-left {
        align-self: flex-start;

        .message-content-text {
          background: #eaeaea;
          color: #000;
          border-radius: 10px;
          padding: 10px;
          word-break: break-all;
        }

        .message-content-time {
          text-align: left;
        }
      }

      .message-content-time {
        font-size: 12px;
        color: #666;
        margin-top: 4px;
      }
    }
  }
  .input {
    background-color: #ffffff;
    box-sizing: border-box;
    .send-button {
      position: absolute;
      right: 10px;
      bottom: 10px;
      width: 80px;
      height: 40px;
      background-color: #00823a;
      color: #fff;
      border: 1px solid #adffd2;
    }
  }
}
</style>
