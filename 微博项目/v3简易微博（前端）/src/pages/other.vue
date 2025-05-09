<template>
    <div class="container">
      <div class="head">
        <textarea v-model="contentto" class="comment" placeholder="请输入内容，支持换行"></textarea>
        <el-button type="primary" plain class="b" @click="push()">提交</el-button>
      </div>
      <div class="list">
      <div class="box" v-for='(item,index) in tip'  :key="index">
        <div class="top">
          <div class="pic">{{ item.img }}</div>
          <div class="title">{{item.name}}</div>
          <div class="time">发布于：{{item.time}}</div>
        </div>
        <div class="word">{{item.content}}</div>
        <div class="bottom">
          <div class="like">打赏次数：{{item.like}}</div>
          <el-button type="warning" :icon="Star" @click="likeadd(item.id)" circle class="save"/>
          <el-button type="primary" :icon="Delete" @click="deleteTip(item.id)" class="delete"/>
         
        </div>
        
      </div>
        
      </div>
  </div>
</template>

<script setup lang="ts" >
import axios from 'axios';
import {reactive, ref} from 'vue'
import { Delete} from '@element-plus/icons-vue'
import { Star} from '@element-plus/icons-vue'
import { useRoute } from 'vue-router';
import { id } from 'element-plus/es/locales.mjs';

let contentto=ref('')
let router=useRoute()
let timeto=ref(new Date().toLocaleString())
let nameto=ref(router.query.name)




let tip=ref(
[{ 
  id:'',
  name:'',
  content:'',
  time:'',
  img:'',
  like:0}]
)
let idto=1

function getTip(){
  axios.get('/api/tip1').then(res=>{
    console.log(res.data)
    tip.value=res.data

  })
}
function push(){
  axios.post('/api/tipadd',{
    id:crypto.randomUUID(),
    content:contentto.value,
    time:timeto.value,
    name:nameto.value,
    img:'发帖人：',
    like:0
  },{
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
      
    }
  }
).then(res=>{
    console.log(res.data);
    alert('提交成功');
    getTip();
  })
}

function deleteTip(id:string){
    axios.post("/api/tipdelete",{
      id
      },
      {
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
        }
      
    }).then(res=>{
      console.log(res.data);
      alert('删除成功');
      getTip();
})
}
function likeadd(id:string){
    axios.post("/api/tiplike",{
      id
      },
      {
        headers: {
          'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8'
        }
      
    }).then(res=>{

      getTip();
})
}



getTip();
</script>

<style lang="scss" scoped>
.container{
  width: 100%;
  height: 100%;

  .list{
    width:60%;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
    margin-left: 20%;
    margin-top:20px;
    .box{
      padding:1px;
      margin-top:10px;
      width: 100%;
      height:150px;
      background-color:rgba($color: #e8e8e8, $alpha: 0.6);
      border-radius: 20px;
      .top{
        width: 100%;
        height:30%;   
        display: flex;
        justify-content: space-between;
        align-items: center;
        background-color:rgba($color: #e8e8e8, $alpha: 0.6);
        border-radius: 10px;
        .title{
          margin-left:-250px;
          font-size:20px;
        }
      }
      .word{
          display: flex;
          justify-content: space-between;
          width: 100%;
          height: 42%;
        }
      .bottom{
        margin-bottom:1px;
        height:20%;
        display: flex;
        justify-content: space-between;
        align-items: center;
        .save{
          margin-left:-400px;
        }
      }
    }
  }

  .head{
    width: 100%;

    .comment{
       margin-left: 55px;
       width:60%;
       height: 100px;
       background-color:white;
       border: 1px solid rgba($color: #e8e8e8, $alpha: 0.6);
       
     }
     .b{
        position: relative;
        right:100px;
        bottom:10px;
      }
  }

}
</style>