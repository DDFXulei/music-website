<template>
    <div class="content-list">
        <ul class="section-content">
          <li class="content-item" v-for="(item, index) in contentList" :key="index">
            <div class="kuo" @click="goDetail(item)">
              <img class="item-img" :src="attachImageUrl(item.productPic)" alt="">
            </div>
            <p class="item-name">{{item.productName}}</p>
          </li>
        </ul>
    </div>
</template>

<script>
import { mixin } from '../mixins'

export default {
  name: 'content-list',
  mixins: [mixin],
  props: [
    'contentList'
  ],
  methods: {
    goDetail (item) {
      console.log(item.productId)
      // this.$store.commit('setTempList', item)
      this.$store.commit('setProductId', item.productId)
      this.$store.commit('setProductType', item.productType)
      this.$store.commit('setProductPic', item.productPic)
      this.$store.commit('setProductName', item.productName)
      this.$store.commit('setUpdateTime', item.updateTime)
      this.$router.push({path: `/product-detail/${item.productId}`})
      // if (type) {
      //   this.$router.push({path: `/singer-album/${item.id}`})
      // } else {
      //   this.$router.push({path: `/song-list-album/${item.id}`})
      // }
    }
  }
}
</script>

<style scoped>

  div, ul, li, p{
    box-sizing: border-box;
  }
  .content-list {
    min-height: 500px;
    padding: 0 20px;
  }
  ul{
    padding-left: 15%;
  }
  .section-content {
    display: flex;
    flex-wrap: wrap;
    align-content: flex-start;
  }
  .content-item {
    flex-flow: column wrap;
    width: 20%;
    margin: 20px 1%;
    overflow: hidden;
    border-radius: 6px;
    -webkit-box-shadow: 0 0 5px 1px rgba(0, 0, 0, 0.1);
    -moz-box-shadow: 0 0 5px 1px rgba(0, 0, 0, 0.1);
    box-shadow: 0 0 5px 1px rgba(0, 0, 0, 0.1);
    position: relative;
  }
  li:hover{
    -webkit-box-shadow: 0 0 10px 4px rgba(0, 0, 0, 0.4);
    -moz-box-shadow: 0 0 10px 4px rgba(0, 0, 0, 0.4);
    box-shadow: 0 0 10px 4px rgba(0, 0, 0, 0.4);
    color: #0079A8;
    font-weight: bold;
  }
  li:hover .item-img{
    transform: scale(1.05);
  }

  .item-img {
    width: 100%;
    transition: all 0.4s ease;
    cursor: pointer;
  }
  .item-name {
    overflow:hidden;
    text-overflow:ellipsis;
    display:-webkit-box;
    -webkit-box-orient:vertical;
    -webkit-line-clamp:2;
    margin: 10px 8px;
  }
  .icon {
    width: 2.5em;
    height: 2.5em;
    fill: currentColor;
    color: rgba(240,240,240,1);
    font-size: 1.6em;
  }

</style>
