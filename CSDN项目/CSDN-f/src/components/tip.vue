<template>
  <div class="t1">
    <div class="t2">
      <div class="tp"><img src="../pic/KK.png" alt="" class="ti" /></div>
      <div class="content">
        <div class="tn">Karmen</div>
        <div class="tt">2025.6.16</div>
      </div>
    </div>
    <div class="tc">Hello,world!</div>
    <div class="foot">
      <div class="tg">点赞:0<Heart class="tc"></Heart></div>
      <div>评论:0<Comment class="tc"></Comment></div>
    </div>
  </div>
</template>

<script setup lang="ts" name="Tip">
import { Heart, Comment } from '@nutui/icons-vue'
</script>

<style scoped lang="scss">
.t1 {
  border: 1px solid black;
  width: 76%;
  height: 25vh;
  margin: auto;
  border-radius: 5px;
  padding: 10px;
  background-color: rgba(205, 205, 205, 0.9);
  backdrop-filter: blur(10px);
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  position: relative;
  .t2 {
    display: flex;
    align-items: center;
    .tp {
      width: 5%;
      height: 5%;
      border-radius: 50%;
      margin-bottom: 10px;
      .ti {
        width: 100%;
        height: 100%;
        border-radius: 50%;
      }
    }
    .content {
      display: flex;
      flex-direction: column;
      justify-content: center;
      margin-left: 10px;
      .tn {
        font-size: 25px;
        font-weight: 600;
      }
      .tt {
        font-size: 15px;
        color: #888;
      }
    }
  }
  .foot {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    position: absolute;
    bottom: 0;
    right: 5%;
    gap: 10px;
    .tg {
      .tc {
        margin-top: 3px;
      }
    }
  }
}
@media (max-width: 760px) {
  .t1 {
    width: 96%;
    height: 14vh;
    margin: 0 auto;
    background-color: rgba(205, 205, 205, 0.9);
    backdrop-filter: blur(10px);
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
    .t2 {
      display: flex;
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
      .content {
        display: flex;
        flex-direction: ROW;
        justify-content: center;
        margin-left: 10px;
        flex-direction: column;
        .tn {
          font-size: 15px;
          font-weight: 600;
        }
        .tt {
          font-size: 10px;
          color: #888;
        }
      }
    }
  }
}
</style>
