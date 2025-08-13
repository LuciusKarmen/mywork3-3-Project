<template>
  <div class="about">
    <section class="about-section">
      <h1>关于网站</h1>
      <div class="about-content">
        <p>本网站为个人项目，仅供学习参考，请勿用于商业用途。</p>
        <p>本网站基于 Vue.js 开发，使用 Element-UI / Nut-UI / Bootstrap 进行前端 UI 设计。</p>
      </div>
    </section>

    <section class="about-section">
      <h1>论坛使用规范</h1>
      <div class="about-content">
        <ol>
          <li v-for="(rule, i) in rules" :key="i">{{ rule }}</li>
        </ol>
      </div>
    </section>

    <section class="about-section">
      <h1>关于网站作者</h1>
      <div class="about-content">
        <p>网站作者：Lucius.John.Karmen (许光明)</p>
      </div>
    </section>
    <el-button type="primary" @click="get">返回首页</el-button>
  </div>
</template>

<script setup>
import router from '@/router'
import { ref } from 'vue'

const rules = ref([
  '请勿发布任何关于本站的广告',
  '请遵守社区准则，文明发言',
  '禁止恶意攻击他人账号行为',
  '不得传播违法不良信息',
])
const get = () => {
  router.push('/main')
}
</script>

<style scoped lang="scss">
.about {
  padding: 20px;
  min-height: 100vh;

  color: #333;

  h1 {
    text-align: center;
    margin-top: 40px;
    font-weight: 700;
    font-size: 2rem;
    color: #0077cc;
  }

  .about-section {
    max-width: 900px;
    margin: 0 auto 40px auto;
  }

  .about-content {
    margin-top: 20px;
    border: 1px solid #ddd;
    padding: 24px;
    border-radius: 10px;
    background-color: #ffffffee;
    box-shadow: 0 8px 16px rgba(0, 128, 255, 0.05);

    p,
    ol {
      line-height: 1.8;
      font-size: 1rem;
      margin-bottom: 16px;
    }

    ol li {
      margin-bottom: 8px;
    }
  }
}
</style>
