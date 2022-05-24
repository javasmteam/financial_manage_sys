function MenuInfo() {
    this.permissionId = '';
    this.permissionName = '';
    this.permissionPath = '';
    this.permissionImage = '';
    this.parentId = '';
    this.parentName = '';
    this.copy=function (menuInfo) {
        this.permissionId=menuInfo.permissionId;
        this.permissionName=menuInfo.permissionName;
        this.permissionPath =menuInfo.permissionPath;
        this.permissionImage =menuInfo.permissionImage;
        this.parentId =menuInfo.parentId;
        this.parentName =menuInfo.parentName;
    }
}

function ParentMenu() {
    this.permissionId = '';
    this.permissionName = '';
}


var app = new Vue({
    el: "#app",
    data: {
        //父级菜单下拉选项
        parentMenus: [new ParentMenu()],
        //菜单集合
        menuList: [new MenuInfo()],
        //显示菜单详情对象
        menuInfo: new MenuInfo(),
        //修改菜单对象
        setMenuInfo: new MenuInfo(),
        //添加菜单对象
        addMenuInfo: new MenuInfo(),
        //分页请求条件
        pageSelect: {
            nowPage: 1,
            pageCount: 5,
            permissionName: '',
            permissionId: '',
        },
        //分页数据
        page: {
            nowPage: '',
            pageCount: '',
            allCount: ''
        },
        addFlag: false,
        setMenuFlag: false,
        menuDetailsFlag: false,
        //验证规则
        addMenuRule: {
            permissionName: [{required: true, message: "请输入菜单名", trigger: 'change'}],
            parentId: [{required: true, message: "请输入父级菜单", trigger: 'change'}],
            permissionPath: [{required: true, message: "请输入菜单路径", trigger: 'change'}],
            permissionImage: [{required: true, message: "请输入菜单图标", trigger: 'change'}],
        }
    },
    methods: {
        //请求修改菜单数据
        reqSetMenuInfo(menu) {
            this.setMenuInfo = new MenuInfo();
            this.setMenuInfo.copy(menu);
        },
        //请求修改菜单数据
        reqSetMenu() {
            axios.post(projectPath + "/menuManage?type=reqSetMenu", this.setMenuInfo).then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("修改失败");
                } else {
                    this.$message.success("修改成功");
                    this.setMenuInfo = new MenuInfo();
                    this.setMenuFlag = false;
                    this.ini();
                }
            })
        },
        //请求添加菜单
        reqAddMenu() {
            axios.post(projectPath + "/menuManage?type=reqAddMenu", this.addMenuInfo).then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("添加失败")
                } else {
                    this.$message({message: "添加成功", type: "success"})
                    this.regUser = new MenuInfo();
                    this.addFlag = false;
                    this.$refs[rules].resetFields();
                    this.ini();
                }
            })
        },
        //请求分页查询
        reqPageSelect() {
            axios.post(projectPath + "/menuManage?type=reqPageSelect", this.pageSelect).then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("数据连接有误");
                } else {
                    this.menuList = resp.data.dataList;
                    this.page.nowPage = resp.data.nowPage;
                    this.page.pageCount = resp.data.pageCount;
                    this.page.allCount = resp.data.allCount;
                }
            })
        },

        //请求删除菜单
        reqDelMenu(menu) {

                this.$confirm('此操作将删除菜单, 是否继续?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    axios.post(projectPath + "/menuManage?type=reqDelMenu", menu).then(resp => {
                        if (resp.data == "-1") {
                            this.$message.error("删除失败")
                        } else {
                            this.$message({message: "删除成功", type: "success"})
                            this.ini();
                        }
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });


        },
        //请求一级菜单
        reqParentMenu() {
            axios.post(projectPath + "/menuManage?type=reqParentMenu").then(resp => {
                if (resp.data == "-1") {
                    this.$message.error("网络有误");
                } else {
                    this.parentMenus = resp.data;
                }
            })
        },

        queryPageSelect() {
            this.pageSelect.nowPage = 1;
            this.reqPageSelect();
        },

        showMenuInfo(menu){
            this.menuInfo = menu;
            this.menuDetailsFlag = true;
        },
        showSetMenuInfo(menu){
            this.reqParentMenu();
            this.reqSetMenuInfo(menu);
            this.setMenuFlag=true;
        },
        setMenu(flag){
            if(flag){
                this.reqSetMenu();
            }else {
                this.setMenuFlag=false;
                this.setMenuInfo = new MenuInfo();
            }
        },
        addMenu(flag){
            if(flag){
                this.reqAddMenu();
            }else {
                this.addMenuInfo = new MenuInfo();
                this.addFlag = flag;
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
        ini(){
            this.reqParentMenu();
            this.reqPageSelect();
        }


    },
    created() {
        this.ini();
    }
})