<template>
  <div class="order-card">
    <div class="order-header">
      <div class="order-shop">厂商：{{ props.order.ordershop }}</div>
      <div class="order-id">订单号：{{ props.order.orderid }}</div>
    </div>
    <div class="order-content">
      <div class="order-name">商品名称：{{ props.order.ordername }}</div>
      <div class="order-number">商品个数：{{ props.order.ordernumber }}</div>
    </div>
    <div class="order-state">
      <div>
        是否发货：<span class="status-tag success">{{ props.order.orderSend }}</span>
      </div>
      <div>
        是否收货：<span class="status-tag warning">{{ props.order.orderOk }}</span>
      </div>
    </div>
    <div class="order-actions">
      <n-button type="primary" size="small">确认收货</n-button>
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
import { Order } from '../type/order'
const order = ref<Order>({
  orderid: '',
  orderuser: '',
  ordershop: '',
  ordername: '',
  ordernumber: 0,
  orderCar: false,
  orderSend: false,
  orderOk: false,
})

const props = defineProps<{
  order: Order
}>()
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
