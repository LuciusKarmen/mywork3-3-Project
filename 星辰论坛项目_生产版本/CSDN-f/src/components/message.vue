<template>
  <div class="message-card">
    <div class="message-header">
      <div class="avatar">
        <img :src="picture" alt="User Avatar" class="avatar-img" />
      </div>
      <div class="user-info">
        <div class="sender">{{ mes.msend }}</div>
        <div class="time">{{ mes.mtime }}</div>
      </div>
    </div>
    <div class="message-content">
      {{ mes.mcontent }}
    </div>
    <div class="actions">
      <button class="like-btn" @click="toggleLike">
        <span :class="{ liked: isLiked }">❤</span> {{ likeCount }}
      </button>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, watch, onMounted, computed } from 'vue'
import { type Message } from '../api/message'

const props = defineProps<{
  mes: Message
}>()

const isLiked = ref(false)
const likeCount = ref(0)
const isRead = ref(props.mes.mread || false)

const toggleLike = () => {
  isLiked.value = !isLiked.value
  likeCount.value += isLiked.value ? 1 : -1
}

const toggleRead = () => {
  isRead.value = !isRead.value
}

const picture = computed(() => {
  return `http://118.195.143.104/${props.mes.mname}`
})

watch(
  () => props.mes,
  () => {
    console.log('Message updated:', props.mes)
  },
)

onMounted(() => {
  console.log('Mounted message:', props.mes)
})
</script>

<style scoped lang="scss">
.message-card {
  border: 1px solid #ddd;
  border-radius: 10px;
  padding: 16px;
  width: 90vw;
  background-color: #fff;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
  transition: all 0.2s ease;
  cursor: pointer;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  margin-left: 5vw;

  &:hover {
    transform: translateY(-2px);
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
  }
}

.message-header {
  display: flex;
  align-items: center;
  margin-bottom: 12px;
}

.avatar {
  width: 40px;
  height: 40px;
  border-radius: 50%;
  overflow: hidden;
  margin-right: 12px;
}

.avatar-img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.user-info {
  display: flex;
  flex-direction: column;
}

.sender {
  font-weight: bold;
  font-size: 16px;
}

.time {
  font-size: 12px;
  color: #888;
}

.message-content {
  font-size: 15px;
  color: #333;
  margin-bottom: 16px;
}

.actions {
  display: flex;
  gap: 10px;
}

.like-btn,
.read-toggle {
  padding: 6px 12px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  font-size: 14px;
  transition: all 0.2s ease;
}

.like-btn {
  background-color: #f0f0f0;
  color: #666;

  &:hover {
    background-color: #e0e0e0;
  }

  .liked {
    color: red;
  }
}

.read-toggle {
  background-color: #2196f3;
  color: white;

  &:hover {
    background-color: #1976d2;
  }
}

/* 响应式适配 */
@media (max-width: 768px) {
  .message-card {
    padding: 12px;
  }

  .sender {
    font-size: 14px;
  }

  .time {
    font-size: 10px;
  }

  .message-content {
    font-size: 13px;
  }
}
</style>
<!-- mid: string
  mname: string //这里的mname是回复的帖子的id(tid)不然后面人看不懂
  mget: string
  msend: string
  mtime: string
  mcontent: string
  mread: boolean
  mtipid: string -->
