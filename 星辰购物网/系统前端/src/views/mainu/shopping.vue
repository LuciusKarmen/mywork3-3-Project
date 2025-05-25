<template>
  <div class="shopping-container">
    <div class="header">
      <n-card>
        <n-tabs type="line" animated>
          <n-tab-pane name="成人服饰" tab="成人服饰"><Good></Good></n-tab-pane>
          <n-tab-pane name="电子产品" tab="电子产品"><Good></Good></n-tab-pane>
          <n-tab-pane name="家居用品" tab="家居用品"><Good></Good></n-tab-pane>
          <n-tab-pane name="食品" tab="食品"><Good></Good></n-tab-pane>
          <n-tab-pane name="运动器械" tab="运动器械"><Good></Good></n-tab-pane>
          <n-tab-pane name="玩具五金" tab="玩具五金"><Good></Good></n-tab-pane>
          <n-tab-pane name="其他" tab="其他"><Good></Good></n-tab-pane>
        </n-tabs>
      </n-card>
    </div>
    <div class="content"></div>
  </div>
</template>

<script setup lang="ts" name="Shopping">
import { ref } from 'vue'
import Good from '../../components/good.vue'

const activeTab = ref('成人服饰')
</script>

<style scoped lang="scss">
.shopping-container {
  height: 93vh;
  width: 83%;
  position: absolute;
  top: 7vh;
  left: 17%;

  .header {
    height: 5vh;
    width: 100%;
    background-color: #f0f0f0;
    position: absolute;
    top: 0;
    left: 0;
  }
}
</style>
