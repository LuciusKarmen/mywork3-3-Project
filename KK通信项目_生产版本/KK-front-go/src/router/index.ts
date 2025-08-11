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
      children: [
        {
          path: '',
          name: 'home',
          component: () => import('../components/title/friendlist.vue'),
        },
        {
          path: 'chat',
          name: 'chat',
          component: () => import('../components/title/friendlist.vue'),
        },
        {
          path: 'add',
          name: 'add',
          component: () => import('../components/title/friendadd.vue'),
        },
        {
          path: 'control',
          name: 'control',
          component: () => import('../components/title/control.vue'),
        },
        {
          path: 'about',
          name: 'about',
          component: () => import('../components/title/about.vue'),
        },
        {
          path: 'server',
          name: 'server',
          component: () => import('../components/title/server.vue'),
        },
      ],
    },
  ],
})

export default router
