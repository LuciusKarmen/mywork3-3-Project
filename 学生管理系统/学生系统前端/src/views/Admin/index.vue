<template>
  <div class="main">
    <div class="centre"></div>
  </div>
</template>
<script lang="ts" setup name="">
import { ref } from 'vue'
</script>
<style lang="scss" scoped>
.main {
  width: 100%;
  height: 100%;
  background: #f5f5f5;
  .centre {
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;

    background: linear-gradient(135deg, rgb(156, 235, 255), rgb(241, 241, 241));
    display: flex;
    background-size: 400% 400%;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    color: white;
    text-align: center;
    animation: gradientBG 15s ease infinite;
    overflow: hidden;
  }
}
</style>
