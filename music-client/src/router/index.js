import Vue from 'vue'
import Router from 'vue-router'
import LoginIn from '@/pages/LoginIn'
import LoginUp from '@/pages/LoginUp'
import Home from '@/pages/Home'
import SongList from '@/pages/SongList'
import Singer from '@/pages/Singer'
import MyMusic from '@/pages/MyMusic'
import SongListAlbum from '@/pages/SongListAlbum'
import SingerAlbum from '@/pages/SingerAlbum'
import Search from '@/pages/Search'
import Setting from '@/pages/Setting'
import Lyric from '@/pages/Lyric'
import ProductList from '@/pages/ProductList'
import ProductDetail from '@/pages/ProductDetail'
import LoseConnect from '@/pages/LoseConnect'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '*',
      redirect: '/404'
    },
    {
      path: '/404',
      component: resolve => require(['../pages/404.vue'], resolve)
    },
    {
      path: '/lose-connect',
      name: 'lose-connect',
      component: LoseConnect
    },
    {
      path: '/login-in',
      name: 'login-in',
      component: LoginIn
    },
    {
      path: '/login-up',
      name: 'login-up',
      component: LoginUp
    },
    {
      path: '/',
      name: 'home',
      component: Home
    },
    {
      path: '/song-list',
      name: 'song-list',
      component: SongList
    },
    {
      path: '/product-list',
      name: 'product-list',
      component: ProductList,
      meta: {
        keepAlive: true
      }
    },
    {
      path: '/product-detail/:productId',
      name: 'product-detail',
      component: ProductDetail
    },
    {
      path: '/my-music',
      name: 'my-music',
      component: MyMusic
    },
    {
      path: '/song-list-album/:id',
      name: 'song-list-album',
      component: SongListAlbum
    },
    {
      path: '/singer',
      name: 'singer',
      component: Singer
    },
    {
      path: '/singer-album/:id',
      name: 'singer-album',
      component: SingerAlbum
    },
    {
      path: '/lyric/:id',
      name: 'lyric',
      component: Lyric
    },
    {
      path: '/search',
      name: 'search',
      component: Search
    },
    {
      path: '/setting',
      name: 'setting',
      component: Setting
    }
  ],
  mode: 'history',
  scrollBehavior (to, from, savedPosition) {
    if (savedPosition) {
      return savedPosition
    } else {
      return {x: 0, y: 0}
    }
  }
})

// const originalPush = Router.prototype.push
// Router.prototype.push = function push (location) {
//   return originalPush.call(this, location).catch(err => err)
// }