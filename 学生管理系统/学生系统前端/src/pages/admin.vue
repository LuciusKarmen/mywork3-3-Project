<template>
  <div class="main-layout">
    <!-- 顶部 -->
    <div class="top-bar">
      <div class="logo" @click="close">
        <el-popover title="登出" content="即将返回登录界面" placement="left-end" color="#fff">
          <template #reference>
            <img src="../assets/退出.png" alt="退出" />
          </template>
        </el-popover>
      </div>
    </div>

    <!-- 主体：左侧菜单 + 右侧内容 -->
    <div class="content-container">
      <!-- 左侧菜单 -->
      <div class="sidebar">
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
              <el-menu-item index="1-1" @click="router.push('/admin/studentList')"
                >学生列表</el-menu-item
              >
              <el-menu-item index="1-2" @click="router.push('/admin/studentAdd')"
                >添加学生</el-menu-item
              >
            </el-menu-item-group>
          </el-sub-menu>
          <el-sub-menu index="2">
            <template #title>
              <el-icon><UserFilled /></el-icon>
              <span>教师管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="2-1" @click="router.push('/admin/teacherList')"
                >教师列表</el-menu-item
              >
              <el-menu-item index="2-2" @click="router.push('/admin/teacherAdd')"
                >添加老师</el-menu-item
              >
            </el-menu-item-group>
          </el-sub-menu>
          <el-sub-menu index="3">
            <template #title>
              <el-icon><Location /></el-icon>
              <span>课程管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="3-1" @click="router.push('/admin/courseList')"
                >课程列表</el-menu-item
              >
              <el-menu-item index="3-2" @click="router.push('/admin/agree')">申请列表</el-menu-item>
            </el-menu-item-group>
          </el-sub-menu>
          <el-sub-menu index="4">
            <template #title>
              <el-icon><Avatar /></el-icon>
              <span>管理员管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="4-1" @click="router.push('/admin/adminList')"
                >管理员列表</el-menu-item
              >
              <el-menu-item index="4-2" @click="router.push('/admin/adminAdd')"
                >添加管理员</el-menu-item
              >
            </el-menu-item-group>
          </el-sub-menu>
          <el-sub-menu index="5">
            <template #title>
              <el-icon><Setting /></el-icon>
              <span>系统信息</span>
            </template>
            <el-menu-item index="5-1" @click="router.push('/our')">关于我们</el-menu-item>
          </el-sub-menu>
        </el-menu>
      </div>

      <!-- 右侧内容区 -->
      <div class="main-content">
        <router-view />
      </div>
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
// 确保 html 和 body 占满全屏
html,
body {
  height: 100%;
  margin: 0;
  padding: 0;
  overflow: hidden; // 防止 body 出现滚动条
}

.main-layout {
  display: flex;
  flex-direction: column;
  height: 100vh; // 使用 vh 更可靠
  width: 100vw;
}

.top-bar {
  height: 8vh;
  background-color: #494949;
  display: flex;
  justify-content: flex-end;
  align-items: center;
  padding-right: 16px;
  flex-shrink: 0; // 不可压缩

  .logo {
    height: 6vh;
    cursor: pointer;
    img {
      width: 100%;
      height: 100%;
      object-fit: contain;
    }
  }
}

.content-container {
  display: flex;
  flex: 1; // 占据剩余全部空间
  overflow: hidden; // 防止内部滚动
}

.sidebar {
  width: 18vw;
  background-color: #545c64;
  height: 100%;

  :deep(.el-menu) {
    border-right: none;
    height: 100%;
  }
}

.main-content {
  flex: 1;
  overflow: auto; // 允许右侧内容滚动
  background-color: #f5f7fa; // 可选：加个背景色区分
}
</style>
