<template>
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
  </div>
</template>
<script lang="ts" setup>
import { ref } from 'vue'
defineOptions({
  name: 'Chat',
})
const historyMessage = ref([
  {
    id: '1',
    content: 'hello',
    time: '2021-01-01 00:00:00',
    is: true,
  },
  {
    id: '2',
    content: 'hello',
    time: '2021-01-01 00:00:00',
    is: false,
  },
])
</script>
<style lang="scss" scoped>
.chat {
  width: 80vw;
  height: 73vh;
  background: #b1b1b1;
  padding: 20px;
  overflow-y: auto;
  box-sizing: border-box;

  .message {
    max-width: 50%;
    padding: 10px;
    border-radius: 10px;
    display: flex;
    flex-direction: column;
    margin-bottom: 10px;
    &.message-right {
      align-self: flex-end;
      background: transparent;

      .message-content-text {
        color: #000;
        background: rgb(149, 236, 105);
        border-radius: 10px;
        padding: 10px;
        word-break: break-all;
        border-bottom-right-radius: 1px;
      }

      .message-content-time {
        font-size: 12px;
        color: #666;
        margin-top: 4px;
        text-align: right;
      }
    }

    &.message-left {
      align-self: flex-start;
      background: transparent;

      .message-content-text {
        background: #eaeaea;
        color: #000;
        border-radius: 10px;
        padding: 10px;
        word-break: break-all;
      }

      .message-content-time {
        font-size: 12px;
        color: #666;
        margin-top: 4px;
        text-align: left;
      }
    }

    .message-content-time {
      font-size: 12px;
      color: #999;
      margin-top: 4px;
    }
  }
}
</style>
