<template>
  <div class="main">
    <div class="login-box">
      <div class="login-title">登录</div>
      <div class="login-form">
        <div class="login-input">
          <label>用户名：</label>
          <el-input type="text" placeholder="用户名" size="large" />
        </div>
        <div class="login-input">
          <label>密&nbsp;&nbsp;&nbsp;码：</label>
          <el-input type="password" placeholder="密码" size="large" />
        </div>
      </div>
      <div class="login-button">
        <el-button type="primary" @click="stu">我是学生</el-button>
        <el-button type="success" @click="tea">我是教师</el-button>
        <el-button type="warning" @click="adm">我是管理</el-button>
      </div>
    </div>
  </div>
</template>
<script lang="ts" setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
const router = useRouter()
const stu = () => {
  router.push('/student')
}
const tea = () => {
  router.push('/teacher')
}
const adm = () => {
  router.push('/admin')
}
</script>
<style lang="scss" scoped>
.main {
  width: 100vw;
  height: 100vh;
  background-image: url('../assets/背景1.png');
  background-size: cover;
  position: absolute;

  .login-box {
    position: relative;
    top: calc(50% - 200px);
    left: calc(50% - 250px);
    width: 500px;
    height: 400px;
    background-color: rgba(255, 255, 255, 0.5);
    border-radius: 10px;

    .login-title {
      text-align: center;
      font-size: 40px;
      margin-top: 20px;
      background: linear-gradient(to right, #17f3ff, #c9c9c9);
      -webkit-background-clip: text;
      -webkit-text-fill-color: transparent;
      animation: floatUp 2s ease-out forwards;
    }
    .login-form {
      position: relative;
      top: 20px;
      left: 50px;
      width: 400px;
      height: 200px;

      .login-input {
        margin-top: 20px;
      }
    }
    .login-button {
      display: flex;
      width: 80%;
      justify-content: space-around;
      position: relative;
      bottom: 0px;
      left: 10%;

      .el-button {
        width: 100px;
      }
    }
  }
}
</style>
