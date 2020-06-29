<template>
    <div id="container">
        <section class="inmain product-show">
            <div class="container">
                <div class="product-info">
                    <div class="pic">
                        <img :src=attachImageUrl(pic)>
                    </div>
                    <div class="text">
                        <div class="bt">{{productName}}</div>
                        <div class="jsh">
                            <p>配置高品质部件的PHCL(E)压缩热吸附式干燥机，可提供洁净和干燥的空气，从而延长您设备的使用寿命，全程保护您的产品。压缩热吸附式干燥机使用压缩机高温气体，脱附干燥剂中的水分；冷吹时，使用冷却后的压缩空气冷却干燥剂，全程没有压缩空气排放。</p><p>PHCL(E)吸附式干燥机，双塔结构，塔内装填干燥剂，冷却器翅片式，内置分离结构，结构紧凑压损低。有多种可选项可灵活组合。</p><p>Purelogic智能控制器，温度参与控制，可选露点控制，优化运行成本。监控干燥机重要运行参数。</p>
                        </div>
                        <div class="tedian">
                            <div class="left">
                                <p>压力露点：0~-40℃</p><p>入口温度：90-130℃</p><p>工作压力： 4.5-10 barg</p><p>平均耗气量：0%</p><p>电源： 220V/1PH/50HZ</p><p>双塔结构</p><p>Purelogic控制器</p>
                            </div>
                            <div class="right">
                                <a @click=retrunLast()>返回上一级</a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </section>
        <div class="product-center">
            <div class="container">
                <div class="product-info">
                    <div class="title">产品特点和优势</div>
                    <div class="list">
                        <ul class=" list-paddingleft-2">
                            <li>
                                <div class="box">
                                    <div class="bt">选择高品质高效率的干燥剂，露点稳定</div>
                                    <div class="jsh">PDP-40℃ 活性氧化铝（标准）</div>
                                    <div class="jsh">PDP-70℃ 活性氧化铝+硅胶+分子筛（OPTION）</div>
                                </div>
                            </li>
                            <li>
                                <div class="box">
                                    <div class="bt">零气耗节能设计</div>
                                    <div class="jsh">使用自然空气加热干燥剂，内循环冷吹，再生零气耗</div>
                                    <div class="jsh">温度控制再生和冷吹</div>
                                </div>
                            </li>
                            <li>
                                <div class="box">
                                    <div class="bt">大尺寸塔体和流量控制，干燥剂磨损风险最小</div>
                                </div>
                            </li>
                            <li>
                                <div class="box">
                                    <div class="bt">高可靠性的设计，稳定运行</div>
                                    <div class="jsh">双偏心软密封阀门（耐高温）</div>
                                    <div class="jsh">翅片式冷却器较小的气侧压损</div>
                                    <div class="jsh">阀位保持/故障报警/反馈功能</div>
                                    <div class="jsh">使用高品质鼓风机</div>
                                    <div class="jsh">配有高温保护装置和低功率密度电加热器，寿命长，低风险</div>
                                </div>
                            </li>
                        </ul>                                 
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
    </div>
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
      time: '',
      param: ''
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
    this.param = this.productParam
    this.time = this.updateTime
    this.getProductEnvList()
    console.log('this.param:' + this.productPic)
  },
  methods: {
    getProductEnvList () {
      getProductEnvOfProductId(this.id)
        .then(res => {
          this.$store.commit('setListOfSongs', res)
        })
        .catch(err => {
          console.log(err)
        })
    },
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
