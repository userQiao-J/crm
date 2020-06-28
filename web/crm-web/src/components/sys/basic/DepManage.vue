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
      :filter-node-method="filterNode"
      ref="tree"
    >
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
    }
  }
};
</script>
