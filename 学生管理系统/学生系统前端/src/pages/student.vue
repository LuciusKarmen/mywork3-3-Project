<template>
  <div class="main">
    <div class="top"></div>
    <div class="left"></div>
    <div class="right"></div>
  </div>
</template>
<script lang="ts" setup name="">
import { ref } from 'vue'
</script>
<style lang="scss" scoped>
.main {
  width: 100%;
  height: 100%;
  background-color: #ffe2e2;
  position: relative;
  .top {
    width: 100%;
    height: 8vh;
    background-color: #f94040;
  }
  .left {
    width: 8vw;
    height: 92vh;
    background-color: #f94040;
    position: absolute;
    top: 8vh;
    left: 0;
  }
}
</style>
