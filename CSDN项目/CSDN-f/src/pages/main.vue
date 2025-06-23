<template>
  <div class="title">
    <div class="logo"></div>
    <input type="text" placeholder="搜索" class="search" />
    <div class="pic">111</div>
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
.title {
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 1% 5%;
  background-color: rgb(208, 208, 208);
  height: 6vh;
  .search {
    width: 50%;
    height: 5vh;
    background-color: rgb(255, 255, 255);
    border-radius: 15px;
    border: 2px solid paleturquoise;
  }
}
.footer {
  position: fixed;
  bottom: 0;
  width: 100%;
}
@media (max-width: 768px) {
  .title {
    height: 7vh;
  }
}
</style>
