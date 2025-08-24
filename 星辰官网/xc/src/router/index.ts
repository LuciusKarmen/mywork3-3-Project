import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import('../pages/Home/index.vue'),
    },
    {
      path: '/Info',
      name: 'Info',
      component: () => import('../pages/Info/index.vue'),
    },
    {
      path: '/Our',
      name: 'Our',
      component: () => import('../pages/Our/index.vue'),
    },
    {
      path: '/Team',
      name: 'team',
      component: () => import('../pages/Team/index.vue'),
    },
    {
      path: '/Works',
      name: 'project',
      component: () => import('../pages/Works/index.vue'),
    },
  ],
})

export default router
