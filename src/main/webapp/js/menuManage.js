function MenuInfo() {
    this.permissionId = '';
    this.permissionId = '';
    this.permissionName = '';
    this.permissionPath = '';
    this.permissionImage = '';
    this.parentId = '';
    this.parentName = '';
}
function ParentMenu(){
    this.permissionId='';
    this.permissionName='';
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
        setMenuInfo:new MenuInfo(),
        //添加菜单对象
        addMenuInfo:new MenuInfo(),
        //分页请求条件
        pageSelect: {
            nowPage: 1,
            pageCount: 5,
            menuName: '',
            permissionId: '',
        },
        //分页数据
        page: {
            nowPage: '',
            pageCount: '',
            allCount: ''
        },
    },
    methods: {
        req
    },
    created() {
    }
})