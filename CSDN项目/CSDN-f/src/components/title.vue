<template>
  <nut-tabbar v-model="active" unactive-color="#7d7e80" active-color="#1989fa">
    <nut-tabbar-item tab-title="Home" :value="11" @click="handleClick1">
      <template #icon>
        <Home></Home>
      </template>
    </nut-tabbar-item>
    <nut-tabbar-item tab-title="Find" :value="110" @click="handleClick2">
      <template #icon>
        <Find></Find>
      </template>
    </nut-tabbar-item>
    <nut-tabbar-item tab-title="Uploader" :dot="true" @click="handleClick3">
      <template #icon>
        <Uploader></Uploader>
      </template>
    </nut-tabbar-item>
    <nut-tabbar-item tab-title="My" :dot="true" @click="handleClick4">
      <template #icon>
        <My></My>
      </template>
    </nut-tabbar-item>
  </nut-tabbar>
</template>
<script setup lang="ts" name="Title">
import { ref } from 'vue'
import { Home, Category, Find, My, Uploader } from '@nutui/icons-vue'
import { useRouter } from 'vue-router'

const active = ref(0)
const route = useRouter()
const handleClick1 = () => {
  route.push('/main')
}
const handleClick2 = () => {
  route.push('/message')
}
const handleClick3 = () => {
  route.push('/send')
}
const handleClick4 = () => {
  route.push('/my')
}
</script>
