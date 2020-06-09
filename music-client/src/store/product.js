const product = {
  state: {
    productId: null, // productID
    productType: '', // 产品类型
    productName: '', // 产品名称
    productTitle: '', // 产品标题
    productPic: '', // 产品图片
    createTime: '', // 产品创建时间
    updateTime: '', // 产品更新时间
    productIntro: '',
    productFeature: '',
    productParam: '',
    listLength: 0,
    listOfProducts: [] // 当前产品列表
  },
  getters: {
    productId: state => {
      let productId = state.productId
      if (!productId) {
        productId = JSON.parse(window.sessionStorage.getItem('productId') || null)
      }
      return productId
    },
    productPic: state => {
      let productPic = state.productPic
      if (!productPic) {
        productPic = JSON.parse(window.sessionStorage.getItem('productPic') || null)
      }
      return productPic
    },
    productType: state => {
      let productType = state.productType
      if (!productType) {
        productType = JSON.parse(window.sessionStorage.getItem('productType') || null)
      }
      return productType
    },
    productName: state => {
      let productName = state.productName
      if (!productName) {
        productName = JSON.parse(window.sessionStorage.getItem('productName') || null)
      }
      return productName
    },
    productTitle: state => {
      let productTitle = state.productTitle
      if (!productTitle) {
        productTitle = JSON.parse(window.sessionStorage.getItem('productTitle') || null)
      }
      return productTitle
    },
    createTime: state => {
      let createTime = state.createTime
      if (!createTime) {
        createTime = JSON.parse(window.sessionStorage.getItem('createTime') || null)
      }
      return createTime
    },
    updateTime: state => {
      let updateTime = state.updateTime
      if (!updateTime) {
        updateTime = JSON.parse(window.sessionStorage.getItem('updateTime') || null)
      }
      return updateTime
    },
    productIntro: state => {
      let productIntro = state.productIntro
      if (!productIntro) {
        productIntro = JSON.parse(window.sessionStorage.getItem('productIntro') || null)
      }
      return productIntro
    },
    productFeature: state => {
      let productFeature = state.productFeature
      if (!productFeature) {
        productFeature = JSON.parse(window.sessionStorage.getItem('productFeature') || null)
      }
      return productFeature
    },
    productParam: state => {
      let productParam = state.productParam
      if (!productParam) {
        productParam = JSON.parse(window.sessionStorage.getItem('productParam') || null)
      }
      return productParam
    },
    listOfProducts: state => {
      let listOfProducts = state.listOfProducts
      if (!listOfProducts.length) {
        listOfProducts = JSON.parse(window.sessionStorage.getItem('listOfProducts') || null)
      }
      return listOfProducts
    },
    listLength: state => {
      let listOfProducts = state.listOfProducts
      if (!listOfProducts.length) {
        listOfProducts = JSON.parse(window.sessionStorage.getItem('listOfProducts') || null)
      }
      return listOfProducts.length
    }
  },
  mutations: {
    setProductId: (state, productId) => {
      state.productId = productId
      window.sessionStorage.setItem('productId', JSON.stringify(productId))
    },
    setProductType: (state, productType) => {
      state.productType = productType
      window.sessionStorage.setItem('productType', JSON.stringify(productType))
    },
    setProductName: (state, productName) => {
      state.productName = productName
      window.sessionStorage.setItem('productName', JSON.stringify(productName))
    },
    setProductTitle: (state, productTitle) => {
      state.productTitle = productTitle
      window.sessionStorage.setItem('productTitle', JSON.stringify(productTitle))
    },
    setProductPic: (state, productPic) => {
      state.productPic = productPic
      window.sessionStorage.setItem('productPic', JSON.stringify(productPic))
    },
    setCreateTime: (state, createTime) => {
      state.createTime = createTime
      window.sessionStorage.setItem('createTime', JSON.stringify(createTime))
    },
    setUpdateTime: (state, updateTime) => {
      state.updateTime = updateTime
      window.sessionStorage.setItem('updateTime', JSON.stringify(updateTime))
    },
    setProductIntro: (state, productIntro) => {
      state.productIntro = productIntro
      window.sessionStorage.setItem('productIntro', JSON.stringify(productIntro))
    },
    setProductFeature: (state, productFeature) => {
      state.productFeature = productFeature
      window.sessionStorage.setItem('productFeature', JSON.stringify(productFeature))
    },
    setProductParam: (state, productParam) => {
      state.productParam = productParam
      window.sessionStorage.setItem('productParam', JSON.stringify(productParam))
    },
    setListOfProducts: (state, listOfProducts) => {
      state.listOfProducts = listOfProducts
      window.sessionStorage.setItem('listOfProducts', JSON.stringify(listOfProducts))
    },
    setListLength: (state, listOfProducts) => {
      state.listOfProducts = listOfProducts
      window.sessionStorage.setItem('listLength', JSON.stringify(listOfProducts.length))
    }
  },
  actions: {}
}

export default product
