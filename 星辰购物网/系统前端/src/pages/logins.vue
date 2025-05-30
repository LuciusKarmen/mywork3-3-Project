<template>
  <div class="all">
    <div class="face">
      <h1>欢迎加盟星辰网</h1>
      <h3>合作共赢是我们的宗旨</h3>
      <n-space vertical>
        <label id="username" for="username">用户名:</label>
        <n-input v-model:value="shopname" type="text" placeholder="用户名/电话号码" id="username" />

        <label id="password" for="password" class="password">密码:</label>
        <n-input v-model:value="shoppassword" type="text" placeholder="密码" id="password" />
      </n-space>

      <n-button type="warning" class="button" @click="handleLogin">登录</n-button>
      <div class="register-link">还没有加盟吗<a href="/regs">点击入驻</a></div>
    </div>
  </div>
</template>

<script setup lang="ts" name="face">
import { ref } from 'vue'
import axios from 'axios'

const shopname = ref('')
const shoppassword = ref('')
function handleLogin() {
  axios
    .post(
      '/api/shop/logins',
      // 发送的数据,设置请求体
      {
        shopname: shopname.value,
        shoppassword: shoppassword.value,
      },
      // 设置请求头
      {
        headers: {
          'Content-Type': 'application/json',
        },
      },
    )
    .then((response) => {
      console.log(response.data)
      if (response.data === 'success') {
        alert('登录成功')
        localStorage.setItem('shopname', shopname.value)
        window.location.href = '/works/index'
      } else {
        alert('登录失败，请检查用户名和密码')
      }
    })
    .catch((error) => {
      console.error(error)
      alert('发生错误，请稍后再试')
    })
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
      bottom: 5%;
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
