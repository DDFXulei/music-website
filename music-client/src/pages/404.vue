<template>
  <div class="error-page">
    <div class="error-code" >404,找不到此页面,系统将在{{seconds}}s后返回主页</div>
  </div>
</template>

<script>
export default {
  date() {
    return {
      timer: '',
      seconds: ''
    }
  },
  created() {
    this.seconds = 5
    console.log(this.seconds)
    // this.timer = setInterval(
    //   () => this.reduceNum, 1000
    // )
    // new Promise(function(resolve){
    //   setInterval(() => this.timer,1000)
    //   clearInterval()
    // }).then(
    //   this.$router.push({path: '/home'})
    // )
  },
  methods: {
    reduceNum () {
        if(this.seconds > 0 ){
        this.seconds--
        console.log(this.seconds)
        } else {
          return false
        }
      }
    
  },
  mounted() {
    setInterval(this.reduceNum,1000)
    this.$router.push({path: '/home'})
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
</style>
