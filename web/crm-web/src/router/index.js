import Vue from "vue";
import VueRouter from "vue-router";
import Login from "../views/Login.vue";
import Home from "../views/Home.vue";
import Test from "../views/Test.vue";
Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Login",
    component: Login,
    hidden: true
  },
  {
    path: "/home",
    name: "Home",
    component: Home,
    hidden: true
  },
  {
    path: "/home",
    name:"导航一",
    component: Home,
    children: [{
      path:'/test',
      name:'TEST页面',
      component: Test
    }]
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
