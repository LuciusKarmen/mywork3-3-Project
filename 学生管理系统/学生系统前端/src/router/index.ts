import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'index',
      component: () => import('../pages/index.vue'),
    },
    {
      path: '/our',
      name: 'our',
      component: () => import('../pages/our.vue'),
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('../pages/login.vue'),
    },
    {
      path: '/student',
      name: 'student',
      component: () => import('../pages/student.vue'),
    },
    {
      path: '/teacher',
      name: 'teacher',
      component: () => import('../pages/teacher.vue'),
    },
    {
      path: '/admin',
      name: 'admin',
      component: () => import('../pages/admin.vue'),
    },
  ],
})

export default router
