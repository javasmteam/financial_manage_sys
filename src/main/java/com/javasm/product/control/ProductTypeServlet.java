package com.javasm.product.control; /**
 * <h4>Financial_manage_sys</h4>
 * <p>${description}</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-17 17:14
 * @Version : 1.0
 **/

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.javasm.annotation.ResponseTypeAnnotation;
import com.javasm.controlUtil.BaseServlet;
import com.javasm.myEnum.ResponseEnum;
import com.javasm.product.bean.PageInfo;
import com.javasm.product.bean.ProductType;
import com.javasm.product.bean.RemitInfo;

import com.javasm.product.bean.vo.ProductTypeVO;
import com.javasm.product.service.ProductTypeService;
import com.javasm.product.service.RemitInfoService;
import com.javasm.product.service.impl.ProductTypeServiceImpl;
import com.javasm.product.service.impl.RemitInfoServiceImpl;
import com.javasm.util.DataUtil;
import com.javasm.util.ServletUtil;

import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/productType.do")
public class ProductTypeServlet extends BaseServlet<ProductType> {
    private final ProductTypeService productTypeService = new ProductTypeServiceImpl();
    private final RemitInfoService remitInfoService = new RemitInfoServiceImpl();


    /**
     * 分页查询所有的英雄信息
     *
     * @param productType
     * @param request
     * @return
     */
    public String showProductType(ProductType productType, HttpServletRequest request) {
        String nowPage = request.getParameter("nowPage");
        String pageNum = request.getParameter("pageSize");
        String productSeriesIdStr = request.getParameter("productSeriesId");
        String productTypeChName = request.getParameter("productTypeChName");
        String productTypeEngName = request.getParameter("productTypeEngName");
        Integer productSeriesId = DataUtil.stringConvertToInteger(productSeriesIdStr);
        productType.setProductSeriesId(productSeriesId);
        productType.setProductTypeChName(productTypeChName);
        productType.setProductTypeEngName(productTypeEngName);
        PageInfo<ProductTypeVO> page = productTypeService.getProductTypesByPage(nowPage, pageNum, productType);
        return JSONObject.toJSONString(page);
    }

    public String updateProductTypeById(HttpServletRequest request) {
        ProductType productType = ServletUtil.jsonConvertToEntity(request, ProductType.class);
        if (productTypeService.updateProductType(productType)) {
            return "1";
        }
        return "-1";
    }

    public String deleteProductTypeById(HttpServletRequest request) {
        String idStr = request.getParameter("id");
        Integer id = DataUtil.stringConvertToInteger(idStr);
        if (productTypeService.deleteProductTypeById(id)) {
            return "1";
        }
        return "-1";
    }

    public String addProductType(HttpServletRequest request) {
        ProductType productType = ServletUtil.jsonConvertToEntity(request, ProductType.class);
        if (productTypeService.addProductType(productType)) {
            Integer count = productTypeService.count();
            RemitInfo remitInfo = new RemitInfo();
            remitInfo.setProductSeriesId(count);
            if (remitInfoService.addRemitInfo(remitInfo)) {
                return "1";
            }
        }
        return "-1";
    }


    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String findProductTypeById(HttpServletRequest request) {
        String id = request.getParameter("addProductType");
        return JSONObject.toJSONString(productTypeService.getProductTypeById(Integer.valueOf(id)));
    }

    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String queryAllProductSeries() {
        return JSONObject.toJSONString(productTypeService.queryAllProductSeries());
    }


}
