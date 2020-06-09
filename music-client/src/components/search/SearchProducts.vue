<template>
  <div class="search-products">
    <content-list :contentList="listOfProducts"></content-list>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { mixin } from '../../mixins'
import ContentList from '../ContentList'

export default {
  name: 'search-products',
  components: {
    ContentList
  },
  mixins: [mixin],
  computed: {
    ...mapGetters([
      'listOfProducts' // 存放的音乐
    ])
  },
  data () {
    return {
      pageSize: 15, // 页数
      currentPage: 1,
      listLength: 0
    }
  },
  mounted () {
    this.getProducts()
  }
}
</script>

<style scoped>
  .search-products{
    min-height: 300px;
  }
</style>
