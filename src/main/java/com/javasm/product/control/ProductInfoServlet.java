package com.javasm.product.control; /**
 * <h4>Financial_manage_sys</h4>
 * <p>${description}</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-19 02:58
 * @Version : 1.0
 **/

import com.alibaba.fastjson.JSONObject;
import com.javasm.controlUtil.BaseServlet;
import com.javasm.product.bean.PageInfo;
import com.javasm.product.bean.ProductInfo;
import com.javasm.product.bean.ProductType;
import com.javasm.product.bean.RemitInfo;
import com.javasm.product.bean.vo.ProductInfoVO;
import com.javasm.product.bean.vo.ProductTypeVO;
import com.javasm.product.service.ProductInfoService;
import com.javasm.product.service.ProductTypeService;
import com.javasm.product.service.impl.ProductInfoServiceImpl;
import com.javasm.product.service.impl.ProductTypeServiceImpl;
import com.javasm.util.DataUtil;
import com.javasm.util.ServletUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ProductInfoServlet.do")
public class ProductInfoServlet extends BaseServlet<ProductInfoVO> {
    private final ProductInfoService productInfoService = new ProductInfoServiceImpl();


    /**
     * 分页查询商品信息
     *
     * @param productInfoVO
     * @param request
     * @return
     */
    public String showProductInfo(ProductInfoVO productInfoVO, HttpServletRequest request) {
        String nowPage = request.getParameter("nowPage");
        String pageNum = request.getParameter("pageSize");
        String productChNameStr = request.getParameter("productChName");
        String secIdStr = request.getParameter("secId");
        String auditTypeStr = request.getParameter("auditType");
        Integer productSeriesId = DataUtil.stringConvertToInteger(productChNameStr);
        Integer secId = DataUtil.stringConvertToInteger(secIdStr);
        Integer auditType = DataUtil.stringConvertToInteger(auditTypeStr);
        productInfoVO.setProductSeriesId(productSeriesId);
        productInfoVO.setSecId(secId);
        productInfoVO.setAuditType(auditType);
        PageInfo<ProductInfoVO> page = productInfoService.getProductInfoByPage(nowPage, pageNum, productInfoVO);
        return JSONObject.toJSONString(page);
    }

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

}
