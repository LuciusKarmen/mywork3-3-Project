<template>
  <div class="main">
    <!-- 表单部分 -->
    <div class="centre form-section">
      <div class="top">学生添加</div>
      <el-form
        ref="ruleFormRef"
        style="max-width: 600px"
        :model="ruleForm"
        status-icon
        :rules="rules"
        label-width="auto"
        class="demo-ruleForm"
      >
        <el-form-item label="学生姓名" prop="name">
          <el-input v-model="ruleForm.name" autocomplete="off" />
        </el-form-item>
        <el-form-item label="年龄" prop="age">
          <el-input v-model.number="ruleForm.age" />
        </el-form-item>
        <el-form-item label="性别" prop="sex">
          <el-radio-group v-model="ruleForm.sex">
            <el-radio label="男">男</el-radio>
            <el-radio label="女">女</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="电话" prop="phone">
          <el-input v-model="ruleForm.phone" autocomplete="off" />
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="ruleForm.email" autocomplete="off" />
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

const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive({
  name: '',
  age: '',
  sex: '男', // 默认值为男
  phone: '',
  email: '',
})

// 在提交时自动生成password
function generatePassword(phone: string) {
  return phone
}

const rules = reactive<FormRules>({
  name: [{ required: true, message: '请输入学生姓名', trigger: 'blur' }],
  age: [
    { required: true, message: '请输入年龄', trigger: 'blur' },
    { type: 'number', message: '年龄必须是数字' },
  ],
  phone: [{ required: true, message: '请输入电话号码', trigger: 'blur' }],
})

function submitForm(formEl: FormInstance | undefined) {
  if (!formEl) return
  formEl.validate((valid) => {
    if (valid) {
      const password = generatePassword(ruleForm.phone)
      console.log('表单数据:', { ...ruleForm, password })
    } else {
      console.log('error submit!')
      return false
    }
  })
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
