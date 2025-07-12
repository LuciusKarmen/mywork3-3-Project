import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: '/',
      name: 'face',
      component: () => import('../views/face.vue'),
    },
    {
      path: '/about',
      name: 'about',
      component: () => import('../views/about.vue'),
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../views/login.vue'),
    },
    {
      path: '/reg',
      name: 'reg',
      component: () => import('../views/reg.vue'),
    },
    {
      path: '/our',
      name: 'our',
      component: () => import('../views/our.vue'),
    },
    {
      path: '/main',
      name: 'main',
      component: () => import('../views/main.vue'),
    },
  ],
})

export default router
