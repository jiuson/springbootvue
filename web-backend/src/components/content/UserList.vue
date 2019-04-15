<template>
  <div class="deit">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item><i class="el-icon-date"></i> 用户管理</el-breadcrumb-item>
        <el-breadcrumb-item>用户列表</el-breadcrumb-item>
      </el-breadcrumb>
      <div style="width: 100%; height: 95px">
        <el-form style="margin-top: 18px">
          <el-date-picker v-model="currentDate" type="date" placeholder="time" style="float: left;"></el-date-picker>
          <el-button style="float: left; margin-left: 20px; margin-top: 10px; color: #3b97d1" v-on:click="search">查询</el-button>
        </el-form>
      </div>
      <div class="cantainer">
        <div  v-if="userData.length > 0">
          <el-table :data="userData.slice((currentPage - 1) * pageSize, currentPage * pageSize)"style="width: 100%; margin-top: -10px" height="650">
            <el-table-column fixed width="100px" prop="number">
              <template slot="header" slot-scope="scope">
                <el-tooltip content="编号" placement="top">
                  <div class="tb-header">编号</div>
                </el-tooltip>
              </template>
            </el-table-column>
            <el-table-column fixed width="100px" prop="username">
              <template slot="header" slot-scope="scope">
                <el-tooltip content="姓名" placement="top">
                  <div class="tb-header">姓名</div>
                </el-tooltip>
              </template>
            </el-table-column>
            <el-table-column fixed width="200px" prop="address">
              <template slot="header" slot-scope="scope">
                <el-tooltip content="地址" placement="top">
                  <div class="tb-header">地址</div>
                </el-tooltip>
              </template>
            </el-table-column>
            <el-table-column fixed width="200px" prop="createDate">
              <template slot="header" slot-scope="scope">
                <el-tooltip content="创建时间" placement="top">
                  <div class="tb-header">创建时间</div>
                </el-tooltip>
              </template>
            </el-table-column>
            <el-table-column fixed width="200px" prop="modifyDate">
              <template slot="header" slot-scope="scope">
                <el-tooltip content="修改时间" placement="top">
                  <div class="tb-header">修改时间</div>
                </el-tooltip>
              </template>
            </el-table-column>
            <el-table-column label="操作">
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                <el-button
                  size="mini"
                  type="danger"
                  @click="handleDelete(scope.$index, scope.row)">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
          <div>
            <el-pagination background layout="sizes, prev, pager, next" :total="totalElement" @current-change="currentChange"></el-pagination>
          </div>
        </div>
        <div  v-else style="text-align: center; width: 100%;">
          <span>暂无数据</span>
        </div>
      </div>
    </div>
  </div>
</template>


<script>
  import {userList} from '../../api/Api'
    export default {
      name: "UserList",
      data() {
        return {
          currentDate: '',
          pageSize: 100,
          currentPage: 1,
          totalElement: '',
          userData: []
        }
      },

      created: function(){
        userList().then(data => {
          console.log(data.success);
        });
        this.totalElement = this.userData.length;
      },
      methods: {
        search: function () {

        },

        /**
         * 翻页
         */
        currentChange: function () {
          console.log('翻页啦');
        },

        /**
         * 编辑
         * @param index
         * @param row
         */
        handleEdit: function (index, row) {
          console.log('编辑第' + index + '行' + row);
        },

        /**
         * 删除
         * @param index
         * @param row
         */
        handleDelete: function (index, row) {
          console.log('删除');
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
