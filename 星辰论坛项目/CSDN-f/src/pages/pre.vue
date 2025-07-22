<template>
  <div class="tip-detail">
    <h2>{{ tip.tname }}</h2>
    <p>分类：{{ tip.tclass }}</p>
    <p>作者：{{ tip.tuser }}</p>
    <p>时间：{{ tip.ttime }}</p>
    <img :src="tip.tpic" alt="封面图" v-if="tip.tpic" style="max-width: 100%; margin-top: 10px" />
    <hr />
    <div style="white-space: pre-wrap">{{ tip.tcontent }}</div>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import request from '../util/request'

const route = useRoute()
const tid = route.params.tid

const tip = ref(null)

const getTipDetail = () => {
  request({
    method: 'get',
    url: `/tip/getTip/${tid}`,
  })
    .then((data) => {
      tip.value = data
      console.log('请求成功:', data)
    })
    .catch(() => {
      console.error('请求失败')
    })
}

onMounted(() => {
  getTipDetail()
})
</script>

<style scoped>
.tip-detail {
  max-width: 800px;
  margin: 20px auto;
  padding: 20px;
  background-color: #fff;
  border-radius: 8px;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
}
</style>
