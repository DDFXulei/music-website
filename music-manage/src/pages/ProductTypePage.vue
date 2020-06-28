<template>
  <div class="table">
    <div class="container">
      <div class="handle-box">
        <el-input v-model="select_word" size="mini" placeholder="筛选关键词" class="handle-input mr10"></el-input>
        <el-button type="primary" size="mini" @click="centerDialogVisible = true">添加产品类别</el-button>
      </div>
      <el-table ref="multipleTable" size="mini" border style="width: 100%" height="550px" :data="data" @selection-change="handleSelectionChange">
        <el-table-column label="序号" type="index" width="50"></el-table-column>
        <el-table-column label="产品类别Id" width="80" align="center">
          <template slot-scope="scope">
            <div>{{scope.row.productTypeId}}</div>
          </template>
        </el-table-column>
        <el-table-column label="产品类别" width="120" align="center">
          <template slot-scope="scope">
            <div>{{scope.row.productTypeName}}</div>
          </template>
        </el-table-column>
        <!-- <el-table-column prop="productTitle" label="产品简介" width="100" align="center"></el-table-column> -->
        <el-table-column label="操作" width="150" align="center">
          <template slot-scope="scope">
            <el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.row.productTypeId)">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <div class="pagination">
        <el-pagination
          @current-change="handleCurrentChange"
          background
          layout="total, prev, pager, next"
          :current-page="currentPage"
          :page-size="pageSize"
          :total="tableData.length">
        </el-pagination>
      </div>
    </div>

    <el-dialog title="添加产品类别" :visible.sync="centerDialogVisible" width="450px" center>
      <el-form
        :model="registerForm"
        status-icon
        ref="registerForm"
        label-width="80px"
        class="demo-ruleForm"
        >
       <el-form-item label="产品类别">
          <el-input v-model="registerForm.productTypeName"></el-input>
        </el-form-item>

      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button size="mini" @click="centerDialogVisible = false">取 消</el-button>
        <el-button type="primary" size="mini" @click="addProductType">确 定</el-button>
      </span>
    </el-dialog>

    <!-- 编辑弹出框 -->
    <el-dialog title="编辑" :visible.sync="editVisible" width="450px">
      <el-form ref="formData" :model="formData" label-width="80px">
        <el-form-item label="产品类别Id">
          <el-input :disabled="true" v-model="formData.productTypeId"></el-input>
        </el-form-item>
        <el-form-item label="产品类别">
          <el-input v-model="formData.productTypeName"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button size="mini"  @click="editVisible = false">取 消</el-button>
        <el-button type="primary" size="mini" @click="saveEdit">确 定</el-button>
      </span>
    </el-dialog>

    <!-- 删除提示框 -->
    <el-dialog title="提示" :visible.sync="delVisible" width="300px" center>
      <div class="del-dialog-cnt" align="center">删除不可恢复，是否确定删除？</div>
      <span slot="footer" class="dialog-footer">
        <el-button size="mini" @click="delVisible = false">取 消</el-button>
        <el-button type="primary" size="mini" @click="deleteRow">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import { mixin } from '../mixins'
import { getProductTypeList, updateProductType, setProductType, deleteProductType } from '../api/index'

export default {
  name: 'product-type-page',
  mixins: [mixin],
  data () {
    return {
      productTypeId: '',
      productTypeName: '',

      registerForm: {
        // 添加框信息
        productTypeName: ''
      },
      tableData: [],
      tempDate: [],
      multipleSelection: [],
      centerDialogVisible: false,
      editVisible: false,
      delVisible: false,
      select_word: '',
      formData: {
        // 编辑框信息
        productTypeId: '',
        productTypeName: ''
      },
      pageSize: 25, // 页数
      currentPage: 1, // 当前页
      idx: -1
    }
  },
  computed: {
    // 计算当前表格中的数据
    data () {
      return this.tableData.slice((this.currentPage - 1) * this.pageSize, this.currentPage * this.pageSize)
    }
  },
  watch: {
    select_word: function () {
      if (this.select_word === '') {
        this.tableData = this.tempDate
        // console.log(this.tableData)
      } else {
        this.tableData = []
        for (let item of this.tempDate) {
          if (item.productTypeName.includes(this.select_word)) {
            this.tableData.push(item)
          }
        }
      }
    }
  },
  created () {
    this.getData()
  },
  methods: {
    // 获取当前页
    handleCurrentChange (val) {
      this.currentPage = val
    },

    // 添加产品类别
    addProductType () {
      let params = new URLSearchParams()
      params.append('productTypeName', this.registerForm.productTypeName)
      setProductType(params)
        .then(res => {
          if (res.code === 1) {
            this.getData()
            this.registerForm = {}
            this.notify('添加成功', 'success')
          } else {
            this.notify('添加失败', 'error')
          }
        })
        .catch(err => {
          console.log(err)
        })
      this.centerDialogVisible = false
    },
    // 获取产品
    getData () {
      this.tableData = []
      this.tempDate = []
      getProductTypeList().then(res => {
        this.tableData = res
        this.tempDate = res
        this.currentPage = 1
        console.log(this.tableData)
      })
    },
    // 编辑
    handleEdit (row) {
      this.editVisible = true
      this.productTypeId = row.productTypeId
      this.productTypeName = row.productTypeName
      this.formData = {
        productTypeId: row.productTypeId,
        productTypeName: row.productTypeName
      }
      // console.log(this.formData)
    },
    // 保存编辑
    saveEdit () {
      let d = new Date()
      let datetime = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate()
      let params = new URLSearchParams()
      params.append('productTypeId', this.formData.productTypeId)
      params.append('productTypeName', this.formData.productTypeName)
      params.append('updateTime', datetime)
      updateProductType(params)
        .then(res => {
          if (res.code === 1) {
            this.getData()
            this.notify('编辑成功', 'success')
          } else {
            this.notify('编辑失败', 'error')
          }
        })
        .catch(err => {
          console.log(err)
        })
      this.editVisible = false
    },
    handleDelete (productTypeId) {
      this.productTypeId = productTypeId
      this.delVisible = true
    },
    // 确定删除
    deleteRow () {
      deleteProductType(this.productTypeId)
        .then(res => {
          if (res) {
            this.getData()
            this.notify('删除成功', 'success')
          } else {
            this.notify('删除失败', 'error')
          }
        })
        .catch(err => {
          console.log(err)
        })
      this.productTypeId = ''
      this.delVisible = false
    },
    productEdit (productId, productName) {
      this.$router.push({path: `/param`, query: {productId: productId, productName: productName}})
    }
  }
}
</script>

<style scoped>
.handle-box {
  margin-bottom: 20px;
}

.handle-input {
  width: 300px;
  display: inline-block;
}

.product-img {
  width: 100%;
  height: 80px;
  border: 1px solid balck;
  border-radius: 5px;
  margin-bottom: 5px;
  overflow: hidden;
}

.pagination {
  display: flex;
  justify-content: center;
}
</style>
