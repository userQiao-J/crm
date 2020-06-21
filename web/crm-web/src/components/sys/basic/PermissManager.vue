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
      <el-collapse accordion>
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
            <div></div>
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
      roles: []
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
