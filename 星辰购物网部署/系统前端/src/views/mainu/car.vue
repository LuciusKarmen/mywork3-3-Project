<template>
  <n-scrollbar class="scroll">
    <div class="aa">
      <h1 class="fancy-heading">专属于您的购物车车</h1>
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
import { type Ordertype } from '../../type/order'
import { ref, onMounted, computed } from 'vue'
import axios from 'axios'
const username = ref<string | null>(localStorage.getItem('username'))

const item = ref([
  {
    orderid: '',
    orderuser: '',
    ordershop: '',
    ordername: username.value ?? '',
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
  return item.value.filter(
    (item: any) =>
      item.orderCar === true && item.orderBuy == false && item.orderuser == username.value,
  )
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
.fancy-heading {
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  font-size: 3.5rem;
  background: linear-gradient(45deg, #ff758c, #ff7eb3);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  text-align: center;
  margin: 2rem 0;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.1);
  transition:
    transform 0.3s ease,
    color 0.3s ease;
}

.fancy-heading:hover {
  transform: scale(1.05);
}
</style>
