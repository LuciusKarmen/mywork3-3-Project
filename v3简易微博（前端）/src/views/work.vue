<template>
  <div class="A">
    <!-- 头部 -->
    <h1 class="head">hnust计算机论坛</h1>
    <!-- 导航栏 -->
     <div class="wb">
      <RouterLink to="/work/home" active-class="light">首页</RouterLink>
      <RouterLink to="/work/F" active-class="light">前端</RouterLink>
      <RouterLink to="/work/B" active-class="light">后端</RouterLink>
      <RouterLink to="/work/other" active-class="light">论坛</RouterLink>

     </div>

    <!-- 内容展示 -->
    <div class="context">
      <RouterView></RouterView>
    </div>
  </div>
    
  </template>
  
  <script lang="ts" setup name="App">

  import {RouterView,RouterLink} from 'vue-router'
  import router from '../router'

  </script>
  
  <style>
  .A{
    width: 100%;
    height: 100%;
  }
  .wb {
    width: 600px; 
    margin: auto;
    display: flex;
    background-color: aqua;
    justify-content: space-around;
    align-items: center;
    border-radius: 20px;
    
  }
  .context {
    width: 1000px;
    height: 400px;
    margin: auto;
    border: 3px solid rgb(154, 154, 154);
    overflow-y: auto;
    border-radius: 20px;
    padding: 20px;
    margin-bottom: 10px;
    
  }
  .light {
    color: rgb(0, 0, 0);
    background-color: rgb(255, 255, 255);
    border-radius: 5px;
    text-decoration: none;
  }
  .A {
    background-image: url('../assets/34624328_232234642105_2.jpg');
    background-size: cover;
    background-repeat: no-repeat;
    width: 100%;
    height: 100%;
  }
  .head {
    text-align: center;
    color: rgb(0, 247, 255);
    font-size: 50px;
    font-style: italic;
    font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;

  }
  
  </style>