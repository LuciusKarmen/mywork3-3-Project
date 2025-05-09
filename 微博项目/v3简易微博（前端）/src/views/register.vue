<template>
  <div class="register">
    <div class="q">欢迎加入湖南科技大学大家庭</div>
    <div class="p">
      <div class="form">
      <div class="input">
       <label for="11">姓名：</label>
       <input type="text" placeholder="用户名" id="11" v-model="user.name">
       <br>
       <label for="22">密码：</label>
       <input type="password" placeholder="密码" id="22" v-model="user.password">
      </div>
      <br>
         <div class="btn">
            <el-button @click="push()">提交</el-button>
            <el-button @click="reset()">重置</el-button>
         </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts" setup name="register">
import { reactive} from 'vue'
import axios from 'axios'
const user = reactive({
  name: '',
  password: ''
})

function push() {
  axios.post('/api/useradd', user,{
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded'
    }
  })

  .then(res => {
    console.log(res.data)
    if(res.data.success){
      alert('注册成功')
      window.location.href = '/'
    }
    else{
      alert('注册失败')
    }
 
  })
}
function reset() {
  user.name = ''
  user.password = ''
}
</script>

<style scoped lang="scss">
.register {
    width: 100%;
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-flow: wrap;
    background-image: url('../picture/cloud.jpg');
    background-repeat: no-repeat; 
    background-size: cover;


    .q{
        margin-left: 30px;
        width: 60%;
        height: 10px;
        font-size: 50px;
        color: rgba($color: #12fffb, $alpha: 0.8);
        font-weight: 600;
    }
    .p{
    
    padding: 50px;
    height: 150px;
    width: 30%;
    background-color:aqua;
    border-radius: 20px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5); 
      .form{

        .input{
          margin-left: 15%;
          input{
            height:30px;
            margin-bottom: 5px;
          }

        }
        .btn{
          margin-left: 30%;
        }
      }
    }
}

</style>