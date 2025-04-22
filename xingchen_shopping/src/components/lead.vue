<template>
  <div class="k">
    <div class="a">
      <RouterLink to="/a" active-class="active" class="r">111</RouterLink>
      <RouterLink to="/b" active-class="active" class="r">222</RouterLink>
      <RouterLink to="/c" active-class="active" class="r">333</RouterLink>
    </div>
    <div class="f">
    <RouterView></RouterView>
    </div>
  </div>
  
    
  
</template>

<script lang="ts" setup name="lead">
import {RouterView,RouterLink} from 'vue-router'
import a from "../page/111.vue"
import b from "../page/222.vue"
import c from "../page/333.vue"

</script>

<style scoped>
.a {
  display: flex;
  color: red;

  flex-direction: column;
  width:30% ;

}
.r {
  background-color: aqua ;
}
.k {

  display:flex;
  


}
.f {
  width:60% ;
  border: 2px solid red;
  margin-left: 50px;
  
}
</style>