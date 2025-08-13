import { createRouter, type NavigationGuardWithThis } from 'vue-router'
import { createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      name: 'face',
      component: () => import('../pages/face.vue'),
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../pages/login.vue'),
    },
    {
      path: '/reg',
      name: 'register',
      component: () => import('../pages/reg.vue'),
    },
    {
      path: '/main',
      name: 'main',
      component: () => import('../pages/main.vue'),
    },
    {
      path: '/our',
      name: 'our',
      component: () => import('../pages/our.vue'),
    },
    {
      path: '/message',
      name: 'message',
      component: () => import('../pages/message.vue'),
    },
    {
      path: '/my',
      name: 'my',
      component: () => import('../pages/my.vue'),
    },
    {
      path: '/pre/:tid',
      name: 'Preview',
      component: () => import('../pages/pre.vue'),
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('../pages/about.vue'),
    },
    {
      path: '/send',
      name: 'send',
      component: () => import('../pages/send.vue'),
    },
  ],
})

const authPages = ['/main', '/my', '/message', '/our', '/send', '/pre']

// 路由守卫！！！
const beforeEach: NavigationGuardWithThis<undefined> = (to, from, next) => {
  const username = localStorage.getItem('username')

  if (authPages.includes(to.path)) {
    if (username) {
      next()
    } else {
      alert('请先登录')
      next('/login')
    }
  } else {
    next()
  }
}

router.beforeEach(beforeEach)
export default router
