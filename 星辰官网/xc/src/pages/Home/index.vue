<template>
  <div class="home">
    <div class="title">
      <div class="name">介绍</div>
      <div class="bar">
        <div class="item">首页</div>
        <div class="item">公司简历</div>
        <div class="item">管理团队</div>
        <div class="item">产品案例</div>
        <div class="item">联系我们</div>
      </div>
    </div>
    <div class="header">22</div>
    <div class="content">333</div>
  </div>
</template>
<script lang="ts" setup name="">
import { ref } from 'vue'
</script>
<style lang="scss" scoped>
.home {
  width: 100%;
  height: 200vh;
  background-color: #f5f5f5;
  .title {
    position: fixed;
    left: 0;
    top: 0;
    width: 100%;
    height: 9vh;
    background-color: #ffffff;
    display: flex;
    justify-content: space-around;
    align-items: center;
    .bar {
      display: flex;
      justify-content: space-around;
      align-items: center;
      .item {
        width: 10vw;
        background-color: #ffffff;
      }
    }
  }
  .header {
    width: 100%;
    height: 60vh;
    background-color: #aaffaa;
  }
}
</style>
