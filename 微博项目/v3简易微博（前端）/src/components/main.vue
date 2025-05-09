<template>
  <div class="app-container">
      <div class="a1">湖南科技大学<br>暗网论坛</div>
      <div class="a2">
        <div>
          <img src="../assets/Snipaste_2025-04-02_00-16-01.png" alt="hhh" class="a4">
        </div>
        <div>
          <label for="username" class="a3" >账号:</label>
          <input v-model="user.username" type="text" key="username">
          <br>
          
        </div>
        <div>
          <label for="password" class="a3">密码:</label>
          <input v-model="user.password" key="password">
          <div>
           
            <a href="/register" class="add">还没有加入？点击注册</a>
          </div>
          <el-button @click="push()">提交</el-button>
          <el-button @click="clean()" >清空</el-button>
        </div>
      </div>
  </div>
  
</template>

<script lang="ts" setup name="Calendar">
import { ref, reactive } from 'vue'
import axios from 'axios'
import {RouterView,RouterLink} from 'vue-router'

const user=reactive({
  username: '手机号/邮箱/用户名',
  password: '请输入密码'
})

let flag=false;

let response = reactive([{name:'',password:''}])


function push() {

  axios.get('/api/user').then(res=>{
    console.log(res.data)
    response=res.data
    console.log(response[1].name)
    for(let i=0;i<response.length;i++){
      if(response[i].name==user.username&&response[i].password==user.password){
        alert('登录成功')
        flag=true;
        window.location.href = `/work/other?name=${encodeURIComponent(response[i].name)}`
      }
    }
    if(flag==false){
      alert('账号或密码错误')
    }

  })
  
}
function clean() {
  user.username = ''
  user.password = ''
}

</script>

<style scoped>
.app-container {
  background-image: url('../assets/aaaa.jpg'); 
  background-size: cover; 
  background-repeat: no-repeat; 
  width: 100%;
  height: 100vh;
}

.a1{
  
 text-align: center;
 font-style: italic;
 font-family: 'Franklin Gothic Medium', 'Arial Narrow', Arial, sans-serif;
 color:rgb(0, 89, 255);
 text-shadow: 30% 30% 0px rgb(0, 0, 0);
 font-size: 40px;
 
}
.a2{
  text-align: center;
  font-size: 30px;
  background-color: aquamarine;
  width: 250px;
  height: 300px;
  margin: 0 auto;
  border-radius: 10px;
  box-shadow: 1px 1px rgb(255, 255, 255);
  opacity: 0.8;


}
.a3{
  font-size: 15px;
  border-radius: 10px;
  font-style: italic;
  font-family:Verdana, Geneva, Tahoma, sans-serif;
  font-style: bold;
  
}
.a4{
  margin-top: 15px;
  width: 70px;
  height:75px;

}
.add{
  font-size: 10px;
  font-style: italic;
  font-family:Verdana, Geneva, Tahoma, sans-serif;
  font-style: bold;
  color:rgb(0, 89, 255);
  text-decoration: none;
}
</style>