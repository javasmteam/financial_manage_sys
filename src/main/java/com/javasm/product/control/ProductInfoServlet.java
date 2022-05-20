//package com.javasm.product.control; /**
// * <h4>Financial_manage_sys</h4>
// * <p>${description}</p>
// *
// * @Author : zhao Yuanming
// * @Date : 2022-05-19 02:58
// * @Version : 1.0
// **/
//
//import com.alibaba.fastjson.JSONObject;
//import com.javasm.controlUtil.BaseServlet;
//import com.javasm.product.bean.PageInfo;
//import com.javasm.product.bean.ProductInfo;
//import com.javasm.product.bean.ProductType;
//import com.javasm.product.bean.RemitInfo;
//import com.javasm.product.bean.vo.ProductTypeVO;
//import com.javasm.product.service.ProductInfoService;
//import com.javasm.product.service.ProductTypeService;
//import com.javasm.product.service.impl.ProductInfoServiceImpl;
//import com.javasm.product.service.impl.ProductTypeServiceImpl;
//import com.javasm.util.DataUtil;
//import com.javasm.util.ServletUtil;
//
//import javax.servlet.*;
//import javax.servlet.http.*;
//import javax.servlet.annotation.*;
//import java.io.IOException;
//
//@WebServlet("/ProductInfoServlet.do")
//public class ProductInfoServlet extends BaseServlet<RemitInfo> {
//    private final ProductInfoService productInfoService = new ProductInfoServiceImpl();
//
//
//    /**
//     * 分页查询所有的英雄信息
//     *
//     * @param productInfo
//     * @param request
//     * @return
//     */
//    public String showProductInfo(ProductInfo productInfo, HttpServletRequest request) {
//        String nowPage = request.getParameter("currentPage");
//        String pageNum = request.getParameter("pageSize");
//        String productSeriesIdStr = request.getParameter("productSeriesId");
//        String productTypeChName = request.getParameter("productTypeChName");
//        String productTypeEngName = request.getParameter("productTypeEngName");
//        Integer productSeriesId = DataUtil.stringConvertToInteger(productSeriesIdStr);
//        productInfo.setProductSeriesId(productSeriesId);
//        productInfo.setProductTypeChName(productTypeChName);
//        productInfo.setProductTypeEngName(productTypeEngName);
//        PageInfo<ProductTypeVO> page = productTypeService.getProductTypesByPage(nowPage, pageNum, productType);
//        return JSONObject.toJSONString(page);
//    }

//    public void updateProductType(ProductType productType) {
//        productTypeService.updateProductType(productType);
//    }
//
//    public String addProductType(HttpServletRequest request) {
//        ProductType productType = ServletUtil.jsonConvertToEntity(request, ProductType.class);
//        if (productTypeService.addProductType(productType)) {
//            return "1";
//        }
//        return "-1";
//    }

//}
