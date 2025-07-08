<template>
  <div class="title">
    <div class="logo"><img src="../pic/KK.png" alt="图片" /></div>
    <div class="search">
      <Search class="iconfont"></Search>
      <input type="text" placeholder="搜索" class="search2" />
    </div>
    <div class="pic">
      <HorizontalN class="iconfont3" @click="menu"></HorizontalN>
    </div>
    <div class="menu" v-show="ok1">
      <h1>选择主题</h1>
      <div class="menu1" v-for="(item, index) in classify" :key="index">
        <div class="menu2" @click="ok1 = false">
          <span>{{ item }}</span>
          <Right class="iconfont2"></Right>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts" name="title">
import { indexOf } from 'lodash'
import { Search, HorizontalN, Right } from '@nutui/icons-vue'
import { ref, computed } from 'vue'

const menu = () => {
  ok1.value = !ok1.value
}
const classify = ref([
  '全部',
  '学习',
  '编程',
  '生活',
  '端游',
  '手游',
  '动漫',
  '影视',
  '音乐',
  '文学',
  '科技',
  '体育',
  '美食',
  '旅游',
])

const ok1 = ref(true)
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
      right: 10px;
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
  .menu {
    position: absolute;
    top: 6vh;
    right: 0%;
    width: 22%;
    height: 50vh;
    overflow-y: scroll;
    background-color: rgb(255, 255, 255);
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    z-index: 1001;
    h1 {
      text-align: center;
      font-size: 1.2rem;
      color: #333;
      margin-bottom: 10px;
    }
    .menu1 {
      padding: 5px;
      .menu2 {
        display: flex;
        justify-content: space-between;
        padding: 5px;
        cursor: pointer;
        border-bottom: 2px solid #c2c2c2;
        &:hover {
          background-color: #f0f0f0;
        }
        span {
          font-size: 1rem;
          color: #555;
        }
      }
    }
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
