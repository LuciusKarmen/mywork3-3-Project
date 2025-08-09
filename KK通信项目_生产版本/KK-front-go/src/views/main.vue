<template>
  <div class="main">
    <div class="top">
      <div class="user-info">
        <div class="user">
          <img :src="file" alt="user" />
        </div>
        <div>{{ username }}</div>
      </div>
      <div>{{ friendname }}</div>
      <div><span>切换模式</span><el-switch v-model="night" @click="changeLight" /></div>
    </div>
    <div class="title">
      <div class="title-text" :class="{ active: current === 'friends' }" @click="f">
        <img src="../assets/用户.png" alt="好友" />
        好友
      </div>
      <div class="title-text" :class="{ active: current === 'add' }" @click="add">
        <img src="../assets/添加.png" alt="" />
        添加
      </div>
      <div class="title-text" :class="{ active: current === 'server' }" @click="s">
        <img src="../assets/更多服务、功能.png" alt="" />
        服务
      </div>
      <div class="title-text" :class="{ active: current === 'control' }" @click="control">
        <img src="../assets/通知.png" alt="" />
        通知
      </div>
      <div class="title-text" :class="{ active: current === 'about' }" @click="about">
        <img src="../assets/提示.png" alt="" />
        关于
      </div>

      <div class="title-foot" @click="out">
        <img src="../assets/退出.png" alt="" />
        退出
      </div>
    </div>
    <div class="left">
      <router-view></router-view>
    </div>
    <div class="right">
      <Chat :Messages="historyMessage" @newMessage="handleNewMessage" />
    </div>
  </div>
</template>
<script lang="ts" setup name="">
import { onMounted, ref, computed, onUnmounted } from 'vue'
import { useRouter } from 'vue-router'
import Chat from '../components/chat.vue'
import { getMessage } from '@/api/main/chat'
import type { Message } from '../types/message'

const username = ref(localStorage.getItem('username'))
const userid = ref(localStorage.getItem('userid'))
const userpic = ref(localStorage.getItem('userpic'))
const friendname = ref(localStorage.getItem('friendname'))
const file = computed(() => {
  return `http://118.195.143.104:8899/${userpic.value}`
})

const night = ref(false)
const router = useRouter()
const changeLight = () => {
  night.value = !night.value
}

const current = ref('friends')
const setActive = (tab: string) => {
  current.value = tab
}

const f = () => {
  setActive('friends')
  router.push('/main')
}
const add = () => {
  setActive('add')
  router.push('/main/add')
}
const s = () => {
  setActive('server')
  router.push('/main/server')
}
const control = () => {
  setActive('control')
  router.push('/main/control')
}
const about = () => {
  setActive('about')
  router.push('/main/about')
}
const out = () => {
  router.push('/login')
}

const historyMessage = ref<Message[]>([])
// 格式化时间为 HH:mm 格式
const formatTime = (timeStr: string): string => {
  const date = new Date(timeStr)
  return date.toTimeString().slice(0, 5)
}

const loadMessages = async () => {
  const id = localStorage.getItem('friendid')
  friendname.value = localStorage.getItem('friendname')
  const uid = userid.value

  if (!id || !uid) {
    historyMessage.value = []
    return
  }

  try {
    const messages: Message[] = await getMessage(uid, id)
    console.log('!!!加载聊天记录:', messages)

    // 格式化所有消息的时间
    const formattedMessages = messages.map((msg) => ({
      ...msg,
      time: formatTime(msg.time as string),
    }))

    historyMessage.value = formattedMessages
  } catch (err) {
    console.error('加载失败', err)
    historyMessage.value = []
  }
}
const handleNewMessage = (msg: Message) => {
  // 关键：必须创建新数组引用，触发响应式更新
  historyMessage.value = [...historyMessage.value, msg]
}
onMounted(() => {
  loadMessages()
  window.addEventListener('storage', loadMessages)
})

onUnmounted(() => {
  window.removeEventListener('storage', loadMessages)
})
</script>
<style lang="scss" scoped>
.main {
  width: 100vw;
  height: 100vh;
  position: relative;
  overflow: hidden;
  .top {
    width: 100%;
    height: 7vh;
    background: rgb(217, 217, 217);
    display: flex;
    justify-content: space-between;
    align-items: center;

    .user-info {
      display: flex;
      align-items: center;
      gap: 20px;
      margin: 0 20px;
      .user {
        width: 3vw;
        height: 3vw;
        background: #00823a;
        border-radius: 50%;
        border: 2px solid rgb(161, 255, 206);
        img {
          width: 100%;
          height: 100%;
          border-radius: 50%;
        }
      }
    }
  }
  .title {
    background: rgb(51, 51, 51);
    width: 3vw;
    height: 93vh;
    position: absolute;
    left: 0vw;
    top: 7vh;
    .title-text {
      font-size: 1vw;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      margin-top: 5px;
      img {
        width: 2vw;
        height: 2vw;
      }
      &.active {
        background: #1a8300;
        color: #fff;
        border-radius: 5px;
        cursor: pointer;
      }
      &:hover {
        background: #00823a;
        color: #888888;
        border-radius: 5px;
        cursor: pointer;
        transition: all 0.3s;
      }
    }
    .title-foot {
      font-size: 1vw;
      border-bottom: #000 1px solid;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      position: absolute;
      bottom: 0;
      width: 100%;
      img {
        width: 2vw;
        height: 2vw;
      }
      &:active {
        background: #000;
        color: #fff;
        border-radius: 5px;
      }
      &:hover {
        background: #000;
        color: #858585;
        border-radius: 5px;
      }
    }
  }
  .left {
    width: 17vw;
    height: 93vh;
    position: absolute;
    left: 3vw;
    top: 7vh;
    background: rgb(167, 167, 167);
  }
  .right {
    width: 80vw;
    height: 93vh;
    position: absolute;
    left: 20vw;
    top: 7vh;
    overflow-x: hidden;
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
