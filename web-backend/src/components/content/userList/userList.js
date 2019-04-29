export default {
  name: "UserList",
  data() {
    return {
      currentDate: '',
      pageSize: 10,
      currentPage: '',
      totalElement: '',
      userData: [],
      dialogVisible: false,
      form: {
        name: '',
        address: ''
      },
    }
  },

  created: function(){
    this.search();
  },
  methods: {
    search: function () {
      this.$fetch('http://127.0.0.1:8080/user/list').then((response) => {
        // console.log(response);
        this.userData = response.payload.content;
        console.log(this.userData);
        this.totalElement = response.payload.totalElements;
        this.currentPage = 0;
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
      this.$fetch('http://127.0.0.1:8080/user/list', param).then((response) => {
        console.log(response);
        this.userData = response.payload.content;
        this.totalElement = response.payload.totalElements;
      });
    },

    /**
     * 上一页
     */
    /*prevClick: function () {
      console.log('上一页');
      this.currentPage = this.currentPage - 1;
      let param = {};
      param.page = this.currentPage;
      param.size = this.pageSize;
      this.$fetch('http://127.0.0.1:8080/user/list', param).then((response) => {
        console.log(response);
        this.userData = response.payload.content;
        this.totalElement = response.payload.totalElements;
      });
    },*/

    /**
     * 下一页
     */
    /*nextClick: function () {
      console.log('下一页');
      this.currentPage = this.currentPage + 1;
      let param = {};
      param.page = this.currentPage;
      param.size = this.pageSize;
      this.$fetch('http://127.0.0.1:8080/user/list', param).then((response) => {
        console.log(response);
        this.userData = response.payload.content;
        this.totalElement = response.payload.totalElements;
      });
    },*/

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
      console.log('删除第' + index + '行数据,id=' + row.id);
      this.$confirm('确定要删除数据吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$post("http://127.0.0.1:8080/user/" + row.id).then((response => {
          console.log(response);
        }));
        this.$message({
          type: 'success',
          message: '删除成功！'
        });
        this.search();//刷新页面
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        });
      });
    },

    /**
     * 新增
     */
    createUserInfo: function () {
      let param = {};
      param.username = this.form.name;
      param.address = this.form.address;
      this.$post("http://127.0.0.1:8080/");
      this.dialogVisible = true;
    }
  }
}
