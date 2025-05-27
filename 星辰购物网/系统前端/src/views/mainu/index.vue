<template>
  <!-- <div class="active">成人服饰</div>
      <div class="active">儿童服饰</div>
      <div class="active">家居用品</div>
      <div class="active">数码产品</div>
      <div class="active">运动用品</div>
      <div class="active">枪支弹药</div>
      <div class="active">食品饮料</div>
      <div class="active">其他</div> -->
  <div class="shopping">
    <div class="tabs">
      <div
        class="tab"
        v-for="item in [
          '全部商品',
          '成人服饰',
          '儿童服饰',
          '家居用品',
          '数码产品',
          '运动用品',
          '枪支弹药',
          '食品饮料',
          '其他',
        ]"
        :key="item"
        @click="show(item)"
      >
        <div class="tab-item">{{ item }}</div>
      </div>
    </div>
  </div>
</template>
<script setup lang="ts" name="shop">
import { ref } from 'vue'
import Good from '../../components/good.vue'

const tab = ref('1')
const show = (item: string) => {
  tab.value = item
}
</script>

<style scoped lang="scss">
.shopping {
  width: 100%;
  height: 100%;
  .tabs {
    width: 100%;
    height: 6%;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    background-color: aliceblue;
    .tab {
      width: 11%;
      height: 100%;
      display: flex;
      justify-content: center;
      cursor: pointer;
      .tab-item {
        font-size: 16px;
        color: #333;
        font-weight: bold;
        padding: 5px 10px;
        border-radius: 5px;
        &:hover {
          background-color: #ddd;
        }
      }
    }
  }
}
</style>
