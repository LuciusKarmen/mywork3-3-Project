<template>
  <div class="tip-detail">
    <div>
      <el-icon @click="back"><Back /></el-icon>
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
    <div style="white-space: pre-wrap">{{ tip?.tcontent }}</div>
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
</template>

<script setup lang="ts">
import { ref, onMounted, computed } from 'vue'
import { useRoute } from 'vue-router'
import request from '../util/request'
import { getTip } from '../api/pre'
import { type Tip } from '../../src/api/tip'
import router from '../router'

const route = useRoute()
const tid = route.params.tid
const textarea = ref('')
const tip = ref<Tip | null>(null)

const submitComment = () => {
  console.log('提交:', textarea.value)

  textarea.value = ''
}
onMounted(() => {
  getTip(tid as string)
    .then((data) => {
      tip.value = data
    })
    .catch((error) => {
      console.error('获取提示信息失败:', error)
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
  .title {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 20px;
  }
  .info2 {
    color: gray;
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
</style>
