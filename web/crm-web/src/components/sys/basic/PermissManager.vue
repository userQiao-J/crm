<template>
  <div>
    <div class="perManagerTool">
      <el-input
        size="small"
        placeholder="请输入角色英文名称"
        v-model="role.name"
      >
        <template slot="prepend">ROLE_</template>
      </el-input>
      <el-input
        size="small"
        v-model="role.nameZh"
        placeholder="请输入角色中文名称"
      ></el-input>
      <el-button type="primary" size="small" icon="el-icon-plus"
        >添加角色</el-button
      >
    </div>
    <div style="margin-top: 10px;width: 700px">
      <el-collapse v-model="activeName" accordion @change="change">
        <el-collapse-item
          :title="r.nameZh"
          :name="r.id"
          v-for="(r, index) in roles"
          :key="index"
        >
          <el-card class="box-card">
            <div slot="header" class="clearfix">
              <span>可访问的资源</span>
              <el-button
                style="float: right; padding: 3px 0;color: red"
                icon="el-icon-delete"
                type="text"
              ></el-button>
            </div>
            <div>
              <el-tree
                show-checkbox
                node-key="id"
                ref="tree"
                :default-checked-keys="selectedMenus"
                :data="allmenus"
                :props="defaultProps"
              >
              </el-tree>
              <div style="display: flex;justify-content: flex-end">
                <el-button size="mini" @click="exitUpdate">取消修改</el-button>
                <el-button
                  size="mini"
                  type="primary"
                  @click="doUpdate(r.id, index)"
                  >确认修改</el-button
                >
              </div>
            </div>
          </el-card>
        </el-collapse-item>
      </el-collapse>
    </div>
  </div>
</template>

<script>
export default {
  name: "PermissManager",
  data() {
    return {
      role: {
        name: "",
        nameZh: ""
      },
      roles: [],
      allmenus: [],
      selectedMenus: [], //选中的菜单项
      defaultProps: {
        children: "children",
        label: "name"
      },
      activeName: -1
    };
  },
  mounted() {
    this.initRoles();
  },
  methods: {
    initRoles() {
      this.getRequest("/system/basic/permiss/getAllRoles").then(resp => {
        if (resp.object) {
          console.log(resp.object);
          this.roles = resp.object;
        }
      });
    },
    // 根据角色ID获取选中项的菜单列表ID
    initSelectMenus(rid) {
      this.getRequest(`/system/basic/permiss/getMidsByRid/` + rid).then(
        resp => {
          console.log(resp);
          if (resp.object) {
            this.selectedMenus = resp.object;
          }
        }
      );
    },
    change(rid) {
      if (rid) {
        this.initAllMenus();
        this.initSelectMenus(rid);
      }
    },
    initAllMenus() {
      this.getRequest("/system/basic/permiss/menus").then(resp => {
        if (resp.object) {
          console.log(resp.object);
          this.allmenus = resp.object;
        }
      });
    },
    doUpdate(rid, index) {
      // 修改角色与菜单的关联关系
      let tree = this.$refs.tree[index];
      let selectKeys = tree.getCheckedKeys(true);
      let url = "/system/basic/permiss/?rid=" + rid + "&mids=" + selectKeys;
      this.putRequest(url).then(resp => {
        if (resp) {
          this.$message.success(resp.msg);
          this.initRoles();
          this.activeName = -1;
        }
      });
    },
    exitUpdate() {
      this.activeName = -1;
    }
  }
};
</script>

<style scoped>
.perManagerTool .el-input {
  width: 300px;
  margin-right: 5px;
}
</style>
