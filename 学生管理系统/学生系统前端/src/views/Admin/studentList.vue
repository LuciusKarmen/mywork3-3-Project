<template>
  <div class="main">
    <div class="centre">
      <div class="table-container">
        <el-table :data="pagedData" style="width: 100%" border>
          <el-table-column prop="name" label="姓名" width="100" />
          <el-table-column prop="sex" label="性别" width="80" />
          <el-table-column prop="age" label="年龄" width="80" />
          <el-table-column prop="phone" label="手机号" width="120" />
          <el-table-column prop="email" label="邮箱" width="120" />

          <!-- 操作列 -->
          <el-table-column label="操作" width="120" fixed="right">
            <template #default="scope">
              <el-button size="small" type="danger" @click="handleDelete(scope.row.id)">
                删除
              </el-button>
            </template>
          </el-table-column>
        </el-table>

        <el-pagination
          v-model:current-page="currentPage"
          v-model:page-size="pageSize"
          :total="studentList.length"
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
import { getStudentList, deleteStudent } from '../../api/admin'
import type { Student } from '../../type/Student'

const studentList = ref<Student[]>([])
const currentPage = ref(1)
const pageSize = ref(10)

const pagedData = computed(() => {
  const start = (currentPage.value - 1) * pageSize.value
  return studentList.value.slice(start, start + pageSize.value)
})

const handleSizeChange = (val: number) => {
  pageSize.value = val
  currentPage.value = 1
}

const handleCurrentChange = (val: number) => {
  currentPage.value = val
}

const fetchStudentList = () => {
  getStudentList()
    .then((data) => {
      studentList.value = data
    })
    .catch((err) => {
      alert(err.message || '获取学生列表失败')
      studentList.value = []
    })
}

// ✅ 使用系统默认弹窗（confirm + alert）
const handleDelete = (id: string) => {
  const isConfirmed = window.confirm('确定要删除该学生吗？此操作不可恢复！')
  if (!isConfirmed) return // 用户点击“取消”

  deleteStudent(id)
    .then((affectedRows) => {
      alert(`删除成功（已删除 ${affectedRows} 条记录）`)
      fetchStudentList() // 刷新列表
    })
    .catch((err: any) => {
      alert(err.message || '删除失败')
    })
}

onMounted(() => {
  fetchStudentList()
})
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
  justify-content: center;
  align-items: center;
  border-radius: 12px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
  padding: 20px;
  box-sizing: border-box;
}

.table-container {
  width: 100%;
  height: 100%;
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
