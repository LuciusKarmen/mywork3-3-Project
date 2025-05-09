<template>
<el-carousel :interval="3000" type="card" height="200px" >
    <el-carousel-item v-for="(item,index) in list" :key="index">
      <img :src="item.id" alt="hhh">
    </el-carousel-item>
</el-carousel>
<h1>为什么说时代需要掌握计算机的人才</h1>
<li>技术发展：随着信息技术的快速发展，包括人工智能、大数据、云计算等前沿技术的应用越来越广泛。这些技术正在改变各个行业的运作模式，因此对具备相关技能的人才需求巨大。</li>
<li>市场需求：各行各业都在寻求通过数字化转型来提高效率和竞争力，这就需要大量的计算机专业人才来开发和维护相关的软件系统、网络架构以及数据处理平台。</li>
<li>高薪就业机会：计算机专业毕业生往往能够获得较高的起薪，并且职业发展前景广阔。随着经验的增长和技术能力的提升，薪资水平也有望持续增长。</li>
<li>创业机会：计算机技术和互联网为创业者提供了更多的可能性。无论是开发新的应用程序、提供在线服务还是利用电子商务开拓市场，都离不开计算机专业知识的支持。</li>
<li>解决问题的能力：编程是一种强大的工具，可以帮助人们解决日常生活中的各种问题。学习计算机科学可以增强逻辑思维能力和解决问题的能力。</li>
<li>跨学科应用：计算机科学与其他领域的交叉越来越多，如医学、金融、生物学、物理学等。这使得计算机专业的人才能够在不同领域中找到用武之地，进一步拓宽了就业范围。</li>
<li>学科交叉性强：计算机专业涉及多个学科的知识，包括数学、物理、工程学等，有助于培养学生的综合素养和创新能力。</li>
<li>综上所述，计算机专业的人才因为其专业技能的实用性和对未来发展的适应性而受到时代的呼唤，扮演着不可或缺的角色。</li>


</template>

<script setup lang="ts" name="Home">
import { ref, onMounted, reactive } from 'vue'
import img1 from '../assets/0422.jpg_wh860.png'
import img2 from '../assets/2047.jpg_wh860.jpg'
import img3 from '../assets/4215.jpg_wh860.jpg'
import img4 from '../assets/1689302106613476.png'
const list = reactive([
  { id: img1 },
  { id: img2 },
  { id: img3 },
  { id: img4 }
])


</script>

<style scoped lang="scss">
.el-carousel__item h3 {
  color: #475669;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
  text-align: center;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
</style>