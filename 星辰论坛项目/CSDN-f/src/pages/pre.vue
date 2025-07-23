<template>
  <div class="tip-detail">
    <h2>{{ tip?.tname }}</h2>
    <p>分类：{{ tip?.tclass }}</p>
    <p>作者：{{ tip?.tuser }}</p>
    <p>时间：{{ tip?.ttime }}</p>
    <img :src="tip.tpic" alt="封面图" v-if="tip?.tpic" style="max-width: 100%; margin-top: 10px" />
    <hr />
    <div style="white-space: pre-wrap">{{ tip?.tcontent }}</div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { useRoute } from 'vue-router'
import request from '../util/request'
import { getTip } from '../api/pre'
import { type Tip } from '../../src/api/tip'

const route = useRoute()
const tid = route.params.tid

const tip = ref<Tip | null>(null)

onMounted(() => {
  getTip(tid as string)
    .then((data) => {
      tip.value = data
    })
    .catch((error) => {
      console.error('获取提示信息失败:', error)
    })
})
</script>

<style scoped>
.tip-detail {
  background: white;
  min-height: 100vh;
}
</style>
