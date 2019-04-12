<template>
  <div class="login">
   <el-form class="login-form" ref="ruleForm" :model="ruleForm" :rules="rules" label-width="70px" label-position="left">
    <h2 class=  "login-form-title">ELEMENT-VUE登录</h2>
    <el-form-item label="用户名:" prop="account">
      <el-input class="login-form-account" v-model="ruleForm.account" placeholder="请输入账号"></el-input>
    </el-form-item>
    <el-form-item label="密    码:" prop="password">
      <el-input class="login-form-password" v-model="ruleForm.password" type="password" placeholder="请输入密码"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button class="login-form-commit-button" @click="login">登录</el-button>
      <el-button class="login-form-reset-button" @click="reset">重置</el-button>
    </el-form-item>
   </el-form>
  </div>
</template>

<script>
    import {login} from '../../api/Api'
    export default {
        name: "Login",
      data() {
          return {
            ruleForm: {
              account: '',
              password: ''
            },
            rules: {
              account: [
                {required: false, message: '请输入账号', trigger: ''},
                {min: 6, max: 10, message: '长度在6-10个字符', trigger: 'blur'}
              ],
              password: [
                {required: false, message: '请输入密码', trigger: 'blur'},
                {min: 6, max: 10, message: '长度在6-10个字符', trigger: 'blur'}
              ]
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
            //     this.$router.push('/main');//登录成功，跳转到主页面
            //   }
            // });
            this.$router.push('/main');//登录成功，跳转到主页面
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
    padding: 35px 35px 15px 35px;
    background: aliceblue;
    border: 1px solid #eaeaea;
    .login-form-title {
      margin: 0px auto 40px auto;
      text-align: center;
      color: #505458;
    }
  }

  .login-form-account {
    width: auto;
  }
  .login-form-password {
    width: auto;
  }
  .login-form-commit-button {
    width: 40%;
    background-color: #4aabff;
  }
  .login-form-reset-button {
    width: 40%;
  }
</style>
