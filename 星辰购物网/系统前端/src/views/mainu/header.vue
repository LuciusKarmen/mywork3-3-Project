<template>
  <div class="title">
    <div class="subtitle">xingcheng.com</div>
    <div class="search">
      <input placeholder="搜索" class="search-input" />
    </div>
    <div class="user">
      <img src="../../pic/购物车.png" alt="" />
    </div>
  </div>
  <div class="left">
    <div class="pic">
      <n-carousel autoplay>
        <img
          class="carousel-img"
          src="https://naive-ui.oss-cn-beijing.aliyuncs.com/carousel-img/carousel1.jpeg"
        />
        <img
          class="carousel-img"
          src="https://naive-ui.oss-cn-beijing.aliyuncs.com/carousel-img/carousel2.jpeg"
        />
        <img
          class="carousel-img"
          src="https://naive-ui.oss-cn-beijing.aliyuncs.com/carousel-img/carousel3.jpeg"
        />
        <img
          class="carousel-img"
          src="https://naive-ui.oss-cn-beijing.aliyuncs.com/carousel-img/carousel4.jpeg"
        />
      </n-carousel>
    </div>
    <div class="classify">
      <div class="classify-item">星辰商城</div>
      <div class="classify-item">待发货订单</div>
      <div class="classify-item">待收货订单</div>
      <div class="classify-item">已完成订单</div>
      <div class="classify-item" @click="toAbout()">联系我们</div>
    </div>
  </div>
</template>

<script lang="ts" setup name="Header">
import { useRouter } from 'vue-router'
const router = useRouter()
const toAbout = () => {
  router.push('/our')
}
</script>

<style scoped lang="scss">
.title {
  height: 7%;
  width: 100%;
  font-size: 30px;
  font-weight: bold;
  color: #fa4646;
  background-color: pink;
  display: flex;
  justify-content: space-between;
  align-items: center;
  .subtitle {
    margin-left: 20px;
  }
  .search {
    margin-right: 20px;
    margin-top: -5px;
    .search-input {
      font-size: 15px;
      width: 400px;
      height: 30px;
      border-radius: 15px;
      border: 1px solid #fffdfd;
      padding-left: 10px;
      background: rgba($color: #fc7b7b, $alpha: 0.3);
      margin-top: -5px;
    }
  }
  .user {
    margin-top: 3px;
    margin-right: 20px;
    img {
      width: 30px;
      height: 30px;
    }
  }
}
.left {
  height: 93vh;
  width: 17%;

  background-color: #fa4646;

  .pic {
    width: 100%;
    height: 30%;

    .carousel-img {
      width: 100%;
      height: 100%;
      border-radius: 5px;
      border: 1px solid #fa4646;
    }
  }
  .classify {
    width: 100%;
    height: 68%;
    background-color: #fa4646;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    .classify-item {
      display: flex;
      align-items: center;
      justify-content: center;
      width: 100%;
      height: 20%;
      font-size: 18px;
      color: #fffdfd;
      border-bottom: 1px solid #fffdfd;
      background-color: #e600ff;
      cursor: pointer;
      &:hover {
        color: #fc7b7b;
        text-decoration: none;
        background-color: #00ffff;
      }
    }
  }
}
</style>
