var app = new Vue({
    el: "#app",
    data: {
        //显示修改弹窗
        setUserFlag: false,
        setPwdFlag: false,
        uploadAvatarFlag: false,
        //修改用户数据
        setUserInfo: {
            userName: '',
            des: '',
            sex: 0,
            birthday: '',
            avatarColor: '',
            phone: '',
            roles: {
                nowRole: {},
                userRoles: []
            },
        },
        //显示用户信息对象
        userInfo: {
            headPic: '',
            userId: '',
            userAct: '',
            userName: '',
            des: '',
            sex: 0,
            birthday: '',
            avatarColor: '',
            phone: '',
            roleName: '',
            lastLogin: ''
        },
        //设置密码信息
        setPwdInfo: {
            userId: '',
            oldPwd: '',
            newPwd: '',
        },

    },
    methods: {
        reqUserInfoVo() {
            axios.post(projectPath + "/userInfo?type=reqUserInfoVo").then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("网络请求有误");
                } else {
                    this.userInfo = resp.data;
                }
            })
        },
        reqSetUserInfo() {
            axios.post(projectPath + "/userInfo?type=reqSetUserInfo").then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("网络请求有误");
                } else {
                    this.setUserInfo = resp.data;
                }
            })
        },
        reqSetUser() {
            axios.post(projectPath + "/userInfo?type=reqSetUser", this.setUserInfo).then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("修改失败");
                } else {
                    this.userInfo = resp.data;
                    this.reqSetUserInfo();
                    this.setUserFlag = false;
                }
            })
        },
        reqSetPwd() {
            axios.post(projectPath + "/userInfo?type=reqSetPwd", this.setPwdInfo).then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("修改失败");
                } else {
                    this.$message.success("修改成功");
                    this.setPwdInfo = {
                        userId: '',
                        oldPwd: '',
                        newPwd: '',
                    };
                    this.setPwdFlag = false;
                }
            })
        },

        setUser(flag) {
            if (flag) {
                this.reqSetUser();
            } else {
                this.reqSetUserInfo();
                this.setUserFlag = false;
            }

        },
        setPwd(flag) {
            if (flag) {
                this.reqSetPwd();
            } else {
                this.setPwdInfo = {
                    userId: '',
                    oldPwd: '',
                    newPwd: '',
                };
                this.setPwdFlag = false;
            }
        },
        showSetPwd() {
            this.setPwdInfo.userId = this.userInfo.userId;
            this.setPwdFlag = true;
        }

    },
    created: function () {
        this.reqUserInfoVo();
        this.reqSetUserInfo();
    }
})