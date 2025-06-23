<template>
  <div class="my">
    <div class="t">
      <div class="pic"><img src="/src/pic/IMG_20250312_172314.jpg" alt="" class="p" /></div>
      <div class="name">karmen</div>
    </div>
    <div class="m">
      <div class="li">我的发帖</div>
    </div>
    <div class="b">
      <div class="li">关于网站</div>
      <div class="li" @click="our">联系我们</div>
    </div>
    <div class="footer">
      <Title></Title>
    </div>
  </div>
</template>

<script setup lang="ts" name="My">
import router from '../router/index'
import Title from '../components/title.vue'

const our = () => {
  router.push('/our')
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
}
.footer {
  position: fixed;
  bottom: 0;
  width: 100%;
}
</style>
