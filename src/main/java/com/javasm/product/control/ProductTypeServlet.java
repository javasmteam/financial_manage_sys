package com.javasm.product.control; /**
 * <h4>Financial_manage_sys</h4>
 * <p>${description}</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-17 17:14
 * @Version : 1.0
 **/

import com.alibaba.fastjson.JSONObject;
import com.javasm.controlUtil.BaseServlet;
import com.javasm.product.bean.PageInfo;
import com.javasm.product.bean.ProductType;
import com.javasm.product.bean.vo.ProductTypeVO;
import com.javasm.product.service.ProductTypeService;
import com.javasm.product.service.impl.ProductTypeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("productType.do")
public class ProductTypeServlet extends BaseServlet<ProductTypeVO> {
    private final ProductTypeService productTypeService = new ProductTypeServiceImpl();


    /**
     * 分页查询所有的英雄信息
     *
     * @param productType
     * @param request
     * @return
     */
    public String showProductType(ProductType productType, HttpServletRequest request) {
        String nowPage = request.getParameter("nowPage");
        String pageNum = request.getParameter("pageNum");
        PageInfo<ProductTypeVO> page = productTypeService.getProductTypesByPage(nowPage, pageNum, productType);
        return JSONObject.toJSONString(page);
    }

    public void updateProductType(ProductType productType) {
        productTypeService.updateProductType(productType);
    }

    public void addProductType(ProductType productType) {
        productTypeService.addProductType(productType);
    }

    ;


}
