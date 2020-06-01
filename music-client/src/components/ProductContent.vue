<template>
  <div class="content">
      <div class="container">
          <div class="firstone">
              <div class="list">
                <ul>
                    <li>
                        <div class="box">
                            <div class="pic"></div>
                            <img src="" alt="">
                            <div class="hover"></div>
                        </div>                              
                    </li>
                </ul>
              </div>
          </div>
      </div>
  </div>
</template>

<script>
import {mixin} from '../mixins'
import { mapGetters } from 'vuex'

export default {
  name: 'album-content',
  mixins: [mixin],
  props: [
    'songList'
  ],
  computed: {
    ...mapGetters([
      'id' // 音乐ID
    ])
  }
}
</script>

<style scoped>
  *{
    box-sizing: border-box;
  }
  div{
    margin: 0;
    padding: 0;
    font-family: "Microsoft YaHei";
  }
  .content {
    padding-top: 45px;
    overflow: hidden;
  }
  .container .title {
      font-size: 30px;
  }
  .list ul {
    list-style-type: none;
    margin: 0 -9px;
    overflow: hidden;
  }
  .container .list ul li {
    width: 16.666667%;
    float: left;
    padding: 0 9px;
  }
  .pic {
        width: 100%;
        overflow: hidden;
        position: relative;
  }
  .hover {
    height: 37px;
    line-height: 37px;
    text-align: center;
    font-size: 16px;
    color: #fff;
    background: rgba(0,0,0,0.5);
    position: absolute;
    bottom: 0;
    left: 0;
    width: 100%;
}

</style>
