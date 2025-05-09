<template>
  <div id="header">
    <Header></Header>
  </div>
  <div class="main">
    <Left></Left>
    <Content></Content>
  </div>
</template>

<script setup lang="ts" name="dain">
import Left from '../components/left.vue'
import Content from '../components/content.vue'
import Header from '../components/header.vue'
</script>

<style lang="scss" scoped>
.main {
  display: flex;
  width: 100%;
  height: 90vh;
  background-color: #f0f0f0;
}
</style>
