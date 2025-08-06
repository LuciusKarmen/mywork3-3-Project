<template>
  <div class="all">
    <div class="chat">
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
      <el-input v-model="textarea" :rows="7" type="textarea" placeholder="Please input" />
      <el-button type="primary" @click="sendMessage" class="send-button">发送</el-button>
    </div>
  </div>
</template>

<script lang="ts" setup name="Chat">
import type { Message } from '../types/message'
import { ref, onUpdated, nextTick } from 'vue'

const userid = localStorage.getItem('userid')
const props = defineProps<{
  Messages: Message[]
}>()
const sendMessage = async () => {
  console.log(userid)
}

const textarea = ref('')
const chatContainer = ref<HTMLElement | null>(null)
onUpdated(async () => {
  await nextTick()
  if (chatContainer.value) {
    chatContainer.value.scrollTop = chatContainer.value.scrollHeight
  }
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
          // ✅ 删除 border-bottom-right-radius
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
