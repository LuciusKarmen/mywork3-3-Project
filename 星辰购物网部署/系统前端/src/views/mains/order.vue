<template>
  <n-scrollbar>
    <div class="fancy-heading">待处理订单</div>
    <div v-for="item in filter" :key="item.orderid">
      <Order :item="item" />
      <div class="btn">
        <n-button type="error" class="btnok" @click="Send(item)">确认发货</n-button>
      </div>
      <hr />
    </div>
  </n-scrollbar>
</template>

<script setup lang="ts">
import { ref, onMounted, computed } from 'vue'
import axios from 'axios'
import { type Ordertype } from '../../type/order'
import Order from '../../components/order.vue'

const orderList = ref<Ordertype[]>([])

const fetchData = () => {
  axios.post('/api/order/showorder').then((res) => {
    orderList.value = res.data
  })
}
const shopname = ref<String | null>('')
shopname.value = localStorage.getItem('shopname')

const filter = computed(() => {
  return orderList.value.filter(
    (item) => !item.orderSend && item.orderBuy && item.orderCar && item.ordershop == shopname.value,
  )
})

const Send = (clickedItem: Ordertype) => {
  const updatedData = {
    ...clickedItem,
    orderSend: true,
  } //这个拓展运算符（...）记得一直使用

  axios
    .post('/api/order/send', updatedData, {
      headers: {
        'Content-Type': 'application/json',
      },
    })
    .then((res) => {
      console.log('发货成功:', res.data)
      fetchData()
    })
    .catch((err) => {
      console.error('发货失败:', err)
      alert('发货失败，请检查网络或联系管理员')
    })
}

onMounted(() => {
  fetchData()
})
</script>

<style scoped lang="scss">
.btnok {
  margin-bottom: 30px;
  margin-left: 350px;
  width: 200px;
  height: 50px;
}
.fancy-heading {
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  font-size: 3rem;
  background: linear-gradient(45deg, #ff0dbe, #ff7eb3);
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
