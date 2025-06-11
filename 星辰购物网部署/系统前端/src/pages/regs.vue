<template>
  <div class="all">
    <div class="face">
      <h1>欢迎来到星辰网</h1>
      <h3>祝您每天开开心心</h3>
      <n-space vertical>
        <label id="username" for="username">用户名:</label>
        <n-input
          v-model:value="shopname"
          type="text"
          placeholder="用户名/电话号码"
          id="username"
          @blur="shopBlur"
        />
        <span v-if="errors.name">{{ errors.name }}</span>

        <label id="password" for="password">密码:</label>
        <n-input
          v-model:value="shoppassword"
          type="text"
          placeholder="密码"
          id="password"
          @blur="shopBlur"
        />
        <span v-if="errors.password">{{ errors.password }}</span>
      </n-space>
      <n-space vertical class="a">
        <div class="label">选择头像：</div>
        <div class="k">
          <input type="file" accept="image/*" @change="handleAvatarUpload" />
          <div v-if="avatarUrl" class="avatar-preview">
            <img :src="avatarUrl" alt="头像预览" />
          </div>
        </div>
      </n-space>
      <n-button type="warning" class="button" @click="handleRegisters" :disable="!isFormValid"
        >入驻</n-button
      >
      <div class="register-link">入住了成功了吧<a href="/logins">点击登录</a></div>
    </div>
  </div>
</template>

<script setup lang="ts" name="face">
import { reactive, ref, computed } from 'vue'
import axios from 'axios'
import { generateUUID } from '../utils/uuid.js'

const errors = ref({
  name: '',
  password: '',
})
const shopBlur = () => {
  let hasshow = false
  if (!shopname.value) {
    errors.value.name = '请输入用户名'
    hasshow = true
  } else {
    errors.value.name = ''
  }

  if (shoppassword.value.length < 7) {
    errors.value.password = '密码太短'
    hasshow = true
  } else {
    errors.value.password = ''
  }
  return !hasshow
}

const isFormValid = computed(() => {
  return shopname.value.trim() !== '' && shoppassword.value.length >= 7
})

const shopid = ref('')
const shopname = ref('')
const shoppassword = ref('')
const shoppath = ref('')
const avatarUrl = ref('')
const shopfile = ref<File | null>(null)

shopid.value = generateUUID//todo

// 处理头像上传

const handleAvatarUpload = (event: Event) => {
  const target = event.target as HTMLInputElement
  const file = target.files?.[0]
  shopfile.value = file || null
  if (file) {
    // 创建临时 URL 预览图片
    const reader = new FileReader()
    reader.onload = (e) => {
      shoppath.value = e.target?.result as string
    }
    reader.readAsDataURL(file)
  }
}

const handleRegisters = () => {
  const fromdata = new FormData()
  if (shopfile.value) {
    fromdata.append('shopfile', shopfile.value)
  }

  fromdata.append('shopid', shopid.value)
  fromdata.append('shopname', shopname.value)
  fromdata.append('shoppassword', shoppassword.value)
  fromdata.append('shopfile', shopfile.value || '')

  console.log('Form Data:', fromdata)
  axios
    .post('/api/shop/register', fromdata, {
      headers: {
        'Content-Type': 'multipart/form-data',
      },
    })
    .then((response) => {
      console.log(response.data)
      if (response.data === 'success') {
        alert('注册成功')
        localStorage.setItem('shopname', shopname.value)
        window.location.href = '/works/index'
      } else {
        alert('注册失败，请检查输入信息')
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

    height: 65vh;
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
