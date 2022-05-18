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
        productType: {
            productSeriesId: "", productTypeChName: "", productTypeEngName: "", remitInfoSummary: "",

        },
        productTypeVOList: [],
    }, methods: {
        search() {
            axios.get()
            axios.get("/productType.do", {
                params: this.selectParams
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
    created() {
        //调用method中的方法查询英雄的函数
        this.search();
        axios.get("/productType.do", {params: {type: "showProductType"}}).then(response => {
            this.productTypeVOList = response.data;
        })
    }
})