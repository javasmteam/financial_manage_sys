function RoleInfo() {
    this.roleId = '';
    this.roleName = '';
    this.roleState = '';
    this.copy = function (roleInfo) {
        this.roleId = roleInfo.roleId;
        this.roleName = roleInfo.roleName;
        this.roleState = roleInfo.roleState;
    }
}


var app = new Vue({
    el: "#app",
    data: {
        //分页请求条件
        pageSelect: {
            nowPage: 1,
            pageCount: 5,
            roleName: ''
        },
        //分页数据
        page: {
            nowPage: '',
            pageCount: '',
            allCount: ''
        },

        userList: [],

        permissions: [],
        setRolePermissions: {
            roleId: '',
            permissions: [],
        },

        roleList: [new RoleInfo()],
        roleInfo: new RoleInfo(),
        addRoleInfo: new RoleInfo(),
        setRoleInfo: new RoleInfo(),


        addFlag: false,
        authorizeFlag: false,
        roleDetailsFlag: false,
        setRoleFlag: false,

        addRoleRule: {
            roleName: [{required: true, message: "请输入角色名", trigger: 'change'}],
        }

    },
    methods: {
        //分页查询请求
        reqPageSelect() {
            axios.post(projectPath + "/roleManage?type=reqPageSelect", this.pageSelect).then(resp => {
                if (resp.data == "-1") {
                    this.$messages.error("网络连接有误")
                } else {
                    this.roleList = resp.data.dataList;
                    this.page.nowPage = resp.data.nowPage;
                    this.page.pageCount = resp.data.pageCount;
                    this.page.allCount = resp.data.allCount;
                }
            })
        },
        //请求删除角色
        reqDelRole(role) {

            this.$confirm('此操作将删除角色, 是否继续?', '提示', {
                confirmButtonText: '确定',
                cancelButtonText: '取消',
                type: 'warning'
            }).then(() => {
                axios.post(projectPath + "/roleManage?type=reqDelRole&id=" + role.roleId).then(resp => {
                    if (data == "-1") {
                        this.$message.error("删除失败");
                    } else {
                        this.$message.success("删除成功");
                        this.queryPageSelect();
                    }
                })
            }).catch(() => {
                this.$message({
                    type: 'info',
                    message: '已取消删除'
                });
            });


        },
        //请求全部权限
        reqPermissions() {
            axios.post(projectPath + "/roleManage?type=reqPermissions").then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("网络请求有误");
                } else {
                    this.permissions = resp.data;
                }
            })
        },

        //请求修改角色
        reqSetRole() {
            axios.post(projectPath + "/roleManage?type=reqSetRole", this.setRoleInfo).then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("修改失败");
                } else {
                    this.$message.success("修改成功");
                    this.setRoleFlag = false;
                    this.setRoleInfo = new RoleInfo();
                    this.queryPageSelect();
                }
            })
        },
        //请求角色权限
        reqRolePermissions(id) {
            axios.post(projectPath + "/roleManage?type=reqRolePermissions&id=" + id).then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("网络连接有误")
                } else {
                    this.setRolePermissions = resp.data;
                    this.$refs.roleTree.setCheckedKeys(this.setRolePermissions.permissions);
                }
            })
        },
        //请求修改角色权限
        reqSetRolePermissions() {
            axios.post(projectPath + "/roleManage?type=reqSetRolePermissions", this.setRolePermissions).then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("修改失败");
                } else {
                    this.$message.success("修改成功");

                }
            })
        },
        //请求添加角色
        reqAddRoleInfo() {
            axios.post(projectPath + "/roleManage?type=reqAddRoleInfo", this.addRoleInfo).then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("添加失败");
                } else {
                    this.$message.success("添加成功");
                    this.addRoleInfo = new RoleInfo();
                }
            })
        },
        //请求拥有此角色的用户
        reqUserListByRoleId(id) {
            axios.post(projectPath + "/roleManage?type=reqUserListByRoleId&id=" + id).then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("网络请求有误");
                } else {
                    this.userList = resp.data;
                }
            })
        },
        //分页查询
        queryPageSelect() {
            this.pageSelect.nowPage = 1;
            this.reqPageSelect();
        },
        //显示详情
        showRoleInfo(role) {
            this.reqUserListByRoleId(role.roleId);
            this.roleDetailsFlag = true;
        },
        //显示修改弹窗
        showSetRoleInfo(role) {
            this.setRoleInfo.copy(role);
            this.setRoleFlag = true;
        },
        //显示授权弹窗
        showAuthorize(role) {
            this.reqRolePermissions(role.roleId);
            this.authorizeFlag = true;
        },
        //设置角色
        setRole(flag) {
            if (flag) {
                this.reqSetRole();
            } else {
                this.setRoleInfo = new RoleInfo();
                this.setRoleFlag = false;
            }
        },
        //添加角色
        addRole(flag) {
            if (flag) {
                this.reqAddRoleInfo();
            } else {
                this.addRoleInfo = new RoleInfo();
                this.addRoleFlag = false;
            }
        },
        //授权
        authorize(flag) {
            if (flag) {
                this.setRolePermissions.permissions = this.$refs.roleTree.getCheckedKeys();
                this.reqSetRolePermissions();
            } else {
                this.authorizeFlag = false;
                this.setRolePermissions = {};
            }
        },
        //请求设置每页数据
        SetPageCount(pageCount) {
            this.pageSelect.pageCount = pageCount;
            this.reqPageSelect();
        },
        //请求设置当前页
        SetNowPage(nowPage) {
            this.pageSelect.nowPage = nowPage;
            this.reqPageSelect();
        },

    },
    created() {
        this.queryPageSelect();
        this.reqPermissions();
    }
})