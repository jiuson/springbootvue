<template>
    <div>
      <el-container style="height: 1650px; border: 1px solid #eee">
        <el-header style="text-align: right; font-size: 15px">
          <el-dropdown>
            <i class="el-icon-setting" style="margin-right: 15px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>查看</el-dropdown-item>
              <el-dropdown-item>新增</el-dropdown-item>
              <el-dropdown-item>删除</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          <span style="margin-right: 35px">王小虎</span>
          <i class="el-icon"></i>
        </el-header>
        <el-container>
          <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
            <el-menu :default-openeds="['1']">
              <el-submenu index="1" style="padding: auto">
                <template slot="title"><i class="el-icon-message"></i>用户管理</template>
                <el-menu-item-group>
                  <el-menu-item index="1-1">用户列表</el-menu-item>
                </el-menu-item-group>
              </el-submenu>
              <el-submenu index="2">
                <template slot="title"><i class="el-icon-tickets"></i>消费明细</template>
                <el-menu-item>月消费明细</el-menu-item>
              </el-submenu>
              <el-submenu index="3">
                <template slot="title"><i class="el-icon-document"></i>统计报表</template>
                <el-menu-item>报表</el-menu-item>
              </el-submenu>
            </el-menu>
          </el-aside>
          <el-main>

          </el-main>
        </el-container>
      </el-container>
    </div>
</template>

<script>
    export default {
        name: "Main1",
      components: {
      },
      data: function () {
          let a = {};
        return a;
      }
    }
</script>

<style lang="scss" scoped>
  .el-header{
    background-color: #5e99d1;
    color: black;
    text-align: center;
    line-height: 60px;
  }

  .el-aside {
    background-color: #D3DCE6;
    color: #333;
    text-align: left;
    line-height: 100px;
  }

  .el-main {
    background-color: #fdfbff;
    color: #333;
    text-align: center;
    line-height: 160px;
  }

  .el-container:nth-child(5) .el-aside,
  .el-container:nth-child(6) .el-aside {
    line-height: 160px;
  }

  .el-container:nth-child(7) .el-aside {
    line-height: 120px;
  }

</style>
