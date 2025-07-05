<template>
  <Transition name="slide-in" appear>
    <div class="login">
      <div class="tit">注册<span class="title"></span></div>
      <label for="name" class="label">用户名：</label>
      <nut-input v-model="name" placeholder="姓名" id="name" class="a" />
      <label for="password" class="label">密 码：</label>
      <nut-input v-model="password" placeholder="密码" id="password" class="a" type="password" />
      <label for="password" class="label">确认密码：</label>
      <nut-input
        v-model="passwordConfirm"
        placeholder="确认密码"
        id="password"
        class="a"
        type="password"
      />
      <label for="pic" class="label">选择头像：</label>
      <input type="file" accept="image/*" @change="handleUpload" />
      <div class="btn">
        <nut-button type="success" @click="Upload">登录</nut-button>
        <nut-button type="warning" @click="clean">清空</nut-button>
      </div>
    </div>
  </Transition>
  <footer>
    <hr />
    <div class="footer">©解释权Lucius.John.Karmen(许光明)</div>
  </footer>
  <!-- 算了还是加一个返回登录吧 -->
  <div class="back" @click="back">
    <el-icon size="10"><Back /><span>返回登录</span></el-icon>
  </div>
</template>

<script setup lang="ts" name="reg">
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { ElIcon } from 'element-plus'
import { Back } from '@element-plus/icons-vue'
import request from '../util/request'

const router = useRouter()
const name = ref('')
const password = ref('')
const passwordConfirm = ref('')

const pic = ref<File | null>(null)
const handleUpload = (e: Event) => {
  const file = (e.target as HTMLInputElement).files?.[0]
  pic.value = file || null
}
const Upload = () => {
  if (password.value !== passwordConfirm.value) {
    alert('两次输入的密码不一致，请重新输入！')
    return
  }
  const formData = new FormData()
  formData.append('name', name.value)
  formData.append('password', password.value)
  formData.append('pic', pic.value!)
  request({
    method: 'post',
    url: '/user/register',
    data: formData,
    headers: {
      'Content-Type': 'multipart/form-data',
    },
  })
    .then((data: any) => {
      console.log(data)
      if (data === '注册成功') {
        alert('注册成功！')
        router.push('/login')
      } else {
        alert('注册失败，宝宝请稍后再试！')
      }
    })
    .catch((error) => {
      console.error('请求失败:', error)
    })
}
const clean = () => {
  name.value = ''
  password.value = ''
  passwordConfirm.value = ''
  pic.value = null
}
const back = () => {
  router.push('/login')
}
</script>

<style lang="scss" scoped>
.login {
  width: 30%;
  margin: 0 auto;
  padding: 20px;
  height: 70vh;
  border: 1px solid #ffffff;
  border-radius: 20px;
  background-color: rgba(122, 244, 251, 0.467);
  position: fixed;
  left: 50%;
  transform: translateX(-50%);
  top: 15vh;
  blur: 5px;
  box-shadow: 0 0 30px rgba(244, 244, 244, 0.5);

  .btn {
    display: flex;
    justify-content: space-around;
    margin-top: 20px;
  }
  .tit {
    font-size: 24px;
    color: rgb(0, 46, 248);
    font-weight: 600;
    .title {
      font-size: 20px;
      color: #f69116;
      margin-left: 20%;
      font-style: italic;
    }
  }
}
.footer {
  position: fixed;
  bottom: 0;
  left: 0;
  right: 0;
  text-align: center;
}
.label {
  font-size: 15px;
  font-weight: 400;
  color: #27aef7;
}
.back {
  color: #1980fd;
  position: fixed;
  top: 10px;
  left: 10px;
}
@media (max-width: 768px) {
  .login {
    width: 68%;
    height: 50vh;
    position: fixed;
    left: 50%;
    transform: translateX(-50%);
    .label {
      font-size: 15px;
      font-weight: 500;
      color: #1980fd;
    }
    .tit {
    }
  }
  .footer {
    position: fixed;
    bottom: 0;
    left: 0;
    right: 0;
    text-align: center;
  }
  .a {
    margin-bottom: 30px;
  }
}

.slide-in-enter-active {
  transition: all 1s cubic-bezier(0.4, 0, 0.2, 1);
  opacity: 0;
  transform: translateY(40px);
}

.slide-in-enter-to {
  opacity: 1;
  transform: translateY(0);
}
</style>
