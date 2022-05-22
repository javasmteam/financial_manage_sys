package com.javasm.product.control; /**
 * <h4>Financial_manage_sys</h4>
 * <p>${description}</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-19 02:58
 * @Version : 1.0
 **/

import com.javasm.controlUtil.BaseServlet;
import com.javasm.product.bean.ProductAudit;
import com.javasm.product.service.ProductAuditService;
import com.javasm.product.service.impl.ProductAuditServiceImpl;
import com.javasm.util.ServletUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ProductAuditServlet.do")
public class ProductAuditServlet extends BaseServlet<ProductAudit> {
    private final ProductAuditService productAuditService = new ProductAuditServiceImpl();

    /**
     * 审核产品
     *
     * @param request
     * @return
     */
    public String productAudit(HttpServletRequest request) {
        ProductAudit productAudit = ServletUtil.jsonConvertToEntity(request, ProductAudit.class);
        if (productAuditService.updateProductAuditInfo(productAudit)) {
            return "1";
        }
        return "-1";
    }
}
