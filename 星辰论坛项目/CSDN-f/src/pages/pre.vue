<template>
  <div class="tip-detail">
    <div>
      <el-icon @click="back" size="40"><Back /></el-icon>
    </div>
    <h1>{{ tip?.tname }}</h1>
    <br />
    <div class="title">
      <div class="info1">
        <p>
          作者<el-icon><Avatar /></el-icon>:{{ tip?.tuser }}
        </p>
      </div>
      <div class="info2">
        <p>分类专栏：{{ tip?.tclass }}</p>
        <p>时间：{{ formattedTime }}</p>
      </div>
    </div>
    <img :src="imagePath" alt="封面图" v-if="tip?.tpic" style="max-width: 100%; margin-top: 10px" />
    <hr />
    <br />
    <div style="white-space: pre-wrap; word-break: break-word; overflow-wrap: break-word">
      {{ tip?.tcontent }}
    </div>
    <div class="good">
      <div class="info2" @click="GoodsFill" :class="{ disabled: isLiking }">
        <div class="icon" v-if="!Good">
          <img src="../pic/点赞 (1).png" alt="" />
        </div>
        <div v-if="Good" class="icon1">
          <img src="../pic/点赞.png" alt="" />
        </div>
        <p>获赞数：{{ tip?.tgood }}</p>
      </div>
    </div>
  </div>
  <hr />
  <div class="comment">
    <el-input
      v-model="textarea"
      style="width: 70vw"
      autosize
      type="textarea"
      placeholder="善意的评论会让作者更有动力哦~"
    />
    <el-button @click="submitComment" class="btn">提交</el-button>
  </div>
  <div class="main">
    <div v-for="(item, index) in tipComments" :key="index">
      <MessageComponent :mes="item"></MessageComponent>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted, computed } from 'vue'
import { useRoute } from 'vue-router'
import request from '../util/request'
import { getTip, getTipComments, sendComment, addTipGood, addTipMessage } from '../api/pre'
import { type Tip } from '../../src/api/tip'
import router from '../router'
import type { Message as MyMessage } from '../api/message'
import MessageComponent from '../components/message.vue'
import { GoodsFilled } from '@element-plus/icons-vue'

const route = useRoute()
const tid = route.params.tid
const textarea = ref('')
const tip = ref<Tip | null>(null)
const tipComments = ref<MyMessage[]>([])
function formatToFriendly(date = new Date()) {
  const pad = (n: any) => String(n).padStart(2, '0')
  return `${date.getFullYear()}年${pad(date.getMonth() + 1)}月${pad(date.getDate())}日 ${pad(date.getHours())}:${pad(date.getMinutes())}`
}
const Good = ref(false)
const isLiking = ref(false) //锁死，非常good吧
const GoodsFill = () => {
  if (isLiking.value) {
    return 
  }
  if (!tip.value) {
    isLiking.value = false
    return
  }

  isLiking.value = true

  addTipGood(tip.value.tid)
    .then(() => {
      tip.value!.tgood++
      Good.value = !Good.value
    })
    .catch((err) => {
      console.error('点赞失败:', err)
    })
}
const submitComment = () => {
  const formData = new FormData()
  formData.append('mid', '')
  formData.append('mname', localStorage.getItem('userpic') || '')
  formData.append('mget', '')
  formData.append('msend', localStorage.getItem('username') || '')
  formData.append('mtime', formatToFriendly())
  formData.append('mread', 'false')
  formData.append('mcontent', textarea.value)
  formData.append('mtipid', tid as string)
  sendComment(formData)
    .then(() => {
      console.log('评论提交成功')
      // 评论数增加
      addTipMessage(tid as string)
      textarea.value = ''
      getComments()
    })
    .catch(() => {
      console.error('评论提交失败')
    })
}
const getComments = () => {
  getTipComments(tid as string)
    .then((data) => {
      console.log(tid)
      console.log('获取评论成功:', data)
      tipComments.value = Array.isArray(data) ? (data as MyMessage[]) : [data as MyMessage]
    })
    .catch((error) => {
      console.error('获取评论失败:', error)
    })
}

onMounted(() => {
  getTip(tid as string)
    .then((data) => {
      tip.value = data
    })
    .catch((error) => {
      console.error('获取提示信息失败:', error)
    })
    .then(() => {
      getComments()
    })
})

const formattedTime = computed(() => {
  if (!tip.value?.ttime) return ''

  const date = new Date(tip.value.ttime)
  const year = date.getFullYear()
  const month = String(date.getMonth() + 1).padStart(2, '0') // 月份从0开始
  const day = String(date.getDate()).padStart(2, '0')

  return `${year}-${month}-${day}`
})
const imagePath = computed(() => {
  if (!tip.value || !tip.value.tpic) return ''
  return `http://localhost:8080/${tip.value.tpic}`
})
const back = () => {
  router.back()
}
</script>

<style lang="scss" scoped>
.tip-detail {
  background: white;
  min-height: 95vh;
  padding: 30px;
  width: 100%;
  overflow-x: hidden;
  box-sizing: border-box;
  .title {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 20px;
  }
  .info2 {
    color: gray;
    .disabled {
      
      pointer-events: none;
      opacity: 0.6;
      cursor: not-allowed;
    }
  }
}
.comment {
  display: flex;
  justify-content: space-around;
  align-items: center;
  margin-top: 20px;
  .btn {
    width: 80px;
    height: 30px;
    background-color: #ff59c5;
    color: white;
    border-radius: 5px;
    border: none;
    cursor: pointer;
    transition: background-color 0.3s ease;
    &:hover {
      background-color: #ffc7e4;
    }
  }
}
.main {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  margin-top: 10px;
}
.good {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 5vh;
  .icon {
    width: 9vh;
    height: 9vh;
    border: 2px solid #000000;
    padding: 10px;
    border-radius: 50%;

    img {
      width: 100%;
      height: 100%;
    }
  }
  .icon1 {
    width: 9vh;
    height: 9vh;
    border: 2px solid #fb0314;
    padding: 10px;
    border-radius: 50%;

    img {
      width: 100%;
      height: 100%;
    }
  }
}
</style>
