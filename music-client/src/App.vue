<template>
  <div id="app">
    <the-header/>
    <the-aside></the-aside>
    <keep-alive>
      <router-view class="music-content" v-if="$route.meta.keepAlive"/>
    </keep-alive>
    <router-view v-if="!$route.meta.keepAlive"></router-view>
    <!-- <play-bar/> -->
    <scroll-top/>
    <the-footer/>
  </div>
</template>

<script>
import ScrollTop from './components/ScrollTop'
import SongAudio from './components/SongAudio'
import TheHeader from './components/TheHeader'
import TheFooter from './components/TheFooter'
// import PlayBar from './components/PlayBar'
import TheAside from './components/TheAside'

export default {
  name: 'App',
  components: {
    ScrollTop,
    SongAudio,
    TheHeader,
    TheFooter,
    TheAside
    // PlayBar
  }
}
</script>

<style>
#app{
  background-color: #e6ecf0;
  display: flex;
  flex-direction: column;
}
.music-content{
  flex: 1;
}
</style>
