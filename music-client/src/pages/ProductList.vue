<template>
  <div class="product-list">
    <div class="product-list-header">
      <ul>
        <li
          v-for="(item, index) in productType"
          :key="index"
          :class="{active: item.name === activeName}"
          @click="handleChangeView(item.name)">
          {{item.name}}
        </li>
      </ul>
    </div>
    <div class="product-content">
      <content-list :contentList="data"></content-list>
      <div class="pagination">
        <el-pagination
          @current-change="handleCurrentChange"
          background
          layout="total, prev, pager, next"
          :current-page="currentPage"
          :page-size="pageSize"
          :total="albumDatas.length">
        </el-pagination>
      </div>
    </div>
  </div>
</template>

<script>
import ContentList from '../components/ContentList'
import { mapGetters } from 'vuex'
import { getProductList, getProductListOfType } from '../api/index'
import { productType } from '../assets/data/productList'

export default {
  name: 'product-list',
  components: {
    ContentList
  },
  data () {
    return {
      productType: [], // 产品导航栏类别
      activeName: '全部类别',
      pageSize: 15, // 页数
      currentPage: 1, // 当前页
      albumDatas: [] // 产品单
    }
  },
  computed: {
    // 计算当前表格中的数据
    data () {
      return this.albumDatas.slice((this.currentPage - 1) * this.pageSize, this.currentPage * this.pageSize)
    }
  },
  mounted () {
    this.productType = productType
    this.handleChangeView('全部类别')
  },
  methods: {
    // 获取当前页
    handleCurrentChange (val) {
      this.currentPage = val
    },
    // 获取产品
    handleChangeView: function (name) {
      this.activeName = name
      this.albumDatas = []
      if (name === '全部类别') {
        this.getProductList(this.cur_page)
      } else {
        this.getProductListOfType(name)
      }
    },
    // 获取全部产品
    getProductList (page) {
      getProductList()
        .then(res => {
          this.currentPage = 1
          this.albumDatas = res
        })
        .catch(err => {
          console.log(err)
        })
    },
    // 通过类别获取产品
    getProductListOfType (style) {
      getProductListOfType(style)
        .then(res => {
          this.currentPage = 1
          this.albumDatas = res
        })
        .catch(err => {
          console.log(err)
        })
    }
  }
}
</script>

<style scoped>
.product-list {
  margin: 30px 150px;
  padding-bottom: 50px;
  min-width: 800px;
  background-color: #ffffff;
}

.product-list-header {
  width: 100%;
  padding: 0 40px;
}

li {
  display: inline-block;
  line-height: 40px;
  margin: 40px 20px 15px 20px;
  font-size: 20px;
  font-weight: 400;
  color: #67757f;
  border-bottom: none;
  cursor: pointer;
}

.active {
  color: black;
  font-weight: 600;
  border-bottom: 4px solid black;
}

.pagination {
  display: flex;
  justify-content: center;
}
</style>
