package com.javasm.product.control; /**
 * <h4>Financial_manage_sys</h4>
 * <p>${description}</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-19 02:58
 * @Version : 1.0
 **/

import com.alibaba.fastjson.JSONObject;
import com.javasm.annotation.ResponseTypeAnnotation;
import com.javasm.controlUtil.BaseServlet;
import com.javasm.myEnum.ResponseEnum;
import com.javasm.product.bean.*;
import com.javasm.product.bean.vo.ProductInfoVO;
import com.javasm.product.bean.vo.ProductRecommendVO;
import com.javasm.product.bean.vo.ProductTypeIdVO;
import com.javasm.product.bean.vo.SecValueVO;
import com.javasm.product.service.MiddleProductService;
import com.javasm.product.service.ProductRecommendService;
import com.javasm.product.service.impl.MiddleProductServiceImpl;
import com.javasm.product.service.impl.ProductRecommendServiceImpl;
import com.javasm.util.DataUtil;
import com.javasm.util.ServletUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ProductRecommendServlet")
public class ProductRecommendServlet extends BaseServlet<ProductTypeIdVO> {
    private final ProductRecommendService productRecommendService = new ProductRecommendServiceImpl();
    private final MiddleProductService middleProductService = new MiddleProductServiceImpl();


    /**
     * 分页查询产品推荐信息
     *
     * @param productTypeIdVO
     * @param request
     * @return
     */
    public String showProductRecommend(ProductTypeIdVO productTypeIdVO, HttpServletRequest request) {
        String nowPage = request.getParameter("nowPage");
        String pageNum = request.getParameter("pageSize");
        String productSeriesIdStr = request.getParameter("productSeriesId");
        String productChName = request.getParameter("productChName");
        Integer productSeriesId = DataUtil.stringConvertToInteger(productSeriesIdStr);
        productTypeIdVO.setProductTypeChName(productChName);
        productTypeIdVO.setProductSeriesId(productSeriesId);
        PageInfo<ProductRecommendVO> page = productRecommendService.getProductTypesByPage(nowPage, pageNum, productTypeIdVO);
        return JSONObject.toJSONString(page);
    }

    /**
     * 返回没有推荐过的集合
     *
     * @param request
     * @return
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String getProductNotRecommends(HttpServletRequest request) {
        return JSONObject.toJSONString(productRecommendService.getProductNotRecommends());
    }


    public String addProductRecommend(HttpServletRequest request) {
        ProductRecommend productRecommend = ServletUtil.jsonConvertToEntity(request, ProductRecommend.class);
        if (productRecommendService.addProductRecommend(productRecommend)) {
            return "1";
        }
        return "-1";
    }


    public String updateProductRecommendById(HttpServletRequest request) {
        String productChName = request.getParameter("productChName");
        ProductRecommend productRecommend = ServletUtil.jsonConvertToEntity(request, ProductRecommend.class);
        if (productRecommendService.updateProductRecommend(productRecommend, productChName)) {
            return "1";
        }
        return "-1";
    }


    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String findProductRecommendById(HttpServletRequest request) {
        String id = request.getParameter("productId");
        return JSONObject.toJSONString(productRecommendService.getProductRecommendById(Integer.valueOf(id)));
    }


    /**
     * @param request
     * @return
     */
    public String associateProductRecommend(HttpServletRequest request) {
        String idStr = request.getParameter("id");
        String[] productIdBS = request.getParameterValues("productIdB");
        Integer id = DataUtil.stringConvertToInteger(idStr);
        if (middleProductService.addMiddleProduct(id, productIdBS)) {
            return "1";
        }
        return "-1";
    }


    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String findProductWithoutId(HttpServletRequest request) {
        String idStr = request.getParameter("id");
        Integer id = DataUtil.stringConvertToInteger(idStr);
        return JSONObject.toJSONString(middleProductService.getProductWithoutId(id));
    }


}
