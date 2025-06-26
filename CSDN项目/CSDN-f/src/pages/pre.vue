<template>
  <div class="preview">
    <div class="t">
      <RectLeft class="icon" @click="getBack" />
      <div>帖子详情</div>
      <MoreX class="icon" />
    </div>
    <h1 class="title">为什么说只有共产主义才能救中国</h1>
    <div class="show">
      <div class="author">作者：Karmem</div>
      <div class="time">2023-05-05</div>
    </div>
    <div class="content">
      <p>
        共产主义是人类社会发展的最高阶段，它代表了人类文明的终极目标。只有实现共产主义，中国才能真正摆脱贫困、实现全面发展。
      </p>
      <p>
        共产主义强调生产资料公有制，消灭阶级差别，实现全人类的共同富裕。只有在共产主义社会中，才能实现真正的公平正义。
      </p>
      <p>
        共产主义的实现，需要从生产资料、生产方法、生产关系、生产环境、生产组织、生产控制、生产效率、生产质量、生产安全、生产成本、生产效率、生产质量、生产安全、生产成本、生产效率、生产质量、生产安全、生产成本、生产效率、生产质量、生产安全、生产成本、生产效率、生产质量、生产安全、生产成本、生产效率、生产质量、生产安全、生产成本、生产效率、生产质量、
      </p>
    </div>
    <div class="pic">
      <img src="../pic/R-C.jpg" alt="图片" class="img" />
    </div>
    <div class="good">
      <Fabulous class="icon" />
      <div class="good">点赞</div>
    </div>
    <br />
    <br />
    <hr />
    <div class="comment">
      <input type="text" class="input" />
      <el-button type="primary" @click="pushcomment">评论</el-button>
    </div>
    <br />
    <br />
    <div class="comment-list">
      <div v-for="(item, index) in 10" :key="index">
        <Message />
      </div>
    </div>
  </div>
</template>

<script setup lang="ts" name="face">
import { RectLeft, MoreX, Fabulous } from '@nutui/icons-vue'
import { useRouter } from 'vue-router'
import Message from '../components/message.vue'
const router = useRouter()
const getBack = () => {
  router.back()
}
const pushcomment = () => {
  alert('评论功能尚未实现')
}
</script>

<style lang="scss" scoped>
.preview {
  background-color: #f5f5f5;
  padding: 10px;
  border-radius: 5px;
  min-height: 50vh;
  .t {
    display: flex;
    align-items: center;
    justify-content: space-between;
    height: 8vh;
    background-color: #f5f5f5;
    border-bottom: 2px solid #959595;
  }
  .title {
  }
  .show {
    display: flex;
    justify-content: space-between;
    margin-top: 10px;
    margin-bottom: 20px;
    .author {
      color: #333;
      font-size: 16px;
      font-weight: bold;
      font-style: italic;
    }
    .time {
      color: #999;
      font-size: 14px;
    }
  }
  .pic {
    width: 80%;
    margin-left: 10%;
    aspect-ratio: 16/9;
    overflow: hidden;
    border-radius: 5px;
    margin-top: 20px;
    .img {
      width: 100%;
      height: 100%;
      object-fit: cover;
      object-position: center;
    }
  }
  .good {
    display: flex;
    align-items: center;
    flex-direction: column;
    justify-content: center;
    margin-top: 20px;

    .icon {
      margin-right: 5px;
      width: 50px;
      height: 50px;
      padding: 10px;
      border: 2px solid #080808;
      border-radius: 50%;
    }
  }
  .comment {
    display: flex;
    align-items: center;
    justify-content: space-between;
    margin-top: 20px;
    .input {
      width: 80%;
      height: 50px;
      border-radius: 5px;
      padding: 10px;
      border: 1px solid #959595;
    }
  }
}
@media (max-width: 768px) {
  .preview {
  }
}
</style>
