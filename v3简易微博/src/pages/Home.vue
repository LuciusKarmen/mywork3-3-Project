<template>
  <div class="block text-center" m="t-4">
    <el-carousel trigger="click">
      <el-carousel-item v-for="(item, index) in list" :key="index" >
        <img :src="item.src" alt="carousel-image" class="carousel-image" />
      </el-carousel-item>
    </el-carousel>
  </div>
   

</template>

<script setup lang="ts" name="Home">
import { ref, onMounted } from 'vue'


let list = ref([
{
  src:'../picture/OIP-1.jpg'

},
{
  src:'../picture/OIP-1.jpg'

},
{
  src:'../picture/OIP-1.jpg'

},
{
  src:'../picture/OIP-1.jpg'
}

])


</script>

<style scoped>
.demonstration {
  color: var(--el-text-color-secondary);
}

.el-carousel__item h3 {
  color: #475669;
  opacity: 0.75;
  line-height: 150px;
  margin: 0;
  text-align: center;
  
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}

.carousel-image {

    width: 200px;
    height: 100px;

}
</style>