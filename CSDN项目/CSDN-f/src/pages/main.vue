<template>
  <div class="title">
    <div class="logo"></div>
    <div class="search"></div>
    <div class="pic"><img src="../pic" alt="" /></div>
  </div>
  <div class="main">
    <div v-for="(item, index) in 11" :key="index">
      <Tip></Tip>
    </div>
  </div>
  <div class="footer">
    <Title></Title>
  </div>
</template>

<script setup lang="ts" name="face">
import { indexOf } from 'lodash'
import Tip from '../components/tip.vue'
import Title from '../components/title.vue'
</script>

<style lang="scss" scoped>
.footer {
  position: fixed;
  bottom: 0;
  width: 100%;
}
</style>
