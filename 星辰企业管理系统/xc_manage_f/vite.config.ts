import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueDevTools from 'vite-plugin-vue-devtools'
import Components from 'unplugin-vue-components/vite'
// https://vite.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    vueDevTools(),
    Components({
      resolvers: [
        (name) => {
          console.log('🔍 Resolver 被调用:', name) // 看是否触发
          if (name.startsWith('Xc')) {
            console.log('✅ 匹配成功:', name)
            return {
              name,
              from: 'xingchengnet-ui',
            }
          }
        },
      ],
      dts: 'src/components.d.ts',
    }),
  ],
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url)),
    },
  },
})
