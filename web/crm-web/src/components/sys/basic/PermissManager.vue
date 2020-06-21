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
      <el-collapse v-model="activeName" accordion>
        <el-collapse-item title="一致性 Consistency" name="1">
          <div>
            与现实生活一致：与现实生活的流程、逻辑保持一致，遵循用户习惯的语言和概念；
          </div>
          <div>
            在界面中一致：所有的元素和结构需保持一致，比如：设计样式、图标和文本、元素的位置等。
          </div>
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
      activeName: "2"
    };
  }
};
</script>

<style scoped>
.perManagerTool .el-input {
  width: 300px;
  margin-right: 5px;
}
</style>
