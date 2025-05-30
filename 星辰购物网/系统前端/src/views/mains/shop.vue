<template>
  <n-scrollbar>
    <div class="shop">欢迎来到你的商店，今天也要财源广进嗷</div>
    <div class="add-product-form">
      <div class="title">上架货品</div>
      <div class="add-product">
        <label for="product">商品名称：</label
        ><n-input id="product" placeholder="请输入货品名称" class="add" v-model:value="form.name" />
      </div>

      <div class="add-product">
        <label for="product">商品价格：</label
        ><n-input
          id="product"
          placeholder="请输入货品价格"
          class="add"
          v-model:value="form.price"
        />
      </div>

      <div class="add-product">
        <label for="product">商品分类：</label
        ><n-input
          id="product"
          placeholder="请输入货品分类"
          class="add"
          v-model:value="form.class"
        />
      </div>

      <div class="add-product">
        <label for="product">店铺名称：</label
        ><n-input id="product" placeholder="请输入店铺名称" class="add" v-model:value="form.shop" />
      </div>
      <div class="add-product">
        <div>选择照片</div>
        <div>
          <input type="file" class="add" @change="handleFileChange" />
        </div>
      </div>

      <div class="bto">
        <n-button class="submit-button" type="primary" @click="handleSubmit">提交</n-button>
        <n-button class="submit-button" type="warning" @click="handleReset">清空</n-button>
      </div>
    </div>
    <div class="shop">货品列表</div>
    <div class="kuang">
      <div v-for="item in filteredGoods" :key="item.goodid" class="good-item">
        <Good :item="item" />
        <n-button type="warning" @click="deletegood(item.goodid)">下架该商品</n-button>
      </div>
    </div>
  </n-scrollbar>
</template>

<script setup lang="ts">
import { reactive, ref, computed } from 'vue'
import axios from 'axios'
import Good from '../../components/good.vue'
import { id } from 'element-plus/es/locales.mjs'

// 定义商品类型
interface GoodItem {
  goodid: string
  goodname: string
  goodprice: string
  goodclass: string
  goodshop: string
  goodpath?: string
}

const form = reactive({
  name: '',
  price: '',
  class: '',
  shop: '',
  id: '',
})

const goodfile = ref<File | null>(null)

const handleFileChange = (event: Event) => {
  const target = event.target as HTMLInputElement
  if (target.files && target.files.length > 0) {
    goodfile.value = target.files[0] || null
  } else {
    goodfile.value = null
  }
}

const shopname = ref<String | null>('')
shopname.value = localStorage.getItem('shopname')
const handleSubmit = () => {
  const formData = new FormData()
  form.id = crypto.randomUUID()
  formData.append('goodid', form.id)
  formData.append('goodname', form.name)
  formData.append('goodprice', form.price)
  formData.append('goodclass', form.class)
  if (goodfile.value) {
    formData.append('goodpath', goodfile.value)
  }
  formData.append('goodshop', form.shop)
  axios
    .post('/api/good/add', formData, {
      headers: {
        'Content-Type': 'multipart/form-data',
      },
    })
    .then((response) => {
      if (response.data === 'success') {
        alert('提交成功')
        axios.post('/api/good/showgood').then((res) => {
          goods.value = res.data
        })
        handleReset()
      } else {
        alert('提交失败: ' + response.data.message)
      }
    })
    .catch((error) => {
      if (error.response) {
        console.error('Server responded with 400:', error.response.data)
      } else if (error.request) {
        console.error('No response received:', error.request)
      } else {
        console.error('Error:', error.message)
      }
    })
}

const handleReset = () => {
  form.name = ''
  form.price = ''
  form.class = ''
  form.shop = ''
  form.id = ''
  goodfile.value = null
  console.log('重置表单')
}

const goods = ref<GoodItem[]>([])
axios.post('/api/good/showgood').then((res) => {
  goods.value = res.data
  console.log(goods.value)
})

const deletegood = (id: string) => {
  console.log(id)
  axios
    .post(
      '/api/good/delete',
      { goodid: id },
      {
        headers: {
          'Content-Type': 'application/json',
        },
      },
    )
    .then((res) => {
      console.log(res.data)
      if (res.data == 'success') {
        alert('下架成功')
        axios.post('/api/good/showgood').then((res) => {
          goods.value = res.data
        })
      } else {
        alert('删除失败')
      }
    })
}

//这边搞一个过滤器
const filteredGoods = computed(() => {
  return goods.value.filter((item) => item.goodshop == shopname.value)
})
</script>

<style scoped lang="scss">
.add-product-form {
  display: flex;
  flex-direction: column;
  width: 500px;
  height: 600px;
  margin: 20px auto;
  margin-left: 350px;
  padding: 40px;
  margin-bottom: 50px;
  background-color: rgba($color: #41ecff, $alpha: 0.5);
  border-radius: 20px;
  border: 3px solid #ffffff;
  .title {
    font-size: 30px;
    font-weight: bold;
    color: #333;
    margin-bottom: 20px;
  }
  .add-product {
    display: flex;
    flex-direction: row;
    margin-bottom: 20px;
    background-color: rgba($color: #ffffff, $alpha: 0.5);
    padding: 10px;
    border-radius: 10px;
    .add {
      width: 300px;
      height: 30px;
      margin-left: 20px;
    }
  }
  .bto {
    display: flex;
    flex-direction: row;
    justify-content: space-around;
    margin-top: 20px;
    .submit-button {
      width: 100px;
      height: 40px;
    }
  }
}
.shop {
  display: flex;
  flex-direction: row;
  justify-content: center;
  font-family: 'Courier New', Courier, monospace;
  font-size: 30px;
  color: #f732cc;
  padding: 10px;
  background-color: rgba($color: #23ffff, $alpha: 0.4);
  border-radius: 20px;
  width: 700px;
  margin-left: 150px;
}
.kuang {
  width: 100%;
  display: grid;
  grid-template-columns: repeat(5, 1fr);
  .good-item {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    padding: 10px;
  }
}
</style>
