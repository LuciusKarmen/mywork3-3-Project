<template>
  <div class="send">
    <div class="title">
      <el-button type="warning">取消编辑</el-button>
      <el-button type="primary">发帖</el-button>
    </div>
    <div class="content">
      <el-input
        type="textarea"
        placeholder="请输入标题"
        rows="1"
        class="t"
        v-model="title"
      ></el-input>
      <hr />
      <el-input
        type="textarea"
        placeholder="请输入内容（不少于5个字）"
        rows="20"
        v-model="tcontent"
      ></el-input>
      <hr />
      <div class="avatar-upload">
        <p>点击下方方形区域上传封面</p>
        <!-- 预览图 -->
        <div class="avatar-preview" @click="triggerUpload">
          <img v-if="avatarUrl" :src="avatarUrl" alt="头像预览" />
          <span v-else>+</span>
          <input ref="fileInput" type="file" accept="image/*" @change="handleImageChange" />
        </div>
      </div>
    </div>
    <br />
    <br />
    <br />
    <div class="footer">
      <Title></Title>
    </div>
  </div>
</template>

<script setup lang="ts" name="face">
import Title from '../components/title.vue'
import { ref } from 'vue'
const title = ref('')
const tcontent = ref('')
const fileInput = ref<HTMLInputElement | null>(null)
const avatarUrl = ref<string | null>(null)
const triggerUpload = () => {
  if (fileInput.value) {
    fileInput.value.click()
  }
}

const handleImageChange = (event: Event) => {
  const file = (event.target as HTMLInputElement).files?.[0]
  if (file) {
    const reader = new FileReader()
    reader.onload = (e) => {
      avatarUrl.value = e.target?.result as string
    }
    reader.readAsDataURL(file)
  }
}
</script>

<style lang="scss" scoped>
.send {
  min-height: 100vh;
  .title {
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 1% 5%;
    background-color: rgb(208, 208, 208);
    height: 6vh;
  }
  .content {
    .t {
      font-size: 3vh;
    }
  }
}
.footer {
  position: fixed;
  bottom: 0;
  width: 100%;
}
.avatar-upload {
  display: flex;
  flex-direction: column;
  align-items: center;

  background-color: #ffffff;

  .avatar-preview {
    width: 150px;
    height: 150px;
    border: 2px dashed #ccc;
    border-radius: 10px;
    display: flex;
    justify-content: center;
    align-items: center;
    cursor: pointer;

    img {
      max-width: 100%;
      max-height: 100%;
      border-radius: 10px;
      //填满，1:1
      aspect-ratio: 1;
      object-fit: cover;
    }

    span {
      font-size: 24px;
      color: #999;
    }
  }

  input[type='file'] {
    display: none; /* 隐藏文件输入框 */
  }
}
</style>
