import Vue from 'vue'
import Router from 'vue-router'
// import HelloWorld from '../components/demo/HelloWorld'
import home from '../components/demo/home'
// import about from '../components/demo/about'
import Login from '../components/Login'

Vue.use(Router)

export default new Router({
  routes: [
    // {
    //   path: '/',
    //   name: 'HelloWorld',
    //   component: HelloWorld
    // },
    // {
    //   path: '/about',
    //   // name: 'about',
    //   component: about
    // },
    {
      path: '/home',
      // name: 'home',
      component: home
    },
    {
      path: '/',
      name: 'Login',
      component: Login
    }
  ]
})
