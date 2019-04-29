<template>
  <div class="login">
   <el-form class="login-form" ref="ruleForm" :model="ruleForm" :rules="rules" label-width="70px" label-position="left">
    <h2 class=  "login-form-title">ELEMENT-VUE登录</h2>
    <el-form-item label="用户名:" prop="account">
      <el-input class="login-form-account" v-model="ruleForm.username" placeholder="请输入账号"></el-input>
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

<script src="./login.js"></script>

<style lang="scss" scoped>
  @import "./login";
</style>
