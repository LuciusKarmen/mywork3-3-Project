<template>
  <div class="main">
    <div class="centre">
      <!-- Logo / Icon -->
      <div class="logo-glow">
        <div class="logo">🎓</div>
      </div>

      <!-- 主标题 -->
      <h1 class="title">智慧校园管理系统</h1>

      <!-- 副标题 -->
      <p class="subtitle">高效 · 安全 · 智能一体化教学管理平台</p>

      <!-- 动态装饰线条 -->
      <div class="divider"></div>

      <!-- 角色提示 -->
      <p class="hint">欢迎使用本系统</p>

      <!-- 跳转按钮（可选，或留白让用户去登录页） -->
      <!-- 
      <div class="actions">
        <el-button type="primary" @click="$router.push('/login')">立即登录</el-button>
      </div>
      -->
    </div>
  </div>
</template>

<script lang="ts" setup></script>

<style lang="scss" scoped>
.main {
  width: 100vw;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background: linear-gradient(135deg, #1a2a6c, #f7d4d4, #1a2a6c);
  background-size: 400% 400%;
  animation: gradientBG 15s ease infinite;
  overflow: hidden;
  font-family: 'Segoe UI', 'Microsoft YaHei', sans-serif;

  .centre {
    width: 90%;
    max-width: 800px;
    height: 85%;
    max-height: 600px;
    background: rgba(255, 255, 255, 0.15);
    backdrop-filter: blur(12px);
    -webkit-backdrop-filter: blur(12px);
    border-radius: 20px;
    box-shadow:
      0 10px 30px rgba(0, 0, 0, 0.3),
      inset 0 0 20px rgba(255, 255, 255, 0.1);
    border: 1px solid rgba(255, 255, 255, 0.2);
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    padding: 40px;
    position: relative;
    overflow: hidden;

    /* 背景微纹理 */
    &::before {
      content: '';
      position: absolute;
      top: -50%;
      left: -50%;
      width: 200%;
      height: 200%;
      background: radial-gradient(circle, rgba(255, 255, 255, 0.1) 0%, transparent 70%);
      z-index: -1;
    }

    .logo-glow {
      margin-bottom: 25px;
      animation: pulse 2s infinite;

      .logo {
        font-size: 64px;
        filter: drop-shadow(0 0 15px rgba(255, 255, 255, 0.7));
      }
    }

    .title {
      font-size: 36px;
      font-weight: 800;
      margin: 0 0 15px;
      background: linear-gradient(to right, #ffffff, #a0d2ff);
      -webkit-background-clip: text;
      -webkit-text-fill-color: transparent;
      text-shadow: 0 2px 10px rgba(0, 0, 0, 0.2);
    }

    .subtitle {
      font-size: 18px;
      color: rgba(255, 255, 255, 0.85);
      margin: 0 0 30px;
      max-width: 80%;
      line-height: 1.5;
    }

    .divider {
      width: 60%;
      height: 1px;
      background: linear-gradient(to right, transparent, rgba(255, 255, 255, 0.5), transparent);
      margin: 20px 0;
    }

    .hint {
      font-size: 16px;
      color: rgba(255, 255, 255, 0.7);
      margin-top: 10px;
    }

    .actions {
      margin-top: 30px;
      :deep(.el-button) {
        background: rgba(255, 255, 255, 0.2);
        border: 1px solid rgba(255, 255, 255, 0.3);
        color: white;
        backdrop-filter: blur(5px);
        &:hover {
          background: rgba(255, 255, 255, 0.3);
        }
      }
    }
  }
}

/* 渐变背景动画 */
@keyframes gradientBG {
  0% {
    background-position: 0% 50%;
  }
  50% {
    background-position: 100% 50%;
  }
  100% {
    background-position: 0% 50%;
  }
}

/* Logo 脉冲光晕 */
@keyframes pulse {
  0% {
    transform: scale(1);
    filter: drop-shadow(0 0 15px rgba(255, 255, 255, 0.7));
  }
  50% {
    transform: scale(1.05);
    filter: drop-shadow(0 0 25px rgba(255, 255, 255, 1));
  }
  100% {
    transform: scale(1);
    filter: drop-shadow(0 0 15px rgba(255, 255, 255, 0.7));
  }
}
</style>
