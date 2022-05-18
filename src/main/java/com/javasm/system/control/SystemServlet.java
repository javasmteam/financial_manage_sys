package com.javasm.system.control;

import com.javasm.annotation.ResponseTypeAnnotation;
import com.javasm.myEnum.ResponseEnum;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: 云勇
 * @date: 2022/5/18 15:38
 * @description:
 */
@WebServlet("/system")
public class SystemServlet {
    /**
     * 请求用户显示信息
     * @param req
     * @return
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqUserInfoVo(HttpServletRequest req){
        return null;
    }

    /**
     * 请求设置用户当前数据
     * @param req
     * @return
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqSetUserInfo(HttpServletRequest req){
        return null;
    }

    /**
     * 请求设置用户数据
     * @param req
     * @return
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqSetUser(HttpServletRequest req){
        return null;
    }
}
