import { createRouter } from "vue-router";
import { createWebHistory } from "vue-router";

import a from '../page/111.vue'
import b from '../page/222.vue'
import c from '../page/333.vue'





export const router = createRouter({
  history: createWebHistory(),
  routes:[
    {
      path: "/a",
      component:a
    },
    {
      path: "/b",
      component:b
    },
    {
      path: "/c",
      component:c
    }
  ]
});