<template>
  <div class="title">
    <div class="show">
      <div class="logo">
        <img :src="picture" alt="用户头像" />
      </div>
      <div class="name">{{ username }}</div>
    </div>
    <div class="search">
      <Search class="iconfont"></Search>
      <input type="text" placeholder="搜索" class="search2" />
    </div>
    <div class="pic">
      <HorizontalN class="iconfont3" @click="menu"></HorizontalN>
    </div>
    <div class="menu" v-show="ok1">
      <h1>选择主题</h1>
      <div class="menu1" v-for="(item, index) in classify" :key="index" @click="select(item)">
        <div class="menu2" @click="ok1 = false">
          <span>{{ item }}</span>
          <Right class="iconfont2"></Right>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts" name="title">
import { indexOf } from 'lodash'
import { Search, HorizontalN, Right } from '@nutui/icons-vue'
import { ref, computed } from 'vue'
import { useRouter } from 'vue-router'
const router = useRouter()

const select = (item: string) => {
  ok1.value = false
  console.log(item)
  localStorage.setItem('classify', item)
  window.location.reload()
}
const menu = () => {
  ok1.value = !ok1.value
}

const username = ref(localStorage.getItem('username') || '匿名用户')
const classify = ref([
  '全部',
  '学习',
  '编程',
  '生活',
  '端游',
  '手游',
  '动漫',
  '影视',
  '音乐',
  '文学',
  '科技',
  '体育',
  '美食',
  '旅游',
])
const avatar = ref(localStorage.getItem('userpic') || '../pic/KK.png')
const picture = computed(() => {
  return `http://118.195.143.104/${avatar.value}`
})
const ok1 = ref(false)
</script>

<style lang="scss" scoped>
.title {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  z-index: 1000;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 1% 5%;
  background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
  height: 6vh;
  box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
  border-bottom: 2px solid rgba(0, 188, 212, 0.3);
  transition: background 0.3s ease;

  &:hover {
    background: linear-gradient(135deg, #e8f5e9 0%, #fce4ec 100%);
  }

  .show {
    display: flex;
    align-items: center;
    gap: 12px;
    font-weight: bold;
    color: #333;
    font-size: 1.1rem;
    transition: color 0.3s ease;
    .logo {
      height: 5vh;
      width: 5vh;
      border-radius: 50%;
      overflow: hidden;
      transition: transform 0.3s ease;

      &:hover {
        transform: scale(1.1);
      }

      img {
        width: 100%;
        height: 100%;
        object-fit: cover;
      }
    }
  }

  .search {
    position: relative;
    width: 35%;
    height: 5vh;

    .search2 {
      width: 100%;
      height: 100%;
      background-color: rgba(255, 255, 255, 0.8);
      border-radius: 25px;
      border: 2px solid rgba(0, 188, 212, 0.5);
      padding-left: 40px;
      font-size: 1.2rem;
      outline: none;
      transition: all 0.3s ease;

      &:focus {
        border-color: #00bcd4;
        box-shadow: 0 0 5px rgba(0, 188, 212, 0.5);
      }
    }

    .iconfont {
      position: absolute;
      left: 12px;
      top: 50%;
      transform: translateY(-50%);
      font-size: 1.3rem;
      color: #999;
      transition: color 0.3s ease;
    }

    &:focus-within .iconfont {
      color: #00bcd4;
    }
  }

  .pic {
    background-color: rgba(255, 255, 255, 0.9);
    width: 4%;
    padding: 6px;
    border-radius: 10%;
    text-align: center;
    cursor: pointer;
    transition: all 0.3s ease;

    &:hover {
      background-color: rgba(123, 123, 123, 0.2);
      transform: rotate(90deg);
    }

    .iconfont3 {
      font-size: 1.5rem;
      color: #333;
    }
  }

  .menu {
    position: absolute;
    top: 6vh;
    right: 5%;
    width: 20%;
    max-height: 50vh;
    background: linear-gradient(135deg, #ffffff 0%, #f9f9f9 100%);
    border-radius: 12px;
    box-shadow: 0 6px 16px rgba(0, 0, 0, 0.15);
    z-index: 1001;
    overflow-y: auto;
    animation: fadeIn 0.3s ease forwards;
    padding: 10px 0;

    h1 {
      text-align: center;
      font-size: 1.1rem;
      color: #333;
      margin-bottom: 8px;
      font-weight: bold;
    }

    .menu1 {
      padding: 4px 10px;

      .menu2 {
        display: flex;
        justify-content: space-between;
        align-items: center;
        padding: 8px 12px;
        cursor: pointer;
        border-radius: 8px;
        transition: background 0.2s ease;

        &:hover {
          background-color: #e0f7fa;
        }

        span {
          font-size: 1rem;
          color: #555;
        }

        .iconfont2 {
          font-size: 1rem;
          color: #999;
          transition: transform 0.2s ease;
        }

        &:hover .iconfont2 {
          transform: translateX(4px);
        }
      }
    }

    &::-webkit-scrollbar {
      width: 6px;
    }

    &::-webkit-scrollbar-thumb {
      background-color: rgba(0, 0, 0, 0.2);
      border-radius: 3px;
    }
  }
}

// 动画
@keyframes fadeIn {
  from {
    opacity: 0;
    transform: translateY(-10px);
  }
  to {
    opacity: 1;
    transform: translateY(0);
  }
}

// 响应式适配
@media (max-width: 768px) {
  .title {
    height: 7vh;
    padding: 1% 3%;

    .logo {
      width: 10%;
      height: 4vh;
    }

    .search {
      width: 40%;
      .search2 {
        font-size: 1rem;
        padding-left: 35px;
      }
      .iconfont {
        left: 10px;
        font-size: 1.1rem;
      }
    }

    .pic {
      width: 8%;
      padding: 4px;
    }

    .menu {
      right: 3%;
      width: 40%;
    }
  }
}
</style>
