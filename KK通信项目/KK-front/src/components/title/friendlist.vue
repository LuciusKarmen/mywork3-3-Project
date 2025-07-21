<template>
  <SearchInput />
  <div class="friend-list">
    <div v-for="(friend, index) in 10" :key="index" class="friend-item">
      <div class="friend-item-pic">
        <img src="../../assets/圆添加.png" alt="" class="friend-item-pic-img" />
      </div>
    </div>
  </div>
</template>
<script lang="ts" setup name="">
import { ref } from 'vue'
import SearchInput from '../search.vue'
</script>
<style lang="scss" scoped>
.friend-list {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 1rem;
  height: 83vh;
  overflow-y: auto;
  scrollbar-width: none;
  -ms-overflow-style: none;
  .friend-item {
    display: flex;
    align-items: center;
    width: 100%;
    padding: 0.5rem;
    border-bottom: 1px solid #ccc;
    .friend-item-pic {
      width: 40px;
      height: 40px;
      margin-right: 1rem;
      .friend-item-pic-img {
        width: 100%;
        height: 100%;
        border-radius: 50%;
      }
    }
  }
}
</style>
