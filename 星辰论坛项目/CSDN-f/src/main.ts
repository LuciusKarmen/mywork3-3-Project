import App from './App.vue'
import router from './router'
import { createApp } from 'vue'
import { createPinia } from 'pinia'
import './index.css'

import NutUI from '@nutui/nutui'
import '@nutui/nutui/dist/style.css'

createApp(App).use(NutUI).use(router).use(createPinia()).mount('#app')
