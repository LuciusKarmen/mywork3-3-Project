<template>
  <div class="search-container">
    <input type="text" v-model="searchQuery" :placeholder="placeholderText" class="search-input" />
    <div class="eye">
      <img src="../assets/搜索.png" alt="" />
    </div>
    <div class="add">
      <img src="../assets/圆添加.png" alt="" />
    </div>
  </div>
</template>
<script lang="ts" setup name="SearchInput">
import { ref } from 'vue'
import { DefineProps } from 'vue'
// import { useRouter } from 'vue-router'
// const router = useRouter()
const searchQuery = ref('')

const placeholderText = ref('寻找那个合适的TA')
</script>
<style lang="scss" scoped>
.search-container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 6vh;
  background-color: #f0f0f0;
  width: 100%;
  .search-input {
    width: 70%;
    height: 80%;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 12px;
    outline: none;
    transition: border-color 0.3s ease;
    position: relative;
    &:focus {
      border-color: #007bff;
      box-shadow: 0 0 5px rgba(0, 123, 255, 0.5);
      outline: none;
      transition: border-color 0.3s ease;
      background-color: #eff6f8;
    }
  }
  .eye {
    width: 20px;
    height: 20px;
    position: absolute;
    right: 22%;
    img {
      width: 100%;
      height: 100%;
    }
  }
  .add {
    width: 20px;
    height: 20px;
    margin-left: 10px;
    img {
      width: 100%;
      height: 100%;
    }
  }
}
</style>
