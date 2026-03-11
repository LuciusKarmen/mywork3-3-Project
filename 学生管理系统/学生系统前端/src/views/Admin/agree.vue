<template>
  <div class="review-main">
    <h2 class="title">课程审核中心</h2>
    <div class="table-container">
      <el-table :data="pendingCourses" border style="width: 100%">
        <el-table-column prop="id" label="课程ID" width="120" />
        <el-table-column prop="name" label="课程名称" width="150" />
        <el-table-column prop="describe" label="课程描述" min-width="200" />
        <el-table-column prop="time" label="上课时间" width="150" />
        <el-table-column prop="num" label="选课人数" width="100" />
        <el-table-column prop="teacher_id" label="教师ID" width="120" />

        <el-table-column label="操作" width="180" fixed="right">
          <template #default="{ row }">
            <el-button
              type="success"
              size="small"
              @click="handleAgree(row)"
              :loading="agreeLoading[row.id]"
            >
              通过
            </el-button>
            <!-- 可选：拒绝按钮（如果后端支持） -->
            <!--
            <el-button
              type="danger"
              size="small"
              @click="handleReject(row)"
              :loading="rejectLoading[row.id]"
            >
              拒绝
            </el-button>
            -->
          </template>
        </el-table-column>
      </el-table>

      <!-- 空状态提示 -->
      <el-empty
        v-if="pendingCourses.length === 0 && !loading"
        description="暂无待审核课程"
        style="margin-top: 40px"
      />
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { ElMessage, ElMessageBox } from 'element-plus'
import { getCourseList, agreeCourse } from '../../api/admin'
import type { Course } from '../../type/Course'

const loading = ref(false)
const pendingCourses = ref<Course[]>([])

// 加载状态映射（按课程ID）
const agreeLoading = ref<Record<string, boolean>>({})

// 获取待审核课程
const fetchPendingCourses = () => {
  loading.value = true
  getCourseList()
    .then((res) => {
      // 过滤出 no === '0' 的课程（未审核）
      pendingCourses.value = Array.isArray(res) ? res.filter((course) => course.no === '0') : []
    })
    .catch((err) => {
      console.error('获取待审核课程失败:', err)
      ElMessage.error('获取课程列表失败')
      pendingCourses.value = []
    })
    .finally(() => {
      loading.value = false
    })
}

// 审核通过
const handleAgree = async (course: Course) => {
  try {
    agreeLoading.value[course.id] = true

    // 调用审核接口（只传课程ID更合理）
    await agreeCourse(course.id)

    ElMessage.success('课程审核通过！')

    // 从列表中移除已审核课程（或刷新）
    pendingCourses.value = pendingCourses.value.filter((c) => c.id !== course.id)
  } catch (err) {
    console.error('审核失败:', err)
    ElMessage.error('审核失败，请重试')
  } finally {
    agreeLoading.value[course.id] = false
  }
}

onMounted(() => {
  fetchPendingCourses()
})
</script>

<style scoped lang="scss">
.review-main {
  padding: 24px;
  background-color: #f5f7fa;
  min-height: 100%;
}

.title {
  text-align: center;
  margin-bottom: 24px;
  color: #1d3f7f;
  font-size: 24px;
  font-weight: 600;
}

.table-container {
  background: #ffffff;
  border-radius: 8px;
  box-shadow: 0 2px 12px rgba(0, 0, 0, 0.08);
  padding: 20px;
}
</style>
