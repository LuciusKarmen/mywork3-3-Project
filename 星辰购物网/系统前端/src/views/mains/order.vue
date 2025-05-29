<template>
  <n-scrollbar>
    <div>待处理订单</div>
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
import { Ordertype } from '../../type/order'
import Order from '../../components/order.vue'

const orderList = ref<Ordertype[]>([])

const fetchData = () => {
  axios.post('/api/order/showorder').then((res) => {
    orderList.value = res.data
  })
}

const filter = computed(() => {
  return orderList.value.filter((item) => !item.orderSend && item.orderBuy && item.orderCar)
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
</style>
