<template>
  <div class="main">
    <div class="top">
      <div class="logo" @click="close">
        <el-popover title="登出" content="即将返回登录界面" placement="left-end" color="#fff">
          <template #reference>
            <img src="../assets/退出.png" alt="" />
          </template>
        </el-popover>
      </div>
    </div>
    <div class="left">
      <el-row class="tac">
        <el-col :span="24">
          <el-menu
            active-text-color="#ffd04b"
            background-color="#545c64"
            class="el-menu-vertical-demo"
            default-active="2"
            text-color="#fff"
            @open="handleOpen"
            @close="handleClose"
          >
            <el-sub-menu index="1">
              <template #title>
                <el-icon><Avatar /></el-icon>
                <span>学生管理</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="1-1" @click="router.push('/teacher/score')"
                  >学生成绩录入</el-menu-item
                >
              </el-menu-item-group>
            </el-sub-menu>
            <el-sub-menu index="2">
              <template #title>
                <el-icon><UserFilled /></el-icon>
                <span>课程管理</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="2-1" @click="router.push('/teacher/c_list')"
                  >课程列表</el-menu-item
                >
                <el-menu-item index="2-2" @click="router.push('/teacher/c_add')"
                  >添加课程</el-menu-item
                >
              </el-menu-item-group>
            </el-sub-menu>
            <el-sub-menu index="3">
              <template #title>
                <el-icon><Location /></el-icon>
                <span>教师助手</span>
              </template>
              <el-menu-item-group>
                <el-menu-item index="3-1">工资查询</el-menu-item>
              </el-menu-item-group>
            </el-sub-menu>
            <el-sub-menu index="4">
              <template #title>
                <el-icon><Setting /></el-icon>
                <span>系统信息</span>
              </template>

              <el-menu-item index="4-1" @click="router.push('/our')">关于我们</el-menu-item>
            </el-sub-menu>
          </el-menu>
        </el-col>
      </el-row>
    </div>
    <div class="right">
      <router-view></router-view>
    </div>
  </div>
</template>
<script lang="ts" setup>
import { useRouter } from 'vue-router'
import { Location, Setting, Avatar, UserFilled } from '@element-plus/icons-vue'

const router = useRouter()

const handleOpen = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const handleClose = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}
const close = () => {
  router.push('/')
}
</script>
<style lang="scss" scoped>
.main {
  width: 100vw;
  height: 100vh;
  background-color: #ffffff;

  .top {
    width: 100%;
    height: 8vh;
    background-color: #494949;
    display: flex;
    justify-content: flex-end;
    align-items: center;
    .logo {
      height: 6vh;
      img {
        width: 100%;
        height: 100%;
      }
    }
  }

  .left {
    width: 18vw;
    height: 92vh;
    background-color: #545c64;
    position: absolute;
    top: 8vh;
    left: 0;

    .el-menu {
      height: 100%;
      border-right: none;
    }
  }

  .right {
    position: absolute;
    left: 18vw;
    top: 8vh;
    width: calc(100vw - 18vw);
    height: 92vh;
    padding: 20px;
    box-sizing: border-box;
  }
}
</style>
