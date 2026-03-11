<template>
  <div class="main">
    <!-- 表单部分 -->
    <div class="centre form-section">
      <div class="top">课程添加</div>
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
        <el-form-item label="审核状态" prop="no">
          <el-select v-model="ruleForm.no" placeholder="请选择审核状态">
            <el-option label="未审核" value="0"></el-option>
            <el-option label="已通过" value="1"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="课程描述" prop="describe">
          <el-input type="textarea" v-model="ruleForm.describe" />
        </el-form-item>
        <el-form-item label="上课时间" prop="time">
          <el-input v-model="ruleForm.time" autocomplete="off" />
        </el-form-item>
        <el-form-item label="选课人数" prop="num">
          <el-input-number v-model="ruleForm.num" :min="0" />
        </el-form-item>
        <el-form-item label="教师ID" prop="teacher_id">
          <el-input v-model="ruleForm.teacher_id" autocomplete="off" />
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
import { ref, reactive } from 'vue'
import type { FormInstance, FormRules } from 'element-plus'
import { addCourse } from '../../api/admin'
import type { Course } from '../../type/Course'

const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive<Course>({
  id: '',
  name: '',
  no: '0', // 默认为未审核
  describe: '',
  time: '',
  num: 0,
  teacher_id: '',
})

const rules = reactive<FormRules>({
  name: [{ required: true, message: '请输入课程名称', trigger: 'blur' }],
  no: [{ required: true, message: '请选择审核状态', trigger: 'change' }],
  describe: [{ required: true, message: '请输入课程描述', trigger: 'blur' }],
  time: [{ required: true, message: '请输入上课时间', trigger: 'blur' }],
  num: [
    { required: true, message: '请输入选课人数', trigger: 'blur' },
    { type: 'number', message: '选课人数必须是数字' },
  ],
  teacher_id: [{ required: true, message: '请输入教师ID', trigger: 'blur' }],
})

async function submitForm(formEl: FormInstance | undefined) {
  if (!formEl) return

  const valid = await formEl.validate()
  if (valid) {
    try {
      await addCourse(ruleForm)
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
  display: flex;
  background-size: 400% 400%;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  color: white;
  text-align: center;
  animation: gradientBG 15s ease infinite;
  overflow: hidden;

  .centre {
    width: 90%;
    height: 90%;
    display: flex;
    background-color: rgb(255, 255, 255);
    justify-content: center;
    align-items: center;
    border-radius: 2%;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
  }
}
</style>
