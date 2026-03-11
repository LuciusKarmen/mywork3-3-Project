<template>
  <div class="main">
    <div class="centre form-section">
      <div class="top">课程添加申请</div>
      <el-form
        ref="ruleFormRef"
        style="max-width: 600px"
        :model="ruleForm"
        status-icon
        :rules="rules"
        label-width="auto"
        class="demo-ruleForm"
      >
        <el-form-item label="课程名称" prop="name">
          <el-input v-model="ruleForm.name" autocomplete="off" />
        </el-form-item>

        <el-form-item label="课程描述" prop="describe">
          <el-input type="textarea" v-model="ruleForm.describe" />
        </el-form-item>

        <!-- 学年学期 -->
        <el-form-item label="学年学期" required>
          <el-row :gutter="10">
            <el-col :span="6">
              <el-input-number
                v-model="timeConfig.startYear"
                :min="2000"
                :max="2100"
                placeholder="起始年"
              />
            </el-col>
            <el-col :span="2" style="display: flex; align-items: center; justify-content: center"
              >-</el-col
            >
            <el-col :span="8">
              <el-input-number
                v-model="timeConfig.endYear"
                :min="2000"
                :max="2100"
                placeholder="结束年"
              />
            </el-col>
            <el-col :span="6">
              <el-select v-model="timeConfig.term" placeholder="学期">
                <el-option label="第1学期" value="1" />
                <el-option label="第2学期" value="2" />
              </el-select>
            </el-col>
          </el-row>
        </el-form-item>

        <!-- 星期 -->
        <el-form-item label="星期" prop="weekday">
          <el-select v-model="timeConfig.weekday" placeholder="请选择星期">
            <el-option label="周一" value="周一" />
            <el-option label="周二" value="周二" />
            <el-option label="周三" value="周三" />
            <el-option label="周四" value="周四" />
            <el-option label="周五" value="周五" />
            <el-option label="周六" value="周六" />
            <el-option label="周日" value="周日" />
          </el-select>
        </el-form-item>

        <!-- 上课时间段 -->
        <el-form-item label="上课时间" required>
          <el-time-picker
            v-model="timeConfig.startTime"
            format="HH:mm"
            value-format="HH:mm"
            placeholder="开始时间"
            :picker-options="{ selectableRange: '08:00:00 - 20:00:00' }"
            style="width: 45%"
            :clearable="false"
          />
          <span style="margin: 0 10px">至</span>
          <el-time-picker
            v-model="timeConfig.endTime"
            format="HH:mm"
            value-format="HH:mm"
            placeholder="结束时间"
            :clearable="false"
            :picker-options="{ selectableRange: '08:00:00 - 20:00:00' }"
            style="width: 45%"
          />
        </el-form-item>

        <el-form-item label="最大人数" prop="num">
          <el-input-number v-model="ruleForm.num" :min="1" :max="100" />
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="submitForm(ruleFormRef)">提交</el-button>
          <el-button @click="resetForm(ruleFormRef)">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script setup lang="ts">
import { ref, reactive, watch } from 'vue'
import type { FormInstance, FormRules } from 'element-plus'
import { addCourse } from '../../api/teacher'
import type { Course } from '../../type/Course'

const ruleFormRef = ref<FormInstance>()

// 从 localStorage 获取 teacherId
const teacherId = localStorage.getItem('teacherId') || ''

// 表单数据（不含 time 字段，由 timeConfig 拼接）
const ruleForm = reactive<Omit<Course, 'time'> & { time?: string }>({
  id: '',
  name: '',
  no: '0',
  describe: '',
  num: 1,
  teacherId: teacherId,
})

// 时间配置（用于 UI 控制）
const timeConfig = reactive({
  startYear: new Date().getFullYear(),
  endYear: new Date().getFullYear() + 1,
  term: '2', // 默认第2学期
  weekday: '周一',
  startTime: '08:00',
  endTime: '09:40',
})

// 监听 timeConfig 变化，自动拼接 time 字符串
watch(
  () => ({ ...timeConfig }),
  () => {
    const { startYear, endYear, term, weekday, startTime, endTime } = timeConfig
    ruleForm.time = `${startYear}-${endYear}-${term} 每${weekday} ${startTime}-${endTime}`
  },
  { immediate: true },
)

// 表单验证规则（time 不再直接验证，由子字段保证）
const rules = reactive<FormRules>({
  name: [{ required: true, message: '请输入课程名称', trigger: 'blur' }],
  describe: [{ required: true, message: '请输入课程描述', trigger: 'blur' }],
  num: [
    { required: true, message: '请输入最大人数', trigger: 'change' },
    { type: 'number', min: 1, max: 100, message: '人数必须在1到100之间' },
  ],
})

async function submitForm(formEl: FormInstance | undefined) {
  if (!formEl) return

  // 手动触发 timeConfig 相关字段的验证（可选）
  const valid = await formEl.validate()
  if (valid) {
    try {
      // 确保 time 已生成
      if (!ruleForm.time) {
        alert('上课时间格式错误')
        return
      }

      await addCourse(ruleForm as Course)
      alert('课程添加成功！')
      resetForm(formEl)
    } catch (error) {
      alert('添加失败，请重试')
      console.error('添加课程失败:', error)
    }
  }
}

function resetForm(formEl: FormInstance | undefined) {
  if (!formEl) return
  formEl.resetFields()
  Object.assign(timeConfig, {
    startYear: new Date().getFullYear(),
    endYear: new Date().getFullYear() + 1,
    term: '2',
    weekday: '周一',
    startTime: '08:00',
    endTime: '09:40',
  })
}
</script>

<style scoped lang="scss">
.main {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  background: linear-gradient(135deg, rgb(224, 249, 255), rgb(241, 241, 241));
  background-size: 400% 400%;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  text-align: center;
  animation: gradientBG 15s ease infinite;
  overflow: hidden;

  .centre {
    width: 90%;
    max-width: 700px;
    height: 90%;
    background-color: rgb(255, 255, 255);
    border-radius: 16px;
    box-shadow: 0 0 15px rgba(0, 0, 0, 0.3);
    padding: 30px;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: center;
    overflow-y: auto;
  }

  .top {
    font-size: 26px;
    font-weight: bold;
    margin-bottom: 25px;
    color: #1d3b6f;
  }

  :deep(.el-form-item__label) {
    font-weight: 600;
  }
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
</style>
