<template>
  <div class="message">
    <div class="header">我的消息</div>
    <br />
    <br />
    <br />
    <div class="main">
      <div v-for="(item, index) in messages" :key="index">
        <Message :mes="item"></Message>
      </div>
    </div>
    <div class="footer">
      <Bar></Bar>
    </div>
  </div>
</template>

<script setup lang="ts" name="face">
import Bar from '../components/bar.vue'
import Message from '../components/message.vue'
import { onMounted, ref } from 'vue'
import request from '../util/request'
import { type Message as MessageType } from '../api/message'
import { getMessages } from '../api/message/index'

const messages = ref<MessageType[]>([])
const user = ref<string>(localStorage.getItem('username') || '')
const fetchMessages = (name: string) => {
  getMessages(name)
    .then((data: MessageType[]) => {
      // 自下而上遍历
      messages.value = Array.isArray(data) ? data.reverse() : [data]
      console.log('请求成功:', data)
    })
    .catch(() => {
      messages.value = []
      console.error('请求失败')
    })
}

onMounted(() => {
  fetchMessages(user.value)
})
</script>

<style lang="scss" scoped>
.message {
  min-height: 100vh;
  .header {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    z-index: 1000;
    display: flex;
    justify-content: center;
    align-items: center;
    padding: 1% 5%;
    background-color: rgb(208, 208, 208);
    height: 6vh;
    border-bottom: 2px solid paleturquoise;
  }
  .footer {
    position: fixed;
    bottom: 0;
    width: 100%;
  }
}
</style>
