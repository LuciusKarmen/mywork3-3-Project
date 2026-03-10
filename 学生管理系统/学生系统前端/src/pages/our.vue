<template>
  <div class="about-container">
    <div class="overlay"></div>
    <div class="content">
      <h1>欢迎来到星辰网络工作室</h1>
      <p>
        这是一支专注于互联网开发与数字创新的年轻团队，致力于打造高质量的 Web
        应用、小程序、企业级解决方案，并积极探索人工智能技术的应用与落地。
      </p>

      <h2>我们的优势</h2>
      <ul>
        <li>✅ 前端设计：响应式网站、Vue/React 框架精通</li>
        <li>✅ 后端开发：Node.js、Spring Boot</li>
        <li>✅ 移动开发：微信小程序、App 开发</li>
        <li>✅ 人工智能：Spring AI、项目智能化改造</li>
        <li>✅ 技术支持：7×24 小时在线服务，全程技术指导</li>
      </ul>

      <h2>本工作室的愿景<span style="color: red">&#10084;</span></h2>
      <p>以技术为基石，以用户体验为核心，助力企业实现数字化转型，让科技点亮未来。</p>

      <div class="contact">
        <p>📧 邮箱：karmenluious@gmail.com</p>
        <p>📞 电话：+86 183-2918-3547</p>
        <p>📍 地址：中国 · 杭州市西湖区</p>
      </div>
    </div>
  </div>
</template>

<script setup name="our" lang="ts"></script>

<style scoped lang="scss">
.about-container {
  position: relative;
  height: 110vh;
  width: 100%;
  background-image: url('../assets/ys.png');
  background-size: cover;
  background-position: center;
  display: flex;
  align-items: center;
  justify-content: center;
  color: white;
  font-family: 'Segoe UI', sans-serif;

  .overlay {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    z-index: 0;
  }

  .content {
    position: relative;
    z-index: 1;
    max-width: 800px;
    padding: 40px;
    background-color: rgba(255, 255, 255, 0.1);
    border-radius: 15px;
    backdrop-filter: blur(10px);
    text-align: left;

    h1 {
      font-size: 2rem;
      margin-bottom: 20px;
    }

    h2 {
      margin-top: 30px;
      font-size: 1.4rem;
    }

    p {
      font-size: 1rem;
      line-height: 1.6;
    }

    ul {
      list-style-type: none;
      padding-left: 0;
      margin-top: 10px;

      li {
        margin-bottom: 10px;
      }
    }

    .contact {
      margin-top: 30px;
      font-size: 0.95rem;
      color: #ddd;
    }
  }
}
</style>
