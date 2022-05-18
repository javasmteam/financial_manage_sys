var vue = new Vue({
    el: "#app",
    data: {
        queryParams: {
            productSeriesId: "",
            productTypeChName: "",
            productTypeEngName: "",
            currentPage: 1,
            pageSize: 5,
            type: "showProductType"
        },
        productTypeVO: {
            productSeriesId: "",
            productTypeChName: "",
            productTypeEngName: "",
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
        },
        pageInfo: {
            currentPage: 1,
            pageNum: 5,
            total: 0,
        },
        saveFlag2: false,
        saveFlag1: false,
        //产品系列数据
        productTypeVOList: [],
        rules: {}
    }, methods: {
        search() {
            axios.post(
                projectPath + "/productType.do", {
                    queryParams: this.queryParams,
                }
            ).then(response => {
                this.productTypeVOList = response.data.dataList;
                this.currentPage = response.data.nowPage;
                this.pageSize = response.data.pageNum;
                this.pageInfo.total = response.data.total;
            })
        },
        handleSizeChange(pageSize) {
            this.pageSize = pageSize;
        }
        ,
        handleCurrentChange(nowPage) {
            this.currentPage = nowPage;
            this.search(nowPage);
        },
        deleteItem(item) {
            this.productTypeVOList.splice(item, 1)
            axios.get(projectPath + "productType.do?type=updateProductType", {
                productSeriesId: this.productTypeVOList.productSeriesId
            })
        },

    },
    created() {
        this.search();
    }
})