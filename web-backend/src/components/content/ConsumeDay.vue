<template>
  <div class="deit">
    <div class="crumbs">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item><i class="el-icon-date"></i> 消费明细</el-breadcrumb-item>
        <el-breadcrumb-item>日消费明细</el-breadcrumb-item>
      </el-breadcrumb>
      <div style="width: 100%; height: 95px">
        <el-form style="margin-top: 18px">
          <el-date-picker v-model="currentDate" type="date" placeholder="time" style="float: left;"></el-date-picker>
          <el-button style="float: left; margin-left: 20px; margin-top: 10px; color: #3b97d1" v-on:click="search">查询</el-button>
          <el-button style="float: right; margin-right: 60px; margin-top: 10px; color: #3b97d1" v-on:click="createConsumeRecord">新增</el-button>
        </el-form>
      </div>
      <div class="cantainer">
        <div  v-if="consumeData.length > 0">
          <el-table :data="consumeData" style="width: 100%; margin-top: -10px" height="650">
            <el-table-column fixed width="100px" prop="id">
              <template slot="header" slot-scope="scope">
                <el-tooltip content="编号" placement="top">
                  <div class="tb-header">编号</div>
                </el-tooltip>
              </template>
            </el-table-column>
            <el-table-column fixed width="160px" prop="consumeName">
              <template slot="header" slot-scope="scope">
                <el-tooltip content="消费名称" placement="top">
                  <div class="tb-header">消费名称</div>
                </el-tooltip>
              </template>
            </el-table-column>
            <el-table-column width="260px" prop="expenditure">
              <template slot="header" slot-scope="scope">
                <el-tooltip content="消费额" placement="top">
                  <div class="tb-header">消费额</div>
                </el-tooltip>
              </template>
            </el-table-column>
            <el-table-column width="270px" prop="consumeType">
              <template slot="header" slot-scope="scope">
                <el-tooltip content="消费类型" placement="top">
                  <div class="tb-header">消费类型</div>
                </el-tooltip>
              </template>
            </el-table-column>
            <el-table-column width="270px" prop="consumeDate">
              <template slot="header" slot-scope="scope">
                <el-tooltip content="创建时间" placement="top">
                  <div class="tb-header">创建时间</div>
                </el-tooltip>
              </template>
            </el-table-column>
            <el-table-column width="270px" prop="modifyDate">
              <template slot="header" slot-scope="scope">
                <el-tooltip content="修改时间" placement="top">
                  <div class="tb-header">修改时间</div>
                </el-tooltip>
              </template>
            </el-table-column>
            <el-table-column fixed="right" width="180px" label="操作">
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
            <el-pagination background layout="sizes, prev, pager, next" :total="totalElement"
                           @size-change="sizeChange"
                           @current-change="currentChange"></el-pagination>
          </div>
          <el-dialog title="新增消费记录"
                     :visible.sync="dialogVisible"
                     width="20%"
                     :modal="true"
                     :append-to-body="true"
                     :close-on-click-modal="false">
            <el-form ref="form" :model="form" label-width="80px">
              <el-form-item label="消费名称">
                <el-input v-model="form.name"></el-input>
              </el-form-item>
              <el-form-item label="消费额">
                <el-input v-model="form.expenditure"></el-input>
              </el-form-item>
              <el-form-item label="消费类型">
                <el-input v-model="form.consumeType"></el-input>
              </el-form-item>
              <el-form-item label="消费时间">
                <el-input v-model="form.consumeDate"></el-input>
              </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
              <el-button @click="dialogVisible = false">取 消</el-button>
              <el-button type="primary" @click="dialogVisible = false">确 定</el-button>
            </span>
          </el-dialog>
        </div>
        <div  v-else style="text-align: center; width: 100%;">
          <span>暂无数据</span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
      name: "ConsumeDay",
      data() {
        return {
          currentDate: '',
          totalElement: '',
          consumeData: [],
          form: {
            consumeName: '',
            expenditure: '',
            consumeType: '',
            consumeDate: ''
          },
          dialogVisible: false,
        }
      },

      created: function () {

      },

      methods: {
        search: function () {

        },

        sizeChange: function () {

        },

        currentChange: function () {

        },

        createConsumeRecord: function () {

        },


      }
    }
</script>

<style scoped>

</style>
