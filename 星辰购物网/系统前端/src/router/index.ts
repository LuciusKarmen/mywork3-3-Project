import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'face',
      component: () => import('../pages/face.vue'),
    },
    {
      path: '/loginu',
      name: 'loginu',
      component: () => import('../pages/loginu.vue'),
    },
    {
      path: '/logins',
      name: 'logins',
      component: () => import('../pages/logins.vue'),
    },
  ],
})

export default router
