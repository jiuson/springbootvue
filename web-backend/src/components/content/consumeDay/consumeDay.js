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
