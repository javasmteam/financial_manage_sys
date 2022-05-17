//项目绝对路径
const projectPath = "http://localhost:8088/Financial_manage_sys_war_exploded";

function SimpleJSON(str){
    this.value = str;
}
var app = new Vue({
    el: "#app",
    data: {
        roleMenu: {},
        userRole: {},
        pageSrc:projectPath+"/default.html",
    },
    methods: {
        reqRoleMenu(obj){
            axios.post(projectPath + "/login?type=reqRoleMenu", obj).then(resp => {
                if (resp.data == '-1') {
                    this.$message.error('网络有误,请刷新后重新尝试')
                } else {
                    this.userRole = resp.data
                }
            })
        },
        //请求角色
        reqUserRole(obj) {
            axios.post(projectPath + "/login?type=reqUserRole", obj).then(resp => {
                if (resp.data == '-1') {
                    this.$message.error('网络有误,请刷新后重新尝试')
                } else {
                    this.userRole = resp.data
                }
            })
        },

        //切换角色
        changeRole(roleId) {
            //更新角色
            this.reqUserRole(new SimpleJSON(roleId));
            //更新菜单
            this.reqRoleMenu(new SimpleJSON(0));
        },
    },
    created: function () {
        //请求用户角色信息
        this.reqUserRole(new SimpleJSON(0));
        this.reqRoleMenu(new SimpleJSON(0));
    }
})