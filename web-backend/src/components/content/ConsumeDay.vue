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
          <el-button style="float: right; margin-right: 60px;margin-top: 10px; color: #3b97d1" v-on:click="importConsume">导入</el-button>
          <el-button style="float: right; margin-right: 20px; margin-top: 10px; color: #3b97d1" v-on:click="createConsumeRecord">新增</el-button>
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
            <el-table-column width="270px"
                             prop="consumeDate" :formatter="this.$paseDate">
              <template slot="header" slot-scope="scope">
                <el-tooltip content="消费时间" placement="top">
                  <div class="tb-header">消费时间</div>
                </el-tooltip>
              </template>
            </el-table-column>
            <el-table-column width="270px"
                             prop="modifyDate"
                             :formatter="this.$paseDate">
              <template slot="header" slot-scope="scope">
                <el-tooltip content="录入时间" placement="top">
                  <div class="tb-header">录入时间</div>
                </el-tooltip>
              </template>
            </el-table-column>
            <el-table-column fixed="right" width="180px" label="操作">
              <template slot-scope="scope">
                <el-button
                  size="mini"
                  @click="modifyConsumeRecord(scope.$index, scope.row)">编辑</el-button>
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
                     width="25%"
                     :modal="true"
                     :append-to-body="true"
                     :close-on-click-modal="false">
            <el-form ref="form" :model="form" label-width="80px">
              <el-form-item label="消费名称:">
                <el-input v-model="form.consumeName"></el-input>
              </el-form-item>
              <el-form-item label="消费额:">
                <el-input v-model="form.expenditure"></el-input>
              </el-form-item>
              <el-form-item label="消费类型:">
                <el-input v-model="form.consumeType"></el-input>
              </el-form-item>
              <el-form-item label="消费时间:">
                <el-date-picker v-model="form.consumeDate" type="datetime" placeholder="time" style="float: left;" value-format="timestamp"></el-date-picker>
              </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
              <el-button @click="dialogVisible = false">取 消</el-button>
              <el-button type="primary" @click="commitConsumeForm">提 交</el-button>
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
          pageSize: 10,
          currentPage: '',
          consumeData: [],
          form: {
            consumeName: '',
            expenditure: '',
            consumeType: '',
            consumeDate: ''
          },
          dialogVisible: false,
          create: true,
          row: {},
        }
      },

      created: function () {
        this.search();
      },

      methods: {
        /**
         * 查询
         */
        search: function () {

          this.$fetch('http://127.0.0.1:8080/consume').then((response => {
            this.consumeData = response.payload.content;
            this.totalElement = response.payload.totalElements;
          })).catch(e => {
            alert(JSON.stringify(e.response.data));
          });
        },

        /**
         * 每页记录数
         */
        sizeChange: function (pageSize) {
          console.log(pageSize);
          this.pageSize = pageSize;
          let param = {};
          param.page = 0;
          param.size = pageSize;
          this.$fetch('http://127.0.0.1:8080/user/list', param).then((response) => {
            console.log(response);
            this.userData = response.payload.content;
            this.totalElement = response.payload.totalElements;
            this.currentPage = 0;
          });
        },

        /**
         * 翻页
         */
        currentChange: function (page) {
          console.log('翻页啦');
          this.currentPage = page - 1;
          let param = {};
          param.page = this.currentPage;
          param.size = this.pageSize;
          this.$fetch('http://127.0.0.1:8080/consume', param).then((response) => {
            console.log(response);
            this.consumeData = response.payload.content;
            this.totalElement = response.payload.totalElements;
          });
        },

        /**
         * 弹出新增消费记录表单
         */
        createConsumeRecord: function () {
          this.dialogVisible = true;
          this.create = true;
        },

        /**
         * 提交新增消费记录表单
         */
        commitConsumeForm: function () {
          let param;
          let message;
          let url;
          let method;
          // let headers = {
          //   'Content-Type': 'application/json'
          // }
          // this.$post('http://127.0.0.1:8080/consume', param, headers).then(response => {
          //   if (response.errorCode === 0){
          //     this.dialogVisible = false;
          //   } else {
          //     alert(response.errorMessage);
          //   }
          // }).catch(e => {//http调用异常是弹错
          //   console.log(e);
          //   alert(JSON.stringify(e.response.data));
          // });
          if (this.create){
            param = this.form;
            url = 'http://127.0.0.1:8080/consume';
            method = 'post';
            message = '添加成功';
          } else {
            param = this.form;
            url = 'http://127.0.0.1:8080/consume/' + this.row.id;
            method = 'put';
            message = '修改成功';
          }

          this.$axios({
            url: url,
            method: method,
            data: param,
            header: {
              'Content-Type': 'application/json'
            }
          }).then(response => {
            console.log(response);
            if (response.data.errorCode === 0){
                  this.dialogVisible = false;
                  alert(message);
                  this.search();
                } else {
                  alert(response.data.errorMessage);
                }
          });
        },

        /**
         * 导入消费记录
         */
        importConsume: function () {
          console.log('导入啦');
          alert('导入啦');
        },

        /**
         * 弹出修改消费记录表单
         */
        modifyConsumeRecord: function (index, row) {
          this.dialogVisible = true;
          this.form.consumeName = row.consumeName;
          this.form.expenditure = row.expenditure;
          this.form.consumeType = row.consumeType;
          this.create = false;
          this.row = row;
        },

        /**
         * 删除指定消费记录
         */
        handleDelete: function (index, row) {
          this.$post("http://127.0.0.1:8080/consume/" + row.id).then((response => {
            if (response.errorCode === 0) {
              alert('删除成功');
              this.search();
            }else {
              alert(response.errorMessage);
            }
          })).catch(e => {
            alert(JSON.stringify(e.response.data));
          });
        }
      }
    }
</script>

<style scoped>

</style>
