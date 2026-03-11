<template>
  <div class="main">
    <div class="centre">
      <h2 class="title">可选课程列表</h2>
      <div class="table-container">
        <el-table :data="pagedData" style="width: 100%" border v-loading="loading">
          <el-table-column prop="id" label="课程ID" width="120" />
          <el-table-column prop="name" label="课程名称" width="150" />
          <el-table-column prop="describe" label="课程描述" />
          <el-table-column prop="time" label="上课时间" width="150" />
          <el-table-column prop="num" label="当前人数" width="100" />
          <el-table-column prop="teacherId" label="教师ID" width="120" />
          <el-table-column label="操作" width="120" fixed="right">
            <template #default="{ row }">
              <!-- 只有审核通过（no === '1'）才显示可点击按钮 -->
              <el-button size="small" type="primary" @click="handleSelect(row.id)">
                选课
              </el-button>
            </template>
          </el-table-column>
        </el-table>

        <el-pagination
          v-if="!loading"
          v-model:current-page="currentPage"
          v-model:page-size="pageSize"
          :total="availableCourseList.length"
          layout="total, sizes, prev, pager, next, jumper"
          :page-sizes="[5, 10, 20]"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          class="pagination"
        />
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, computed, onMounted } from 'vue'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'
import { getAvailableCourses, selectCourse } from '../../api/student'
import type { Course } from '../../type/Course'

const router = useRouter()
const availableCourseList = ref<Course[]>([])
const loading = ref(false)

const currentPage = ref(1)
const pageSize = ref(10)

// 仅显示已审核课程（no === '1'）
const filteredCourses = computed(() => {
  return availableCourseList.value.filter((course) => course.no === '1')
})

const pagedData = computed(() => {
  const start = (currentPage.value - 1) * pageSize.value
  return filteredCourses.value.slice(start, start + pageSize.value)
})

const handleSizeChange = (val: number) => {
  pageSize.value = val
  currentPage.value = 1
}

const handleCurrentChange = (val: number) => {
  currentPage.value = val
}

const getStudentId = (): string | null => {
  return localStorage.getItem('studentId')
}

const handleSelect = async (courseId: string) => {
  const studentId = getStudentId()
  if (!studentId) {
    ElMessage.error('未检测到学生身份，请重新登录')
    router.push('/login')
    return
  }

  try {
    await selectCourse({ studentId, courseId })
    ElMessage.success('选课成功！')
    // 可选：刷新列表（或减少人数等）
    fetchAvailableCourses()
  } catch (err: any) {
    ElMessage.error(err.message || '选课失败，请稍后重试')
  }
}

const fetchAvailableCourses = async () => {
  loading.value = true
  try {
    const res = await getAvailableCourses()
    availableCourseList.value = Array.isArray(res) ? res : []
  } catch (err) {
    console.error('获取可选课程失败:', err)
    availableCourseList.value = []
    ElMessage.error('加载课程失败')
  } finally {
    loading.value = false
  }
}

onMounted(() => {
  const studentId = getStudentId()
  if (!studentId) {
    ElMessage.warning('请先登录')
    router.push('/login')
    return
  }
  fetchAvailableCourses()
})
</script>

<style scoped lang="scss">
/* 样式保持不变，复用你原有的渐变风格 */
.main {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background: linear-gradient(135deg, rgb(250, 245, 255), rgb(240, 248, 255));
  background-size: 400% 400%;
  animation: gradientBG 18s ease infinite;
  overflow: hidden;
}

@keyframes gradientBG {
  0% {
    background-position: 0% 50%;
  }
  50% {
    background-position: 100% 50%;
  }
  100% {
    background-position: 0% 50%;
  }
}

.centre {
  width: 90%;
  height: 90%;
  display: flex;
  flex-direction: column;
  background-color: #ffffff;
  justify-content: flex-start;
  align-items: center;
  border-radius: 12px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.12);
  padding: 24px;
  box-sizing: border-box;
}

.title {
  margin-bottom: 20px;
  font-size: 24px;
  color: #6a5acd;
  font-weight: 600;
}

.table-container {
  width: 100%;
  height: calc(100% - 60px);
  display: flex;
  flex-direction: column;

  .el-table {
    flex: 1;
    width: 100%;
  }

  .pagination {
    display: flex;
    justify-content: flex-end;
    margin-top: 16px;
  }
}
</style>
