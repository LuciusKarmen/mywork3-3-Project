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
import { ref, onMounted, onUnmounted, nextTick, defineProps, defineEmits, onUpdated } from 'vue'

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

const sendMessage = () => {
  if (
    !textarea.value.trim() ||
    !friendid.value ||
    !ws.value ||
    ws.value.readyState !== WebSocket.OPEN
  ) {
    return
  }

  const content = textarea.value.trim()
  const time = new Date().toTimeString().slice(0, 5)

  const message: Message = {
    id: '',
    from_id: userid!,
    to_id: friendid.value,
    content,
    time,
    read: false,
  }

  ws.value.send(JSON.stringify(message))
  emit('newMessage', message)
  textarea.value = ''

  nextTick(() => {
    scrollToBottom()
  })
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

const handleStorageChange = (e: StorageEvent) => {
  if (e.key === 'friendid') {
    friendid.value = e.newValue

    if (ws.value) {
      ws.value.close()
    }

    if (friendid.value) {
      connectWebSocket()
    }
  }
}

const connectWebSocket = () => {
  if (!userid || !friendid.value) return

  const url = `${WS_URL}?userid=${userid}&friendid=${friendid.value}`
  ws.value = new WebSocket(url)

  ws.value.onopen = () => {
    console.log('WebSocket connected to friend:', friendid.value)
  }

  ws.value.onmessage = (event) => {
    try {
      const msg: Message = JSON.parse(event.data)
      emit('newMessage', msg)
    } catch (err) {
      console.error('Message parse error:', err)
    }
  }

  ws.value.onclose = () => {
    console.log('WebSocket closed')
  }

  ws.value.onerror = (err) => {
    console.error('WebSocket error:', err)
  }
}

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

onUpdated(() => {
  nextTick(() => {
    scrollToBottom()
  })
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
