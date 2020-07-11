<template>
  <div>
    <el-tabs v-model="activeName" type="card">
      <el-tab-pane label="菜单管理" name="menuManage">
        <menu-manager />
      </el-tab-pane>
      <el-tab-pane label="部门管理" name="depManage">
        <dep-manage />
      </el-tab-pane>
      <el-tab-pane label="权限组" name="permiss-manager">
        <permiss-manager />
      </el-tab-pane>
    </el-tabs>
  </div>
</template>

<script>
import DepManage from "../../components/sys/basic/DepManage";
import MenuManager from "../../components/sys/basic/MenuManager";
import PermissManager from "../../components/sys/basic/PermissManager";

export default {
  name: "SysBasic",
  data() {
    return {
      activeName: "menuManage"
    };
  },
  components: {
    DepManage,
    MenuManager,
    PermissManager
  }
};
</script>

<style scoped></style>
