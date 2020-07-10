<template>
  <div>
    <el-form
      ref="menuform"
      :model="menuForm"
      label-width="80px"
      :rules="rules"
      size="medium"
    >
      <el-form-item label="父级菜单" prop="partName" v-if="type == 2">
        <el-input
          v-model="menuForm.parentName"
          placeholder="请输入父级菜单"
          clearable
          disabled
          :style="{ width: '100%' }"
        >
        </el-input>
      </el-form-item>
      <el-form-item label="菜单名称" prop="name">
        <el-input
          v-model="menuForm.name"
          placeholder="请输入菜单名称"
          clearable
          :style="{ width: '100%' }"
        ></el-input>
      </el-form-item>
      <el-form-item label="请求地址" prop="url">
        <el-input
          v-model="menuForm.url"
          placeholder="请输入请求地址"
          clearable
          :style="{ width: '100%' }"
        ></el-input>
      </el-form-item>
      <el-form-item label="组件路径" prop="path">
        <el-input
          v-model="menuForm.path"
          placeholder="请输入组件路径"
          clearable
          :style="{ width: '100%' }"
        ></el-input>
      </el-form-item>
      <el-form-item label="组件名称" prop="component">
        <el-input
          v-model="menuForm.component"
          placeholder="请输入组件名称"
          clearable
          :style="{ width: '100%' }"
        >
        </el-input>
      </el-form-item>
      <el-form-item label="是否启用" prop="enabled" required>
        <el-switch
          v-model="menuForm.enabled"
          active-color="#15FF00"
        ></el-switch>
      </el-form-item>
      <el-form-item size="large">
        <el-button type="primary" @click="submitForm">提交</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
export default {
  name: "MenuInfo",
  props: ["menu", "type"],
  data() {
    return {
      menuForm: {}, // 实际上要显示以及提交的内容
      rules: {
        partName: [],
        name: [
          {
            required: true,
            message: "请输入菜单名称",
            trigger: "blur"
          }
        ],
        url: [
          {
            required: true,
            message: "请输入请求地址",
            trigger: "blur"
          }
        ],
        path: [
          {
            required: true,
            message: "请输入组件路径",
            trigger: "blur"
          }
        ],
        component: [
          {
            required: true,
            message: "请输入组件名称",
            trigger: "blur"
          }
        ]
      }
    };
  },
  mounted() {
    this.initMenu();
  },
  methods: {
    initMenu(){
      if (this.type == 1) {
        // 显示当前菜单信息
        console.log(this.menu);
        // this.menuForm = this.menu;
        this.getRequest("/system/basic/menu/" + this.menu.id).then(resp => {
          if (resp && resp.status == 200) {
            this.menuForm = resp.object;
          }
        });
      } else if (this.type == 2) {
        console.log(this.menu);
        this.$set(this.menuForm, "parentId", this.menu.id);
        this.$set(this.menuForm, "parentName", this.menu.name);
      }
    },
    submitForm() {
      this.$refs["menuform"].validate(valid => {
        if (!valid) {
          return;
        }
        if (this.type == 1) {
          this.putRequest("/system/basic/menu/", this.menuForm).then(resp => {
            if (resp && resp.status == 200) {
              this.$emit("initMenu");
              this.$message.success(resp.msg);
            }
          });
        } else if (this.type == 2) {
          this.postRequest("/system/basic/menu/", this.menuForm).then(resp => {
            if (resp && resp.status == 200) {
              this.$emit("initMenu");
              this.$message.success(resp.msg);
            }
          });
        }
      });
    }
  }
};
</script>

<style scoped></style>
