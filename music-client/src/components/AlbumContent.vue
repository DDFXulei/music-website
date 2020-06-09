<template>
  <div class="content">
    <h1 class="title">
      <slot name="title"></slot>
    </h1>
    <hr>
    <ul>
      <li class="list-title">
        <div class="product-item">
          <span class="item-index"></span>
          <span class="item-title">产品名称</span>
          <span class="item-intro">产品简介</span>
        </div>
      </li>
      <li class="list-content" v-for="(item, index) in productList" :key="index">
        <div class="product-item" @click="toplay()">
          <span class="item-index">{{index+1}}</span>
          <span class="item-title">{{item.productName}}</span>
          <span class="item-name">{{item.productTitle}}</span>
          <span class="item-intro">{{item.productIntro}}</span>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
import {mixin} from '../mixins'
import { mapGetters } from 'vuex'

export default {
  name: 'album-content',
  mixins: [mixin],
  props: [
    'productList'
  ],
  computed: {
    ...mapGetters([
      'productId' // 产品ID
    ])
  }
}
</script>

<style scoped>
  *{
    box-sizing: border-box;
  }
  .content {
    background-color: white;
    border-radius: 12px;
    padding: 20px 40px;
    min-width: 700px;
  }
  .content .title {
    text-align: center;
  }
  .content > ul {
    width: 100%;
    padding-bottom: 50px;
  }
  .content > ul > li {
    border-bottom: 1px solid rgba(0, 0, 0, 0.1);
    display: block;
    height: 50px;
    line-height: 50px;
    text-indent: 20px;
  }
  .list-content {
    cursor: pointer;
  }
  .product-item {
    display: flex;
    flex-wrap: nowrap;
    overflow: hidden;
    align-items: center;
    text-overflow:ellipsis;
    white-space: nowrap;
  }
  .item-index {
    width: 5%;
  }
  .item-title {
    width: 30%;
  }
  .item-name {
    width: 20%;
  }
  .item-intro {
    width: 45%;
  }
  .icon {
    width: 1.5em;
    height: 1.5em;
    vertical-align: -0.3em;
    position: relative;
    right: 5px;
    fill: currentColor;
    overflow: hidden;
  }
</style>
