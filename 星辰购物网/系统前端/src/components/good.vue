<template>
  <div v-for="item in 15" class="good" :key="item">
    <n-card>
      <n-card-header>
        <h3>商品名称</h3>
      </n-card-header>
      <n-card-body>
        <p>商品描述</p>
        <p>价格: ￥100</p>
      </n-card-body>
      <n-card-footer>
        <n-button>加入购物车</n-button>
      </n-card-footer>
    </n-card>
  </div>
</template>

<script lang="ts" setup name="Good"></script>

<style scoped lang="scss">
.good {
  width: 20%;
  height: 30vh;
  margin: 2vh;
  display: inline-block;
  vertical-align: top;
}
</style>
