<template>
  <SearchInput />
  <div class="friend-list">
    <div
      v-for="item in friendlist"
      :key="item.id"
      class="friend-item"
      @click="choose(item)"
      :class="{ active: selectedFriendId === item.id }"
    >
      <div class="friend-item-pic">
        <img :src="`http://localhost:8080/${item.pic}`" alt="头像" />
      </div>
      <div class="name">{{ item.username }}</div>
    </div>
  </div>
</template>
<script lang="ts" setup>
import { ref, onMounted } from 'vue'
import SearchInput from '../search.vue'
import { getFriendList } from '../../api/title/index'
import type { User } from '@/types/user'

const friendlist = ref<User[]>()
const selectedFriendId = ref('')
const choose = (item: User) => {
  localStorage.setItem('friendid', item.id)
  localStorage.setItem('friendname', item.username)
  console.log(localStorage.getItem('friendid'), localStorage.getItem('friendname'))
  selectedFriendId.value = item.id
  window.dispatchEvent(new Event('storage'))
}
onMounted(() => {
  const id = localStorage.getItem('userid')
  if (id) {
    getFriendList(id).then((data) => {
      friendlist.value = data
      console.log(data)
      console.log('1')
    })
  }
})
</script>
<style lang="scss" scoped>
.friend-list {
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 83vh;
  overflow-y: auto;
  scrollbar-width: none;
  -ms-overflow-style: none;
  .friend-item {
    display: flex;
    align-items: center;
    width: 100%;
    padding: 0.5rem;
    height: 8vh;
    border-bottom: 1px solid #ccc;
    &:last-child {
      border-bottom: none;
    }
    &:hover {
      background-color: #bcbcbc;
      cursor: pointer;
    }
    &.active {
      background-color: #fefefe;
    }
    .friend-item-pic {
      width: 6vh;
      height: 6vh;
      margin-right: 1rem;
      img {
        width: 100%;
        height: 100%;
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
