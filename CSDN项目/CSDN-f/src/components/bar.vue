<template>
  <!-- active可以分配给儿子们，非常可以 -->
  <nut-tabbar v-model="active" unactive-color="#7d7e80" active-color="#1989fa">
    <nut-tabbar-item tab-title="Home" :value="11" @click="handleClick1">
      <template #icon="{ active }">
        <Home :style="{ fill: active ? '#1989fa' : '#7d7e80' }" />
      </template>
    </nut-tabbar-item>

    <nut-tabbar-item tab-title="Find" :value="110" @click="handleClick2">
      <template #icon="{ active }">
        <Find :style="{ fill: active ? '#1989fa' : '#7d7e80' }" />
      </template>
    </nut-tabbar-item>

    <nut-tabbar-item tab-title="Uploader" :dot="true" @click="handleClick3">
      <template #icon="{ active }">
        <Uploader :style="{ fill: active ? '#1989fa' : '#7d7e80' }" />
      </template>
    </nut-tabbar-item>

    <nut-tabbar-item tab-title="My" :dot="true" @click="handleClick4">
      <template #icon="{ active }">
        <My :style="{ fill: active ? '#1989fa' : '#7d7e80' }" />
      </template>
    </nut-tabbar-item>
  </nut-tabbar>
</template>
<script setup lang="ts" name="Bar">
import { ref, watch, onMounted } from 'vue'
import { Home, Category, Find, My, Uploader } from '@nutui/icons-vue'
import { useRouter } from 'vue-router'

const route = useRouter()
const active = ref<number>(Number(localStorage.getItem('index') || 0))
//储存的所有串转字符（为了安全）
//  String(index)
//JSON.stringify(user)
const handleClick1 = () => {
  localStorage.setItem('index', '0')
  route.push('/main')
}
const handleClick2 = () => {
  localStorage.setItem('index', '1')
  route.push('/message')
}
const handleClick3 = () => {
  localStorage.setItem('index', '2')
  route.push('/send')
}
const handleClick4 = () => {
  localStorage.setItem('index', '3')
  route.push('/my')
}
</script>
