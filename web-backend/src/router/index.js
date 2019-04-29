import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/login/Login.vue'
import Main from '../components/Main.vue'
import UserList from '../components/content/userList/UserList.vue'
import ConsumeMonth from '../components/content/consumeMonth/ConsumeMonth.vue'
import ConsumeDay from "../components/content/consumeDay/ConsumeDay.vue"

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
        {path: '/consumeMonth', name: 'consumeMonth', component: ConsumeMonth},
        {path: '/consumeDay', name: 'ConsumeDay', component: ConsumeDay}
      ]
    }
  ]
})
