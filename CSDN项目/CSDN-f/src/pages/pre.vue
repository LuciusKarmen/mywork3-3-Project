<template>
  <div class="preview">
    <slot></slot>
  </div>
</template>

<script setup lang="ts" name="face"></script>

<style lang="scss" scoped>
.preview {
  background-color: #f5f5f5;
  padding: 10px;
  border-radius: 5px;
}
</style>
