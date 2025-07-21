<template>
  <div>
    <SearchInput></SearchInput>
    <div class="friend-add">
      <br />
      <br />
      <br />
      <div>世界不是一座座孤岛</div>
      <div>你我一起</div>
      <div>改变世界</div>
    </div>
  </div>
</template>
<script lang="ts" setup name="">
import SearchInput from '../search.vue'
</script>
<style lang="scss" scoped>
.friend-add {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100%;
  font-size: 20px;
  color: #fff;
}
</style>
