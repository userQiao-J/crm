<template>
  <div>
    <el-container>
      <el-header class="homeHeader">
        <div class="title">CRM客户管理系统</div>
        <el-dropdown class="userInfo" @command="commandHandler">
          <span class="el-dropdown-link">
            {{ user.name }}<i><img :src="user.userface" alt="头像"/></i>
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item command="userinfo">个人中心</el-dropdown-item>
            <el-dropdown-item command="setting">设置</el-dropdown-item>
            <el-dropdown-item command="loginout" divided
              >注销登录</el-dropdown-item
            >
          </el-dropdown-menu>
        </el-dropdown>
      </el-header>
      <el-container>
        <el-aside>
          <el-menu router>
            <div
              v-for="(item, index) in this.$router.options.routes"
              :key="index"
            >
              <el-submenu index="1" v-if="!item.hidden">
                <template slot="title">
                  <span>{{ item.name }}</span>
                </template>
                <el-menu-item
                  :index="child.path"
                  v-for="(child, indexj) in item.children"
                  :key="indexj"
                  >{{ child.name }}</el-menu-item
                >
              </el-submenu>
            </div>
          </el-menu>
        </el-aside>
        <el-main>
          <router-view />
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
export default {
  name: "Home",
  data() {
    return {
      user: JSON.parse(window.sessionStorage.getItem("user"))
    };
  },
  methods: {
    commandHandler(cmd) {
      if (cmd == "loginout") {
        this.$confirm("此操作将注销登录, 是否继续?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        })
          .then(() => {
            this.getRequest("/logout").then(() => {
              window.sessionStorage.removeItem("user");
              this.$router.replace("/");
            });
          })
          .catch(() => {
            this.$message({
              type: "info",
              message: "已取消删除"
            });
          });
      }
    }
  }
};
</script>

<style scoped>
.homeHeader {
  display: flex;
  background-color: #409eff;
  align-items: center;
  border-bottom: aliceblue solid 1px;
  justify-content: space-between;
  padding: 0px 15px;
}

.homeHeader .title {
  font-size: 30px;
  font-family: 楷体;
  color: white;
}

.homeHeader .userInfo {
  cursor: pointer;
}

.el-dropdown-link img {
  width: 48px;
  height: 48px;
  border-radius: 50%;
  margin-left: 10px;
}

.el-dropdown-link {
  display: flex;
  align-items: center;
}
</style>
