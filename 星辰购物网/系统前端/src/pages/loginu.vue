<template>
  <div class="all">
    <div class="face">
      <h1>欢迎来到星辰网</h1>
      <h3>祝您每天开开心心</h3>
      <n-space vertical>
        <label id="username" for="username">用户名:</label>
        <n-input v-model:value="username" type="text" placeholder="用户名/电话号码" id="username" />

        <label id="password" for="password">密码:</label>
        <n-input v-model:value="password" type="text" placeholder="密码" id="password" />
      </n-space>
      <n-button type="primary" class="button">登录</n-button>
      <div class="register-link">还没有加入大家庭吗<a href="/regu">点击注册</a></div>
    </div>
  </div>
</template>

<script setup lang="ts" name="face">
import { ref } from 'vue'

const username = ref('')
const password = ref('')
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
      margin-bottom: 10px;
      color: aqua;
      font-weight: 600;
    }

    h3 {
      margin-top: 10px;
      margin-bottom: 30px;
      font-style: italic;
    }

    .register-link {
      font-size: 14px;
      color: orange;
      text-decoration: none;
      position: absolute;
      bottom: 0%;
      left: 5%;

      a {
        color: #007bff;
        text-decoration: none;
        margin-left: 5px;
      }
    }

    .button {
      width: 100px;
      height: 30px;
      margin-top: 30px;
    }
  }
}
</style>
