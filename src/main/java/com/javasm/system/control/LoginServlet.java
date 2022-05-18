package com.javasm.system.control;

import com.alibaba.fastjson.JSON;
import com.javasm.annotation.ResponseTypeAnnotation;
import com.javasm.controlUtil.BaseServlet;
import com.javasm.myEnum.ResponseEnum;
import com.javasm.system.bean.SimpleJSON;
import com.javasm.system.bean.UserInfo;
import com.javasm.system.bean.vo.LoginUser;
import com.javasm.system.bean.vo.RegUser;
import com.javasm.system.bean.vo.RoleMenu;
import com.javasm.system.bean.vo.UserRoleVo;
import com.javasm.system.service.LoginService;
import com.javasm.system.service.implement.LoginServiceImpl;
import com.javasm.util.BaseUtil;
import com.javasm.util.DataUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author: 云勇
 * @date: 2022/5/16 19:10
 * @description:
 */
@WebServlet("/login")
public class LoginServlet extends BaseServlet<UserInfo> {
    private LoginService loginService = new LoginServiceImpl();

    /**
     * 请求登录
     *
     * @param req  请求对象
     * @param resp 响应对象
     * @return "-1":登录失败   "1":登录成功
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqLogin(HttpServletRequest req, HttpServletResponse resp) {
        //获取请求登录数据
        LoginUser loginUser = BaseUtil.readBean(req, LoginUser.class);
        //查询对象用户
        UserInfo login = loginService.login(loginUser);
        //判断是否登录成功
        if (login == null) {
            return "-1";
        }
        //将登录用户保存到session域对象
        req.getSession().setAttribute("login", login);
        //是否记住密码
        if (loginUser.getIsMemory()) {
            //添加cookie
            Cookie cookie = new Cookie("saveUser", loginUser.getUserAct() + ":" + loginUser.getUserPwd());
            resp.addCookie(cookie);
        }
        //登录成功
        return "1";
    }

    /**
     * 请求注册
     *
     * @param req 请求对象
     * @return "-1":登录失败   "1":登录成功
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqReg(HttpServletRequest req) {
        RegUser regUser = BaseUtil.readBean(req, RegUser.class);
        return loginService.reg(regUser);
    }

    /**
     * 请求角色
     * @param req
     * @return
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqUserRole(HttpServletRequest req) {
        SimpleJSON s = BaseUtil.readBean(req, SimpleJSON.class);
        UserInfo login = (UserInfo) req.getSession().getAttribute("login");
        //是否切换用户当前角色
        if (s != null && !"0".equals(s.getValue())) {
            Integer integer = DataUtil.stringConvertToInteger(s.getValue());
            login.setRoleId(integer);
        }
        UserRoleVo userRoleVo = loginService.getUserRoleVo(login);
        //判断是否查询到角色信息
        if (userRoleVo == null) {
            return "-1";
        }
        return JSON.toJSONString(userRoleVo);
    }

    public String reqRoleMenu(HttpServletRequest req){
        SimpleJSON simpleJSON = BaseUtil.readBean(req, SimpleJSON.class);
        UserInfo userInfo = (UserInfo)req.getSession().getAttribute("login");
        List<RoleMenu> roleMenus = loginService.getRoleMenu(userInfo.getUserId());
        if(roleMenus==null){
            return "-1";
        }
        return JSON.toJSONString(roleMenus);
    }
}
