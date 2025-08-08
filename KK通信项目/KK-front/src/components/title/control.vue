<template>
  <div class="control">
    <div class="title">
      <h4>好友申请</h4>
    </div>
    <div class="content">
      <div v-for="item in ApplyUserList" :key="item.id" class="apply-item">
        <div class="apply-item-top">
          <div class="apply-item-left">
            <img :src="`http://localhost:8080/${item.pic}`" alt="" />
          </div>
          <div class="apply-item-right">
            <div class="text1">{{ item.username }}</div>
            <div class="text">向您发送了一则好友请求</div>
          </div>
        </div>
        <div class="apply-item-button">
          <el-button type="warning" @click="reject(item.id)">拒绝</el-button>
          <el-button type="success" @click="accept(item.id)">同意</el-button>
        </div>
      </div>
    </div>

    <div class="title"><h4>系统消息</h4></div>
  </div>
</template>
<script lang="ts" setup name="">
import { onMounted, ref } from 'vue'
import { getFriendRequests, getFriendInfo, updateFriendRequest } from '../../api/main/add'
import type { Friends } from '@/types/friends'
import type { User } from '@/types/user'

const ApplyID = ref([])
const ApplyUserList = ref<User[]>([])
const applyList = ref<Friends[]>()
const accept = (id: string) => {
  updateFriendRequest(id, 'accepted').then(() => {
    console.log('accepted')
    alert('已同意')
  })
}
const reject = (id: string) => {
  updateFriendRequest(id, 'reject').then(() => {
    console.log('reject')
    alert('已拒绝')
  })
}
onMounted(() => {
  const userid = localStorage.getItem('userid') || ''
  getFriendRequests(userid).then((res) => {
    console.log(res)
    ApplyID.value = res.map((item) => item.user_id)
    console.log('刷了' + ApplyID.value)
    ApplyID.value.forEach((item) => {
      getFriendInfo(item).then((res) => {
        ApplyUserList.value.push(res)
      })
    })
    console.log(ApplyUserList.value)

    applyList.value = res
  })
})
</script>
<style lang="scss" scoped>
.control {
  width: 100%;
  height: 100%;
  background: rgb(251, 236, 236);
  .title {
    height: 6vh;
    width: 100%;
    background: rgb(255, 255, 255);
    display: flex;
    align-items: center;
    border-bottom: 1px solid rgb(158, 158, 158);
  }
  .content {
    width: 100%;
    .apply-item {
      display: flex;
      align-items: center;
      flex-direction: column;
      height: 14vh;
      background: wheat;
      .apply-item-button {
        width: 100%;
        height: 2vh;
        display: flex;
        justify-content: space-between;
      }
      .apply-item-top {
        width: 100%;
        display: flex;
        justify-content: space-between;
        .apply-item-left {
          padding: 1vh;
          width: 20%;
          height: 100%;
          display: flex;
          align-items: center;
          justify-content: center;
          img {
            width: 6vh;
            height: 6vh;
          }
        }
        .apply-item-right {
          width: 80%;
          display: flex;
          flex-direction: column;
          .text {
            font-size: 2vh;
            color: #333;
            font-weight: 500;
          }
          .text1 {
            font-size: 3vh;
            color: #0f0f0f;
            font-weight: 600;
          }
        }
      }
    }
  }
}
</style>
