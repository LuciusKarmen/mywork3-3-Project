<template>
  <div class="all">
    <div class="face">
      <h1>欢迎来到星辰网</h1>
      <h3>祝您每天开开心心</h3>
      <n-space vertical>
        <label id="username" for="username">用户名:</label>
        <n-input v-model:value="username" type="text" placeholder="用户名/电话号码" id="username" />

        <label id="password" for="password">密码:</label>
        <n-input v-model:value="userpassword" type="text" placeholder="密码" id="password" />
      </n-space>
      <n-space vertical class="a">
        <div class="label">选择头像：</div>
        <div class="k">
          <input
            type="file"
            class="input"
            id="avatar"
            accept="image/*"
            @change="handleAvatarUpload"
          />
          <div v-if="avatarUrl" class="avatar-preview">
            <img :src="avatarUrl" alt="头像预览" />
          </div>
        </div>
      </n-space>
      <n-button type="primary" class="button" @click="handleRegister">注册</n-button>
      <div class="register-link">注册好了吧<a href="/loginu">点击登录</a></div>
    </div>
  </div>
</template>

<script setup lang="ts" name="face">
import { ref } from 'vue'
import axios from 'axios'

const username = ref('')
const userpassword = ref('')
const avatarUrl = ref('')
const userid = ref(crypto.randomUUID())
const userfile = ref<File | null>(null)

const handleAvatarUpload = (event: Event) => {
  const target = event.target as HTMLInputElement
  const file = target.files?.[0]
  userfile.value = file || null
  if (file) {
    const reader = new FileReader()
    reader.onload = (e) => {
      avatarUrl.value = e.target?.result as string
    }
    reader.readAsDataURL(file)
  }
}
function handleRegister() {
  const formData = new FormData()
  if (userfile.value) {
    formData.append('userfile', userfile.value)
  }
  formData.append('username', username.value)
  formData.append('userpassword', userpassword.value)
  formData.append('userid', userid.value)

  axios
    .post('/api/user/registeruser', formData, {
      headers: {
        'Content-Type': 'multipart/form-data',
      },
    })
    .then((response) => {
      console.log(response.data)
      if (response.data === 'success') {
        alert('注册成功')
        localStorage.setItem('username', username.value)
        window.location.href = '/worku/index'
      } else {
        alert('注册失败，请检查用户名和密码')
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
      margin-bottom: 10px;
      font-style: italic;
    }

    .a {
      .label {
        margin-left: 100px;
        margin-top: 10px;
        margin-bottom: 5px;
      }

      .k {
        display: flex;
        margin-left: 100px;
      }
    }

    .avatar-preview {
      width: 50px;
      height: 50px;
      border-radius: 50%;
      overflow: hidden;
      margin-left: -20px;
      position: absolute;
      top: 70%;
      left: 70%;

      img {
        width: 100%;
        height: 100%;
        object-fit: cover;
      }
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
      position: absolute;
      bottom: 8%;
      left: 30%;
      width: 100px;
      height: 30px;
      margin-top: 10px;
    }
  }
}
</style>
