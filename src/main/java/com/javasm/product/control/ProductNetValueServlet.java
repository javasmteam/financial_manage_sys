package com.javasm.product.control; /**
 * <h4>Financial_manage_sys</h4>
 * <p>${description}</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-19 02:59
 * @Version : 1.0
 **/

import com.javasm.controlUtil.BaseServlet;
import com.javasm.product.bean.ProductNetValue;
import com.javasm.product.bean.RemitInfo;
import com.javasm.product.service.ProductNetValueService;
import com.javasm.product.service.impl.ProductNetValueServiceImpl;
import com.javasm.util.ServletUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/ProductNetValueServlet")
public class ProductNetValueServlet extends BaseServlet<ProductNetValue> {
    private final ProductNetValueService productNetValueService = new ProductNetValueServiceImpl();

    public String updateProductNetValueById(HttpServletRequest request) {
        ProductNetValue productNetValue = ServletUtil.jsonConvertToEntity(request, ProductNetValue.class);
        if (productNetValueService.updateProductNetValue(productNetValue)) {
            return "1";
        }
        return "-1";
    }

}
