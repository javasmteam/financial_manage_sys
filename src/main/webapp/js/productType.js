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
            pageNum: 6
        },
        pageInfo: {
            nowPage: 1,
            pageNum: 6,
            total: 0
        },
        productType: {
            productSeriesId: "", productTypeChName: "", productTypeEngName: "", remitInfoSummary: "",

        }, productTypeList: [],
    }, methods: {
        search() {
            axios.get("${appPath}/productType.do", {})
        }
    }

})