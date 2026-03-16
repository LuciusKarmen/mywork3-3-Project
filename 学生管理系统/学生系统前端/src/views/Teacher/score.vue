<template>
  <div class="evaluation-page">
    <el-card class="form-card">
      <template #header>
        <h2 class="title">学生综合表现评分</h2>
      </template>

      <!-- 学生信息 -->
      <div class="student-info">
        <el-descriptions :column="1" size="small" border>
          <el-descriptions-item label="学号">{{ student.id }}</el-descriptions-item>
          <el-descriptions-item label="姓名">{{ student.name }}</el-descriptions-item>
          <el-descriptions-item label="班级">{{ student.className }}</el-descriptions-item>
          <el-descriptions-item label="课程">{{ student.courseName }}</el-descriptions-item>
        </el-descriptions>
      </div>

      <!-- 评分区域 -->
      <div class="score-section">
        <label class="label">综合表现评分（0 ~ 100 分）：</label>
        <div class="score-display">
          <span class="score-value">{{ score }} 分</span>
        </div>
        <el-slider
          v-model="score"
          :min="0"
          :max="100"
          :step="1"
          show-input
          show-input-controls
          style="margin-top: 12px"
        />
      </div>

      <!-- 评语 -->
      <div class="comment-section">
        <label class="label">综合评语（可选）：</label>
        <el-input
          v-model="comment"
          type="textarea"
          :rows="4"
          placeholder="请对学生的课堂参与、作业完成、学习态度等方面进行简要评价（最多300字）"
          maxlength="300"
          show-word-limit
          clearable
        />
      </div>

      <!-- 提交按钮 -->
      <div class="submit-section">
        <el-button type="primary" size="large" @click="handleSubmit" :loading="loading">
          提交评分
        </el-button>
      </div>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import { ElMessage } from 'element-plus'

// 模拟学生数据（实际项目中通过路由参数或 API 获取）
const student = {
  id: '20231001',
  name: '李明',
  className: '计算机科学与技术 2301 班',
  courseName: 'Web前端开发技术',
}

const score = ref<number>(85) // 默认 85 分
const comment = ref<string>('')
const loading = ref<boolean>(false)

const handleSubmit = () => {
  if (score.value < 0 || score.value > 100) {
    ElMessage.warning('评分必须在 0 ~ 100 之间')
    return
  }

  loading.value = true

  // 模拟提交
  setTimeout(() => {
    ElMessage.success(`已成功为【${student.name}】提交综合评分：${score.value} 分`)
    console.log('提交数据:', {
      studentId: student.id,
      score: score.value,
      comment: comment.value.trim() || '无',
    })
    loading.value = false
    // 真实场景：await api.submitStudentEvaluation(...)
  }, 600)
}
</script>

<style scoped lang="scss">
.evaluation-page {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  background: linear-gradient(135deg, #f9f7fe 0%, #eef5ff 100%);
  padding: 20px;
  box-sizing: border-box;
}

.form-card {
  width: 100%;
  max-width: 650px;
  border-radius: 14px;
  box-shadow: 0 8px 24px rgba(0, 0, 0, 0.12);

  .title {
    margin: 0;
    font-size: 22px;
    color: #2c3e8f;
    text-align: center;
    font-weight: 600;
  }
}

.student-info {
  margin: 24px 0;
}

.label {
  display: block;
  margin: 20px 0 10px;
  font-weight: bold;
  color: #2d3748;
  font-size: 15px;
}

.score-section {
  .score-display {
    text-align: center;
    margin-top: 8px;

    .score-value {
      font-size: 28px;
      font-weight: bold;
      color: #409eff;
    }
  }
}

.comment-section {
  margin: 24px 0;
}

.submit-section {
  text-align: center;
  margin-top: 16px;
}
</style>
