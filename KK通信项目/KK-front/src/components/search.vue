<template>
  <div>
    <input type="text" v-model="searchQuery" placeholder="Search..." class="search-input" />
  </div>
</template>
<script lang="ts" setup name="Search">
import { ref } from 'vue'
// import { useRouter } from 'vue-router'
// const router = useRouter()
const searchQuery = ref('')
</script>
<style lang="scss" scoped></style>
