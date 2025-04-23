<template>
    <div id="app" class="container">
      <div class="title">权威光明计算机论坛</div>
      <div class="post-form">
        <textarea v-model="newPostContent" placeholder="有什么新鲜事？" class="post-input"></textarea>
        <button @click="addPost" class="post-button">发布</button>
      </div>
      <ul class="posts-list">
        <li v-for="(post, index) in posts" :key="index" class="post-item">
          <div class="post-content">{{ post.content }}</div>
          <div class="post-date">{{ post.date }}</div>
          <button @click="good(post.id)" class="good-button">点赞</button>
          <label>{{ post.likes }}</label>
          <span><button class="delete-button" @click="des(index)">删贴</button></span>
        </li>
      </ul>
    </div>
  </template>

<script lang="ts" setup name="other">
import { ref } from 'vue';
import axios from 'axios';

// 响应式数据
const newPostContent = ref('');
const posts = ref<{ content: string; date: string; likes: number; id: number }[]>([]);
let n = ref(0);

axios.get('http://localhost:3000/tip1').then((response) => {
  posts.value = response.data;
});

// 添加帖子
function addPost() {
  if (newPostContent.value.trim()) {
    const currentDate = new Date().toLocaleString();
    const postId = posts.value.length + 1;
    posts.value.unshift({ content: newPostContent.value, date: currentDate, likes: 0, id: postId });
    newPostContent.value = '';
  }
}

// 点赞功能
function good(id: number) {
  alert("点赞成功");
  const post = posts.value.find((post) => post.id === id);
  if (post) {
    post.likes += 1;
  }
}

// 删除帖子
function des(index: number) {
  alert("删除成功");
  posts.value.splice(index, 1);
}
</script>

<style>
    body {
     
      font-family: Arial, sans-serif;
      margin: 20px;
      background-repeat: no-repeat;
      background-size:cover;
    }
    .container {
      max-width: 600px;
      margin: auto;
    }
    .post-form {
      margin-bottom: 20px;
    }
    .post-input {
      width: calc(100% - 22px);
      padding: 10px;
      margin-bottom: 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }
    .post-button {
      padding: 10px 15px;
      background-color: #1da1f2;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
      border: #657786 2px solid;
    }
    .good-button {

      border-radius: 5px;
      padding: 1px 2px;
      background-color: #f59724;
      color: white;
      border: none;
      cursor: pointer;

    }
    .delete-button {
      
      border-radius: 5px;
      padding: 1px 2px;
      background-color: #ff0000;
      color: white;
      border: none;
      cursor: pointer;
      border: #ff0000 2px solid;
      margin-right: 100px;
     }
    .post-button:hover {
      background-color: #1a91da;
    }
    .posts-list {
      list-style-type: none;
      padding: 0;
    }
    .post-item {
      background-color: #f5f8fa;
      border: 1px solid #e1e8ed;
      border-radius: 4px;
      padding: 15px;
      margin-bottom: 10px;
    }
    .post-content {
      margin-bottom: 10px;
    }
    .post-date {
      color: #657786;
      font-size: 12px;
    }
    .title {
      font-size: 24px;
      margin: auto;
      margin-bottom: 20px;
    }
</style>