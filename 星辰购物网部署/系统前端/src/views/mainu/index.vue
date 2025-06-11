<template>
  <n-scrollbar>
    <div class="introduction-page">
      <header class="header">
        <h1>
          欢迎来到星辰购物网站, <span class="fancy-heading">{{ username }}客人</span>
        </h1>
        <p>一站式购物平台，品质生活从这里开始</p>
      </header>

      <section class="features">
        <h2>核心功能</h2>
        <div class="feature-list">
          <div class="feature-item">
            <h3>商品丰富</h3>
            <p>涵盖数码、家居、服饰、美妆等数千种商品，满足你的日常所需。</p>
          </div>
          <div class="feature-item">
            <h3>智能搜索</h3>
            <p>支持关键词搜索与分类筛选，快速找到你想要的商品。</p>
          </div>
          <div class="feature-item">
            <h3>安全支付</h3>
            <p>支持多种支付方式，保障交易安全可靠。</p>
          </div>
          <div class="feature-item">
            <h3>物流跟踪</h3>
            <p>实时查看订单状态，掌握物流信息，安心收货。</p>
          </div>
        </div>
      </section>
      <section class="advantages">
        <h2>为什么选择我们？</h2>
        <ul>
          <li>提供正品保障，<span class="highlight">假一赔十!!!</span></li>
          <li><span class="highlight">7天</span>退换货<span class="highlight">无理由</span></li>
          <li>会员专属折扣与积分返利</li>
          <li>专业客服24小时在线服务</li>
        </ul>
      </section>

      <section class="process">
        <h2>如何开始购物？</h2>
        <ol>
          <li>注册或登录账号</li>
          <li>浏览商品或通过搜索查找</li>
          <li>加入购物车并结算</li>
          <li>完成支付并等待收货</li>
        </ol>
        <n-button @click="a" type="primary">开始你的旅程</n-button>
      </section>

      <footer class="footer">
        <p>&copy; 2025 许光明拥有购物网站. 保留所有权利.</p>
      </footer>
    </div>
  </n-scrollbar>
</template>

<script setup lang="ts" name="IntroductionPage">
import type { S } from 'vitest/dist/chunks/config.d.UqE-KR0o.js'
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'

const username = ref<string | null>(null)

onMounted(() => {
  // 从 localStorage 读取用户名
  const storedUsername = localStorage.getItem('username')
  username.value = storedUsername
  console.log('获取到的用户名:', username.value)
})

const router = useRouter()
const a = () => {
  router.push('/worku/indexu')
}
</script>

<style scoped>
.introduction-page {
  width: 100%;
  height: 100%;
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  line-height: 1.6;
  color: #333;
  max-width: 1000px;
  margin: auto;
  padding: 20px;
}

.header {
  text-align: center;
  padding: 2em 1em;
  background-color: #f8f8f8;
  border-bottom: 1px solid #ddd;
}
.header h1 {
  margin: 0;
  font-size: 2em;
}
.header p {
  margin-top: 0.5em;
  font-size: 1.2em;
  color: #666;
}

.features h2,
.advantages h2,
.process h2 {
  margin-top: 2em;
  font-size: 1.5em;
  color: #2c3e50;
}

.feature-list {
  display: flex;
  flex-wrap: wrap;
  gap: 1em;
  justify-content: space-between;
}
.feature-item {
  flex: 1 1 45%;
  background-color: #f9f9f9;
  padding: 1em;
  border-radius: 8px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.05);
}
@media (max-width: 768px) {
  .feature-item {
    flex: 1 1 100%;
  }
}

.advantages ul,
.process ol {
  padding-left: 1.5em;
}
.advantages li,
.process li {
  margin-bottom: 0.8em;
}

.footer {
  margin-top: 3em;
  text-align: center;
  font-size: 0.9em;
  color: #777;
  border-top: 1px solid #eee;
  padding-top: 1em;
}
.highlight {
  color: #e74c3c;
  font-weight: bold;
  font-size: 40px;
}
.fancy-heading {
  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
  font-size: 3.5rem;
  background: linear-gradient(45deg, #ff758c, #ff7eb3);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  text-align: center;
  margin: 2rem 0;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.1);
  transition:
    transform 0.3s ease,
    color 0.3s ease;
}

.fancy-heading:hover {
  transform: scale(1.05);
}
</style>
