package com.javasm.system.control;

import com.javasm.annotation.ResponseTypeAnnotation;
import com.javasm.myEnum.ResponseEnum;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: 云勇
 * @date: 2022/5/20 14:22
 * @description:
 */

@WebServlet("/menuManage")
public class MenuManageServlet {
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqSetMenuInfo(HttpServletRequest req) {
        req.getParameter()
    }
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqSetMenu(HttpServletRequest req) {

    }
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqAddMenu(HttpServletRequest req) {

    }
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqDelMenu(HttpServletRequest req) {

    }
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqParentMenu(HttpServletRequest req) {

    }


}
