<template>
  <div class="product-album">
    <div class="album">
      <div class="album-slide">
        <div class="product-img">
          <img :src=attachImageUrl(pic) alt="">
        </div>
        <ul class="info">
          <li>产品名称：{{name}}</li>      
          <li>制造商：无锡托普艾尔净化设备有限公司</li>
          <li>WuXi Topair Purify Equipment Co.,Ltd</li>
          <li>更新日期：{{time}}</li>
        </ul>
      </div>
      <!-- <div class="album-content">
        <div class="intro">
          <h2>{{name}}</h2>
          <span>{{product.introduction}}</span>
        </div>
        <div class="content">
          <album-content :songList="listOfSongs">
            <template slot="title">产品信息列表</template>
          </album-content>
        </div>
      </div> -->
    </div>
  </div>
</template>

<script>
import { mixin } from '../mixins'
import { mapGetters } from 'vuex'
import AlbumContent from '../components/AlbumContent'
import { getProductEnvOfProductId } from '../api/index'

export default {
  name: 'product-datail',
  components: {
    AlbumContent
  },
  mixins: [mixin],
  data () {
    return {
      id: '',
      type: '',
      pic: '',
      name: '',
      time: ''
    }
  },
  computed: {
    ...mapGetters([
      'productType', // 产品类型
      'productName', // 产品名称
      'productPic', // 产品图片
      'createTime', // 产品创建时间
      'updateTime', // 产品更新时间
      'productIntro',
      'productFeature',
      'productParam',
      'tempList',
      'listOfSongs'
    ])
  },
  mounted () {
    this.id = this.$route.params.productId
    this.type = this.productType
    this.pic = this.productPic
    this.name = this.productName
    this.time = this.updateTime
    this.getProductEnvList()
  },
  methods: {
    getProductEnvList () {
      getProductEnvOfProductId(this.productId)
        .then(res => {
          this.$store.commit('setListOfSongs', res)
        })
        .catch(err => {
          console.log(err)
        })
    }
  }
}
</script>

<style scoped>
.product-album{
  background-color: white;
}

.album {
  margin-top: 150px;
  background-color: #e6ecf0;
}

/*左*/
.album-slide {
  float: left;
  width: 400px;
}

.product-img {
  height: 500px;
  width: 500px;
  display: inline-block;
  position: relative;
  margin-bottom: -50px;
  top: -100px;
  left: 50px;
  border-radius: 10%;
  overflow: hidden;
  background-color: #ffffff;
  border: 5px solid white;
}

.product-img img {
  width: 100%;
}

.info {
  color: black;
  font-size: 20px;
  font-weight: 500;
  padding-left: 100px;
}

.info li {
  width: 100%;
  height: 40px;
}

/*右*/
.album-content{
  margin-left: 300px;
  padding: 30px 100px;
}

.intro {
  font-size: 20px;
}

.intro > span {
  color: rgba(0, 0, 0, 0.5);
}

.content {
  margin-top: 50px;
}

</style>
