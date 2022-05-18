<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/5/17
  Time: 19:39
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
    <style>
        #companySelect .el-input__inner {
            width: 220px
        }

        .el-upload-list__item {
            height: 32px;

        }
    </style>
</head>
<body>
<div id="app">
    <el-descriptions title="独角兽管理>充值管理信息"></el-descriptions>

        <el-form :inline="true" id="companySelect">
            <el-form-item label="企业名：">
                <el-input v-model="selectParams.comName"></el-input>
            </el-form-item>
            <el-button type="primary" plain @click="showCompany()">查询</el-button>
            <el-button type="primary" plain @click="addFlag=true">新增</el-button>
        </el-form>

        <el-table :data="companyList" height="330" >
            <el-table-column type="selection" width="55"></el-table-column>
            <el-table-column prop="comName" label="企业名称" width="150"></el-table-column>
            <el-table-column prop="tradeCode" label="交易代码" width="150"></el-table-column>
            <el-table-column prop="comSeqCode" label="顺序" width="80"></el-table-column>
            <el-table-column prop="newMakerAmount" label="最新挂牌价" width="110"></el-table-column>
            <el-table-column label="操作" width="260">
                <template slot-scope="scope">
                    <el-button @click="initUpdate(scope.row)" type="text" size="small">详情</el-button>
                    <el-button @click="initUpdate(scope.row)" type="text" size="small">修改</el-button>
                    <el-button type="text" size="small" @click="deleteHero(scope.row.heroId)">删除</el-button>
                    <el-button type="text" size="small" @click="">编辑挂单</el-button>
                    <el-button type="text" size="small" @click="">历史融资</el-button>
                </template>
            </el-table-column>
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
        el: "#app",
        data: {
            selectParams: {
                comName: "",
                type: "showCompany",
                newMakerAmount:"",
                nowPage: 1,
                pageNum: 5
            },
            pageInfo: {
                nowPage: 1,
                pageNum: 5,
                total: 0
            },
            companyList: [],
            // tableData: [{
            //     companyList:[]
            // }]

        },
        methods: {
            queryCompany() {
                axios.get("http://localhost:8088/Financial_manage_sys_war_exploded/companyInfo.do", {
                    params: this.selectParams
                }).then(response => {
                    this.companyList = response.data.dataList;
                    this.pageInfo.nowPage = response.data.nowPage;
                    this.pageInfo.pageNum = response.data.pageNum;
                    this.pageInfo.total = response.data.allCount;
                });
            },
            handleSizeChange(pageSize) {
                console.log("显示几条数据：" + pageSize)
                this.selectParams.pageNum = pageSize;
                this.queryCompany();
            },
            handleCurrentChange(nowPage) {
                console.log("当前页：" + nowPage)
                this.selectParams.nowPage = nowPage;
                this.queryCompany();
            },
            showCompany() {
                //  调用 methods中查询英雄的函数
                this.queryCompany();
            },
            // toggleSelection(rows) {
            //     if (rows) {
            //         rows.forEach(row => {
            //             this.$refs.multipleTable.toggleRowSelection(row);
            //         });
            //     } else {
            //         this.$refs.multipleTable.clearSelection();
            //     }
            //     this.queryCompany();
            // },

        }
    })
</script>
</body>
</html>
