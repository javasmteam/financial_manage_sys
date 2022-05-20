<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/5/19
  Time: 22:26
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
    <el-descriptions title="独角兽管理>充值信息管理"></el-descriptions>

    <el-form :inline="true" id="investSelect">
        <el-form-item label="姓名：">
            <el-input v-model="selectParams.userName"></el-input>
        </el-form-item>
        <el-form-item label="交易类型：">
            <el-input v-model="selectParams.investmoneytype"></el-input>
        </el-form-item>
        <el-form-item label="交易状态：">
            <el-input v-model="selectParams.state"></el-input>
        </el-form-item>
        <el-button type="primary" plain @click="showInvest()">查询</el-button>
    </el-form>

    <el-table :data="investList" height="330">
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column prop="userid" label="客户编号" width="130"></el-table-column>
        <el-table-column prop="userName" label="客户名称" width="150"></el-table-column>
        <el-table-column prop="investmoneytype" label="交易类型" width="150"></el-table-column>
        <el-table-column prop="investmoney" label="金额(万)" width="100"></el-table-column>
        <el-table-column prop="investrequesttime" label="请求时间" width="200"></el-table-column>
        <el-table-column prop="investhandletime" label="处理完成时间" width="200"></el-table-column>
        <el-table-column prop="investbankcode" label="银行交易编号" width="150"></el-table-column>
        <el-table-column prop="state" label="状态" width="110"></el-table-column>

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
                type:"showInvest",
                userName:"",
                investmoneytype:"",
                state:"",
                nowPage: 1,
                pageNum: 5,
            },
            pageInfo: {
                nowPage: 1,
                pageNum: 5,
                total: 0
            },
            investList:[]
        },
        methods: {
            queryInvest() {
                axios.get("http://localhost:8088/Financial_manage_sys_war_exploded/invest.do", {
                    params: this.selectParams
                }).then(response => {
                    this.investList = response.data.dataList;
                    this.pageInfo.nowPage = response.data.nowPage;
                    this.pageInfo.pageNum = response.data.pageNum;
                    this.pageInfo.total = response.data.allCount;
                });
            },
            handleSizeChange(pageSize) {
                console.log("显示几条数据：" + pageSize)
                this.selectParams.pageNum = pageSize;
                this.queryInvest();
            },
            handleCurrentChange(nowPage) {
                console.log("当前页：" + nowPage)
                this.selectParams.nowPage = nowPage;
                this.queryInvest();
            },
            showInvest() {
                //  调用 methods中查询英雄的函数
                this.queryInvest();
            },
        },
        created(){
            this.queryInvest();
        }
    })
</script>
</body>
</html>
