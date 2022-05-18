var vue = new Vue({
    el: "#app",
    data: {
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
            nowPage: 1,
            pageNum: 5,
            total: 0
        },
        productTypeVOList: [],
    }, methods: {
        search() {
            axios.get(projectPath + "/productType.do", {
                params: {
                    type:"showProductType",
                    pageNum:1,

                }
            }).then(response => {
                this.productTypeVOList = response.data.dataList;
                this.pageInfo.nowPage = response.data.nowPage;
                this.pageInfo.pageNum = response.data.pageNum;
                this.pageInfo.total = response.data.total;
            })
        },
        pageSizeChange(pageSize) {
            this.selectParams.pageNum = pageSize;
        },
        nowPageChange(nowPage) {
            this.selectParams.nowPage = nowPage;
        },
        showProductType() {
            this.search();
        }
    },
    // created() {
    //     //调用method中的方法查询英雄的函数
    //     this.search();
    //     axios.get(projectPath + "/productType.do", {params: {type: "showProductType"}}).then(response => {
    //         this.productTypeVOList = response.data;
    //     })
    // }
})