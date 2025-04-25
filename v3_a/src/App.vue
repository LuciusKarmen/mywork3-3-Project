<template>
    <div class="container">
      <div class="box" v-for='(item,index) in lists' :key="index"></div>
    </div>
  </template>
  
  <script setup lang="ts" >
  import axios from 'axios';
  import {ref} from 'vue'
  const lists=ref([])
  
   axios.get('http://localhost:8080/tip1').then(res=>{
    lists.value=res.data
  })
  
  
  </script>
  
  <style>
  
  </style>