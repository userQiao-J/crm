<template>
  <div style="top: 0px">
    <div class="blackgroundImg"></div>
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
          this.postKeyValueRequest("/doLogin", this.loginForm).then(resp => {
            if (resp) {
              console.log(resp);
              window.sessionStorage.setItem(
                "user",
                JSON.stringify(resp.object)
              );
              this.$router.replace("/home");
            }
          });
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
  margin: 13% 55%;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: rgba(0,0,0,0.2);
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
  position: fixed;
}
.loginTile {
  margin: 15px auto 20px auto;
  text-align: center;
}
.elalert {
  margin-top: 10px;
}
  .blackgroundImg{
    background: url("../assets/loginbackground.jpg");
    background-size: 100% 100%;
    height: 100%;
    position: fixed;
    width: 100%
  }
</style>
