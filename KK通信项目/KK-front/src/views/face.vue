<template>
  <section class="welcome">
    <header class="title">欢迎体验 星辰通讯</header>
    <article class="subtitle">即时通信 · 简洁高效 · 安全可靠</article>
    <button @click="a" class="enter">立即体验</button>
  </section>
</template>

<script setup lang="ts" name="face">
import r from '../router/index'
const a=()=>{
  r.push('/login')
}
</script>

<style lang="scss" scoped>
.welcome {
  width: 100vw;
  height: 100vh;
  background: linear-gradient(135deg, #000000ff, #5e5e5eff); 
  background-size: 400% 400%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  color: white;
  text-align: center;
  animation: gradientBG 15s ease infinite;
  overflow: hidden;
}

.title {
  font-size: 3rem;
  font-weight: 800;
  letter-spacing: 2px;
  margin-bottom: 1rem;
   background: linear-gradient(to right, #f0f0f0, #c9c9c9); 
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  animation: floatUp 2s ease-out forwards;
}

.subtitle {
  font-size: 1.2rem;
  opacity: 0.8;
  margin-bottom: 2rem;
  animation: fadeIn 2s ease-in-out forwards;
}

.enter {
  padding: 12px 30px;
  font-size: 1rem;
  font-weight: bold;
  color: #fff;
  background: rgba(255, 255, 255, 0.1);
  border: 1px solid rgba(255, 255, 255, 0.3);
  border-radius: 30px;
  backdrop-filter: blur(10px);
  box-shadow: 0 8px 32px rgba(0, 0, 0, 0.2);
  transition: all 0.3s ease;
  text-decoration: none;
  animation: slideIn 1.5s ease forwards;
}

.enter:hover {
  background: rgba(255, 255, 255, 0.2);
  transform: scale(1.05);
}

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

@keyframes floatUp {
  0% {
    transform: translateY(30px);
    opacity: 0;
  }
  100% {
    transform: translateY(0);
    opacity: 1;
  }
}

@keyframes fadeIn {
  0% {
    opacity: 0;
    transform: translateY(10px);
  }
  100% {
    opacity: 0.8;
    transform: translateY(0);
  }
}

@keyframes slideIn {
  0% {
    transform: translateY(20px);
    opacity: 0;
  }
  100% {
    transform: translateY(0);
    opacity: 1;
  }
}

@media (max-width: 768px) {
  .title {
    font-size: 2rem;
  }

  .subtitle {
    font-size: 1rem;
  }

  .enter {
    padding: 10px 25px;
    font-size: 0.9rem;
  }
}
</style>

