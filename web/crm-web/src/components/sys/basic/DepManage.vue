<template>
  <div style="width: 40%">
    <el-input
      placeholder="请输入部门名称进行搜索"
      v-model="filterText"
      prefix-icon="el-icon-search"
    >
    </el-input>

    <el-tree
      class="filter-tree"
      :data="deps"
      :props="defaultProps"
      :expand-on-click-node="false"
      :filter-node-method="filterNode"
      ref="tree"
    >
      <span
        class="custom-tree-node"
        slot-scope="{ node, data }"
        style="display: flex;justify-content: space-between;width: 100%"
      >
        <span>{{ node.label }}</span>
        <span>
          <el-button
            class="depBtn"
            type="primary"
            size="mini"
            @click="() => showAddDevView(data)"
          >
            添加部门
          </el-button>
          <el-button
            type="danger"
            class="depBtn"
            size="mini"
            @click="deleteDep(data)"
          >
            删除部门
          </el-button>
        </span>
      </span>
    </el-tree>

    <el-dialog title="添加子部门" :visible.sync="dialogVisible" width="30%">
      <el-form :model="addDepObj" label-width="100px">
        <el-form-item label="父级部门" prop="parentName">
          <el-input v-model="addDepObj.parentName" disabled></el-input>
        </el-form-item>
        <el-form-item label="子部门名称" prop="region">
          <el-input v-model="addDepObj.name" />
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="addDepManage">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
export default {
  name: "DepManage",
  data() {
    return {
      filterText: "",
      deps: [],
      defaultProps: {
        children: "children",
        label: "name"
      },
      dialogVisible: false,
      addDepObj: {
        parentId: "",
        parentName: "",
        name: ""
      }
    };
  },
  watch: {
    filterText(val) {
      this.$refs.tree.filter(val);
    }
  },
  mounted() {
    this.initDeps();
  },
  methods: {
    initDeps() {
      this.getRequest("/system/basic/department/").then(resp => {
        if (resp) {
          // this.deps = resp;
          this.$set(this, "deps", resp);
        }
      });
    },
    filterNode(value, data) {
      if (!value) {
        return true;
      }
      return data.name.indexOf(value) !== -1;
    },
    showAddDevView(data) {
      this.addDepObj.parentId = data.id;
      this.addDepObj.parentName = data.name;
      this.dialogVisible = true;
      console.log(data);
    },
    deleteDep(data) {
      this.$confirm("是否删除部门?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.deleteRequest("/system/basic/department/" + data.id).then(
            resp => {
              if (resp && resp.status == 200) {
                this.initDeps();
                this.$message.success(resp.msg);
              }
            }
          );
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除"
          });
        });
      console.log(data);
    },
    addDepManage() {
      this.postRequest("/system/basic/department/", this.addDepObj).then(
        resp => {
          this.$message.success(resp.msg);
          this.initDeps();
        }
      );
      this.dialogVisible = false;
    }
  }
};
</script>

<style scoped>
.depBtn {
  padding: 2px;
}
</style>
