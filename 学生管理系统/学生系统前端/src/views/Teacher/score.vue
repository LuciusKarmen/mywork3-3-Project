<template>
  <div class="main">
    <div class="centre">1</div>
  </div>
</template>
<script lang="ts" setup name="">
import { ref } from 'vue'
</script>
<style lang="scss" scoped>
.main {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background: linear-gradient(135deg, rgb(224, 249, 255), rgb(241, 241, 241));
  display: flex;
  background-size: 400% 400%;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  color: white;
  text-align: center;
  animation: gradientBG 15s ease infinite;
  overflow: hidden;

  .centre {
    width: 90%;
    height: 90%;
    display: flex;
    background-color: rgb(223, 223, 223);
    justify-content: center;
    align-items: center;
    border-radius: 2%;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  }
}
</style>
