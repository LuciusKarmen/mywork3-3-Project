<template>
    <div class="container">
      <div class="head">
        <textarea class="comment" placeholder="请输入内容，支持换行"></textarea>
        <el-button type="primary" plain class="b">提交</el-button>
      </div>
      <div class="list">
      <div class="box" v-for='(item,index) in tip'  :key="index">
        <div class="top">
          <div class="pic">{{item.img}}</div>
          <div class="title">{{item.name}}</div>
          <div class="time">发布于：{{item.time}}</div>
        </div>
        <div class="word">{{item.content}}</div>
        <div class="bottom">
          <div class="like">收藏数量：{{item.like}}</div>
          <el-button type="warning" :icon="Star" circle class="save"/>
          <el-button type="primary" :icon="Delete" class="delete"/>
          <!-- @click="delete(index)" -->
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



let username=ref('karmen')
let tip=ref({
  id:'',
  name:'',
  content:'',
  time:'',
  img:''
})

function getTip(){
  axios.get('/api/tip1').then(res=>{
    console.log(res.data)
    tip.value=res.data
    console.log(tip[1].name)
  })
}

// function delete(index){
//   axios.delete(`/api/tip1/${index}`).then(res=>{
//     console.log(res.data)
//     getTip();
//   })
// }


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
          margin-left:-300px;
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