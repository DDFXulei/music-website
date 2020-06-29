<template>
  <div class="table">
    <div class="container">
      <div class="handle-box">
        <el-button type="primary" size="mini" class="handle-del mr10" @click="delAll">批量删除</el-button>
        <el-input v-model="select_word" size="mini" placeholder="筛选关键词" class="handle-input mr10"></el-input>
        <el-button type="primary" size="mini" @click="centerDialogVisible = true">添加产品</el-button>
      </div>
      <el-table ref="multipleTable" size="mini" border style="width: 100%" height="550px" :data="data" @selection-change="handleSelectionChange">
      <!-- <el-table-column label="序号" type="index" width="40"></el-table-column> -->
        <el-table-column type="selection" width="40"></el-table-column>
        <el-table-column label="产品图片" width="110" align="center">
          <template slot-scope="scope">
            <div class="product-img">
              <img :src="getUrl(scope.row.productPic)" alt="" style="width: 100%;"/>
            </div>
            <el-upload
              class="upload-demo"
              :action="uploadUrl('avatar',scope.row.productId)"
              :show-file-list="false"
              :on-success="handleAvatarSuccess"
              :before-upload="beforeAvatarUpload"
              >
              <el-button size="mini">更新图片</el-button>
            </el-upload>
          </template>
        </el-table-column>
        <!-- <el-table-column label="技术参数图片" width="110" align="center">
          <template slot-scope="scope">
            <div class="product-img">
              <img :src="getUrl(scope.row.pic)" alt="" style="width: 100%;"/>
            </div>
            <el-upload
              class="upload-demo"
              :action="uploadUrl(scope.row.id)"
              :show-file-list="false"
              :on-success="handleAvatarSuccess"
              :before-upload="beforeAvatarUpload"
              >
              <el-button size="mini">更新图片</el-button>
            </el-upload>
          </template>
        </el-table-column> -->
        <el-table-column prop="productName" label="产品名称" width="120" align="center"></el-table-column>
        <el-table-column label="产品类别" width="120" align="center">
          <template slot-scope="scope">
            <div>{{scope.row.productType}}</div>
          </template>
        </el-table-column>
        <el-table-column label="产品标题" width="120" align="center">
          <template slot-scope="scope">
            <p style="height: 100px; overflow: scroll">{{ scope.row.productTitle }}</p>
          </template>
        </el-table-column>
        <!-- <el-table-column prop="productTitle" label="产品简介" width="100" align="center"></el-table-column> -->
        <el-table-column label="产品简介">
          <template slot-scope="scope">
            <p style="height: 100px; overflow: scroll">{{ scope.row.productIntro }}</p>
          </template>
        </el-table-column>
        <el-table-column label="操作" width="150" align="center">
          <template slot-scope="scope">
            <el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button>
            <el-button size="mini" type="danger" @click="handleDelete(scope.row.productId)">删除</el-button>
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

<!--  添加产品 -->
    <el-dialog title="添加产品" :visible.sync="centerDialogVisible" width="400px" center>
      <el-form
        :rules="rules"
        :model="registerForm"
        status-icon
        ref="registerForm"
        label-width="80px"
        class="demo-ruleForm"
        >
       <el-form-item label="产品名称" prop="productName">
          <el-input v-model="registerForm.productName" placeholder="请输入产品名称"></el-input>
        </el-form-item>
        <el-form-item label="产品图片">
          <el-upload
            class="avatar-uploader"
            action="https://jsonplaceholder.typicode.com/posts/"
            :show-file-list="false"
            :on-success="handleAvatarSuccess"
            :before-upload="beforeAvatarUpload">
            <img v-if="imageUrl" :src="imageUrl" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
          </el-upload>
        </el-form-item>
        <el-form-item label="产品类别">
          <el-select v-model="registerForm.productType" placeholder="请选择产品类别">
            <el-option
            v-for="item in options"
            :key="item.type"
            :label="item.name"
            :value="item.type"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="产品标题">
          <el-input
            type="textarea"
            autosize
            placeholder="请输入产品标题"
            v-model="registerForm.productTitle">
          </el-input>
        </el-form-item>
        <el-form-item label="产品简介">
          <el-input
            type="textarea"
            autosize
            placeholder="请输入产品简介"
            v-model="registerForm.productIntro">
          </el-input>
        </el-form-item>
        <el-form-item label="产品参数">
            <el-upload
              class="avatar-uploader"
              action="https://jsonplaceholder.typicode.com/posts/"
              :show-file-list="false"
              :on-success="handleAvatarSuccess"
              :before-upload="beforeAvatarUpload">
              <img v-if="imageUrl" :src="imageUrl" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button size="mini" @click="centerDialogVisible = false">取 消</el-button>
        <el-button type="primary" size="mini" @click="addsinger">确 定</el-button>
      </span>
    </el-dialog>

    <!-- 编辑弹出框 -->
    <el-dialog title="编辑" :visible.sync="editVisible" width="80%">
      <el-form ref="formData" :model="formData" label-width="10%">
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
        <el-form-item label="产品标题">
          <el-input
            type="textarea"
            autosize
            placeholder="请输入产品标题"
            v-model="formData.productIntro">
          </el-input>
        </el-form-item>
        <el-form-item label="产品简介">
          <el-input
            type="textarea"
            autosize
            placeholder="请输入产品简介"
            v-model="formData.productIntro">
          </el-input>
        </el-form-item>
        <el-form-item label="产品参数">
            <div class="product-img">
              <img :src="getUrl(formData.productParam)" alt="" style="width: 100%;"/>
            </div>
            <el-upload
              class="upload-demo"
              :action="uploadUrl('param',formData.productId)"
              :show-file-list="false"
              :on-success="handleAvatarSuccess"
              :before-upload="beforeAvatarUpload"
              >
              <el-button size="mini">添加图片</el-button>
            </el-upload>
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
import { setSinger, getProductList, updateSingerMsg, deleteSinger } from '../api/index'

export default {
  name: 'product-page',
  mixins: [mixin],
  data () {
    return {
      imageUrl: '',
      rules: {
        productName: [
          { required: true, message: '请输入产品名称', trigger: 'blur' }
        ]
      },
      registerForm: {
        // 添加框信息
        productName: '',
        productTitle: '',
        productType: '',
        productIntro: '',
        productParam: ''
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
        productId: '',
        productName: '',
        productTitle: '',
        productType: '',
        productIntro: '',
        productParam: ''
      },
      pageSize: 5, // 页数
      currentPage: 1, // 当前页
      idx: -1,
      options: [
        {
          name: '吸附式干燥机',
          type: 1
        },
        {
          name: '冷冻式干燥机',
          type: 2
        },
        {
          name: '管道过滤器',
          type: 4
        },
        {
          name: '制氮机',
          type: 8
        },
        {
          name: '工艺气体干燥',
          type: 16
        },
        {
          name: '其他辅助产品',
          type: 32
        }
      ]
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
    this.getData()
  },
  methods: {
    // handleClose (done) {
    //   this.$confirm('确认关闭？')
    //     .then(_ => {
    //       done()
    //     })
    //     .catch(_ => {})
    // },
    // 获取当前页
    handleCurrentChange (val) {
      this.currentPage = val
    },
    uploadUrl (name, id) {
      return `${this.$store.state.HOST}/product/${name}/update?id=${id}`
    },
    // 添加歌手
    addsinger () {
      let d = this.registerForm.birth
      let datetime = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate()
      let params = new URLSearchParams()
      params.append('name', this.registerForm.name)
      params.append('sex', this.registerForm.sex)
      params.append('pic', '/img/singerPic/hhh.jpg')
      params.append('birth', datetime)
      params.append('location', this.registerForm.location)
      params.append('introduction', this.registerForm.introduction)
      setSinger(params)
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
      getProductList().then(res => {
        this.tableData = res
        this.tempDate = res
        this.currentPage = 1
        console.log(this.tableData)
      })
    },
    // 编辑
    handleEdit (row) {
      this.editVisible = true
      this.idx = row.productId
      this.formData = {
        productId: row.productId,
        productName: row.productName,
        productTitle: row.productTitle,
        productType: row.productType,
        productIntro: row.productIntro,
        productParam: row.productParam
      }
    },
    // 保存编辑
    saveEdit () {
      let d = new Date(this.form.birth)
      let datetime = d.getFullYear() + '-' + (d.getMonth() + 1) + '-' + d.getDate()
      let params = new URLSearchParams()
      params.append('id', this.form.id)
      params.append('name', this.form.name)
      params.append('sex', this.form.sex)
      params.append('pic', this.form.pic)
      params.append('birth', datetime)
      params.append('location', this.form.location)
      params.append('introduction', this.form.introduction)
      updateSingerMsg(params)
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
    // 确定删除
    deleteRow () {
      deleteSinger(this.idx)
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
      this.delVisible = false
    },
    productEdit (productId, productName) {
      this.$router.push({path: `/param`, query: {productId: productId, productName: productName}})
    }
  },
  handleAvatarSuccess (res, file) {
    this.imageUrl = URL.createObjectURL(file.raw)
  },
  beforeAvatarUpload (file) {
    const isJPG = file.type === 'image/jpeg'
    const isLt2M = file.size / 1024 / 1024 < 2

    if (!isJPG) {
      this.$message.error('上传头像图片只能是 JPG 格式!')
    }
    if (!isLt2M) {
      this.$message.error('上传头像图片大小不能超过 2MB!')
    }
    return isJPG && isLt2M
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

  .avatar-uploader{
    height: 150px;
    width: 180px;
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>
