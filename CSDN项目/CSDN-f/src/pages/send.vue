<template>
  <div class="send">
    <div class="title">
      <el-button type="warning">取消编辑</el-button>
      <el-button type="primary" @click="Send">发帖</el-button>
    </div>
    <div class="content">
      <el-input
        type="textarea"
        placeholder="请输入标题"
        rows="1"
        class="t"
        v-model="tipTip.title"
      ></el-input>
      <hr />
      <el-input
        type="textarea"
        placeholder="请输入内容（不少于5个字）"
        rows="20"
        v-model="tipTip.tcontent"
      ></el-input>
      <hr />
      <div class="avatar-upload">
        <p>点击下方方形区域上传封面</p>
        <div class="avatar-preview" @click="triggerUpload">
          <img v-if="avatarUrl" :src="avatarUrl" alt="fm预览" />
          <span v-else>+</span>
          <input ref="fileInput" type="file" accept="image/*" @change="handleAvatarUpload" />
        </div>
      </div>
      <hr />
      <div>
        <span>选择你的分区：</span>
        <select
          v-model="tipTip.tclass"
          clearable
          placeholder="Select"
          style="width: 100px; height: 30px; margin-left: 10px"
        >
          <option
            v-for="(item, index) in options"
            :key="index"
            :label="item.label"
            :value="item.tclass"
          ></option>
        </select>
      </div>
    </div>
    <br />
    <br />
    <br />
    <div class="footer">
      <Bar></Bar>
    </div>
  </div>
</template>

<script setup lang="ts" name="face">
import Bar from '../components/bar.vue'
import { ref } from 'vue'
import { type Tip } from '../api/tip'
import request from '../util/request'
const file = ref<File | null>(null)
const avatarUrl = ref<string | null>(null)

const triggerUpload = () => {
  const fileInput = document.querySelector<HTMLInputElement>('.avatar-upload input[type="file"]')
  if (fileInput) {
    fileInput.click()
  }
}

const handleAvatarUpload = (event: Event) => {
  const file = (e.target as HTMLInputElement).files?.[0]
  pic.value = file || null
  if (!file.value) {
    console.error('No file selected')
    return
  }
  if (file.value) {
    //提前看图片
    const reader = new FileReader()
    reader.onload = (e) => {
      avatarUrl.value = e.target?.result as string
    }
    reader.readAsDataURL(file)
  }
}
const options = [
  { tclass: '全部', label: '全部' },
  { tclass: '学习', label: '学习' },
  { tclass: '编程', label: '编程' },
  { tclass: '生活', label: '生活' },
  { tclass: '端游', label: '端游' },
  { tclass: '手游', label: '手游' },
  { tclass: '动漫', label: '动漫' },
  { tclass: '影视', label: '影视' },
  { tclass: '音乐', label: '音乐' },
  { tclass: '文学', label: '文学' },
  { tclass: '科技', label: '科技' },
  { tclass: '体育', label: '体育' },
  { tclass: '美食', label: '美食' },
  { tclass: '旅游', label: '旅游' },
]
//这里是我的提交数据功能
const tipTip: Tip = {
  tid: '',
  tname: '', //没错，这是分类
  tcontent: '',
  title: '',
  ttime: '',
  tuser: '',
  tgood: 0,
  tmessage: 0,
  tpic: '',
  tclass: '',
}

const Send = () => {
  tipTip.tuser = localStorage.getItem('user') || '匿名用户'
  tipTip.ttime = new Date().toLocaleString()
  tipTip.tclass = tipTip.tclass || '全部' //如果没有选择分类，则默认为全部
  tipTip.tname = tipTip.tclass //这里的分类就是tname
  tipTip.tcontent = tipTip.tcontent || '无内容'
  tipTip.tgood = 0
  tipTip.tmessage = 0
  if (tipTip.title.length < 5 || tipTip.tcontent.length < 5) {
    alert('标题和内容至少需要5个字！')
    return
  }

  request({
    url: '/tip/addTip',
    method: 'POST',
    data: formdata,
    headers: {
      'Content-Type': 'multipart/form-data',
    },
  })
    .then((data) => {
      if (data === '发布成功') {
        alert('发布成功！')

        tipTip.tcontent = ''
        tipTip.title = ''
        tipTip.tclass = ''
        avatarUrl.value = null
      } else {
        alert('发布失败，请稍后再试！')
      }
    })
    .catch((error) => {
      console.error('请求失败:', error)
      alert('发布失败，请稍后再试！')
    })
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
