<template>
  <div class="my">
    <div class="foot">
      <Title></Title>
    </div>
  </div>
</template>

<script setup lang="ts" name="face">
import Title from '../components/Title.vue'
</script>

<style lang="scss" scoped>
.my {
  width: 100%;
  height: 100vh;
}
.foot {
  position: fixed;
  bottom: 0;
  width: 100%;
}
</style>
