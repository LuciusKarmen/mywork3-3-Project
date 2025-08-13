<template>
  <div class="my">
    <div class="t">
      <div class="pic"><img :src="picture" alt="头像" class="p" /></div>
      <div class="name">{{ username }}</div>
    </div>
    <div class="m">
      <div class="li">我的发帖</div>
    </div>
    <div class="b">
      <div class="li" @click="about">关于网站</div>
      <div class="li" @click="our">联系我们</div>
      <br />
      <br />
      <div class="li" @click="logout">注销登录</div>
    </div>
    <br />
    <br />
    <div class="footer">
      <Bar></Bar>
    </div>
  </div>
</template>

<script setup lang="ts" name="My">
import router from '../router/index'
import Bar from '../components/bar.vue'
import { ref, computed } from 'vue'
const avatar = ref(localStorage.getItem('userpic') || '../pic/KK.png')
const picture = computed(() => {
  return `http://118.195.143.104/${avatar.value}`
})
const username = localStorage.getItem('username')
const our = () => {
  router.push('/our')
}
const about = () => {
  router.push('/about')
}
const logout = () => {
  // 询问是否退出
  const confirmLogout = confirm('确定要注销登录吗？')
  if (!confirmLogout) return
  localStorage.removeItem('username')
  localStorage.removeItem('userpic')

  // 刷新页面
  router.push('/login').then(() => {
    location.reload()
  })
}
</script>

<style lang="scss" scoped>
.my {
  width: 100%;
  min-height: 100vh;
  .t {
    margin-top: 6vh;
    .pic {
      width: 34%;
      aspect-ratio: 1/1;
      border-radius: 50%;
      margin: 0 auto;
      overflow: hidden;
      border: 3px solid rgb(136, 0, 255);

      .p {
        width: 100%;
        height: 100%;
        object-fit: cover;
        border-radius: 50%;
        object-position: center;
      }
    }
    .name {
      margin-top: 3vh;
      text-align: center;
      font-size: 40px;
      color: rgb(49, 49, 54);
      font-weight: 600;
    }
  }
  .m {
    margin-top: 5vh;
  }
}
.li {
  width: 90%;
  margin: 0 auto;
  height: 50px;
  line-height: 50px;
  text-align: center;
  background-color: rgb(250, 250, 250);
  &:hover {
    background-color: rgb(149, 147, 147);
  }
}
.footer {
  position: fixed;
  bottom: 0;
  width: 100%;
}
</style>
