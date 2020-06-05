<template>
  <div>
    <el-form
      :rules="rules"
      :model="loginForm"
      ref="loginForm"
      class="loginContainer"
    >
      <h3 class="loginTile">欢迎使用CRM管理系统</h3>
      <el-form-item prop="username">
        <el-input
          type="text"
          v-model="loginForm.username"
          auto-complete="off"
          placeholder="请输入用户名"
        />
      </el-form-item>
      <el-form-item prop="password">
        <el-input
          type="password"
          v-model="loginForm.password"
          auto-complete="off"
          placeholder="请输入密码"
        />
      </el-form-item>
      <el-button type="primary" style="width: 100%" @click="doLogin"
        >登录</el-button
      >
      <el-alert
        type="error"
        :title="alertTitle"
        v-if="isAlertShow"
        class="elalert"
      />
    </el-form>
  </div>
</template>

<script>
export default {
  name: "login",
  data() {
    return {
      loginForm: {
        username: "",
        password: ""
      },
      alertTitle: "",
      isAlertShow: false,
      rules: {
        username: [
          { required: true, message: "请输入用户名", trigger: "blur" }
        ],
        password: [
          {
            required: true,
            message: "请输入用户名,且长度最小3位",
            min: 3,
            trigger: "blur"
          }
        ]
      }
    };
  },
  methods: {
    doLogin() {
      this.isAlertShow = false;
      this.$refs.loginForm.validate(valid => {
        if (valid) {
          alert("成功");
        } else {
          this.alertTitle = "请填写完整信息";
          this.isAlertShow = true;
          return false;
        }
      });
    }
  }
};
</script>

<style scoped>
.loginContainer {
  border-radius: 15px;
  background-clip: padding-box;
  margin: 140px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #ffffff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
}
.loginTile {
  margin: 15px auto 20px auto;
  text-align: center;
}
.elalert {
  margin-top: 10px;
}
</style>
