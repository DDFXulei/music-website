<template>
  <div class="the-footer">
    <p v-for="(item, index) in list" :key="index">
      {{item}}
    </p>
  </div>
</template>

<script>
export default {
  name: 'the-footer',
  data () {
    return {
      list: [
        `关于 | 帮助 | 条款 | 反馈`,
        `Copyright © 2020`,
        `Designed by TopAir`
      ]
    }
  }
}
</script>

<style scoped>
.the-footer{
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content:center;
  flex-direction: column;
  background-color: #93D2F8;
  color: white;
}

.the-footer p {
  height: 30px;
}
</style>
