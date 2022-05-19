package com.javasm.product.control; /**
 * <h4>Financial_manage_sys</h4>
 * <p>${description}</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-17 17:14
 * @Version : 1.0
 **/


import com.javasm.controlUtil.BaseServlet;
import com.javasm.product.bean.RemitInfo;
import com.javasm.product.service.RemitInfoService;
import com.javasm.product.service.impl.RemitInfoServiceImpl;
import com.javasm.util.ServletUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/remitInfo.do")
public class RemitInfoServlet extends BaseServlet<RemitInfo> {
    private final RemitInfoService remitInfoService = new RemitInfoServiceImpl();

    public void updateProductTypeById(RemitInfo remitInfo) {
        remitInfoService.updateRemitInfo(remitInfo);
    }

    public String addRemitInfo(HttpServletRequest request) {
        RemitInfo remitInfo = ServletUtil.jsonConvertToEntity(request, RemitInfo.class);
        if (remitInfoService.addRemitInfo(remitInfo)) {
            return "1";
        }
        return "-1";
    }


}
