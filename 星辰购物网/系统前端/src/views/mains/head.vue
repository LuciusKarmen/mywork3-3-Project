<template>
  <div class="title">
    <div class="subtitle">xingcheng.com</div>
    <div class="search">
      <div>您的到来是我们最大的荣幸</div>
    </div>
    <div class="user">站长: Karmen-John-Lucius</div>
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
      <RouterLink to="/works/index" class="classify-item" active-class="active"
        >星辰介绍</RouterLink
      >
      <RouterLink to="/works/shop" class="classify-item" active-class="active">我的商店</RouterLink>
      <RouterLink to="/works/order" class="classify-item" active-class="active"
        >我的业务</RouterLink
      >
      <div class="classify-item" active-class="active" @click="toContact()">联系官方</div>
      <RouterLink to="/our" class="classify-item" active-class="active">关于我们</RouterLink>
    </div>
  </div>
  <div class="show">
    <router-view></router-view>
  </div>
</template>

<script lang="ts" setup name="Head">
import { RouterLink, useRouter, RouterView } from 'vue-router'
const router = useRouter()

//拨打电话
const toContact = () => {
  window.location.href = 'tel:16670870515'
}
</script>

<style scoped lang="scss">
.title {
  height: 7vh;
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
    margin-right: 20px;
    font-size: 16px;
    color: #333;
    font-weight: bold;
    background-color: rgba($color: #c8ff14, $alpha: 0.3);
    border: #00ffff;
    border-radius: 5px;
    padding: 5px 10px;
  }
}
.left {
  height: 93vh;
  width: 17%;
  background-color: #fa4646;
  position: absolute;
  top: 7vh;
  left: 0;

  .pic {
    width: 100%;
    height: 32%;

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
      height: 17vh;
      font-size: 18px;
      color: #fffdfd;
      text-decoration: none;
      background-color: #e600ff;
      cursor: pointer;
      &.active {
        color: #fc7b7b;
        border-bottom: 1px solid #fffdfd;
        background-color: #00ffff;
      }
    }
  }
}
.show {
  height: 93vh;
  width: 83%;
  position: absolute;
  top: 7vh;
  left: 17%;
}
</style>
