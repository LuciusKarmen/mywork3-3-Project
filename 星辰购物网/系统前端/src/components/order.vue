<template>
  <div class="order-card">
    <div class="order-header">
      <div class="order-shop">厂商：{{ props.item?.ordershop }}</div>
      <div class="order-id">订单号：{{ props.item?.orderid }}</div>
    </div>
    <div class="order-content">
      <div class="order-name">商品名称：{{ props.item?.ordername }}</div>
      <div class="order-number">商品个数：{{ props.item?.ordernumber }}</div>
    </div>
    <div class="order-state">
      <div>
        是否发货：<span class="status-tag success">{{ props.item?.orderSend }}</span>
      </div>
      <div>
        是否收货：<span class="status-tag warning">{{ props.item?.orderOk }}</span>
      </div>
    </div>
    <div class="order-actions">
      <n-button type="info" size="small" v-if="!v2" @click="handleBuy">确认购买</n-button>
      <n-button type="primary" size="small" v-if="!v4" @click="handleSend">确认收货</n-button>
      <n-popconfirm :show-icon="false">
        <template #trigger>
          <n-button type="warning" size="small">评价商品</n-button>
        </template>
        <n-rate />
      </n-popconfirm>
    </div>
  </div>
</template>

<script setup lang="ts" name="Order">
import { ref } from 'vue'
import { Ordertype } from '../type/order'
import axios from 'axios'
const order = ref<Ordertype>({
  orderid: '',
  orderuser: '',
  ordershop: '',
  ordername: '',
  ordernumber: 0,
  orderCar: false,
  orderBuy: false,
  orderSend: false,
  orderOk: false,
})

const props = defineProps<{
  item: Ordertype
}>()
const v1 = ref(props.item?.orderCar)
const v2 = ref(props.item?.orderBuy)
const v3 = ref(props.item?.orderSend)
const v4 = ref(props.item?.orderOk)
const id = ref(props.item?.orderid)

//更新数据(这倒是第一次)
const handleBuy = () => {
  v2.value = !v2.value
  axios
    .post(
      '/api/order/update',
      {
        orderCar: v1.value,
        orderBuy: v2.value,
        orderSend: v3.value,
        orderOk: v4.value,
        orderid: id.value,
      },
      {
        headers: { 'Content-Type': 'application/json' },
      },
    )
    .then((res) => {
      if (res.data === 'success') {
        alert('下单成功')
        axios.post('/api/order/showorder').then((res) => {
          console.log(res.data)
          order.value = res.data
        })
      } else {
        alert('下单失败')
      }
    })
}
const handleSend = () => {
  v4.value = !v4.value
  axios
    .post(
      '/api/order/update',
      {
        orderCar: v1.value,
        orderBuy: v2.value,
        orderSend: v3.value,
        orderOk: v4.value,
        orderid: id.value,
      },
      {
        headers: {
          'Content-Type': 'application/json',
        },
      },
    )
    .then((res) => {
      if (res.data === 'success') {
        alert('收货成功')
        axios.post('/api/order/showorder').then((res) => {
          order.value = res.data
        })
      }
    })
}
</script>

<style scoped lang="scss">
.order-card {
  font-size: 16px;
  background-color: #f9f9f9;
  color: #333;
  width: 700px;
  height: auto;
  min-height: 200px;
  border-radius: 12px;
  padding: 20px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
  margin: 20px auto;
  transition: all 0.3s ease;

  &:hover {
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
  }

  .order-header,
  .order-content,
  .order-state {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 12px;
  }

  .order-shop,
  .order-id,
  .order-name,
  .order-number {
    font-weight: bold;
    color: #555;
  }

  .order-state {
    font-size: 14px;

    .status-tag {
      margin-left: 8px;
      padding: 2px 8px;
      border-radius: 4px;
      font-weight: bold;
      text-transform: uppercase;
      font-size: 12px;
    }

    .success {
      background-color: #d4edda;
      color: #155724;
    }

    .warning {
      background-color: #fff3cd;
      color: #856404;
    }
  }

  .order-actions {
    display: flex;
    gap: 12px;
    justify-content: flex-end;
    margin-top: 20px;
  }
}
</style>
