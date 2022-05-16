package com.javasm.system.control;

import com.javasm.annotation.ResponseTypeAnnotation;
import com.javasm.controlUtil.BaseServlet;
import com.javasm.myEnum.ResponseEnum;
import com.javasm.system.bean.UserInfo;
import com.javasm.system.bean.vo.LoginUser;
import com.javasm.system.bean.vo.RegUser;
import com.javasm.system.service.LoginService;
import com.javasm.system.service.implement.LoginServiceImpl;
import com.javasm.util.BaseUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: 云勇
 * @date: 2022/5/16 19:10
 * @description:
 */
public class LoginServlet extends BaseServlet<UserInfo> {
    private LoginService loginService = new LoginServiceImpl();

    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqLogin(HttpServletRequest req, HttpServletResponse resp){
        //获取请求登录数据
        LoginUser loginUser = BaseUtil.readBean(req, LoginUser.class);
        //查询对象用户
        UserInfo login = loginService.login(loginUser);
        //判断是否登录成功
        if(login==null){
            return "-1";
        }
        //将登录用户保存到session域对象
        req.getSession().setAttribute("login",login);
        //是否记住密码
        if(loginUser.getIsSavePwd()){
            //添加cookie
            Cookie cookie = new Cookie("saveUser",loginUser.getUserAct()+"="+loginUser.getUserPwd());
            resp.addCookie(cookie);
        }
        //登录成功
        return "1";
    }

    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqReg(HttpServletRequest req){
        RegUser regUser = BaseUtil.readBean(req, RegUser.class);
        return loginService.reg(regUser);
    }
}
