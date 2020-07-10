<template>
  <div>
    <div style="width: 34%;display: inline-block">
      <el-tree
        node-key="id"
        ref="tree"
        :props="defaultProps"
        :data="allmenus"
        :expand-on-click-node="false"
      >
        <span
          class="custom-tree-node"
          slot-scope="{ node, data }"
          style="display: flex;justify-content: space-between;width: 100%"
        >
          <span>{{ node.label }}</span>
          <span>
            <el-button
              type="success"
              size="mini"
              @click="() => addMenu(data)"
              class="depBtn"
              v-if="data.url == '/'"
            >
              添加下级菜单
            </el-button>
            <el-button
              type="primary"
              size="mini"
              @click="() => showInfo(data)"
              class="depBtn"
              v-if="node.label != '所有'"
            >
              查看菜单
            </el-button>
            <el-button
              type="danger"
              size="mini"
              @click="() => deleteMenu(data)"
              class="depBtn"
              v-if="node.label != '所有'"
            >
              删除菜单
            </el-button>
          </span>
        </span>
      </el-tree>
    </div>
    <el-card
      style="width: 60%;display: inline-block;float: right"
      v-if="showMenuInfo"
    >
      <div slot="header">
        <span>菜单信息</span>
        <el-button
          style="float: right; padding: 3px 0;color: red"
          type="text"
          icon="el-icon-close"
          @click="showMenuInfo = false"
        />
      </div>
      <MenuInfo
        :menu="selectMenu"
        v-if="showMenuInfo"
        :type="showMenuInfoType"
        @initMenu="initAllMenus"
      ></MenuInfo>
    </el-card>
  </div>
</template>

<script>
import MenuInfo from "./MenuInfo";

export default {
  name: "MenuManager",
  components: { MenuInfo },
  data() {
    return {
      allmenus: [],
      defaultProps: {
        children: "children",
        label: "name"
      },
      selectMenu: "",
      showMenuInfo: false,
      showMenuInfoType: "" // 右侧显示内容的类型  1、查看/编辑菜单  2、添加子菜单
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
    },
    showInfo(data) {
      this.$set(this, "selectMenu", data);
      this.$set(this, "showMenuInfoType", 1);
      this.showMenuInfo = false;
      this.$nextTick(() => {
        this.showMenuInfo = true;
      });
    },
    addMenu(data) {
      this.$set(this, "selectMenu", data);
      this.$set(this, "showMenuInfoType", 2);
      this.showMenuInfo = false;
      this.$nextTick(() => {
        this.showMenuInfo = true;
      });
    },
    deleteMenu(data) {
      console.log(data);
      this.$confirm("是否删除改目录?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      })
        .then(() => {
          this.deleteRequest("/system/basic/menu/" + data.id).then(resp => {
            if (resp && resp.status == 200) {
              this.initAllMenus();
              this.$message.success(resp.msg);
            }
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
};
</script>

<style scoped>
.depBtn {
  padding: 2px;
}
</style>
