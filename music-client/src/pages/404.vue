<template>
    <div class="error-page">
      <div class="error-code" >404,找不到此页面,<a @click="goHome">点我返回</a></div>
    </div>
</template>

<script>
export default {
  date () {
    return {
      count: '',
      timer: ''
    }
  },
  methods: {
    goHome () {
      this.$router.go(-1)
    }
  }
}

</script>
<style scoped>
.error-page{
  padding: 10rem 0;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  height: 100%;
  background: #f3f3f3;
  box-sizing: border-box;
}
.error-code{
  min-height: 300px;
  line-height: 1;
  font-size: 20px;
  font-weight: bolder;
  color: #95d2f6;
}
a{
  cursor: pointer;
  text-decoration: underline;
}
</style>
