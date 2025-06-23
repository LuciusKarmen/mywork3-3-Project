<template>
  <div class="message">
    <div class="header">我的消息</div>
    <br />
    <br />
    <br />
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
  .header {
    height: 6vh;
    text-align: center;
    line-height: 6vh;
    width: 100%;
    background-color: rgb(208, 208, 208);
  }
  .footer {
    position: fixed;
    bottom: 0;
    width: 100%;
  }
}
</style>
