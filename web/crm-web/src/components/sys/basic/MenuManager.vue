<template>
  <div style="width: 40%">
    <el-tree node-key="id" ref="tree" :props="defaultProps" :data="allmenus">
    </el-tree>
  </div>
</template>

<script>
export default {
  name: "MenuManager",
  data() {
    return {
      allmenus: [],
      defaultProps: {
        children: "children",
        label: "name"
      }
    };
  },
  mounted() {
    this.initAllMenus();
  },
  methods: {
    initAllMenus() {
      this.getRequest("/system/basic/permiss/menus").then(resp => {
        if (resp.object) {
          console.log(resp.object);
          this.allmenus = resp.object;
        }
      });
    }
  }
};
</script>

<style scoped></style>
