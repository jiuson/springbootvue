import {login} from '../../util/http'
export default {
  name: "Login",
  data() {
    return {
      ruleForm: {
        username: '',
        password: ''
      },
      rules: {
        account: [
          {required: false, message: '请输入账号', trigger: ''},
          {min: 2, max: 10, message: '长度在2-10个字符', trigger: 'blur'}
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
      let param = this.ruleForm;
      this.$axios({
        url: 'http://127.0.0.1:8080/login',
        method: 'post',
        data: param,
        header: {
          'Content-Type': 'application/json'
        }
      }).then(response => {
        console.log(response);
        if (response.data.errorCode === 0) {
          this.$router.push('/main');//登录成功，跳转到主页面
        }else {
          alert(response.data.errorMessage)
        }
      }).catch(e => {
        // alert(JSON.stringify(e.response.data));
      });
    },
    reset() {
      this.ruleForm.account = '';
      this.ruleForm.password = '';
    }
  }
}
