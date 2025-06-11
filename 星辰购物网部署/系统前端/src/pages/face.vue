<template>
  <div class="all">
    <div class="face">
      <h1>欢迎来到星辰网</h1>
      <h3>您的购物天堂</h3>

      <n-button type="primary" @click="gou" class="a">我是顾客</n-button>
      <n-button type="warning" @click="gos" class="a">我是商家</n-button>
      <n-button type="error" @click="gom" class="a">我是管理员</n-button>
    </div>
  </div>
</template>

<script setup lang="ts" name="face">
const gou = () => {
  window.location.href = '/loginu'
}
const gos = () => {
  window.location.href = '/logins'
}
const gom = () => {
  window.location.href = '/regm'
}
</script>

<style scoped lang="scss">
.all {
  height: 100vh;
  width: 100vw;
  background-image: url('../pic/启动图.png');
  background-size: cover;
  background-position: center;
  background-repeat: no-repeat;

  .face {
    display: flex;
    flex-direction: column;
    align-items: center;

    height: 70vh;
    width: 24%;
    border: 1px solid #000;
    border-radius: 20px;
    background-color: rgba(white, 0.7);
    position: absolute;
    top: 15%;
    left: 67%;
    h1 {
      margin-top: 10px;
      color: aqua;
      font-weight: 500;
    }
    h3 {
      margin: 10px 0;
      font-style: italic;
    }
    .a {
      width: 200px;
      height: 80px;
      margin-top: 10px;
    }
  }
}
</style>
