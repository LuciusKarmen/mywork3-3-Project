import { createRouter } from 'vue-router'
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
  ],
})
export default router
