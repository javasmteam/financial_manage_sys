package com.javasm.system.control;

import com.javasm.annotation.ResponseTypeAnnotation;
import com.javasm.controlUtil.BaseServlet;
import com.javasm.myEnum.ResponseEnum;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: 云勇
 * @date: 2022/5/16 19:10
 * @description:
 */
public class LoginServlet extends BaseServlet {
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqLogin(HttpServletRequest req){
        req.
    }
}
