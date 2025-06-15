<template>
  <div class="shopping">
    <div class="tabs">
      <div
        v-for="(category, index) in categories"
        :key="index"
        class="tab"
        :class="{ active: tab === category }"
        @click="setActiveCategory(category)"
      >
        {{ category }}
      </div>
    </div>

    <div class="show">
      <n-scrollbar class="scroll">
        <div class="kuang">
          <div v-for="item in changeshow" :key="item.goodid" class="good-item">
            <Good :item="item" />
          </div>
        </div>
        <footer>
          <div class="footer-content">
            <p>&copy; 2025 许光明拥有购物网站. 保留所有权利.</p>
          </div>
        </footer>
      </n-scrollbar>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, computed, onMounted } from 'vue'
import Good from '../../components/good.vue'
import axios from 'axios'

const goods = ref([])
const item = ref({
  goodid: '',
  goodshop: '',
  goodpath: '',
  goodname: '',
  goodprice: '',
  goodclass: '',
})

const tab = ref('')

const setActiveCategory = (category: string) => {
  tab.value = category
}

const categories = [
  '全部商品',
  '成人服饰',
  '儿童服饰',
  '家居用品',
  '数码产品',
  '运动用品',
  '枪支弹药',
  '食品饮料',
  '其他',
]

const changeshow = computed(() => {
  if (!goods.value || goods.value.length === 0) return []
  if (!tab.value || tab.value === '全部商品') {
    return goods.value
  }
  return goods.value.filter((item) => item.goodclass === tab.value)
})

onMounted(() => {
  axios.post('/api/good/showgood').then((res) => {
    goods.value = res.data
    console.log('获取到的商品数据：', goods.value)
  })
})
</script>

<style scoped lang="scss">
.shopping {
  width: 100%;
  height: 100%;

  .tabs {
    width: 100%;
    height: 6%;
    display: flex;
    flex-wrap: wrap;
    justify-content: space-around;
    background-color: aliceblue;

    .tab {
      width: 11%;
      height: 100%;
      display: flex;
      justify-content: center;
      align-items: center;
      cursor: pointer;
      transition: all 0.3s ease;

      &.active {
        color: #fa5353;
        background-color: #fff;
        border-bottom: 2px solid #fa5353;
      }

      &:hover {
        background-color: #f0f0f0;
      }
    }
  }

  .show {
    width: 100%;
    height: 94%;

    .scroll {
      width: 100%;
      height: 100%;
      overflow-y: auto;

      .kuang {
        display: grid;
        grid-template-columns: repeat(5, 1fr);
        grid-gap: 10px;
        padding: 10px;
      }
    }
  }
}
</style>
