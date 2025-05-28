<template>
  <div class="good">
    <!-- 商品图片 -->
    <img :src="imagePath" alt="商品图片" class="good-image" />

    <!-- 商品信息 -->
    <div class="good-name">商品名称: {{ props.item?.goodname }}</div>
    <div class="good-price">商品价格: {{ props.item?.goodprice }}</div>
    <div class="good-desc">商品分类: {{ props.item?.goodclass }}</div>

    <!-- 加入购物车按钮 -->
    <div class="good-btn" @click="addToCart">加入购物车</div>

    <!-- 商品评分 -->
    <div class="good-rating">商品评分: ★★★★☆</div>
  </div>
</template>

<script lang="ts" setup name="Good">
import { defineProps, PropType, computed } from 'vue'
import { onMounted } from 'vue'

interface GoodItem {
  goodid: string
  goodshop: string
  goodpath: string
  goodname: string
  goodprice: string
  goodclass: string
}

const props = defineProps({
  item: {
    type: Object as PropType<GoodItem>,
    required: true,
  },
})

const imagePath = computed(() => {
  return `http://localhost:8080/${props.item.goodpath}`
})

onMounted(() => {
  console.log('item:', props.item)
})
</script>

<style scoped>
.good {
  border: 1px solid #ccc;
  padding: 16px;
  border-radius: 8px;
  width: 250px;
  text-align: center;
  margin: 10px;
  box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
}

.good-image {
  width: 100%;
  height: 180px;
  object-fit: cover;
  border-radius: 4px;
}

.good-name,
.good-price,
.good-desc,
.good-rating {
  margin-top: 8px;
  font-size: 14px;
}

.good-btn {
  margin-top: 12px;
  padding: 8px;
  background-color: #2196f3;
  color: white;
  border-radius: 4px;
  cursor: pointer;
}

.good-btn:hover {
  background-color: #1976d2;
}
</style>

<style scoped lang="scss">
.good {
  width: 160px;
  height: 250px;
  background-color: white;
  border-radius: 10px;
  margin: 10px;
  overflow: hidden;
  box-shadow: #ff5722 0px 4px 8px 0px;
  padding: 5px;

  .good-image {
    width: 100%;
    height: 110px;
    object-fit: cover;
    display: flex;
    justify-content: center;
    img {
      width: 100%;
      height: 100%;
      object-fit: cover;
      border-radius: 5px;
    }
  }
  .good-name {
    font-size: 16px;
    font-weight: bold;
    margin: 5px 0;
  }
  .good-price {
    font-size: 14px;
    color: red;
  }
  .good-sale {
    font-size: 12px;
    color: gray;
  }
  .good-desc {
    font-size: 12px;
    color: #666;
  }
  .good-info {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 5px;
  }
  .good-btn {
    background-color: #ff5722;
    margin-left: 15px;
    color: white;
    padding: 5px 10px;
    border-radius: 5px;
    width: 80%;
    text-align: center;
    // margin: auto;
    cursor: pointer;
    &:hover {
      background-color: #e64a19;
    }
  }
  .good-rating {
    font-size: 12px;
    color: #ff9800;
    margin-top: 5px;
  }
}
</style>
