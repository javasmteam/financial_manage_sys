var app = new Vue({
    el:"#app",
    data:{
        userMenu:[
            {
                groupName:'分组1',
                permissions:[
                    {
                        permissionName:'权限1',
                        permissionSrc:''
                    },
                    {
                        permissionName:'权限2',
                        permissionSrc:''
                    },
                    {
                        permissionName:'权限3',
                        permissionSrc:''
                    }
                ]
            },
            {
                groupName:'分组2',
                permissions:[
                    {
                        permissionName:'权限4',
                        permissionSrc:''
                    },
                    {
                        permissionName:'权限5',
                        permissionSrc:''
                    },
                    {
                        permissionName:'权限6',
                        permissionSrc:''
                    }
                ]
            }
        ],
        pageSrc:''
    },
    methods: {},
})