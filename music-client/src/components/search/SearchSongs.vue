<template>
  <div class="search-products">
    <album-content :songList="listOfSongs"></album-content>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import { mixin } from '../../mixins'
import AlbumContent from '../AlbumContent'

export default {
  name: 'search-songs',
  components: {
    AlbumContent
  },
  mixins: [mixin],
  computed: {
    ...mapGetters([
      'listOfSongs' // 存放的音乐
    ]),
    data () {
      return 1
    }
  },
  mounted () {
    this.getSong()
  }
}
</script>

<style scoped>
  .search-products{
    min-height: 300px;
  }
</style>
