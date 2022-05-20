package com.javasm.system.control;

import com.alibaba.fastjson.JSON;
import com.javasm.annotation.ResponseTypeAnnotation;
import com.javasm.controlUtil.BaseServlet;
import com.javasm.myEnum.ResponseEnum;
import com.javasm.system.bean.PageInfo;
import com.javasm.system.bean.UserInfo;
import com.javasm.system.bean.vo.PageSelectUser;
import com.javasm.system.bean.vo.SetUserInfo;
import com.javasm.system.bean.vo.UserInfoVo;
import com.javasm.system.service.UserService;
import com.javasm.system.service.implement.UserServiceImpl;
import com.javasm.util.BaseUtil;
import com.javasm.util.DataUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: 云勇
 * @date: 2022/5/19 14:55
 * @description:
 */
@WebServlet("/userManage")
public class UserManageSeevlet extends BaseServlet<UserInfo> {
    private UserService userService = new UserServiceImpl();

    /**
     * 请求用户可设置信息
     *
     * @param req
     * @return
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqSetUserInfo(HttpServletRequest req) {
        String userIdStr = req.getParameter("userId");
        if (userIdStr == null) {
            return "-1";
        }
        Integer userId = DataUtil.stringConvertToInteger(userIdStr);
        SetUserInfo setUserInfo = userService.getSetUserInfo(userId);
        if (setUserInfo == null) {
            return "-1";
        }
        return JSON.toJSONString(setUserInfo);
    }

    /**
     * 请求修改用户信息
     *
     * @param req
     * @return 1:成功 -1:失败
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqSetUser(HttpServletRequest req) {
        SetUserInfo setUserInfo = BaseUtil.readBean(req, SetUserInfo.class);
        Integer integer = userService.updateUserInfo(setUserInfo);
        if (integer > 0) {
            return "1";
        } else {
            return "-1";
        }
    }

    /**
     * 请求分页查询
     * @param req
     * @return
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqPageSelect(HttpServletRequest req) {
        PageSelectUser pageSelect = BaseUtil.readBean(req, PageSelectUser.class);
        if(pageSelect==null){
            return "-1";
        }
        PageInfo<UserInfoVo> userInfoVoPage = userService.queryPageUser(pageSelect);
        if(userInfoVoPage==null){
            return "-1";
        }
        return JSON.toJSONString(userInfoVoPage);
    }


    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqDelUser(HttpServletRequest req) {
        String userId = req.getParameter("userId");
        if(userId==null||userId.equals("")){
            return "-1";
        }
        Integer integer = DataUtil.stringConvertToInteger(userId);
        Integer i = userService.delUser(userId);
        if(i>0){
            return "1";
        }
        return "-1";
    }
}
