
var app = new Vue({
    el: "#app",
    data: {
        roleMenu: {},
        userRole: {},
    },
    methods: {
        //项目绝对路径
        projectPath: "http://localhost:8088/financial_manage_sys_war_exploded/system",
        //请求数据封装
        reqDate(reqType,paramObj, receive) {
            axios.post(this.projectPath + reqType,paramObj).then(resp => {
                if (resp.data == '-1') {
                    this.$message.error('网络有误')
                } else {
                    receive = resp.data
                }
            })
        },


    },
    created: function () {
        //请求用户角色信息
        this.reqDate("?type=reqUserRole","0",this.userRole);
        //请求用户当前角色菜单信息
        this.reqDate("?type=reqRoleMenu","0",this.roleMenu);
    }
})