<template>
  <div class="t1">
    <div class="t2">
      <div class="tp"><img src="../pic/KK.png" alt="" class="ti" /></div>
      <div class="tn">Karmen</div>
      <div class="tt">2025.6.16</div>
    </div>
    <div class="tc">Hello,world!</div>
    <div class="foot">
      <div>点赞</div>
      <div>评论</div>
    </div>
  </div>
</template>

<script setup lang="ts" name="Tip"></script>

<style scoped lang="scss">
.t1 {
  border: 1px solid black;
  width: 76%;

  margin: auto;
  border-radius: 5px;
  padding: 10px;
  background-color: rgba(205, 205, 205, 0.9);
  backdrop-filter: blur(10px);
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  .t2 {
    display: flex;
    flex-direction: row;
    align-items: center;
    .tp {
      width: 8%;
      height: 8%;
      border-radius: 50%;
      margin-bottom: 10px;
      .ti {
        width: 100%;
        height: 100%;
        border-radius: 50%;
      }
    }
  }
}
@media (max-width: 760px) {
  .t1 {
    width: 96%;
    margin: 0 auto;
    background-color: rgba(205, 205, 205, 0.9);
    backdrop-filter: blur(10px);
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  }
}
</style>
