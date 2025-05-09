<template>
  <div id="left">
    <div v-for="(item, index) in 10" class="gg">hhh</div>
  </div>
</template>

<script setup lang="ts" name="Left"></script>

<style lang="scss" scoped>
#left {
  width: 180px;
  height: 90vh;
  background-color: #1cffe8;
  display: flex;
  justify-content: space-between;

  align-items: center;
  flex-direction: column;
  border-radius: 5px;

  .gg {
    width: 100%;
    height: 20%;
    background-color: #ffffff;
    margin-top: 1px;
    border-radius: 5px;
    display: flex;
    justify-content: center;
    align-items: center;
  }
}
</style>
