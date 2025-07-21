<template>
  <div class="about">
    <div class="header">
      <h1>{{ appName }}</h1>
      <p class="english">{{ englishName }}</p>
    </div>
    <div class="desc">
      <p>{{ description }}</p>
      <p>{{ name }}</p>
    </div>
    <div class="notes">
      <h2>{{ notesTitle }}</h2>
      <ul>
        <li v-for="(item, index) in notes" :key="index">{{ item }}</li>
      </ul>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue'

const appName = ref('KK通讯')
const englishName = ref('KK Comm')
const description = ref(
  '一款简洁、安全、高效的即时通讯工具，支持文字、图片、文件传输，适合个人与团队沟通使用',
)
const notesTitle = ref('使用须知')
const name = ref('作者:Karmen-Jhon-Lucius(许光明)')
const notes = ref([
  '请勿传播违法或不良信息。',
  '保护个人隐私，谨慎添加好友及分享个人信息。',
  '请定期更新密码，确保账户安全。',
])
</script>

<style lang="scss" scoped>
.about {
  padding: 1.5rem;
  line-height: 1.8;
}

.header h1 {
  font-size: 1.4rem;
  margin-bottom: 0.2rem;
}

.english {
  font-size: 0.95rem;
  color: #777;
  margin-bottom: 0.6rem;
  font-style: italic;
}

.desc p {
  font-size: 0.95rem;
  color: #b7b7b7;
  margin-bottom: 1rem;
}

.notes h2 {
  font-size: 1.1rem;
  margin-bottom: 0.6rem;
  font-weight: 600;
}

.notes li {
  font-size: 0.9rem;
  color: #9a9a9a;
  margin-bottom: 0.4rem;
  position: relative;
  padding-left: 1rem;
}

.notes li::before {
  content: '•';
  position: absolute;
  left: 0;
  color: #999;
}
</style>
