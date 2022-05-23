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
        //上传位置路径
        uploadPath:'',

    },
    computed:{
        reqUploadPath:function (){
            return projectPath+"/userInfo?type=reqUpload&id="+this.userInfo.userId;
        }
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
        //是否保存图片
        reqSaveImage(code){
            axios.post(projectPath+"/userInfo?type=reqSaveImage&code="+code).then(resp=>{
                if(resp.data=="-1"){
                    this.$message.error("上传失败");
                }else {
                    this.$message.success("上传成功");
                }
                this.uploadAvatarFlag = false;
            })
        },

        //上传成功回调,获取保存路径
        setUploadPath(resp){
            if(resp=="-1"){
                this.$message.error("上传失败");
            }else {
                this.uploadPath = resp;
            }
        },
        //显示上传图像弹框
        showUploadAvatarFlag(){
            this.uploadAvatarFlag = true
        },
        //是否保存上传的图片
        saveImage(flag){
            if(flag){
                this.reqSaveImage("1");
            }else {
                this.reqSaveImage("-1");
            }
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