<template>
  <div class="title">
    <div class="logo"><img src="../pic/KK.png" alt="图片" /></div>
    <div class="search">
      <Search class="iconfont"></Search>
      <input type="text" placeholder="搜索" class="search2" />
    </div>
    <div class="pic">
      <HorizontalN class="iconfont3"></HorizontalN>
    </div>
  </div>
</template>

<script setup lang="ts" name="Title">
import { indexOf } from 'lodash'
import { Search, HorizontalN, Right } from '@nutui/icons-vue'
</script>

<style lang="scss" scoped>
.title {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 1000;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 1% 5%;
  background-color: rgb(208, 208, 208);
  height: 6vh;
  border-bottom: 2px solid paleturquoise;
  margin-bottom: 1vh;
  .logo {
    width: 4%;
    height: 5vh;
    img {
      width: 100%;
      height: 100%;
      border-radius: 30%;
    }
  }
  .search {
    .search2 {
      width: 100%;
      height: 5vh;
      background-color: rgb(255, 255, 255);
      border-radius: 20px;
      border: 2px solid paleturquoise;
      padding-left: 10px;
      font-size: 1.2rem;
    }
    .iconfont {
      position: absolute;
      left: 28%;
      top: 50%;
      transform: translateY(-50%);
      font-size: 1.5rem;
      color: #7d7e80;
    }
    .iconfont2 {
    }
    width: 50%;
    height: 5vh;
    position: relative;
  }
  .pic {
    background-color: rgb(255, 255, 255);
    width: 5%;
    padding: 5px;
    border-radius: 10%;
    &:hover {
      background-color: rgb(123, 123, 123);
    }
    text-align: center;
  }
}
@media (max-width: 768px) {
  .title {
    height: 7vh;
    .logo {
      width: 12%;
      height: 5vh;
      img {
        width: 100%;
        height: 100%;
        border-radius: 30%;
      }
    }
    .pic {
      background-color: rgb(255, 255, 255);
      width: 10%;
      padding: 4px;
      border-radius: 10%;
      &:hover {
        background-color: rgb(123, 123, 123);
      }
      text-align: center;
    }
  }
}
</style>
