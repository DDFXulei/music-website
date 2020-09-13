<template>
    <div id="container">
        <div>createTime:{{time}}</div><br>
        <div>title:{{title}}</div>
        <div>intro:{{intro}}</div>
        <div class="product-bottom">
            <div class="container">
                <div class="two">
                    <div class="title">产品简介</div>
                    <div class="jsh">
                        <p><img :src=attachImageUrl(pic)></p>
                         <div class="bt">{{productName}}</div>
                    </div>
                </div>
            </div>
        </div>
        <div class="product-bottom">
            <div class="container">
                <div class="two">
                    <div class="title">技术参数</div>
                    <div class="jsh">
                        <p><img :src=attachImageUrl(param)></p>
                    </div>
                </div>
            </div>
        </div>
        <el-row><el-button @click="retrunLast()" type="primary" round>返回上一级</el-button></el-row>
    </div>
</template>

<script>
import { mixin } from '../mixins'
import { mapGetters } from 'vuex'
import AlbumContent from '../components/AlbumContent'
// import { getProductEnvOfProductId } from '../api/index'

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
      intro: '',
      title: '',
      pic: '',
      name: '',
      time: '',
      param: ''
    }
  },
  computed: {
    ...mapGetters([
      'productType', // 产品类型
      'productName', // 产品名称
      'productTitle',
      'productPic', // 产品图片
      'createTime', // 产品创建时间
      'updateTime', // 产品更新时间
      'productIntro',
      'productFeature',
      'productParam',
      'tempList'
    ])
  },
  mounted () {
    this.id = this.$route.params.productId
    this.type = this.productType
    this.intro = this.productIntro
    this.title = this.productTitle
    this.pic = this.productPic
    this.name = this.productName
    this.param = this.productParam
    this.time = this.updateTime
    // this.getProductEnvList()
    // console.log('this.productTitle:' + this.productType)
    // console.log('this.productIntro:' + this.productIntro)
  },
  methods: {
    retrunLast () {
      this.$router.go(-1)
    }
  }
}
</script>

<style scoped>
       *{
            margin: 0;
            padding: 0;
            font-family: "Microsoft YaHei";
            line-height: 1.5;
        }
        #container{
            overflow: hidden;
            background-color: #F0F1F5;          
        }
        p {
            display: block;
            margin-block-start: 1em;
            margin-block-end: 1em;
            margin-inline-start: 0px;
            margin-inline-end: 0px;
        }
        div{
            display: inline-block;
        }
        img{
            width: 80%;
        }
        .product-show{
            padding: 115px 0 0 0;
        }
        .container {
            margin-right: auto;
            margin-left: auto;
            padding-right: 15px;
            padding-left: 15px;
            width: 100%;
        }
        .pic{
            width: 40%;
        }
        .right{
            cursor: pointer;
        }

        .product-info{
            float: left;
            padding: 0;
        }
        .product-show .text {
            float: right;
            width: 60%;
            margin-left: -10px;
        }
        .product-show .text .bt {
            font-size: 32px;
            color: #333;
            margin-bottom: 7px;
        }
        .product-show .text .jsh {
            font-size: 15px;
            color: #4a4a4a;
            line-height: 24px;
            padding:0 10px 17px 0;
            border-bottom: 1px solid #d6d6d6;
        }
        .tedian{
            width: 100%;
        }
        .product-show .text .tedian {
            padding-top: 17px;
        }
        .product-show .text .tedian .left {
            float: left;
            width: 55%;
            font-size: 15px;
            line-height: 34px;
            color: #444;
        }
        .product-show .text .tedian .right {
            float: left;
            width: 45%;
            padding-top: 65px;
        }
        .product-show .text .tedian .right a {
            display: block;
            width: 152px;
            height: 40px;
            text-align: center;
            line-height: 40px;
            border-radius: 5px;
            color: #fff;
            background: #93D2F8;
        }
        .product-center {
            padding: 15px 0 15px 0;
            overflow: hidden;
            background: #93D2F8;
        }
        .product-center .container {
            margin-right: auto;
            margin-left: auto;
            padding-right: 15px;
            padding-left: 15px;
            width: 100%;
        }
        .product-center .title {
            font-size: 30px;
            color: #fff;
            margin:0 0 30px 80px;
        }
        .product-center .list {
            margin: 0 auto;
            color: #fff;
            text-align: center;
        }
        .product-center .list ul {
            margin: 0 -43px;
        }
        .product-center .list ul li {
            width: 33.333333%;
            display: inline-block;
            color: #fff;
            text-align: left;
            padding: 0 43px;
            vertical-align: top;
            margin-bottom: 45px;
        }
        .product-center .list ul li .bt {
            font-size: 24px;
            margin-bottom: 9px;
        }
        .product-center .list ul li .jsh {
            font-size: 15px;
            line-height: 24px;
        }
        .product-bottom {
            padding-bottom: 45px;
            overflow: hidden;
            color:#444
        }
        .product-bottom img{
            width: 100%;
            height: 100%;
        }
        .product-bottom .container div{
            display: block;
        }
        .two {
            padding: 43px 82px 0 82px;
            overflow: hidden;
        }
        .product-bottom .title {
            font-size: 30px;
        }
        .product-bottom .two .jsh {
            padding: 26px 0;
        }
        .product-bottom .container {
            margin-right: auto;
            margin-left: auto;
            padding-right: 15px;
            padding-left: 15px;
            width: 100%;
        }

</style>
