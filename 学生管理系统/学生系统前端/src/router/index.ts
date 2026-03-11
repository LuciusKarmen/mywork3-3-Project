import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),

  routes: [
    {
      path: '/',
      redirect: '/face',
    },
    {
      path: '/face',
      name: 'face',
      component: () => import('../pages/face.vue'),
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
      children: [
        {
          path: '',
          name: 's',
          component: () => import('../views/Admin/index.vue'),
        },
        {
          path: 'rule',
          name: 'rule',
          component: () => import('../views/Student/rule.vue'),
        },
        {
          path: 'scadd',
          name: 'scadd',
          component: () => import('../views/Student/scAdd.vue'),
        },
        {
          path: 'scList',
          name: 'scList',
          component: () => import('../views/Student/scList.vue'),
        },
      ],
    },
    {
      path: '/teacher',
      name: 'teacher',
      component: () => import('../pages/teacher.vue'),
      children: [
        {
          path: '',
          name: 't',
          component: () => import('../views/Admin/index.vue'),
        },
        {
          path: 'courseList',
          name: 't_courseList',
          component: () => import('../views/Teacher/courseList.vue'),
        },
        {
          path: 'courseAdd',
          name: 't_courseAdd',
          component: () => import('../views/Teacher/courseAdd.vue'),
        },
        {
          path: 'score',
          name: 'score',
          component: () => import('../views/Teacher/score.vue'),
        },
      ],
    },
    {
      path: '/admin',
      name: 'admin',
      component: () => import('../pages/admin.vue'),
      children: [
        {
          path: '',
          name: 'a',
          component: () => import('../views/Admin/index.vue'),
        },
        {
          path: 'agree',
          name: 'agree',
          component: () => import('../views/Admin/agree.vue'),
        },
        {
          path: 'courseList',
          name: 'courseList',
          component: () => import('../views/Admin/courseList.vue'),
        },
        {
          path: 'studentAdd',
          name: 'studentAdd',
          component: () => import('../views/Admin/studentAdd.vue'),
        },
        {
          path: 'studentList',
          name: 'studentList',
          component: () => import('../views/Admin/studentList.vue'),
        },
        {
          path: 'teacherAdd',
          name: 'teacherAdd',
          component: () => import('../views/Admin/teacherAdd.vue'),
        },
        {
          path: 'teacherList',
          name: 'teacherList',
          component: () => import('../views/Admin/teacherList.vue'),
        },
      ],
    },
  ],
})
export default router
