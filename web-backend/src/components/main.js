export default {
  name: "Main1",
  components: {
  },
  data: function () {
    let a = {};
    return a;
  },
  methods: {
    userList: function () {
      this.$router.push('/userList');
    },

    consumeMonth: function () {
      this.$router.push('/consumeMonth');
    },

    chart: function () {

    },

    /**
     *
     */
    consumeDay: function () {
      this.$router.push('/consumeDay');
    }
  }
}
