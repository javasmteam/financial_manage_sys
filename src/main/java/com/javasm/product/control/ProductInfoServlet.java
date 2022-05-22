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
import com.javasm.product.bean.*;
import com.javasm.product.bean.vo.ProductInfoVO;
import com.javasm.product.service.ProductAuditService;
import com.javasm.product.service.ProductInfoService;
import com.javasm.product.service.ProductNetValueService;
import com.javasm.product.service.impl.ProductAuditServiceImpl;
import com.javasm.product.service.impl.ProductInfoServiceImpl;
import com.javasm.product.service.impl.ProductNetValueServiceImpl;
import com.javasm.util.DataUtil;
import com.javasm.util.ServletUtil;

import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/ProductInfoServlet.do")
public class ProductInfoServlet extends BaseServlet<ProductInfoVO> {
    private final ProductInfoService productInfoService = new ProductInfoServiceImpl();
    private final ProductNetValueService productNetValueService = new ProductNetValueServiceImpl();
    private final ProductAuditService productAuditService = new ProductAuditServiceImpl();


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
        Integer secId = DataUtil.stringConvertToInteger(secIdStr);
        Integer auditType = DataUtil.stringConvertToInteger(auditTypeStr);
        productInfoVO.setProductChName(productChNameStr);
        productInfoVO.setSecId(secId);
        productInfoVO.setAuditType(auditType);
        PageInfo<ProductInfoVO> page = productInfoService.getProductInfoByPage(nowPage, pageNum, productInfoVO);
        return JSONObject.toJSONString(page);
    }


    public String addProductInfo(HttpServletRequest request) {
        ProductInfo productInfo = ServletUtil.jsonConvertToEntity(request, ProductInfo.class);
        String auditor = request.getParameter("auditor");
        if (productInfoService.addProductInfo(productInfo)) {
            Integer count = productInfoService.count();
            ProductAudit productAudit = new ProductAudit();
            ProductNetValue productNetValue = new ProductNetValue();
            productAudit.setProductId(count);
            productAudit.setAuditor(auditor);
            productNetValue.setProductId(count);
            if (productAuditService.addProductAudit(productAudit) && productNetValueService.addProductNetValue(productNetValue)) {
                return "1";
            }
        }
        return "-1";
    }

    public String updateProductInfo(HttpServletRequest request) {
        ProductInfoVO productInfoVO = ServletUtil.jsonConvertToEntity(request, ProductInfoVO.class);
        if (productInfoService.updateProductInfo(productInfoVO)) {
            if (productAuditService.updateProductAudit(productInfoVO)) {
                return "1";
            }
        }
        return "-1";
    }


    public String deleteProductInfoTypeById(HttpServletRequest request) {
        String idStr = request.getParameter("id");
        Integer id = DataUtil.stringConvertToInteger(idStr);
        if (productInfoService.deleteProductInfo(id)) {
            return "1";
        }
        return "-1";
    }


}
