<template>
  <div class="login">
    <form class="login-form" ref="ruleForm" :model="ruleForm" label-width="70px" label-position="left">
      <h2 class=  "login-form-title">ELEMENT-VUE登录</h2>
        <div class="account-div">
          用户名:<input class="login-form-account" v-model="ruleForm.account" placeholder="请输入账号"/>
        </div>
        <div class="password-div">
          密&nbsp;&nbsp;&nbsp;&nbsp;码:<input class="login-form-password" v-model="ruleForm.password" type="password" placeholder="请输入密码"/>
        </div>
        <div class="commit-reset-div">
          <button class="login-form-commit-button" @click="login">登录</button>
          <button class="login-form-reset-button" @click="reset">重置</button>
        </div>
    </form>
  </div>
</template>

<script>
  import {login} from '../api/Api'
  export default {
    name: "Login",
    data() {
      return {
        ruleForm: {
          account: '',
          password: ''
        }
      };
    },
    methods: {
      login() {
        // let loginParams = {username: this.ruleForm.account, password: this.ruleForm.password}
        // login(loginParams).then(data => {
        //   if (data.errorCode != 0){
        //     alert('errorCode=' + data.errorCode + ';' + data.errorMessage);
        //   }else {
        //     this.$router.push('/home');//登录成功，跳转到主页面
        //   }
        // });
        this.$router.push('/home');//登录成功，跳转到主页面
      },
      reset() {
        this.ruleForm.account = '';
        this.ruleForm.password = '';
      }
    }
  }
</script>

<style lang="scss" scoped>
  .login {
    margin-left: 500px;
  }
  .login-form {
    white-space: pre-wrap;
    background-clip: padding-box;
    -webkit-border-radius: 5px;
    border-radius: 5px;
    -moz-border-radius: 5px;
    margin: 230px auto;
    width: 350px;
    height: 325px;
    padding: 35px 35px 15px 35px;
    background: aliceblue;
    border: 1px solid #eaeaea;
    .login-form-title {
      margin: 0px auto 40px auto;
      text-align: center;
      color: #505458;
    }
  }
  .account-div {
    margin: 5px auto;
  }
  .login-form-account {
    width: 50%;
    margin-left: 10px;
  }
  .login-form-password {
    width: 50%;
    margin-left: 10px;
  }

  .commit-reset-div {
    margin-top: 20px;
  }
  .login-form-commit-button {
    width: 40%;
    height: 35px;
    margin-left: 5px;
    background-color: #4aabff;
    border-radius: 5px;
  }
  .login-form-reset-button {
    width: 40%;
    height: 35px;
    border-radius: 5px;
  }
</style>
