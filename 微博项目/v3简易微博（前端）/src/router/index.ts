import { createRouter } from "vue-router"
import { createWebHistory } from "vue-router"
import work from "../views/work.vue"
import login from "../views/login.vue"
import register from "../views/register.vue"

import other from "../pages/other.vue"
import F from "../pages/F.vue"
import B from "../pages/B.vue"
import Home from "../pages/Home.vue"


const router = createRouter({
  history: createWebHistory(),
  routes:[
    {
      path: "/work",
      name:"Work",
      component:work,
      children:[
        {
          path:"home",
          name:"kk",
          component:Home
        },
        {
          path:"other",
          name:"Other",
          component:other
        },
        {
          path:"F",
          name:"F",
          component:F
        },
        {
          path:"B",
          name:"B",
          component:B
        }
      ]
    },
    {
      path: "/",
      name:"Login",
      component:login
    },
    {
      path: "/register",
      name:"Register",
      component:register
    }
  ]
})
export default router