var vue = new Vue({
    el: "#app", data: {
        queryParams: {
            productSeriesId: "", productChName: "", nowPage: 1, pageSize: 5, type: "showProductRecommend"
        },
        productRecommend: {
            productId: "",
            recommendLv: "",
            isVisible: "",
            isIpo: "",
            isOnlinePurchase: "",
            recommendReason: "",
            recommendState: 1
        },
        pageInfo: {
            nowPage: 1, pageNum: 5, allCount: 0
        },
        saveFlag2: false,
        saveFlag1: false,
        saveFlag3: false,
        saveFlag4: false,//产品系列数据
        productRecommendVOList: [],
        productSeriesList: [],
        productNotRecommends: [],
        productRecommendData: {},
        rules: {},
        deleteId: "",
        productChName: "",
    }, methods: {
        search() {
            axios.get(projectPath + "/ProductRecommendServlet?showProductRecommend", {params: this.queryParams}).then(response => {
                this.productRecommendVOList = response.data.dataList;
                this.pageInfo.nowPage = response.data.nowPage;
                this.pageInfo.pageSize = response.data.pageNum;
                this.pageInfo.allCount = response.data.allCount;
            })
        }, clearQueryParams() {
            this.queryParams.productSeriesId = "";
            this.queryParams.productChName = "";
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
        },
        showProductRecommend(obj) {
            this.productRecommend.productId = obj.productId;
            this.productChName = obj.productChName;
            axios.get(projectPath + "/ProductRecommendServlet?type=findProductRecommendById", {params: {productId: obj.productId}}).then(response => {
                this.productRecommend.recommendLv = response.data.recommendLv;
                this.productRecommend.isVisible = response.data.isVisible;
                this.productRecommend.isIpo = response.data.isIpo;
                this.productRecommend.isOnlinePurchase = response.data.isOnlinePurchase;
                this.productRecommend.recommendReason = response.data.recommendReason;
            })
            this.saveFlag3 = true;
        },
        changeProductRecommend() {
            axios.post(projectPath + "/ProductRecommendServlet?type=updateProductRecommendById&productChName=" + this.productChName, this.productRecommend).then(response => {
                if (response.data == "1") {
                    this.$message.success("修改成功！")
                } else {
                    this.$message.error("修改失败!")
                }
                this.saveFlag3 = false;
                this.search();
            },)
        },
        addProductRecommend() {
            axios.post(projectPath + "/ProductRecommendServlet?type=addProductRecommend", this.productRecommend).then(response => {
                if (response.data == "1") {
                    this.$message.success("添加成功！")
                } else {
                    this.$message.error("添加失败!")
                }
                this.saveFlag2 = false;
                this.search();
            },)
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
        },
        getProductSeries() {
            axios.get(projectPath + "/productType.do?type=queryAllProductSeries").then(response => {
                this.productSeriesList = response.data;
            })
        },
        getProductNotRecommends() {
            axios.get(projectPath + "/ProductRecommendServlet?type=getProductNotRecommends").then(response => {
                this.productNotRecommends = response.data;
            })
        }
    },
    created() {
        this.search();
        this.getProductSeries();
        this.getProductNotRecommends();
        // axios.get(projectPath + "/productType.do", {params: {type: "showProductInfo"}}).then(response => {
        //     this.productInfoVOList = response.data;
        // })
    }
})