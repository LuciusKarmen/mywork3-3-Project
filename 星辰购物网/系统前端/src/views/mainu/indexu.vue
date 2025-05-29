<template>
  <div class="shopping">
    <div class="tabs">
      <div
        class="tab"
        v-for="item in [
          '全部商品',
          '成人服饰',
          '儿童服饰',
          '家居用品',
          '数码产品',
          '运动用品',
          '枪支弹药',
          '食品饮料',
          '其他',
        ]"
        :key="item"
        @click="show(item)"
      >
        <div class="tab-item">{{ item }}</div>
      </div>
    </div>
    <div class="show">
      <n-scrollbar class="scroll">
        <div class="kuang">
          <div v-for="item in goods" :key="item.id" class="good-item">
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
<script setup lang="ts" name="shop">
import { ref } from 'vue'
import Good from '../../components/good.vue'
import axios from 'axios'

const tab = ref('')
const show = (item: string) => {
  tab.value = item
}
const goods = ref([{ id: '', shop: '', path: '', name: '', price: '', class: '' }])
axios.post('/api/good/showgood').then((res) => {
  goods.value = res.data
  console.log(goods.value)
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
      cursor: pointer;
      .tab-item {
        font-size: 16px;
        color: #333;
        font-weight: bold;
        padding: 5px 10px;
        border-radius: 5px;
        &:hover {
          background-color: #ddd;
          color: #000;
          transition: all 0.5s;
        }
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
        grid-template-rows: repeat(3, 1fr);
        grid-gap: 10px;
      }
    }
  }
}
</style>
