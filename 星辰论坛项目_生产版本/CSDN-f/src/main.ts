import App from './App.vue'
import router from './router'
import { createApp } from 'vue'
import { createPinia } from 'pinia'
import './index.css'
import * as ElementPlusIconsVue from '@element-plus/icons-vue'
import NutUI from '@nutui/nutui'
import '@nutui/nutui/dist/style.css'

const app = createApp(App)
for (const [key, component] of Object.entries(ElementPlusIconsVue)) {
  app.component(key, component)
}

app.use(NutUI)
app.use(router)
app.use(createPinia())

app.mount('#app')
