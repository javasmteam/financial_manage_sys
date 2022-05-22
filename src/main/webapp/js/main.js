function SimpleJSON(str) {
    this.value = str;
}

var app = new Vue({
    el: "#app",
    data: {
        roleMenus: {},
        userRole: {},
        pageSrc: projectPath + "/default.html",
    },
    methods: {
        reqRoleMenu(obj) {
            axios.post(projectPath + "/login?type=reqRoleMenu", obj).then(resp => {
                if (resp.data == '-1') {
                    this.$message.error('网络有误,请刷新后重新尝试')
                } else {
                    this.roleMenus = resp.data
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
                    this.reqRoleMenu(obj);
                }
            })
        },

        //切换角色
        changeRole(role) {
            //更新角色
            this.reqUserRole(new SimpleJSON(role.roleId));
            this.userRole.nowRole = role;
        },
        //切换菜单
        changePage(scr) {
            this.pageSrc = projectPath + scr;
        },
    },
    created: function () {
        //请求用户角色信息
        this.reqUserRole(new SimpleJSON(0));
    }
})