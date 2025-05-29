<template>
  <div class="my-order">
    <n-scrollbar class="scroll">
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
    </n-scrollbar>
  </div>
</template>

<script setup lang="ts" name="order">
import axios from 'axios'
import Order from '../../components/order.vue'
import { Order } from '../../type/order'
import { NScrollbar } from 'naive-ui'
import { reactive, ref, computed } from 'vue'

const orders = reactive<Order>({
  orderid: '',
  orderuser: '',
  ordershop: '',
  ordername: '',
  ordernumber: 0,
  orderCar: false,
  orderSend: false,
  orderOk: false,
})
const item = ref([
  {
    orderid: '',
    orderuser: '',
    ordershop: '',
    ordername: '',
    ordernumber: 0,
    orderCar: false,
    orderSend: false,
    orderOk: false,
  },
])
axios.post('/api/order/showorder').then((res) => {
  console.log(res.data)
  orders.value = res.data
})

const filterwaitsend = computed(() => {
  return orders.value.filter((item: any) => item.orderSend == true)
})
const filtersendwaitget = computed(() => {
  return orders.value.filter((item: any) => item.orderSend == false)
})
const filterget = computed(() => {
  return orders.value.filter((item: any) => item.orderSend == false)
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
