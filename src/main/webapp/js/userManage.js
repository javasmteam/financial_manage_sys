function RegUserF() {
    this.userAct = '';
    this.userPwd = '';
    this.userName = '';
    this.sex = '';
    this.birthday = '';
    this.phone = '';
}

var app = new Vue({
    el: "#app",
    data: {
        //分页请求条件
        pageSelect: {
            nowPage: 1,
            pageCount: 5,
            userName: '',
            userId: '',
        },
        //分页数据
        page: {
            nowPage: '',
            pageCount: '',
            allCount: ''
        },
        //详细显示用户
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
            lastLogin: '',
            userState: 1,
        },
        //表格显示用户集合
        userInfoList: [{
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
            lastLogin: '',
            userState: '1'
        }],
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
        //请求注册对象
        regUser: new RegUserF(),
        //全部角色
        roles: [],

        //用户当前拥有的全部角色id
        setUserRole:{
            userId:'',
            userAllRoleId:[],
        },

        regFlag: false,
        userDetailsFlag: false,
        setUserFlag: false,
        authorizeFlag: false,


        //添加用户验证规则
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
            sex: [
                {required: true, message: "请选择性别", trigger: 'change'}
            ],
            birthday: [
                {required: true, message: "请输入生日", trigger: 'change'}
            ],
            phone: [
                {required: true, message: "请输入联系方式", trigger: 'change'}
            ],
        },


    },
    methods: {
        //请求修改用户数据
        reqSetUserInfo(id) {
            axios.post(projectPath + "/userManage?type=reqSetUserInfo&userId=" + id).then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("网络请求有误");
                } else {
                    this.setUserInfo = resp.data;
                }
            })
        },
        //请求修改用户数据
        reqSetUser() {
            axios.post(projectPath + "/userManage?type=reqSetUser", this.setUserInfo).then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("修改失败");
                } else {
                    this.$message.success("修改成功");
                }
            })
        },
        //请求添加用户请求
        reqReg: function () {
            axios.post(projectPath + "/login?type=reqReg", this.regUser).then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("添加失败")
                } else {
                    this.$message({message: "添加成功", type: "success"})
                    this.regUser = new RegUserF();
                    this.regFlag = false;
                    this.$refs[rules].resetFields();
                }
            })
        },
        //请求分页查询
        reqPageSelect() {
            axios.post(projectPath + "/userManage?type=reqPageSelect", this.pageSelect).then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("数据连接有误");
                } else {
                    this.userInfoList = resp.data.dataList;
                    this.page.nowPage = resp.data.nowPage;
                    this.page.pageCount = resp.data.pageCount;
                    this.page.allCount = resp.data.allCount;
                }
            })
        },

        //请求删除用户
        reqDelUser(user) {
            axios.post(projectPath + "/userManage?type=reqDelUser", user).then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("删除失败")
                } else {
                    this.$message({message: "删除成功", type: "success"});
                    this.reqPageSelect();
                }
            })
        },

        //请求全部角色
        reqAllRole() {
            axios.post(projectPath + "/userManage?type=reqAllRole").then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("网络数据有误");
                } else {
                    this.roles = resp.data;
                }
            })
        },

        //请求用户全部角色id
        reqUserAllRoleId(id) {
            axios.post(projectPath + "/userManage?type=reqUserAllRoleId&id=" + id).then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("网络数据有误");
                } else {
                    this.setUserRole = resp.data;
                    this.$refs.userTree.setCheckedKeys(this.setUserRole.userAllRoleId);
                }
            })
        },
        //请求授权角色给用户
        reqSetUserRole(){
            axios.post(projectPath+"/userManage?type=reqSetUserRole",this.setUserRole).then(resp=>{
                if(resp.data=="-1"){
                    this.$message.error("修改失败");
                }else {
                    this.$message.success("修改成功");
                    this.setUserRole ={};
                    this.authorizeFlag = false;
                }
            })
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
        //分页查询
        queryPageSelect() {
            this.pageSelect.nowPage = 1;
            this.reqPageSelect();
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

        //修改用户
        setUser(flag) {
            if (flag) {
                this.reqSetUser();
            }
            this.setUserFlag = false;

        },

        //显示用户详情
        showUserInfo(user) {
            this.userInfo = user;
            this.userDetailsFlag = true;
        },
        //显示修改用户弹窗
        showSetUserInfo(user) {
            this.reqSetUserInfo(user.userId);
            this.setUserFlag = true;
        },
        //显示授权弹窗
        showAuthorize(user){
            this.reqUserAllRoleId(user.userId);
            this.authorizeFlag = true;
        },

        //授权
        authorize(flag) {
            if (flag) {
                this.setUserRole.userAllRoleId = this.$refs.userTree.getCheckedKeys();
                this.reqSetUserRole();
            } else {
                this.authorizeFlag = false;
                this.setUserRole = {};
            }
        },

    },
    created() {
        this.reqPageSelect();
        this.reqAllRole();
    },
});