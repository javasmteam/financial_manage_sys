function regUserF() {
    this.userAct = '';
    this.userPwd = '';
    this.userName = '';
    this.sex = '';
    this.birthday = '';
    this.phone = '';
}

function userF() {
    this.userAct = '';
    this.userPwd = '';
    this.userVri = '';
    this.isMemory = false;
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
        //登录验证
        loginRules: {
            userAct: [
                {required: true, message: "请输入账号", trigger: 'change'}
            ],
            userPwd: [
                {required: true, message: "请输入密码", trigger: 'change'}
            ],
            userVri: [
                {required: true, message: "请输入验证码", trigger: 'change'}
            ]
        },
        //注册验证
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
            sex:[
                {required: true, message: "请选择性别", trigger: 'change'}
            ],
            birthday: [
                {required: true, message: "请输入生日", trigger: 'change'}
            ],
            phone: [
                {required: true, message: "请输入联系方式", trigger: 'change'}
            ],
        },
        //验证图片
        verifySrc: '',
    },
    methods: {
        //注册请求
        reqReg: function () {
            axios.post(projectPath+"/login?type=reqReg", this.regUser).then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("注册失败")
                } else {
                    this.$message({message: "注册成功", type: "success"})
                    this.regUser = new regUserF();
                    this.loginDialog = false;
                }
            })
        },
        //登录请求
        reqLogin: function () {
            axios.post(projectPath + "/login?type=reqLogin", this.user).then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("登录失败");
                } else {
                    this.$message({message: "登录成功", type: "success"});
                    location.href =projectPath + "/main.html"
                }
            })
        },
        //用户登录
        userLogin: function (rules) {
            this.$refs[rules].validate((valid) => {
                if (valid) {
                    this.reqLogin();
                } else {
                    return false;
                }
            });
        },
        //用户注册
        userReg: function (rules) {
            this.$refs[rules].validate((valid) => {
                if (valid) {
                    this.reqReg()
                } else {
                    return false
                }
            });
        },
        //获取cookie
        getCookie(name){
            let cookies = document.cookie.split(";")
            for(let cookie of cookies){
                let cook = cookie.split("=");
                if(cook[0] === name){
                    return cook[1];
                }
            }
        }

    },
    created: function (){
        let cookie = this.getCookie("saveUser");
        if(cookie!=null&&cookie !== "" ){
            let split = cookie.split(":");
            this.user.userAct = split[0];
            this.user.userPwd = split[1];
        }
    }
});