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
    {
      path: '/our',
      name: 'our',
      component: () => import('../pages/our.vue'),
    },
    {
      path: '/regs',
      name: 'regs',
      component: () => import('../pages/regs.vue'),
    },
    {
      path: '/regu',
      name: 'regu',
      component: () => import('../pages/regu.vue'),
    },
    ////////////////
    {
      path: '/worku',
      name: 'worku',
      component: () => import('../pages/worku.vue'),
      children: [
        {
          path: 'shopping',
          name: 'shopping',
          component: () => import('../views/mainu/shopping.vue'),
        },
      ],
    },
    {
      path: '/works',
      name: 'works',
      component: () => import('../pages/works.vue'),
      children: [],
    },
  ],
})

export default router
