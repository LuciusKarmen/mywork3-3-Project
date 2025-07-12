<template>
  <div class="main">
    <div class="chat">
      <div
        v-for="item in historyMessage"
        :key="item.id"
        :class="['message', item.is ? 'message-right' : 'message-left']"
      >
        <div class="message-content-text">
          {{ item.content }}
        </div>
        <div class="message-content-time">
          {{ item.time }}
        </div>
      </div>
      <div class="input">
        <input placeholder="请输入内容" v-model="input" @keyup.enter="send" class="input-text" />
        <button class="btn" @click="send">发送</button>
      </div>
    </div>
  </div>
</template>
<script lang="ts" setup name="">
import { ref } from 'vue'
const input = ref('')
const message = ref({
  content: '',
  time: new Date().toLocaleString([], { hour: '2-digit', minute: '2-digit' }),
  is: true,
  from: 'me',
  to: 'you',
  id: Math.random().toString(36).substring(3, 8),
})
const send = () => {
  message.value.content = input.value
  if (message.value.content) {
    historyMessage.value.push(message.value)

    message.value = {
      content: '',
      time: new Date().toLocaleString([], { hour: '2-digit', minute: '2-digit' }),
      is: true,
      from: 'me',
      to: 'you',
      id: Math.random().toString(36).substring(3, 8),
    }
  }
}
const historyMessage = ref([
  {
    content: 'hello world',
    time: '10:10',
    is: true,
    from: 'Karmen',
    to: 'xgm',
    id: '0',
  },
  {
    content: 'hello world too',
    time: '10:11',
    is: false,
    from: 'xgm',
    to: 'Karmen',
    id: '1',
  },
])
</script>
<style lang="scss" scoped>
.main {
  width: 100vw;
  height: 100vh;
  position: relative;
  .chat {
    width: 85vw;
    height: 93vh;
    position: absolute;
    left: 15vw;
    top: 7vh;
    background: linear-gradient(135deg, #f49f01, #0ceb69);
    animation: back 15s ease infinite;
    background-size: 400% 400%;
    padding: 20px;
    display: flex;
    flex-direction: column;
    gap: 10px;
    overflow-y: scroll;
    overflow-x: hidden;
    .message {
      max-width: 50%;
      padding: 10px;
      border-radius: 10px;
      display: flex;
      flex-direction: column;

      &.message-right {
        align-self: flex-end;
        border-bottom-right-radius: 3px;
        .message-content-text {
          color: #000;
          background: #26f706;
          border-radius: 10px;
          padding: 10px;
          word-break: break-all;
          border-bottom-right-radius: 1px;
        }
      }
      &.message-left {
        align-self: flex-start;
        border-bottom-left-radius: 3px;
        .message-content-text {
          background: #8be2ff;
          color: #000;
          border-radius: 10px;
          padding: 10px;
          word-break: break-all;
          border-bottom-left-radius: 1px;
        }
      }
      .message-content-time {
        font-size: 12px;
        color: #999;
        margin-top: 4px;
        text-align: right;
      }
    }
    .input {
      width: 100%;
      height: 10vh;
      display: flex;
      align-items: center;
      justify-content: space-around;
      position: absolute;
      bottom: 0;
      padding: 0;
      .input-text {
        width: 80%;
        height: 80%;
        border-radius: 10px;
        padding: 2px;
        font-size: 14px;
        outline: none;
      }
      .btn {
        width: 7%;
        height: 60%;
        border-radius: 5px;
        background-color: #f6729e;
        color: white;
        font-size: 14px;
        cursor: pointer;
        &:hover {
          background-color: #fad1df;
        }
      }
    }
    .question {
      width: 100%;
      height: 10vh;
      position: absolute;
      bottom: 0;
      right: 0;
      background-color: aqua;
    }
  }
}
@keyframes back {
  0% {
    background-position: 0 50%;
  }
  50% {
    background-position: 100% 50%;
  }
  100% {
    background-position: 0 50%;
  }
}
</style>
