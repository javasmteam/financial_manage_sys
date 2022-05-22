var vue = new Vue({
    el: "#app", data: {
        queryParams: {
            productChName: "", secId: "", auditType: "", nowPage: 1, pageSize: 5, type: "showProductInfo"
        },
        productInfo: {
            productId: "",
            productSeriesId: "",
            secId: "",
            regulateBody: "",
            productChName: "",
            recBankName: "",
            annualYield: "",
            currencyType: "",
            openTime: "",
            subCycle: "",
            fundManageFeeRate: "",
            subRate: "",
            initInvestAmount: "",
            subFeeCollectMethod: "",
            redCycle: "",
            redInitAmount: "",
            redAmount: "",
            lockPeriod: "",
            proInfoState: 1,
        },
        productNetValue: {
            productId: "", unitNet: "", unitDate: "", sumIncreaseRate: "", netValueState: 1,
        },
        productAudit: {
            productId: "",
            auditor: "",
            auditorOpinion: "",
            auditType: 0,
            auditState: 1,
        },
        productSecondType: {
            secId: "", secName: "", productSeriesId: "",
        },
        pageInfo: {
            nowPage: 1, pageNum: 5, allCount: 0
        },
        saveFlag2: false,
        saveFlag1: false,
        saveFlag3: false,
        saveFlag4: false,//产品系列数据
        productInfoVOList: [],
        productSecondTypeList: [],
        productSeriesList: [],
        productInfoVO: {},
        rules: {},
        deleteId: "",
    }, methods: {
        search() {
            axios.get(projectPath + "/ProductInfoServlet.do?showProductInfo", {params: this.queryParams}).then(response => {
                this.productInfoVOList = response.data.dataList;
                this.pageInfo.nowPage = response.data.nowPage;
                this.pageInfo.pageSize = response.data.pageNum;
                this.pageInfo.allCount = response.data.allCount;
            })
        }, clearQueryParams() {
            this.queryParams.secId = "";
            this.queryParams.auditType = "";
        }, handleSizeChange(pageSize) {
            //改变每页数据
            this.queryParams.pageSize = pageSize;
            this.search();
        }, handleCurrentChange(nowPage) {
            //改变当前页
            this.queryParams.nowPage = nowPage;
            this.search();
        }, deleteProduct(item) {
            //删除
            this.deleteId = item.productId;
            //显示弹框
            this.saveFlag4 = true;
        }, deleteItem() {
            axios.get(projectPath + "/ProductInfoServlet.do?type=deleteProductInfoTypeById", {params: {id: this.deleteId}}).then(response => {
                if (response.data == "1") {
                    this.search();
                    this.$message.success("删除成功!")
                } else {
                    this.$message.error("删除失败!")
                }
                this.saveFlag4 = false;
                this.search();
            })
        }, showProductAudit(obj) {
            //数据回填
            // this.remitInfo.productSeriesId = obj.productSeriesId;
            this.productInfoVO = obj;
            this.productAudit.productId = obj.productId;
            this.productAudit.auditor = obj.auditor;
            this.saveFlag3 = true;
        }, showProductNetValue(obj) {
            this.productInfoVO = obj;
            // this.productNetValue.productId = obj.productId;
            // this.productNetValue.unitNet = obj.unitNet;
            // this.productNetValue.unitDate = obj.unitDate;
            // this.productNetValue.sumIncreaseRate = obj.sumIncreaseRate;
            this.saveFlag1 = true;

        }, handleEdit(obj) {
            this.productType.productSeriesId = obj.productSeriesId;
            axios.get(projectPath + "/productType.do?type=findProductTypeById", {params: {addProductType: obj.productSeriesId}}).then(response => {
                // if (response.data.productChannel == "1") {
                //     this.productType.productChannel = "香港资管"
                // } else if (response.data.productChannel == "2") {
                //     this.productType.productChannel = "内地资管"
                // }
                // if (response.data.productParentId == "1") {
                //     this.productType.productParentId = "基金"
                // } else if (response.data.productParentId == "2") {
                //     this.productType.productParentId = "保险"
                // } else if (response.data.productParentId == "3") {
                //     this.productType.productParentId = "证券"
                // }
                this.productType.productParentId = response.data.productParentId;
                this.productType.productChannel = response.data.productChannel;
                this.productType.productTypeChName = response.data.productTypeChName
                this.productType.productTypeEngName = response.data.productTypeEngName
            })
            this.saveFlag3 = true;
        }, changeProductInfo() {
            axios.post(projectPath + "/ProductInfoServlet.do?type=updateProductInfo", this.productInfoVO).then(response => {
                if (response.data == "1") {
                    this.$message.success("添加成功！")
                } else {
                    this.$message.error("添加失败!")
                }
                this.saveFlag3 = false;
                this.search();
            },)
        }, changeProductNetValue() {
            axios.post(projectPath + "/remitInfo.do?type=updateRemitInfoById", this.remitInfo).then(response => {
                if (response.data == "1") {
                    this.search();
                    this.$message.success("修改成功!")
                } else {
                    this.$message.error("修改失败!")
                }
                this.saveFlag3 = false;
                this.search();
            })
        }, getProductSecondType() {
            axios.get(projectPath + "/ProductSecondTypeServlet?type=showAllProductSecondTypes").then(response => {
                this.productSecondTypeList = response.data;
            })
        }, getProductSeries() {
            axios.get(projectPath + "/productType.do?type=queryAllProductSeries").then(response => {
                this.productSeriesList = response.data;
            })
        },
        passAudit() {
            this.productAudit.auditType = 1;
            axios.post(projectPath + "/ProductAuditServlet.do?type=productAudit", this.productAudit).then(response => {
                if (response.data == "1") {
                    this.search();
                    this.$message.success("审核成功!")
                } else {
                    this.$message.error("审核成功!")
                }
                this.saveFlag3 = false;
                this.search();
            })
        },
        rejectAudit() {
            this.productAudit.auditType = 2;
            axios.post(projectPath + "/ProductAuditServlet.do?type=productAudit", this.productAudit).then(response => {
                if (response.data == "1") {
                    this.search();
                    this.$message.success("审核成功!")
                } else {
                    this.$message.error("审核成功!")
                }
                this.saveFlag3 = false;
                this.search();
            })
        }
    }, created() {
        this.search();
        this.getProductSecondType();
        this.getProductSeries();
        // axios.get(projectPath + "/productType.do", {params: {type: "showProductInfo"}}).then(response => {
        //     this.productInfoVOList = response.data;
        // })
    }
})