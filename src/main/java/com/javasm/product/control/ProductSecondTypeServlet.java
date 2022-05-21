package com.javasm.product.control; /**
 * <h4>Financial_manage_sys</h4>
 * <p>${description}</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-21 00:18
 * @Version : 1.0
 **/

import com.alibaba.fastjson.JSONObject;
import com.javasm.annotation.ResponseTypeAnnotation;
import com.javasm.controlUtil.BaseServlet;
import com.javasm.myEnum.ResponseEnum;
import com.javasm.product.bean.Value;
import com.javasm.product.service.ProductSecondTypeService;
import com.javasm.product.service.impl.ProductSecondTypeServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProductSecondTypeServlet")
public class ProductSecondTypeServlet extends BaseServlet<Value> {
    private final ProductSecondTypeService productSecondTypeService = new ProductSecondTypeServiceImpl();


    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String showAllProductSecondTypes() {
        List<Value> allSecondType = productSecondTypeService.getAllSecondType();
        return JSONObject.toJSONString(allSecondType);
    }
}
