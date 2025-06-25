<template>
  <Title></Title>
  <div class="main">
    <br />
    <br />
    <br />
    <div v-for="(item, index) in 11" :key="index">
      <Tip></Tip>
    </div>
  </div>
  <div class="footer">
    <Bar></Bar>
  </div>
</template>

<script setup lang="ts" name="face">
import { indexOf } from 'lodash'
import Tip from '../components/tip.vue'
import Title from '../components/title.vue'
import Bar from '../components/bar.vue'
import { Search, HorizontalN, Right } from '@nutui/icons-vue'
</script>

<style lang="scss" scoped>
.footer {
  position: fixed;
  bottom: 0;
  width: 100%;
}
@media (max-width: 768px) {
}
</style>
