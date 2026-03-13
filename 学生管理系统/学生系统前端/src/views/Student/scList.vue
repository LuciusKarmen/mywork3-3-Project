<template>
  <div class="main">
    <div class="centre">
      <h2 class="title">我的已选课程</h2>
      <div class="table-container">
        <el-table :data="pagedData" style="width: 100%" border v-loading="loading">
          <el-table-column prop="id" label="课程ID" width="120" />
          <el-table-column prop="name" label="课程名称" width="150" />
          <el-table-column prop="no" label="审核状态" width="100">
            <template #default="{ row }">
              <el-tag :type="row.no === '1' ? 'success' : 'warning'">
                {{ row.no === '1' ? '已通过' : '未审核' }}
              </el-tag>
            </template>
          </el-table-column>
          <el-table-column prop="describe" label="课程描述" />
          <el-table-column prop="time" label="上课时间" width="150" />
          <el-table-column prop="num" label="选课人数" width="100" />
          <el-table-column prop="teacherId" label="教师ID" width="120" />
        </el-table>

        <el-pagination
          v-if="!loading && myCourses.length > 0"
          v-model:current-page="currentPage"
          v-model:page-size="pageSize"
          :total="myCourses.length"
          layout="total, sizes, prev, pager, next, jumper"
          :page-sizes="[5, 10, 20]"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          class="pagination"
        />

        <div v-else-if="!loading && myCourses.length === 0" class="empty-tip">暂无已选课程</div>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, computed, onMounted } from 'vue'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'
import { queryByStudentId } from '../../api/student'
import type { Course } from '../../type/Course'

const router = useRouter()
const myCourses = ref<Course[]>([])
const loading = ref(false)

const currentPage = ref(1)
const pageSize = ref(10)

const pagedData = computed(() => {
  const start = (currentPage.value - 1) * pageSize.value
  return myCourses.value.slice(start, start + pageSize.value)
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

const fetchMyCourses = async () => {
  const studentId = getStudentId()
  if (!studentId) {
    ElMessage.warning('请先登录')
    router.push('/login')
    return
  }

  loading.value = true
  try {
    // 调用 GET /sc/queryByStudentId?studentId=xxx
    const res = await queryByStudentId(studentId)
    myCourses.value = Array.isArray(res) ? res : []
  } catch (err: any) {
    console.error('获取我的课程失败:', err)
    ElMessage.error('加载课程失败，请重试')
    myCourses.value = []
  } finally {
    loading.value = false
  }
}

onMounted(() => {
  fetchMyCourses()
})
</script>

<style scoped lang="scss">
.main {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background: linear-gradient(135deg, rgb(240, 249, 255), rgb(248, 248, 255));
  background-size: 400% 400%;
  animation: gradientBG 15s ease infinite;
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
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
  padding: 24px;
  box-sizing: border-box;
}

.title {
  margin-bottom: 20px;
  font-size: 24px;
  color: #1a73e8;
  font-weight: 600;
}

.table-container {
  width: 100%;
  height: calc(100% - 60px);
  display: flex;
  flex-direction: column;
  position: relative;

  .el-table {
    flex: 1;
    width: 100%;
  }

  .pagination {
    display: flex;
    justify-content: flex-end;
    margin-top: 16px;
  }

  .empty-tip {
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    color: #999;
    font-size: 16px;
  }
}
</style>
