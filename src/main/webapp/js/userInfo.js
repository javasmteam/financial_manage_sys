var app = new Vue({
    el: "#app",
    data: {
        //显示修改弹窗
        setUserFlag: false,
        //修改用户数据
        setUser: {
            userName: '',
            des: '',
            sex: 0,
            birthday: '',
            avatarColor: '',
            phone: '',
            roles: {
                nowRole: {},
                allRole: []
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
                    this.setUser = resp.data;
                }
            })
        },
        reqSetUser() {
            axios.post(projectPath + "/userInfo?type=reqSetUser", this.setUser).then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("修改失败");
                } else {
                    this.userInfo = resp.data;
                    this.reqSetUserInfo();
                }
            })
        },
        setUser(flag){
            if(flag){
                this.reqSetUser();
            }else {
                this.reqSetUserInfo();
            }
            this.setUserFlag = false;

        }

    },
    created: function () {
        this.reqUserInfoVo();
        this.reqSetUserInfo();
    }
})