var vue = new Vue({
    el: "#app", data: {
        queryParams: {
            productSeriesId: "",
            productTypeChName: "",
            productTypeEngName: "",
            nowPage: 1,
            pageSize: 5,
            type: "showProductType"
        }, remitInfo: {
            productSeriesId: "",
            recBankName: "",
            swiftCode: "",
            bankCode: "",
            cnapsId: "",
            recBankArea: "",
            recBankCity: "",
            recAccountName: "",
            recAccount: "",
            recLocation: "",
            regulateBody: "",
            remitInfoSummary: "",
        }, productType: {
            product_series_id: "",
            productParentId: "",
            productChannel: "",
            productTypeChName: "",
            productTypeEngName: "",
            productTypeLv: 1,
        }, pageInfo: {
            nowPage: 1, pageNum: 5, allCount: 0,
        }, saveFlag2: false, saveFlag1: false, saveFlag3: false,//产品系列数据
        productTypeVOList: [], productTypeVO: {}, rules: {}, count: {}
    }, methods: {
        search() {
            axios.get(projectPath + "/productType.do?", {params: this.queryParams}).then(response => {
                this.productTypeVOList = response.data.dataList;
                this.nowPage = response.data.nowPage;
                this.pageSize = response.data.pageNum;
                this.pageInfo.allCount = response.data.allCount;
            })
        }, handleSizeChange(pageSize) {
            this.queryParams.pageSize = pageSize;
            this.search();
        }, handleCurrentChange(nowPage) {
            this.queryParams.nowPage = nowPage;
            this.search();
        }, deleteItem(item) {
            this.productTypeVOList.splice(item, 1)
            axios.get(projectPath + "productType.do", {})
        }, showRemitInfo(obj) {
            this.remitInfo.productSeriesId = obj.productSeriesId;
            this.productTypeVO = obj;
            this.saveFlag1 = true;
        }, addProductType() {
            axios.post(projectPath + "/productType.do?type=addProductType", this.productType).then(response => {
                if (response.data == "1") {
                    axios.get(projectPath + "/productType.do?type=countProductType").then(response => {
                        this.count = response.data;
                    })
                    this.remitInfo.productSeriesId = this.count.value + 1
                    axios.post(projectPath + "/remitInfo.do?type=addRemitInfo", this.remitInfo).then(response => {
                        if (response.data == "1") {
                            this.$message.success("添加成功!")
                            this.search();
                        } else {
                            this.$message.error("添加失败!")
                        }
                    })
                } else {
                    this.$message.error("添加失败!")
                }
                this.saveFlag2 = false;
            },)
        }, handleEdit(obj) {
            this.productType.product_series_id = obj.product_series_id;
            axios.get(projectPath + "/productType.do?type=findProductTypeById", {params: {addProductType: obj.productSeriesId}}).then(response => {
                if (response.data.productChannel == "1") {
                    this.productType.productChannel = "香港资管"
                } else if (response.data.productChannel == "2") {
                    this.productType.productChannel = "内地资管"
                }
                if (response.data.productParentId == "1") {
                    this.productType.productParentId = "基金"
                } else if (response.data.productParentId == "2") {
                    this.productType.productParentId = "保险"
                } else if (response.data.productParentId == "3") {
                    this.productType.productParentId = "证券"
                }
                this.productType.productTypeChName = response.data.productTypeChName
                this.productType.productTypeEngName = response.data.productTypeEngName
            })
            this.saveFlag3 = true;
        }, changeProductType() {
            axios.post(projectPath + "/remitInfo.do?type=updateProductTypeById", this.productType).then(response => {
                if (response.data == "1") {
                    this.search();
                    this.$message.success("修改成功!")
                } else {
                    this.$message.error("修改失败!")
                }
                this.saveFlag3 = false;
            })
        },
        updateRemitInfo() {
            this.remitInfo.recBankName = this.productTypeVO.recBankName;
            this.remitInfo.swiftCode = this.productTypeVO.swiftCode;
            this.remitInfo.bankCode = this.productTypeVO.bankCode;
            this.remitInfo.cnapsId = this.productTypeVO.cnapsId;
            this.remitInfo.recBankArea = this.productTypeVO.recBankArea;
            this.remitInfo.recBankCity = this.productTypeVO.recBankCity;
            this.remitInfo.recAccountName = this.productTypeVO.recAccountName;
            this.remitInfo.recAccount = this.productTypeVO.recAccount;
            this.remitInfo.recLocation = this.productTypeVO.recLocation;
            this.remitInfo.regulateBody = this.productTypeVO.regulateBody;
            this.remitInfo.remitInfoSummary = this.productTypeVO.remitInfoSummary;
            axios.post(projectPath + "/productType.do?type=updateRemitInfoById", this.remitInfo).then(response => {
                if (response.data == "1") {
                    this.search();
                    this.$message.success("修改成功!")
                } else {
                    this.$message.error("修改失败!")
                }
                this.saveFlag3 = false;
            })
        },

    }, created() {
        this.search();
        axios.get(projectPath + "/productType.do", {params: {type: "showProductType"}}).then(response => {
            this.productTypeVOList = response.data;
        })
    }
})