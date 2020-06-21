<template>

  <div class="container">
    <div class="handle-box">
      <el-button type="primary" size="mini" class="handle-del mr10" @click="goBack()">返回上一级</el-button>
    </div>
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="产品名称">
        <el-input v-model="form.productName"></el-input>
      </el-form-item>
      <el-form-item label="产品类别">
        <el-select v-model="form.productType" placeholder="请选择活动区域">
          <el-option label="区域一" value="shanghai"></el-option>
          <el-option label="区域二" value="beijing"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="活动区域">
        <el-select v-model="form.region" placeholder="请选择活动区域">
          <el-option label="区域一" value="shanghai"></el-option>
          <el-option label="区域二" value="beijing"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="活动时间">
        <el-col :span="11">
          <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
        </el-col>
        <el-col class="line" :span="2">-</el-col>
        <el-col :span="11">
          <el-time-picker placeholder="选择时间" v-model="form.date2" style="width: 100%;"></el-time-picker>
        </el-col>
      </el-form-item>
      <el-form-item label="即时配送">
        <el-switch v-model="form.delivery"></el-switch>
      </el-form-item>
      <el-form-item label="活动性质">
        <el-checkbox-group v-model="form.type">
          <el-checkbox label="美食/餐厅线上活动" name="type"></el-checkbox>
          <el-checkbox label="地推活动" name="type"></el-checkbox>
          <el-checkbox label="线下主题活动" name="type"></el-checkbox>
          <el-checkbox label="单纯品牌曝光" name="type"></el-checkbox>
        </el-checkbox-group>
      </el-form-item>
      <el-form-item label="特殊资源">
        <el-radio-group v-model="form.resource">
          <el-radio label="线上品牌商赞助"></el-radio>
          <el-radio label="线下场地免费"></el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="活动形式">
        <el-input type="textarea" v-model="form.desc"></el-input>
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
      form: {
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
