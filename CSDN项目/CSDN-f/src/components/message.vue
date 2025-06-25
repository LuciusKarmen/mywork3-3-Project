<template>
  <div class="t1">
    <div class="t2">
      <div class="tp"><img src="../pic/KK.png" alt="" class="ti" /></div>
      <div class="content">
        <div class="tn">xgm</div>
        <div class="tt">2025.6.16</div>
      </div>
    </div>
    <div class="tc">Hello,world!</div>
    <div class="ok" v-show="ok" @click="OK"></div>
  </div>
</template>

<script setup lang="ts" name="Tip">
import { Heart, Comment } from '@nutui/icons-vue'
import { ref, reactive, toRefs, watch, onMounted } from 'vue'
import { type Message } from '../api/message'

const props = defineProps<{
  tip: Message
}>()

const ok = ref(false)
const OK = () => {
  ok.value = !ok.value
}
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
  .ok {
    background-color: red;
    width: 2px;
    height: 2px;
    position: absolute;
    right: 5%;
    top: 5%;
    border-radius: 50%;
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
<!-- mid: string
  mname: string //这里的mname是回复的帖子的id(tid)不然后面人看不懂
  mget: string
  msend: string
  mtime: string
  mcontent: string
  mread: boolean
  mtipid: string -->
