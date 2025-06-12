<template>
  <div class="all">
    <div class="face">
      <h1>欢迎来到星辰网</h1>
      <h3>我的主人--Karmen.John.Lucius</h3>
      <h2>--Karmen.John.Lucius</h2>
      <n-space vertical>
        <label id="username" for="username">秘钥:</label>
        <n-input v-model:value="username" type="text" placeholder="秘钥名称" id="username" />

        <label id="password" for="password">密码:</label>
        <n-input v-model:value="userpassword" type="password" placeholder="密码" id="password" />
      </n-space>
      <n-button type="primary" class="button" @click="handleLogin">登录</n-button>
      <div class="register-link">联系我们成为合伙人</div>
      <br />
      <br />
      <br />
      <a href="/our">点击开启新世界的大门</a>
    </div>
  </div>
</template>

<script setup lang="ts" name="face">
import { ref } from 'vue'
import axios from 'axios'
import { lo } from 'element-plus/es/locales.mjs'

const username = ref('')
const userpassword = ref('')

function handleLogin() {
  axios
    .post(
      '/api/user/loginuser',
      {
        username: username.value,
        userpassword: userpassword.value,
      },

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
        localStorage.setItem('username', username.value)

        window.location.href = '/our'
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
      color: rgb(255, 0, 0);
      text-decoration: none;
      position: absolute;
      bottom: 10%;
      left: 32%;

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
