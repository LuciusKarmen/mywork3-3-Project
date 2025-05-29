<template>
  <n-scrollbar class="scroll">
    <div class="aa">
      <n-tag :bordered="false" type="success" class="tag custom-shopping-cart-title"> 购物车</n-tag>
      <div class="kuang">
        <div v-for="item in filterCar" :key="item.orderid" class="myorder-item">
          <Order :item="item" />
        </div>
      </div>
    </div>
  </n-scrollbar>
</template>

<script setup lang="ts" name="Car">
import Order from '../../components/order.vue'
import { Ordertype } from '../../type/order'
import { ref, onMounted, computed } from 'vue'
import axios from 'axios'
const item = ref<Ordertype[]>([
  {
    orderid: '',
    orderuser: '',
    ordershop: '',
    ordername: '',
    ordernumber: 0,
    orderCar: false,
    orderBuy: false,
    orderSend: false,
    orderOk: false,
  },
])

axios.post('/api/order/showorder').then((res) => {
  item.value = res.data
})

const fetchData = () => {
  axios.post('/api/order/showorder').then((res) => {
    item.value = res.data
  })
}
const filterCar = computed(() => {
  console.log(item.value)
  return item.value.filter((item: any) => item.orderCar === true && item.orderBuy == false)
})
onMounted(() => {
  fetchData()
  setInterval(fetchData, 5000)
})
</script>

<style scoped lang="scss">
.custom-shopping-cart-title {
  height: 100px;
  margin-left: 50px;
  font-size: 100px;
  font-weight: bold;
  color: #ffffff;
  background-color: #ff6347;
  padding: 8px 16px;
  border-radius: 4px;
  box-shadow:
    0 4px 6px rgba(50, 50, 93, 0.11),
    0 1px 3px rgba(0, 0, 0, 0.08);

  margin-bottom: 20px;
}
.myorder-item {
  margin-left: -400px;
}
</style>
