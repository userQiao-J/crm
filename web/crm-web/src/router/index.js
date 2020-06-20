import Vue from "vue";
import VueRouter from "vue-router";
import Login from "../views/Login.vue";
import Home from "../views/Home.vue";

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
    hidden: true,
    children: []
  }
];

const router = new VueRouter({
  base: process.env.BASE_URL,
  routes
});

export default router;
