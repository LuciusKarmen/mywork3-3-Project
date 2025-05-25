<template>
  <div>
    <div class="good">
      <img src="https://picsum.photos/200/300" alt="" />
      <div class="good-name">商品名称</div>
      <div class="good-price">商品价格</div>
      <div class="good-desc">商品分类</div>
      <div class="good-btn">加入购物车</div>
      <div class="good-rating">商品评分: ★★★★☆</div>
    </div>
  </div>
</template>

<script lang="ts" setup name="Good">
import { defineComponent } from 'vue'
</script>

<style scoped lang="scss">
.good {
  width: 160px;
  height: 250px;
  background-color: white;
  border-radius: 10px;
  margin: 10px;
  overflow: hidden;
  img {
    width: 90%;
    margin: auto;
    height: 100px;
    object-fit: cover;
  }
  .good-name {
    font-size: 16px;
    font-weight: bold;
    margin: 5px 0;
  }
  .good-price {
    font-size: 14px;
    color: red;
  }
  .good-sale {
    font-size: 12px;
    color: gray;
  }
  .good-desc {
    font-size: 12px;
    color: #666;
  }
  .good-info {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 5px;
  }
  .good-btn {
    background-color: #ff5722;
    color: white;
    padding: 5px 10px;
    border-radius: 5px;
    width: 80%;
    text-align: center;
    // margin: auto;
    cursor: pointer;
    &:hover {
      background-color: #e64a19;
    }
  }
  .good-rating {
    font-size: 12px;
    color: #ff9800;
    margin-top: 5px;
  }
}
</style>
