<template>
  <Transition name="slide-in" appear>
    <div class="login">
      <div class="tit">注册<span class="title">欢迎加入KSDN</span></div>
      <label for="name" class="label">用户名：</label>
      <nut-input v-model="name" placeholder="姓名" id="name" class="a" />
      <label for="password" class="label">密 码：</label>
      <nut-input v-model="password" placeholder="密码" id="password" class="a" />
      <label for="pic" class="label">选择头像：</label>
      <input type="file" accept="image/*" @change="Upload" />
      <div class="btn">
        <nut-button type="success" @click="get" class="btn1">登录</nut-button>
        <nut-button type="warning" @click="get">清空</nut-button>
      </div>
    </div>
  </Transition>
  <footer>
    <hr />
    <div class="footer">©解释权Lucius.John.Karmen(许光明)</div>
  </footer>
</template>

<script setup lang="ts" name="reg">
import { ref } from 'vue'
const name = ref('')
const password = ref('')

const Upload = () => {
  console.log('上传')
}
const get = () => {
  console.log('提交')
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
    justify-content: space-between;
    position: absolute;
    left: 15%;
    bottom: 4%;
    .btn1 {
      margin-right: 30%;
    }
  }
  .tit {
    font-size: 24px;
    color: rgb(0, 46, 248);
    font-weight: 600;
    .title {
      font-size: 20px;
      color: #c3ff00;
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
