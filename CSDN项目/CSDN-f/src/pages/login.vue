<template>
  <div class="login">
    <div class="tit">登录<span class="title">欢迎加入KSDN</span></div>
    <label for="name" class="label">用户名：</label>
    <nut-input v-model="name" placeholder="姓名" id="name" class="a" />
    <label for="password" class="label">密 码：</label>
    <nut-input v-model="password" placeholder="密码" id="password" class="a" type="password" />
    <div class="btn">
      <nut-button type="success" @click="login" class="btn1">登录</nut-button>
      <nut-button type="warning" @click="clear">清空</nut-button>
    </div>
    <br />
    <div class="tip">还没有账号?<a href="/reg">点击注册</a></div>
    <div class="h" @click="go">关于我们</div>
  </div>
  <footer>
    <hr />
    <div class="footer">©解释权Lucius.John.Karmen(许光明)</div>
  </footer>
</template>

<script setup lang="ts" name="face">
import request from '../util/request'
import { ref } from 'vue'
import { useRouter } from 'vue-router'

const router = useRouter()
const go = () => {
  router.push('/our')
}
const name = ref('')
const password = ref('')

const login = () => {
  if (name.value === '' || password.value === '') {
    alert('用户名或密码不能为空！')
    return
  }
  request({
    url: '/user/login',
    method: 'POST',
    data: {
      name: name.value,
      password: password.value,
    },
  })
    .then(() => {
      // 能进到 then 说明 code == 200,这个才是统一接口的妙处
      alert('登录成功！')
      router.push('/main')
    })
    .catch(() => {
      alert('登录失败，请检查用户名或密码')
    })
}

const clear = () => {
  name.value = ''
  password.value = ''
}
</script>

<style lang="scss" scoped>
.login {
  width: 30%;
  margin: 0 auto;
  padding: 20px;
  height: 60vh;
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
    position: absolute;
    left: 20%;
    bottom: 10%;
    .btn1 {
      margin-right: 100px;
    }
  }
  .tit {
    font-size: 24px;
    color: rgb(0, 46, 248);
    font-weight: 600;
    .title {
      font-size: 20px;
      color: #f7bd2a;
      margin-left: 20%;
      font-style: italic;
    }
  }
  .h {
    font-size: 18px;
    position: fixed;
    left: 48%;
    transform: translate(-50%, 0);
    color: rgb(0, 46, 248);
    bottom: 1%;
    .h1 {
      text-decoration: none;
      &:hover {
        color: rgb(255, 255, 255);
        background-color: #c3ff00;
      }
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
      margin-bottom: 40px;
    }
    .btn {
      display: flex;
      position: absolute;
      left: 20%;
      bottom: 10%;
      .btn1 {
        margin-right: 35%;
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
  .a {
    margin-bottom: 30px;
  }
}
</style>
