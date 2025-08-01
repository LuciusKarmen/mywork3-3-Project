<template>
  <div class="login">
    <canvas ref="particleCanvas" class="particles-canvas"></canvas>

    <div class="form">
      <h2>KK Comm</h2>
      <input type="text" placeholder="用户名" v-model="user.name" />
      <input type="password" placeholder="密码" v-model="user.password" />
      <div class="buttons">
        <el-button @click="handleRegister">注册</el-button>
        <el-button @click="handleLogin">登录</el-button>
      </div>
      <br />
      <footer class="footer" @click="show">StellarNet Studio</footer>
    </div>
  </div>
</template>

<script lang="ts" setup>
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'
import { getLogin } from '../api/login/index'
import type { User } from '../types/user'

const particleCanvas = ref<HTMLCanvasElement | null>(null)

// 粒子配置项
const config = {
  number: 100,
  color: '#ffffff',
  opacity: 0.5,
  size: 2,
  lineColor: '#ffffff',
  lineOpacity: 0.3,
  lineWidth: 1,
  linkDistance: 150,
  velocity: 1.5,
}

interface Particle {
  x: number
  y: number
  vx: number
  vy: number
}

const particles: Particle[] = []

function initParticles() {
  const canvas = particleCanvas.value
  if (!canvas) return

  const ctx = canvas.getContext('2d')
  if (!ctx) return

  // 设置 canvas 大小
  function resize() {
    if (!canvas) return
    canvas.width = window.innerWidth
    canvas.height = window.innerHeight
  }

  window.addEventListener('resize', resize)
  resize()

  // 初始化粒子
  for (let i = 0; i < config.number; i++) {
    particles.push({
      x: Math.random() * canvas.width,
      y: Math.random() * canvas.height,
      vx: (Math.random() - 0.5) * config.velocity,
      vy: (Math.random() - 0.5) * config.velocity,
    })
  }

  // 绘制粒子
  function draw() {
    if (!ctx || !canvas) return

    ctx.clearRect(0, 0, canvas.width, canvas.height)
    ctx.fillStyle = config.color
    ctx.globalAlpha = config.opacity

    for (const p of particles) {
      ctx.beginPath()
      ctx.arc(p.x, p.y, config.size, 0, Math.PI * 2)
      ctx.fill()

      // 更新位置
      p.x += p.vx
      p.y += p.vy

      if (p.x <= 0 || p.x >= canvas.width) p.vx *= -1
      if (p.y <= 0 || p.y >= canvas.height) p.vy *= -1
    }

    // 连线
    for (let i = 0; i < particles.length; i++) {
      for (let j = i + 1; j < particles.length; j++) {
        const dx = particles[i].x - particles[j].x
        const dy = particles[i].y - particles[j].y
        const dist = Math.sqrt(dx * dx + dy * dy)

        if (dist < config.linkDistance) {
          ctx.strokeStyle = config.lineColor
          ctx.globalAlpha = config.lineOpacity
          ctx.beginPath()
          ctx.moveTo(particles[i].x, particles[i].y)
          ctx.lineTo(particles[j].x, particles[j].y)
          ctx.stroke()
        }
      }
    }

    requestAnimationFrame(draw)
  }

  draw()
}
const router = useRouter()
function show() {
  router.push('/our')
}
const user = ref<User>({
  id: '1',
  name: '',
  password: '',
  pic: '',
})
function handleLogin() {
  getLogin(user.value.name, user.value.password)
    .then((data) => {
      alert('登录成功')
      localStorage.setItem('username', data.name)
      localStorage.setItem('userid', data.id)
      localStorage.setItem('userpic', data.pic)
      router.push('/main')
    })
    .catch(() => {
      alert('登录失败')
    })
}
function handleRegister() {
  alert('注册按钮被点击')
}

onMounted(() => {
  initParticles()
})
</script>

<style lang="scss" scoped>
.login {
  width: 100vw;
  height: 100vh;
  position: relative;
  overflow: hidden;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #0e0e0e;
}

.particles-canvas {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: 0;
}

.form {
  position: relative;
  z-index: 2;
  background: rgba(255, 255, 255, 0.1);
  backdrop-filter: blur(12px);
  -webkit-backdrop-filter: blur(12px);
  padding: 40px;
  border-radius: 16px;
  box-shadow: 0 8px 32px rgba(0, 0, 0, 0.3);
  text-align: center;
  color: #fff;
  width: 320px;
  position: relative;

  h2 {
    margin-bottom: 20px;
  }

  input {
    display: block;
    width: 100%;
    padding: 10px;
    margin: 10px 0;
    border: none;
    border-radius: 8px;
    outline: none;
    background: rgba(255, 255, 255, 0.2);
    color: white;
  }
  .buttons {
    display: flex;
    justify-content: space-between;
    button {
      width: 45%;
      padding: 10px;
      background: rgba(255, 255, 255, 0.3);
      color: white;
      border: none;
      border-radius: 8px;
      cursor: pointer;
      transition: background 0.3s ease;
    }
  }

  button:hover {
    background: rgba(255, 255, 255, 0.5);
  }
  .footer {
    position: absolute;
    bottom: 10px;
    left: 50%;
    transform: translateX(-50%);
    color: #919191;
    cursor: pointer;
    &:hover {
      color: #fff;
    }
  }
}
</style>
