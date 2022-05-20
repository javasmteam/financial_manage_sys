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
    <el-descriptions title="独角兽管理>企业信息管理"></el-descriptions>

    <el-form :inline="true" id="companySelect">
        <el-form-item label="企业名：">
            <el-input v-model="selectParams.comName"></el-input>
        </el-form-item>
        <el-button type="primary" plain @click="showCompany()">查询</el-button>
        <el-button type="primary" plain @click="addFlag=true">新增</el-button>
    </el-form>

    <el-table :data="companyList" height="330">
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column prop="comName" label="企业名称" width="150"></el-table-column>
        <el-table-column prop="tradeCode" label="交易代码" width="150"></el-table-column>
        <el-table-column prop="comSeqCode" label="顺序" width="80"></el-table-column>
        <el-table-column prop="newMakerAmount" label="最新挂牌价" width="110"></el-table-column>
        <el-table-column label="操作" width="260">
            <template slot-scope="scope">
                <el-button @click="initUpdate(scope.row)" type="text" size="small">详情</el-button>
                <el-button @click="initUpdate(scope.row)" type="text" size="small">修改</el-button>
                <el-button type="text" size="small" @click="deleteHero()">删除</el-button>
                <el-button type="text" size="small" @click="addMaker(scope)">编辑挂单</el-button>
                <el-button type="text" size="small" @click="showHistory()">历史融资</el-button>
            </template>
        </el-table-column>
    </el-table>

    <%--分页--%>
    <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="pageInfo.nowPage"
            :page-sizes="[5, 10, 15, 20]"
            :page-size="pageInfo.pageNum"
            layout="total, sizes, prev, pager, next, jumper"
            :total="pageInfo.total">
    </el-pagination>

    <%--添加企业信息--%>
    <el-dialog id="editCompany" title="编辑企业信息" :visible.sync="addFlag" width="35%">
        <el-form :inline="true" :model="company" label-width="100px">

            <el-row>
                <el-col :span="12">
                    <el-form-item label="企业名称" prop="comName">
                        <el-input v-model="company.comName" placeholder="企业名称"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="交易代码" prop="tradeCode">
                        <el-input v-model="company.tradeCode" placeholder="交易代码"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="12">
                    <el-form-item label="企业logo" prop="comLogo">
                       <el-upload class="upload-demo" action="${appPath}/fileUpload.do" multiple
                               :limit="3" :on-success="getFileName">
                           <el-button size="small" type="primary">点击上传</el-button>
                       </el-upload>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="APP端logo" prop="appLogo">
                       <el-upload class="upload-demo" action="${appPath}/fileUpload.do" multiple
                               :limit="3" :on-success="getFileName">
                         <el-button size="small" type="primary">点击上传</el-button>
                       </el-upload>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="12">
                    <el-form-item label="所属行业" prop="comIndustry">
                      <el-select v-model="company.comIndustry" placeholder="请选择" style="width: 150px">
                        <el-option label="软件开发" value="软件开发"></el-option>
                        <el-option label="医疗器械" value="医疗器械"></el-option>
                        <el-option label="有色金属" value="有色金属"></el-option>
                        <el-option label="工程建设" value="工程建设"></el-option>
                        <el-option label="专用设备" value="专用设备"></el-option>
                      </el-select>
                   </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="成立年份" prop="comCreateYear">
                      <el-col :span="11">
                        <el-date-picker type="date" placeholder="选择日期" v-model="company.comCreateYear"
                                        style="width: 200px;"
                        >
                        </el-date-picker>
                      </el-col>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="12">
                    <el-form-item label=" CEO" prop="comCeo">
                       <el-input v-model="company.comCeo" placeholder="CEO"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="企业所在地" prop="comLocation">
                       <el-input v-model="company.comLocation" placeholder="企业所在地"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="12">
                    <el-form-item label="费率(%)" prop="comRate">
                          <el-input v-model="company.comRate" placeholder="费率(%)"></el-input>
                    </el-form-item>
                </el-col>
                <el-col :span="12">
                    <el-form-item label="企业顺序" prop="comSeqCode">
                         <el-input-number v-model="company.comSeqCode" controls-position="right" :min="1" :max="10"></el-input-number>
                    </el-form-item>
                </el-col>
            </el-row>

            <el-row>
                <el-col :span="24">
                    <el-form-item label="企业介绍" prop="comIntro" label-width="100px">
                        <el-input v-model="company.comIntro" placeholder="企业介绍" label="描述文字"></el-input>
                    </el-form-item>
                </el-col>
            </el-row>


            <el-row>
                    <el-form-item>
                        <el-button @click="editCompany()" type="primary">保存</el-button>
                        <el-button @click="addFlag=false">取消</el-button>
                    </el-form-item>
            </el-row>

        </el-form>
    </el-dialog>

    <%--挂单价--%>
<%--    <el-form :inline="true" :model="formInline" class="demo-form-inline">--%>
<%--        <el-descriptions title="挂单价"></el-descriptions>--%>

<%--        <el-form-item label="买一">--%>
<%--            <el-input v-model="formInline.user" placeholder="买一"></el-input>--%>
<%--        </el-form-item>--%>
<%--        <el-form-item label="买入几手">--%>
<%--            <el-input v-model="formInline.user" placeholder="买入几手"></el-input>--%>
<%--        </el-form-item>--%>
<%--        <el-form-item label="买二">--%>
<%--            <el-input v-model="formInline.user" placeholder="买二"></el-input>--%>
<%--        </el-form-item>--%>
<%--        <el-form-item label="买入几手">--%>
<%--            <el-input v-model="formInline.user" placeholder="买入几手"></el-input>--%>
<%--        </el-form-item>--%>
<%--        <el-form-item label="买三">--%>
<%--            <el-input v-model="formInline.user" placeholder="买三"></el-input>--%>
<%--        </el-form-item>--%>
<%--        <el-form-item label="买入几手">--%>
<%--            <el-input v-model="formInline.user" placeholder="买入几手"></el-input>--%>
<%--        </el-form-item>--%>

<%--        <span slot="footer" class="dialog-footer">--%>
<%--            <el-button @click="addFlag=false">取消</el-button>--%>
<%--            <el-button @click="editHero()" type="primary">保存</el-button>--%>
<%--        </span>--%>
<%--    </el-form>--%>

    <%--历史融资--%>
    <el-dialog  title="历史融资表" Z width="35%">
    <el-form :inline="true" :model="history" :data="historyList" >

        <el-table-column prop="comName" label="企业名称" width="150"></el-table-column>
        <el-table-column prop="funDate" label="投资日期" width="150"></el-table-column>
        <el-table-column prop="funType" label="投资轮" width="80"></el-table-column>
        <el-table-column prop="funAmount" label="投资资金(百万)" width="110"></el-table-column>
        <el-table-column prop="afterFunVal" label="投后估值(百万)" width="110"></el-table-column>
        <el-table-column prop="totalShares" label="总发行股数(百万)" width="110"></el-table-column>
        <el-table-column prop="pricePerShare" label="每股单价" width="110"></el-table-column>

        <span slot="footer" class="dialog-footer">
            <el-button >取消</el-button>
        </span>
    </el-form>
    </el-dialog>
</div>

<script>
    new Vue({
        el: "#app",
        data: {
            selectParams: {
                type: "showCompany",
                comName: "",
                newMakerAmount: "",
                nowPage: 1,
                pageNum: 5
            },
            pageInfo: {
                nowPage: 1,
                pageNum: 5,
                total: 0
            },
            company: {
                type:"addCompany",
                comName: "",
                tradeCode: "",
                comLogo: "",
                appLogo: "",
                comIndustry: "",
                comCreateYear: "1997",
                comCeo: "",
                comRate: "",
                comSeqCode: 0,
                comIntro: ""
            },
            maker: {
                type:"addMaker",
                makerAmount: "",
                tradeAmount: ""
            },
            history: {
                type:"showHistory",
                comName: "",
                funDate: "",
                funType: "",
                funAmount: "",
                afterFunVal: "",
                totalShares: "",
                pricePerShare: "",
                comId:""
            },
            companyList: [],
            comIndustryList:[],
            addFlag:false,
            historyList:[],

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
            editCompany(){
                console.log(this.company)
                let string = window.Qs.stringify(this.company);
                axios.post("http://localhost:8088/Financial_manage_sys_war_exploded/companyInfo.do",string).then(response =>{
                    this.$message({
                        message:response.data,
                        type:'success'
                    });
                    if (response.data== "添加成功" || response.data =="修改成功"){
                        //关闭对话框
                        this.addFlag = false;
                        //查询英雄
                        this.queryCompany();
                        this.company= {
                            type:"addCompany",
                                comName: "",
                                tradeCode: "",
                                comLogo: "",
                                appLogo: "",
                                comIndustry: 1,
                                comCreateYear: "1997",
                                comCeo: "",
                                comRate: "",
                                comSeqCode: 0,
                                comIntro: ""
                        }
                    }
                })
            },
            getFileName(){

            },
            initUpdate(company){
                this.company={
                    type:"updateCompany",
                    comName: company.comName,
                    tradeCode: company.tradeCode,
                    comLogo: company.comLogo,
                    appLogo: company.appLogo,
                    comIndustry: company.comIndustry,
                    comCreateYear: company.comCreateYear,
                    comCeo: company.comCeo,
                    comRate: company.comRate,
                    comSeqCode: company.comSeqCode,
                    comIntro: company.comIntro,
                    comId:company.comId
                };
                this.addFlag = true;
            },
            showHistory(){
                axios.get("http://localhost:8088/Financial_manage_sys_war_exploded/companyInfo.do", {
                    params: this.history
                }).then(response => {
                    this.historyList = response.data.dataList;
                });
            }
        },
        created(){
            this.queryCompany();
        }
    })
</script>
</body>
</html>
