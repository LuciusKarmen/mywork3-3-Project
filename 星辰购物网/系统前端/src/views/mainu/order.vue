<template>
  <n-scrollbar>
    <div class="my-order">
      <div class="aa">
        <n-tag :bordered="false" type="info" class="tag"> 待发货 </n-tag>
        <div class="kuang">
          <div v-for="item in filterwaitsend" :key="item.orderid" class="myorder-item">
            <Order :item="item" />
          </div>
        </div>
      </div>
      <div class="aa">
        <n-tag :bordered="false" type="warning" class="tag"> 待收货 </n-tag>
        <div class="kuang">
          <div v-for="item in filtersendwaitget" :key="item.orderid" class="myorder-item">
            <Order :item="item" />
          </div>
        </div>
      </div>
      <div class="aa">
        <n-tag :bordered="false" type="success" class="tag"> 已收货 </n-tag>
        <div class="kuang">
          <div v-for="item in filterget" :key="item.orderid" class="myorder-item">
            <Order :item="item" />
          </div>
        </div>
      </div>
    </div>
  </n-scrollbar>
</template>

<script setup lang="ts" name="order">
import axios from 'axios'
import Order from '../../components/order.vue'

import { NScrollbar } from 'naive-ui'
import { reactive, ref, computed, onMounted } from 'vue'
import { Ordertype } from '../../type/order'

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
onMounted(() => {
  axios.post('/api/order/showorder').then((res) => {
    item.value = res.data
    console.log('获取到的订单数据：', item.value)
  })
})

const username = ref<String | null>('')
username.value = localStorage.getItem('username')

const filterwaitsend = computed(() => {
  return item.value.filter(
    (item: any) =>
      !item.orderSend &&
      !item.orderOk &&
      item.orderCar &&
      item.orderBuy &&
      item.orderuser == username.value,
  )
})
const filtersendwaitget = computed(() => {
  return item.value.filter(
    (item: any) =>
      item.orderSend &&
      !item.orderOk &&
      item.orderCar &&
      item.orderBuy &&
      item.orderuser == username.value,
  )
})
const filterget = computed(() => {
  return item.value.filter(
    (item: any) =>
      item.orderSend &&
      item.orderOk &&
      item.orderCar &&
      item.orderBuy &&
      item.orderuser == username.value,
  )
})
const fetchData = () => {
  axios.post('/api/order/showorder').then((res) => {
    item.value = res.data
  })
}
onMounted(() => {
  fetchData()
  setInterval(() => {
    fetchData()
  }, 5000)
})
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
