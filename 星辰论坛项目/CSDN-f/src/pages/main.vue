<template>
  <Title></Title>
  <div class="main">
    <br />
    <br />
    <br />
    <div v-for="(item, index) in selectclasslist" :key="index">
      <TipComponent ref="tip" :tip="item"></TipComponent>
    </div>
    <br />
    <br />
  </div>
  <div class="footer">
    <Bar></Bar>
  </div>
  <!-- 回顶刷新 -->
</template>

<script setup lang="ts" name="face">
import { indexOf } from 'lodash'
import TipComponent from '../components/tip.vue'
import Title from '../components/title.vue'
import Bar from '../components/bar.vue'
import { Search, HorizontalN, Right } from '@nutui/icons-vue'
import { ref, computed, watch, onMounted, onBeforeUnmount } from 'vue'
import { type Tip } from '../api/tip'
import { getTips } from '../api/main'

const tips = ref<Tip[]>([])
const classify = ref(localStorage.getItem('classify') || '全部')
const selectclasslist = computed(() => {
  const currentClassify = classify.value
  if (currentClassify === '全部') return tips.value
  return tips.value.filter((item) => item.tclass === currentClassify)
})

onMounted(() => {
  getTips().then((data) => {
    tips.value = data
  })
})
</script>

<style lang="scss" scoped>
.main {
  min-height: 100vh;
}
.footer {
  position: fixed;
  bottom: 0;
  width: 100%;
}
@media (max-width: 768px) {
}
</style>
