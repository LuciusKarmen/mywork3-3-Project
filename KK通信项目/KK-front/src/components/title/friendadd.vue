<template>
  <div class="add-friend-container">
    <SearchInput @new_friend="handleNewFriend" />
    <div class="friend-add">
      <div v-if="!receivedFriend" class="friend-add-item-0">
        <p class="text-block">
          世界不是一座座孤岛<br />
          你我一起<br />
          改变世界
        </p>
      </div>

      <div v-else class="friend-add-item-1" @click="addFriendw">
        <div class="info">
          <div class="pic">
            <img :src="`http://localhost:8080/${receivedFriend.pic}`" alt="头像" />
          </div>
          <div class="name">
            <div class="username">{{ receivedFriend.username }}</div>
            <div class="action">+ 添加好友</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup>
import type { User } from '@/types/user'
import SearchInput from '../search.vue'
import { ref } from 'vue'
import { addFriend } from '@/api/main/add'

const receivedFriend = ref<User | null>(null)
const userId = localStorage.getItem('userid')

const handleNewFriend = (friend: User | null) => {
  if (friend) {
    receivedFriend.value = friend
    console.log('父组件收到新朋友:', friend)
  } else {
    alert('未找到该用户')
  }
}

const addFriendw = () => {
  console.log('添加到通讯录:', receivedFriend.value?.username)
  console.log(userId, receivedFriend.value?.id)

  // 确保 userId 和 friend_id 都存在再调用 addFriend
  if (userId && receivedFriend.value?.id) {
    addFriend(userId, receivedFriend.value.id).then(() => {
      alert('添加中')
    })
  } else {
    alert('用户信息不完整，无法添加好友')
  }
}
</script>

<style lang="scss" scoped>
.add-friend-container {
  display: flex;
  flex-direction: column;
  height: 100%;
  width: 100%;
  overflow: hidden;
}

.friend-add {
  flex: 1;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  color: #fff;
  font-size: 18px;
  text-align: center;
  padding: 20px;
  box-sizing: border-box;
}

.friend-add-item-0 {
  opacity: 0;
  transform: translateY(20px) scale(0.98);
  animation: fadeInUp 1s ease forwards;
}

@keyframes fadeInUp {
  to {
    opacity: 1;
    transform: translateY(0) scale(1);
  }
}

.text-block {
  margin: 0;
  line-height: 2.2;
  letter-spacing: 1px;
  font-weight: 300;
  white-space: pre-line;
  text-shadow: 0 1px 3px rgba(0, 0, 0, 0.2);
}

.friend-add-item-1 {
  width: 90%;
  max-width: 400px;
  height: 120px;
  background-color: rgba(255, 255, 255, 0.1);
  border: 1px solid rgba(255, 255, 255, 0.15);
  border-radius: 12px;
  padding: 16px;
  transition: all 0.3s ease;
  cursor: pointer;

  &:hover {
    background-color: rgba(255, 255, 255, 0.2);
    transform: translateY(-2px);
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
  }

  &:active {
    transform: translateY(0);
  }
}

.info {
  display: flex;
  align-items: center;
  gap: 16px;
  height: 100%;

  .pic {
    flex-shrink: 0;
    width: 60px;
    height: 60px;
    border-radius: 50%;
    overflow: hidden;
    border: 2px solid rgba(255, 255, 255, 0.3);
    box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);

    img {
      width: 100%;
      height: 100%;
      object-fit: cover;
    }
  }

  .username {
    font-size: 18px;
    font-weight: 500;
    color: #fff;
    flex: 1;
    text-align: left;
  }

  .action {
    font-size: 14px;
    color: #007bff;
    font-weight: 500;
    white-space: nowrap;
  }
}

.name {
  display: flex;
  align-items: center;
  flex-direction: column;
}
</style>
