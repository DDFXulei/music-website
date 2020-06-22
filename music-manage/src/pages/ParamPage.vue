<template>

  <div class="container">
    <div class="handle-box">
      <el-button type="primary" size="mini" class="handle-del mr10" @click="goBack()">返回上一级</el-button>
    </div>
    <el-form ref="formData" :model="formData" label-width="80px">
      <el-form-item label="产品名称">
        <el-input v-model="formData.productName"></el-input>
      </el-form-item>
      <el-form-item label="产品类别">
        <el-select v-model="formData.productType" placeholder="请选择产品类别">
          <el-option label="吸附式干燥机" value="1"></el-option>
          <el-option label="冷冻式干燥机" value="2"></el-option>
          <el-option label="管道过滤器" value="4"></el-option>
          <el-option label="制氮机" value="8"></el-option>
          <el-option label="工艺气体干燥" value="16"></el-option>
          <el-option label="其他辅助产品" value="32"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="产品简介">
        <el-input
          type="textarea"
          autosize
          placeholder="请输入产品简介"
          v-model="formData.productIntro">
        </el-input>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">立即创建</el-button>
        <el-button>取消</el-button>
      </el-form-item>
  </el-form>
  </div>

</template>

<script>
import SongAudio from '../components/SongAudio'
import { mixin } from '../mixins'
import { mapGetters } from 'vuex'
import '@/assets/js/iconfont.js'
import { getProductOfProductId } from '../api/index'

export default {
  name: 'param-page',
  components: {
    SongAudio
  },
  mixins: [mixin],
  data () {
    return {
      productId: '',
      productName: '',
      tableData: [],
      tempDate: [],
      formData: {
        name: '',
        region: '',
        date1: '',
        date2: '',
        delivery: false,
        type: [],
        resource: '',
        desc: ''
      }
    }
  },
  computed: {
    ...mapGetters([
      'isPlay' // 播放状态
    ])
  },
  watch: {
    select_word: function () {
      if (this.select_word === '') {
        this.tableData = this.tempDate
      } else {
        this.tableData = []
        for (let item of this.tempDate) {
          if (item.name.includes(this.select_word)) {
            this.tableData.push(item)
          }
        }
      }
    }
  },
  created () {
    this.productId = this.$route.query.productId
    this.productName = this.$route.query.productName
    this.getData()
  },
  destroyed () {
    this.$store.commit('setIsPlay', false)
  },
  methods: {
    onSubmit () {
      console.log('submit!')
    },
    goBack () {
      this.$router.go(-1)
    },
    // 获取歌曲
    getData () {
      this.tableData = []
      this.tempDate = []
      getProductOfProductId(this.productId).then((res) => {
        console.log('产品明细是===========>', res)
        this.tableData = res
        this.tempDate = res
      }).catch(err => {
        console.log(err)
      })
    },

    // 更新参数图片
    uploadUrl (id) {
      return `${this.$store.state.HOST}/song/img/update?id=${id}`
    }
  }
}

</script>

<style scoped>
.handle-box {
    margin-bottom: 40px;
}
</style>
