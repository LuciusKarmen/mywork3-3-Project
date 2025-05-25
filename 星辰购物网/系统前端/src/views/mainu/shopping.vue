<template>
  <div class="shopping-container">
    <div class="header">
      <div class="active">成人服饰</div>
      <div class="active">儿童服饰</div>
      <div class="active">家居用品</div>
      <div class="active">数码产品</div>
      <div class="active">运动用品</div>
      <div class="active">枪支弹药</div>
      <div class="active">食品饮料</div>
      <div class="active">其他</div>
    </div>
    <div class="content">
      <n-scrollbar class="scrollbar">
        <div class="good-list">
          <Good v-for="item in 15" :key="item" class="good" />
        </div>
      </n-scrollbar>
    </div>
  </div>
</template>

<script setup lang="ts" name="Shopping">
import { ref } from 'vue'
import Good from '../../components/good.vue'

const activeTab = ref('成人服饰')
</script>

<style scoped lang="scss">
.shopping-container {
  height: 93vh;
  width: 83%;
  position: absolute;
  top: 7vh;
  left: 17%;

  .header {
    height: 5vh;
    width: 100%;
    background-color: #f0f0f0;
    position: absolute;
    top: 0;
    left: 0;
    display: flex;
    justify-content: space-around;
    align-items: center;
    .active {
      width: 10%;
      height: 70%;
      display: flex;
      justify-content: center;
      align-items: center;
      font-size: 15px;
      color: #000;
      cursor: pointer;
      &:hover {
        text-decoration: underline;
        color: #ff1919;
        background-color: #cfcdcd;
        border-radius: 5px;
        transition: background-color 0.3s ease;
      }
    }
  }
  .content {
    margin-top: 5vh;
    height: 88vh;
    width: 100%;

    .scrollbar {
      height: 100%;
      width: 100%;
      padding: 20px;
      .good-list {
        display: grid;
        grid-template-columns: repeat(5, 1fr);
        grid-template-rows: repeat(3, 1fr);
        gap: 10px;
      }
    }
  }
}
</style>
