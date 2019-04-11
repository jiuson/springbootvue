<template>
  <div class="deit">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item><i class="el-icon-date"></i> 用户管理</el-breadcrumb-item>
        <el-breadcrumb-item>用户列表</el-breadcrumb-item>
      </el-breadcrumb>
      <div>
        <el-form>
          <el-date-picker v-model="currentDate" type="date" placeholder="time" style="float: left;"></el-date-picker>
          <el-button style="float: left; margin-left: 20px; margin-top: 10px; color: #3b97d1" v-on:click="search">查询</el-button>
        </el-form>
      </div>
      <div class="cantainer">
        <el-table :data="userData" v-if="userData.length > 0" style="width: 100%">
          <el-table-column fixed width="100px">
            <template slot="header" slot-scope="scope">
              <el-tooltip content="名称" placement="top">
                <div class="tb-header">名称</div>
              </el-tooltip>
            </template>
            <template slot-scope="scope"></template>
          </el-table-column>
        </el-table>
        <div  v-else style="text-align: center; width: 100%;">
          <span>暂无数据</span>
        </div>
      </div>
    </div>
  </div>
</template>


<script>
    export default {
      name: "UserList",
      data() {
        return {
          currentDate: '',
          userData: []
        }
      },
      methods: {
        search: function () {

        }
      }
    }
</script>

<style lang="scss" scoped>
  .container {
    width: 100%;
    line-height: 10px;
  }
</style>
