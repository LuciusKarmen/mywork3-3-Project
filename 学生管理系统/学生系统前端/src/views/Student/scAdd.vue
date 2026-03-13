<template>
  <div class="main">
    <div class="centre">
      <h2 class="title">可选课程列表</h2>
      <div class="table-container">
        <el-table :data="pagedData" style="width: 100%" border v-loading="loading">
          <el-table-column prop="id" label="课程ID" width="180" show-overflow-tooltip />
          <el-table-column prop="name" label="课程名称" width="150" />
          <el-table-column label="课程描述" width="200">
            <template #default="{ row }">
              {{ row.ddd || '暂无描述' }}
            </template>
          </el-table-column>
          <el-table-column prop="time" label="上课时间" width="200" />
          <el-table-column label="当前人数" width="100">
            <template #default="{ row }">
              {{ row.num ?? 0 }}
            </template>
          </el-table-column>
          <el-table-column prop="teacherId" label="教师ID" width="120" />
          <el-table-column label="操作" width="120" fixed="right">
            <template #default="{ row }">
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
import { selectCourse, queryno } from '@/api/student'
import type { Course } from '@/type/Course'

const router = useRouter()
const availableCourseList = ref<Course[]>([])
const loading = ref(false)
const currentPage = ref(1)
const pageSize = ref(10)

const pagedData = computed(() => {
  const start = (currentPage.value - 1) * pageSize.value
  return availableCourseList.value.slice(start, start + pageSize.value)
})

const handleSizeChange = (val: number) => {
  pageSize.value = val
  currentPage.value = 1
}

const handleCurrentChange = (val: number) => {
  currentPage.value = val
}

const getStudentId = () => localStorage.getItem('studentId')

const handleSelect = async (courseId: string) => {
  const studentId = getStudentId()
  if (!studentId) {
    ElMessage.error('请先登录')
    router.push('/login')
    return
  }

  try {
    await selectCourse({ id: '', no: '1', studentId, courseId })
    ElMessage.success('选课成功')
    fetchAvailableCourses()
  } catch {
    ElMessage.error('选课失败')
  }
}

const fetchAvailableCourses = async () => {
  const studentId = getStudentId()
  if (!studentId) {
    router.push('/login')
    return
  }

  loading.value = true
  try {
    const res = await queryno(studentId)
    // 确保是数组
    availableCourseList.value = Array.isArray(res) ? res : []
  } catch (err) {
    console.error('加载失败:', err)
    ElMessage.error('加载课程失败')
    availableCourseList.value = []
  } finally {
    loading.value = false
  }
}

onMounted(() => {
  fetchAvailableCourses()
})
</script>

<style scoped lang="scss">
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
  width: 95%;
  max-width: 1200px;
  height: 90%;
  display: flex;
  flex-direction: column;
  background-color: #fff;
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
