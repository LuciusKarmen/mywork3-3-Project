<template>
  <div class="main">
    <div class="centre">
      <!-- 表格容器放在这里 -->
      <div class="table-container">
        <el-table :data="pagedData" style="width: 100%" border>
          <el-table-column prop="id" label="编号" width="80" />
          <el-table-column prop="name" label="姓名" width="100" />
          <el-table-column prop="sex" label="性别" width="80" />
          <el-table-column prop="age" label="年龄" width="80" />
          <el-table-column prop="phone" label="电话" width="120" />
          <el-table-column prop="email" label="邮箱" />
        </el-table>

        <el-pagination
          v-model:current-page="currentPage"
          v-model:page-size="pageSize"
          :total="tableData.length"
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
import { ref, computed } from 'vue'

// 注意：你的数据里没有 `id` 字段！需要补上
const tableData = [
  { id: 1, name: 'Tom', sex: '男', age: '18', phone: '12345678901', email: '124921387@gmail.com' },
  {
    id: 2,
    name: 'Jerry',
    sex: '男',
    age: '19',
    phone: '12345678902',
    email: '124921387@gmail.com',
  },
  {
    id: 3,
    name: 'Alice',
    sex: '女',
    age: '20',
    phone: '12345678903',
    email: '124921387@gmail.com',
  },
  { id: 4, name: 'Bob', sex: '男', age: '21', phone: '12345678904', email: '124921387@gmail.com' },
  { id: 5, name: 'Eva', sex: '女', age: '22', phone: '12345678905', email: '124921387@gmail.com' },
  { id: 6, name: 'Tom', sex: '男', age: '18', phone: '12345678901', email: '124921387@gmail.com' },
  { id: 7, name: 'Tom', sex: '男', age: '18', phone: '12345678901', email: '124921387@gmail.com' },
  { id: 8, name: 'Tom', sex: '男', age: '18', phone: '12345678901', email: '124921387@gmail.com' },
  { id: 9, name: 'Tom', sex: '男', age: '18', phone: '12345678901', email: '124921387@gmail.com' },
  { id: 10, name: 'Tom', sex: '男', age: '18', phone: '12345678901', email: '124921387@gmail.com' },
  { id: 11, name: 'Tom', sex: '男', age: '18', phone: '12345678901', email: '124921387@gmail.com' },
  { id: 12, name: 'Tom', sex: '男', age: '18', phone: '12345678901', email: '124921387@gmail.com' },
]

const currentPage = ref(1)
const pageSize = ref(10)

const pagedData = computed(() => {
  const start = (currentPage.value - 1) * pageSize.value
  const end = start + pageSize.value
  return tableData.slice(start, end)
})

const handleSizeChange = (val: number) => {
  pageSize.value = val
  currentPage.value = 1
}

const handleCurrentChange = (val: number) => {
  currentPage.value = val
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
  background-color: rgb(255, 255, 255); /* 改为白色更适配表格 */
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
  }
}
</style>
