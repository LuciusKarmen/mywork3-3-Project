<template>
    <div class="main">
      <div class="chat">
        <div v-for="item in historyMessage" :key="item.id" :class="['message',item.is ? 'message-right' : 'message-left'] ">
          <div class="message-content">
            <div class="message-content-text">
              {{ item.content }}
            </div>
            <div class="message-content-time">
              {{ item.time }}
            </div>
          </div>
        </div>
      </div>

    </div>
</template>
<script lang='ts' setup name=''>
import { Message } from 'element-plus';
import { ref } from 'vue'
const historyMessage = ref([
  {
    content: 'hello world',
    time: '10:10',
    is: true,
    from: 'Karmen',
    to: 'xgm',
    id: '0',
  }
])
const sendMessage = () => {
  historyMessage.value.push({
    content: 'hello world',
    time: '10:10',
    is: false,
    from: 'xgm',
    to: 'Karmen',
    id: '1',
  })
}
</script>
<style lang='scss' scoped>
.main{
  width: 100vw;
  height: 100vh;
}
</style>
