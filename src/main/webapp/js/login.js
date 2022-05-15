function regUserF() {
    userAct = '';
    userPwd = '';
    userName = '';
    userBirthday = '';
    userPhone = '';
}

function userF() {
    userAct = '';
    userPwd = '';
}

var app = new Vue({
    el: "#app",
    data: {
        //用户
        user: new userF(),
        //用户注册对象
        regUser: new regUserF(),
        //显示注册弹框
        loginDialog: false,
        //项目绝对路径
        projectPath: "http://locathost:8088/financial_manage_sys",
        //登录验证
        loginRules: {
            userAct: [
                {required: true, message: "请输入账号", trigger: 'change'}
            ],
            userPwd: [
                {required: true, message: "请输入密码", trigger: 'change'}
            ]
        },
        regRules: {
            userAct: [
                {required: true, message: "请输入账号", trigger: 'change'}
            ],
            userPwd: [
                {required: true, message: "请输入密码", trigger: 'change'}
            ],
            userName: [
                {required: true, message: "请输入姓名", trigger: 'change'}
            ],
            userBirthday: [
                {required: true, message: "请输入生日", trigger: 'change'}
            ],
            userPhone: [
                {required: true, message: "请输入良心方式", trigger: 'change'}
            ],
        }
    },
    methods: {
        //注册请求
        reqReg: function () {
            axios.post(this.projectPath + "?type=reqReg", this.regUser).then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("注册失败")
                } else {
                    this.$message({message: "注册成功", type: "success"})
                    this.reguser = new reguserF();
                    this.loginDialog = false;
                }
            })
        },
        //登录请求
        reqLogin: function () {
            axios.post(this.projectPath + "?type=reqLogin", this.user).then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("登录失败");
                } else {
                    this.$message({message: "登录成功", type: "success"});
                    location.href = this.projectPath + "/main.html"
                }
            })
        },
        //用户登录
        userLogin(rules) {
            this.$refs[rules].validate((valid) => {
                if (valid) {
                    this.reqLogin();
                } else {
                    return false;
                }
            })
        },
        //用户注册
        userReg: function (rules) {
            this.$refs[rules].validate((valid) => {
                if (valid) {
                    this.reqReg()
                } else {
                    return false
                }
            })
        }

    },
    create: {},
});