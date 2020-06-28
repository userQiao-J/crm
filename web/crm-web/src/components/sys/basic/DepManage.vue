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
            @click="() => deleteDep(data)"
          >
            删除部门
          </el-button>
        </span>
      </span>
    </el-tree>
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
          this.deps = resp;
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
      console.log(data);
    },
    deleteDep(data) {
      console.log(data);
    }
  }
};
</script>

<style scoped>
.depBtn {
  padding: 2px;
}
</style>
