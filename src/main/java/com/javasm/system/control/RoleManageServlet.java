package com.javasm.system.control;

import com.alibaba.fastjson.JSON;
import com.javasm.annotation.ResponseTypeAnnotation;
import com.javasm.controlUtil.BaseServlet;
import com.javasm.myEnum.ResponseEnum;
import com.javasm.system.bean.PageInfo;
import com.javasm.system.bean.UserInfo;
import com.javasm.system.bean.UserRole;
import com.javasm.system.bean.vo.PageSelectPermission;
import com.javasm.system.bean.vo.PageSelectRole;
import com.javasm.system.service.RoleService;
import com.javasm.system.service.implement.RoleServiceImpl;
import com.javasm.util.BaseUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: 云勇
 * @date: 2022/5/21 14:44
 * @description:
 */
@WebServlet("/roleManage")
public class RoleManageServlet extends BaseServlet<UserInfo> {
    private RoleService roleService = new RoleServiceImpl();

    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqPageSelect(HttpServletRequest req) {
        PageSelectRole pageSelect = BaseUtil.readBean(req, PageSelectRole.class);
        PageInfo<UserRole> pageInfo = roleService.pageSelectRole(pageSelect);
        if(pageInfo==null){
            return "-1";
        }else {
            return JSON.toJSONString(pageInfo);
        }
    }
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqDelRole(HttpServletRequest req) {
        String id = req.getParameter("id");
        Integer result = roleService.delRole(id);
        if(result<1){
            return "-1";
        }else {
            return "1";
        }
    }
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqSetRole(HttpServletRequest req) {
        UserRole userRole = BaseUtil.readBean(req,UserRole.class);
        if(userRole==null){
            return "-1";
        }
        Integer result =  roleService.updateRole(userRole);
        if(result<1){
            return "-1";
        }else {
            return "1";
        }
    }
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqRolePermissions(HttpServletRequest req) {

    }
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqSetRolePermissions(HttpServletRequest req) {
    }
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqAddRoleInfo(HttpServletRequest req) {
    }
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqUserListByRoleId(HttpServletRequest req) {
    }

}
