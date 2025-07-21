<template>
  <div class="main">
    <div class="top">
      <div>头像</div>
      <div>命数如织，当如磐石</div>
      <el-switch v-model="night" @click="changeLight" /><span>切换模式</span>
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
      <div class="input"></div>
    </div>
  </div>
</template>
<script lang="ts" setup name="">
import { a } from 'vitest/dist/chunks/suite.d.FvehnV49.js'
import { onMounted, ref } from 'vue'
import { useRouter } from 'vue-router'

const night = ref(false)
const router = useRouter()
const storedUser = localStorage.getItem('user')
if (storedUser) {
  const user = JSON.parse(storedUser)
  console.log('用户ID:', user.id)
  console.log('用户名:', user.name)
  console.log('用户头像地址:', user.pic)
}
const changeLight = () => {
  night.value = !night.value
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
const about = () => {
  setActive('about')
  router.push('/main/about')
}
const out = () => {
  //居中弹出提示框
  router.push('/login')
}
</script>
<style lang="scss" scoped>
.main {
  width: 100vw;
  height: 100vh;
  position: relative;
  .top {
    width: 100%;
    height: 7vh;
    background: rgb(43, 43, 43);
    display: flex;
    justify-content: space-around;
    align-items: center;
  }
  .title {
    background: rgb(55, 55, 55);
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
        background: #000;
        color: #fff;
        border-radius: 5px;
      }
      &:hover {
        background: #000;
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
    background: rgb(60, 60, 60);
  }
  .chat {
    width: 80vw;
    height: 73vh;
    position: absolute;
    left: 20vw;
    top: 7vh;
    background: #000;
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
          background: #eaeaea;
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
          background: #aaaaaa;
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
