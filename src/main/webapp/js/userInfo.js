var app = new Vue({
    el:"#app",
    data:{
        //显示修改弹窗
        setUserFlag:false,
        //修改用户数据
        setUser:{
            userName:'',
            des:'',
            sex:0,
            birthday:'',
            avatarColor:'',
            phone:'',
            roles:{
                nowRole:{},
                allRole:[]
            },
            lastLogin:''
        },
        //显示用户信息对象
        userInfo:{
            headPic:'',
            userId:'',
            userAct:'',
            userName:'',
            des:'',
            sex:0,
            birthday:'',
            avatarColor:'',
            phone:'',
            roleName:'',
            lastLogin:''
        },


    },
    methods:{

    },
    created:function (){

    }
})