<template>
  <div class="home">
    <!--轮播图-->
    <swiper/>
      <section class="index-news">
        <hgroup class="columnTitle">
          <a class="more">
            <h3>CORPORATE PURPOSE</h3>
            <h2>企业宗旨</h2>
          </a>
        </hgroup>
      </section>
      <div class="column_content">
        <ul>
          <li v-for="(item,index) in newsList" :key="index">
              <span class="img_container">
                <img :src="item.picImg"
              alt="企业宣言">
              </span>
              <span class="txt_container">
                <h3>{{item.picTitle}}</h3>
                <p>{{item.picDetail}}</p>
                <!-- <span class="time">{{item.time}}</span> -->
              </span>
          </li>
        </ul>
      </div>
    </div>
</template>

<script>
import Swiper from '../components/Swiper'
import ContentList from '../components/ContentList'
import { getSongList, getAllSinger } from '../api/index'
import { newsList } from '../assets/data/componyNews'
export default {
  name: 'home',
  components: {
    Swiper,
    ContentList
  },
  data () {
    return {
      songsList: [
        {name: '歌单', list: []},
        {name: '歌手', list: []}
      ],
      newsList: []
    }
  },
  created () {
    this.newsList = newsList
    console.log(newsList)
    // 获取歌单列表
    this.getSongList('songList')
    // 获取歌手列表
    this.getSinger('singer')
  },
  methods: {
    getSongList (path) {
      getSongList()
        .then(res => {
          this.songsList[0].list = res.slice(0, 10)
        })
        .catch(err => {
          console.log(err)
        })
    },
    getSinger () {
      getAllSinger().then(res => {
        this.songsList[1].list = res.slice(0, 10)
      })
        .catch(err => {
          console.log(err)
        })
    }
  }
}
</script>

<style scoped>
div {
  box-sizing: border-box;
  font-family: 'Microsoft YaHei';
}
section{
  zoom: 1;
}
.column_content{
    color: #2D2D2D;
    font-size: 14px;
    line-height: 1.75em;
    text-align: left;
}
.columnTitle {
    padding: 3em 0 2em;
    text-align: center;
    position: relative;
}
.columnTitle h3 {
    text-transform: uppercase;
    font-size: 14px;
    line-height: 1.5em;
    color: #2B2B2B;
    font-weight: bold;
    padding-bottom: 0.5em;
}
.columnTitle .more h2, .columnTitle .more h1 {
    padding: 0 0 0.25em;
    *background-position: center bottom;
    line-height: 1.75em;
}

.columnTitle h2, .columnTitle h1 {
    position: relative;
    font-size: 32px;
    font-weight: lighter;
    color: #5d5d5d;
    line-height: 1.5em;
    *background: url(../assets/img/news/columntitle.png) no-repeat center top;
    letter-spacing: 1em;
    text-indent: 1em;
    padding-top: 1em;
}
.columnTitle .more h2:after, .columnTitle .more h1:after {
    top: auto;
    bottom: 0;
}
.columnTitle h2:after, .columnTitle h1:after {
    content: "";
    position: absolute;
    width: 1em;
    height: 0.125em;
    background: #E51628;
    position: absolute;
    left: 50%;
    top: 0;
    margin-left: -0.5em;
}
li {
    display: list-item;
    text-align: -webkit-match-parent;
}
.column_content ul {
    width: 100%;
    max-width: 1200px;
}
.column_content ul {
    position: relative;
    margin: 0 auto;
    list-style-type: none;
    overflow: hidden;
    zoom: 1;
    width: 95%;
}
ul {
    display: block;
    list-style-type: disc;
    margin-block-start: 2.0em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    padding-inline-start: 10%;
}

.column_content li {
    float: left !important;
    clear: none !important;
    margin-right: calc(50% - 528px);
}
.column_content li {
    width: 25%;
    float: left;
    *margin-bottom: -5px;
}
.column_content li a {
    position: relative;
    display: block;
}
.img_container {
    position: relative;
    display: block;
    width: 100%;
    padding: 56.25% 0 0;
    height: 0;
    overflow: hidden;
}
.img_container img {
    position: absolute;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
}
li:hover img{
  transform: scale(1.05);
}
li:hover img{
  transform: scale(1.05);
}
.img_container img {
    transition: all 0.4s ease;
    cursor: pointer;
}
.img_container .iea {
    position: absolute;
    left: 0;
    top: 0;
    bottom: 0;
    width: 100%;
    height: 100%;
    /* background: url(../images/tm.gif); */
    z-index: 5;
    zoom: 1;
    display: block;
}
.txt_container {
    display: block;
    padding: 6.25% 0 10%;
    *background: url(../assets/img/news/news_more.png) no-repeat left bottom;
}
.txt_container h3 {
    font-size: 17px;
    line-height: 1.25em;
    height: 3.75em;
    overflow: hidden;
    color: #353535;
    -webkit-transition: all 0.5s ease-out;
    -moz-transition: all 0.5s ease-out;
    transition: all 0.5s ease-out;
}
.txt_container p {
    font-size: 14px;
    line-height: 1.75em;
    height: 5.25em;
    overflow: hidden;
    color: #9F9F9F;
    word-break: break-all;
}
.txt_container .time {
    position: absolute;
    left: 0;
    bottom: 1em;
    line-height: 3em;
    font-size: 16px;
    font-weight: bold;
    color: #E41828;
}
/* .txt_container:after {
    content: "了解更多 >";
    position: absolute;
    left: 0;
    bottom: 1em;
    width: 100%;
    text-align: right;
    line-height: 3em;
    font-size: 16px;
    font-weight: bold;
    color: #000;
    border-top: 1px solid #B2B2B2;
} */
a:link, a:visited, a:active {
    color: #2D2D2D;
    text-decoration: none;
}
a {
    -webkit-transition: all .5s ease;
    -moz-transition: all .5s ease;
    transition: all .5s ease;
}
a {
    outline: 0;
    cursor: pointer;
}
</style>
