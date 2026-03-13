<template>
  <div class="main">
    <div class="centre">
      <h2 class="title">管理员列表</h2>
      <div class="table-container">
        <el-table :data="pagedData" style="width: 100%" border>
          <el-table-column prop="name" label="姓名" width="120" />
          <el-table-column prop="position" label="职位" width="180" />
          <el-table-column label="默认密码" width="120">
            <template #default>
              <span>12345678</span>
            </template>
          </el-table-column>
        </el-table>

        <el-pagination
          v-if="adminList.length > 0"
          v-model:current-page="currentPage"
          v-model:page-size="pageSize"
          :total="adminList.length"
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
import { getAdminList } from '../../api/admin'
import type { Admin } from '../../type/Admin'

const adminList = ref<Admin[]>([])
const currentPage = ref(1)
const pageSize = ref(10)

const pagedData = computed(() => {
  const start = (currentPage.value - 1) * pageSize.value
  return adminList.value.slice(start, start + pageSize.value)
})

const handleSizeChange = (val: number) => {
  pageSize.value = val
  currentPage.value = 1
}

const handleCurrentChange = (val: number) => {
  currentPage.value = val
}

onMounted(() => {
  fetchAdminList()
})

const fetchAdminList = async () => {
  try {
    const res = await getAdminList()
    adminList.value = Array.isArray(res) ? res : []
  } catch (err) {
    console.error('获取管理员列表失败:', err)
    ElMessage.error('加载管理员列表失败')
    adminList.value = []
  }
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
  width: 95%;
  max-width: 1000px;
  height: 90%;
  display: flex;
  flex-direction: column;
  background-color: #fff;
  border-radius: 12px;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
  padding: 24px;
  box-sizing: border-box;
}

.title {
  font-size: 22px;
  font-weight: 600;
  color: #6a5acd;
  margin-bottom: 20px;
  text-align: center;
}

.table-container {
  flex: 1;
  display: flex;
  flex-direction: column;

  .el-table {
    flex: 1;
  }

  .pagination {
    display: flex;
    justify-content: flex-end;
    margin-top: 16px;
  }
}
</style>
