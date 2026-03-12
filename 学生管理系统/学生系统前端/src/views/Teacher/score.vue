<template>
  <div class="main">
    <div class="centre">
      <h2 class="title">课程成绩管理 - {{ courseName }}</h2>
      <div class="table-container">
        <el-table :data="scoreList" border>
          <el-table-column prop="studentId" label="学号" width="150" />
          <!-- 如果有学生姓名，可加一列 -->
          <el-table-column label="成绩" width="180">
            <template #default="{ row, $index }">
              <el-input-number
                v-model="row.score"
                :min="0"
                :max="100"
                controls-position="right"
                placeholder="请输入成绩"
                style="width: 120px"
                @change="handleScoreChange(row)"
              />
              <el-button
                size="small"
                type="primary"
                @click="saveScore(row)"
                :loading="savingIndex === $index"
                style="margin-left: 8px"
              >
                保存
              </el-button>
            </template>
          </el-table-column>
        </el-table>
      </div>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue'
import { ElMessage } from 'element-plus'
import { useRoute } from 'vue-router'
import { getCourseStudents, submitScore } from '@/api/teacher'
import type { StudentCourse } from '@/types/StudentCourse'

const route = useRoute()
const courseId = route.query.courseId as string
const courseName = route.query.courseName as string
const teacherId = localStorage.getItem('teacherId') // 假设老师 ID 也在 localStorage

const scoreList = ref<StudentCourse[]>([])
const savingIndex = ref<number | null>(null)

const fetchStudents = async () => {
  if (!teacherId) {
    ElMessage.error('请先登录')
    return
  }
  try {
    const res = await getCourseStudents({ courseId, teacherId })
    scoreList.value = res.map((item) => ({
      ...item,
      score: item.score ?? null, // 确保 null 显示为空
    }))
  } catch (err) {
    ElMessage.error('加载学生列表失败')
  }
}

const saveScore = async (row: StudentCourse) => {
  if (row.score === null || row.score === undefined) {
    ElMessage.warning('请输入有效成绩')
    return
  }
  const index = scoreList.value.findIndex((r) => r.studentId === row.studentId)
  savingIndex.value = index

  try {
    await submitScore({
      studentId: row.studentId,
      courseId,
      score: row.score.toString(),
    })
    ElMessage.success('成绩保存成功')
  } catch (err: any) {
    ElMessage.error(err.message || '保存失败')
  } finally {
    savingIndex.value = null
  }
}

// 实时校验（可选）
const handleScoreChange = (row: StudentCourse) => {
  if (row.score !== null && (row.score < 0 || row.score > 100)) {
    ElMessage.warning('成绩范围为 0~100')
  }
}

onMounted(() => {
  if (!courseId) {
    ElMessage.error('缺少课程ID')
    return
  }
  fetchStudents()
})
</script>

<style scoped lang="scss">
.main {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background: linear-gradient(135deg, #f0f9ff, #f8f8ff);
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
  color: #d32f2f;
  font-weight: 600;
}

.table-container {
  width: 100%;
  .el-table {
    width: 100%;
  }
}
</style>
