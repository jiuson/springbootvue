import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/login/Login'
import Main from "../components/Main"
import UserList from '../components/content/UserList'
import ConsumeMonth from "../components/content/ConsumeMonth";

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: Login
    },
    {
      path: '/main',
      name: 'main',
      component: Main,
      children: [
        {path: '/userList', name: 'userList', component: UserList},
        {path: '/consumeMonth', name: 'consumeMonth', component: ConsumeMonth}
      ]
    }
  ]
})
