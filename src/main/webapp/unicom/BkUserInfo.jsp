<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/5/20
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 开发环境版本，包含了有帮助的命令行警告 -->
<script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
<!-- 引入样式 -->
<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
<!-- 引入组件库 -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
<%-- 引入 qs --%>
<script src="https://cdn.bootcdn.net/ajax/libs/qs/6.10.1/qs.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="app">
    <el-descriptions title="独角兽管理>用户资产"></el-descriptions>

    <el-form :inline="true" id="investSelect">
        <el-form-item label="姓名：">
            <el-input v-model="selectParams.username"></el-input>
        </el-form-item>
        <el-form-item label="电话：">
            <el-input v-model="selectParams.iphone"></el-input>
        </el-form-item>

        <el-button type="primary" plain @click="showUserInfo()">查询</el-button>
    </el-form>

    <el-table :data="userInfoList" height="330">
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column prop="usercode" label="编号" width="100"></el-table-column>
        <el-table-column prop="username" label="客户姓名" width="150"></el-table-column>
        <el-table-column prop="iphone" label="电话" width="200"></el-table-column>
        <el-table-column prop="comName" label="公司" width="120"></el-table-column>
        <el-table-column prop="holdnumber" label="购买数量" width="100"></el-table-column>
        <el-table-column prop="holdmoney" label="成本价格" width="150"></el-table-column>

    </el-table>

    <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="pageInfo.nowPage"
            :page-sizes="[5, 10, 15, 20]"
            :page-size="pageInfo.pageNum"
            layout="total, sizes, prev, pager, next, jumper"
            :total="pageInfo.total">
    </el-pagination>

</div>
<script>
    new Vue({
        el:"#app",
        data:{
            selectParams:{
                type:"showUserInfo",
                username:"",
                iphone:"",
                nowPage: 1,
                pageNum: 5,
            },
            pageInfo: {
                nowPage: 1,
                pageNum: 5,
                total: 0
            },
            userInfoList:[]
        },
        methods: {
            queryUserInfo() {
                axios.get("http://localhost:8088/Financial_manage_sys_war_exploded/userInfo.do", {
                    params: this.selectParams
                }).then(response => {
                    this.userInfoList = response.data.dataList;
                    this.pageInfo.nowPage = response.data.nowPage;
                    this.pageInfo.pageNum = response.data.pageNum;
                    this.pageInfo.total = response.data.allCount;
                });
            },
            handleSizeChange(pageSize) {
                console.log("显示几条数据：" + pageSize)
                this.selectParams.pageNum = pageSize;
                this.queryUserInfo();
            },
            handleCurrentChange(nowPage) {
                console.log("当前页：" + nowPage)
                this.selectParams.nowPage = nowPage;
                this.queryUserInfo();
            },
            showUserInfo() {
                //  调用 methods中查询英雄的函数
                this.queryUserInfo();
            },
        },
        created(){
            this.queryUserInfo();
        }
    })


</script>
</body>
</html>
