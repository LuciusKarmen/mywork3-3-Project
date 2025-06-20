<template>
  <div class="message">
    gg
    <div class="footer">
      <Title></Title>
    </div>
  </div>
</template>

<script setup lang="ts" name="face">
import Title from '../components/title.vue'
</script>

<style lang="scss" scoped>
.message {
  min-height: 100vh;
}
.footer {
  position: fixed;
  bottom: 0;
  width: 100%;
}
</style>
