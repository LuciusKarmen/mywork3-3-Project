<template>
  <div class="main">
    <div class="centre form-section">
      <div class="top">管理员添加</div>
      <el-form
        ref="ruleFormRef"
        style="max-width: 500px"
        :model="ruleForm"
        status-icon
        :rules="rules"
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item label="姓名" prop="name">
          <el-input v-model="ruleForm.name" placeholder="请输入管理员姓名" />
        </el-form-item>
        <el-form-item label="职位" prop="position">
          <el-input v-model="ruleForm.position" placeholder="例如：系统管理员、教务员等" />
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
import { ElMessage, type FormInstance, type FormRules } from 'element-plus'
import { addAdmin } from '../../api/admin'
import type { Admin } from '../../type/Admin'

const ruleFormRef = ref<FormInstance>()

// 注意：id 和 password 由后端或前端固定处理
const ruleForm = reactive<Omit<Admin, 'id' | 'password'>>({
  name: '',
  position: '',
})

const rules = reactive<FormRules>({
  name: [{ required: true, message: '请输入管理员姓名', trigger: 'blur' }],
  position: [{ required: true, message: '请输入职位', trigger: 'blur' }],
})

async function submitForm(formEl: FormInstance | undefined) {
  if (!formEl) return

  const valid = await formEl.validate()
  if (valid) {
    // 构造完整 Admin 对象，密码固定为 12345678
    const adminData: Admin = {
      id: '', // 后端生成
      name: ruleForm.name,
      position: ruleForm.position,
      password: '12345678',
    }

    try {
      await addAdmin(adminData)
      ElMessage.success('管理员添加成功！')
      resetForm(formEl)
    } catch (error) {
      ElMessage.error('添加失败，请重试')
      console.error('添加管理员失败:', error)
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
  background: linear-gradient(135deg, #e0f9ff, #f1f1f1);
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
  max-width: 600px;
  padding: 30px;
  background-color: #fff;
  border-radius: 12px;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
}

.top {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 24px;
  color: #6a5acd;
  text-align: center;
}
</style>
