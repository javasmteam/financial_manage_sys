package com.javasm.system.control;

import cn.hutool.core.codec.Base64;
import com.alibaba.fastjson.JSON;
import com.javasm.annotation.ResponseTypeAnnotation;
import com.javasm.controlUtil.BaseServlet;
import com.javasm.myEnum.ResponseEnum;
import com.javasm.system.bean.UserInfo;
import com.javasm.system.bean.vo.SetPwdInfo;
import com.javasm.system.bean.vo.SetUserInfo;
import com.javasm.system.bean.vo.UserInfoVo;
import com.javasm.system.service.UserService;
import com.javasm.system.service.implement.UserServiceImpl;
import com.javasm.util.BaseUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: 云勇
 * @date: 2022/5/18 15:38
 * @description:
 */
@WebServlet("/userInfo")
public class UserInfoServlet extends BaseServlet<UserInfo> {
    UserService userService = new UserServiceImpl();

    /**
     * 请求用户显示信息
     *
     * @param req
     * @return
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqUserInfoVo(HttpServletRequest req) {
        UserInfo login = (UserInfo) req.getSession().getAttribute("login");
        UserInfoVo userInfoVo = userService.showUserInfo(login.getUserId());
        if (userInfoVo == null) {
            return "-1";
        }
        return JSON.toJSONString(userInfoVo);
    }

    /**
     * 请求设置用户当前数据
     *
     * @param req
     * @return
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqSetUserInfo(HttpServletRequest req) {
        UserInfo login = (UserInfo) req.getSession().getAttribute("login");
        SetUserInfo setUserInfo = userService.getSetUserInfo(login);
        if (setUserInfo == null) {
            return "-1";
        }
        return JSON.toJSONString(setUserInfo);
    }

    /**
     * 请求设置用户数据
     *
     * @param req
     * @return
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqSetUser(HttpServletRequest req) {
        SetUserInfo setUserInfo = BaseUtil.readBean(req, SetUserInfo.class);
        Integer integer = userService.updateUserInfo(setUserInfo);
        //判断是否成功,成功
        if (integer > 0) {
            UserInfo u = (UserInfo) req.getSession().getAttribute("login");
            updateLogin(u,setUserInfo);
            UserInfoVo userInfoVo = userService.showUserInfo(u.getUserId());
            return JSON.toJSONString(userInfoVo);
        }else {
            return "-1";
        }

    }

    public String reqSetPwd(HttpServletRequest req) {
        SetPwdInfo setPwdInfo = BaseUtil.readBean(req, SetPwdInfo.class);
        if (setPwdInfo.getNewPwd() == null || setPwdInfo.getOldPwd() == null) {
            return "-1";
        }
        setPwdInfo.setOldPwd(Base64.encode(setPwdInfo.getOldPwd()));
        setPwdInfo.setNewPwd(Base64.encode(setPwdInfo.getNewPwd()));
        UserInfo userInfo = (UserInfo) req.getSession().getAttribute("login");
        if (!userInfo.getUserPwd().equals(setPwdInfo.getOldPwd())){
            return "-1";
        }
        Integer i = userService.setPwd(userInfo.getUserId(),setPwdInfo.getNewPwd());
        if(i>0){
            userInfo.setUserPwd(setPwdInfo.getNewPwd());
            return "1";
        }
        return "-1";
    }

    private void updateLogin(UserInfo u,SetUserInfo setUserInfo){
        u.setUserName(setUserInfo.getUserName());
        u.setDes(setUserInfo.getDes());
        u.setSex(setUserInfo.getSex());
        u.setBirthday(setUserInfo.getBirthday());
        u.setAvatarColor(setUserInfo.getAvatarColor());
        u.setPhone(setUserInfo.getPhone());
        u.setRoleId(setUserInfo.getRoles().getNowRole().getRoleId());
    }
}
