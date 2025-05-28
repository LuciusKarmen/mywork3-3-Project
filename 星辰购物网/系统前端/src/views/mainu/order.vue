<template>
  <div class="my-order">
    <n-scrollbar class="scroll">
      <div class="aa">
        <n-tag :bordered="false" type="info" class="tag"> 待发货 </n-tag>
        <div class="kuang">
          <div v-for="item in 3" :key="item" class="myorder-item">
            <Order />
          </div>
        </div>
      </div>
      <div class="aa">
        <n-tag :bordered="false" type="warning" class="tag"> 待收货 </n-tag>
        <div class="kuang">
          <div v-for="item in 3" :key="item" class="myorder-item">
            <Order />
          </div>
        </div>
      </div>
      <div class="aa">
        <n-tag :bordered="false" type="success" class="tag"> 已收货 </n-tag>
        <div class="kuang">
          <div v-for="item in 3" :key="item" class="myorder-item">
            <Order />
          </div>
        </div>
      </div>
    </n-scrollbar>
  </div>
</template>

<script setup lang="ts" name="order">
import Order from '../../components/order.vue'
import { NScrollbar } from 'naive-ui'
import { reactive, ref } from 'vue'

const orderList = reactive([
  { id: 1, status: '待发货' },
  { id: 2, status: '待收货' },
  { id: 3, status: '已收货' },
])
</script>

<style scoped lang="scss">
.my-order {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  .scroll {
    width: 100%;
    height: 100%;
    overflow-y: auto;
    .aa {
      .tag {
        margin-left: 10px;
        margin-top: 10px;
        font-size: 30px;
      }
      .kuang {
        padding: 10px;
        border-radius: 4px;
        margin-bottom: 10px;
        display: flex;
        flex-wrap: wrap;
        .myorder-item {
          margin-bottom: 10px;
        }
      }
    }
  }
}
</style>
