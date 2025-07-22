<template>
  <SearchInput />
  <div class="friend-list">
    <div v-for="(friend, index) in 15" :key="index" class="friend-item">
      <div class="friend-item-pic">
        <img src="../../assets/R-C.jpg" alt="" />
      </div>
      <div class="name">Karmen</div>
      <div class="live"></div>
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
    &:last-child {
      border-bottom: none;
    }
    &:hover {
      background-color: #fafafa;
      cursor: pointer;
    }
    .friend-item-pic {
      width: 30px;
      height: 30px;
      margin-right: 1rem;
      img {
        width: 100%;
        height: 100%;
        border-radius: 50%;
      }
    }
    .name {
      font-size: 1rem;
      font-weight: 500;
    }
    .live {
      width: 5px;
      height: 5px;
      border-radius: 50%;
      background-color: rgb(0, 123, 255);
      margin-left: auto;
      margin-top: -20px;
    }
  }
}
</style>
