import { createApp } from 'vue'
import App from './App.vue'
import { createPinia } from 'pinia'
import { createRouter, createWebHistory } from 'vue-router'

const app = createApp(App)
const pinia = createPinia()

app.mount('#app')
app.use(pinia)
