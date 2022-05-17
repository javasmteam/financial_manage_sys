var vue = new Vue({
    el: "#app",
    data: {
        selectParams: {
            //提交到服务器的值
            productSeriesId: "",
            productTypeChName: "",
            productTypeEngName: "",
            type: "showProductType",
            nowPage: 1,
            pageNum: 5
        },
        pageInfo: {
            nowPage: 1,
            pageNum: 6,
            total: 0
        },
        productType: {
            productSeriesId: "", productTypeChName: "", productTypeEngName: "", remitInfoSummary: "",

        },
        productTypeVOList: [],
    }, methods: {
        search() {
            axios.get("${appPath}/productType.do", {
                params: this.selectParams
            }).then(response => {
                this.productTypeVOList = response.data.dataList;
                this.pageInfo.nowPage = response.data.nowPage;
                this.pageInfo.pageNum = response.data.pageNum;
                this.pageInfo.total = response.data.total;
            })
        },

    }

})