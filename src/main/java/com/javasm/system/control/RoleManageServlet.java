package com.javasm.system.control;

import com.alibaba.fastjson.JSON;
import com.javasm.annotation.ResponseTypeAnnotation;
import com.javasm.controlUtil.BaseServlet;
import com.javasm.myEnum.ResponseEnum;
import com.javasm.system.bean.PageInfo;
import com.javasm.system.bean.UserInfo;
import com.javasm.system.bean.UserRole;
import com.javasm.system.bean.vo.PageSelectRole;
import com.javasm.system.bean.vo.SetRolePermissions;
import com.javasm.system.bean.vo.TreeNode;
import com.javasm.system.bean.vo.UserInfoSimple;
import com.javasm.system.service.RoleService;
import com.javasm.system.service.implement.RoleServiceImpl;
import com.javasm.util.BaseUtil;
import com.javasm.util.DataUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * @author: 云勇
 * @date: 2022/5/21 14:44
 * @description:
 */
@WebServlet("/roleManage")
public class RoleManageServlet extends BaseServlet<UserInfo> {
    private RoleService roleService = new RoleServiceImpl();

    /**
     * 分页查询角色
     * @param req
     * @return
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqPageSelect(HttpServletRequest req) {
        PageSelectRole pageSelect = BaseUtil.readBean(req, PageSelectRole.class);
        PageInfo<UserRole> pageInfo = roleService.pageSelectRole(pageSelect);
        if (pageInfo == null) {
            return "-1";
        } else {
            return JSON.toJSONString(pageInfo);
        }
    }

    /**
     * 删除角色
     * @param req
     * @return
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqDelRole(HttpServletRequest req) {
        String id = req.getParameter("id");
        if (id == null || id.equals("")) {
            return "-1";
        }
        Integer result = roleService.delRole(id);
        if (result < 1) {
            return "-1";
        } else {
            return "1";
        }
    }

    /**
     * 设置角色信息
     * @param req
     * @return
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqSetRole(HttpServletRequest req) {
        UserRole userRole = BaseUtil.readBean(req, UserRole.class);
        if (userRole == null) {
            return "-1";
        }
        Integer result = roleService.updateRole(userRole);
        if (result < 1) {
            return "-1";
        } else {
            return "1";
        }
    }

    /**
     * 请求角色拥有的权限
     * @param req
     * @return
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqRolePermissions(HttpServletRequest req) {
        String id = req.getParameter("id");
        Integer roleId = DataUtil.stringConvertToInteger(id);
        if (id == null || id.equals("")) {
            return "-1";
        }
        List<Integer> list = roleService.findRolePermissions(id);
        if (list == null) {
            return "-1";
        }
        SetRolePermissions setRolePermissions = new SetRolePermissions(roleId,list);
        return JSON.toJSONString(setRolePermissions);

    }

    /**
     * 设置角色权限
     * @param req
     * @return
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqSetRolePermissions(HttpServletRequest req) {
        SetRolePermissions setRolePermissions = BaseUtil.readBean(req, SetRolePermissions.class);
        Integer i = roleService.setRolePermissions(setRolePermissions);
        if (i < 1) {
            return "-1";
        } else {
            return "1";
        }

    }

    /**
     * 添加角色
     * @param req
     * @return
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqAddRoleInfo(HttpServletRequest req) {
        UserRole userRole = BaseUtil.readBean(req, UserRole.class);
        Integer i = roleService.addUserRole(userRole);
        if (i < 1) {
            return "-1";
        } else {
            return "1";
        }

    }

    /**
     * 请求拥有此角色的全部用户
     * @param req
     * @return
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqUserListByRoleId(HttpServletRequest req) {
        String id = req.getParameter("id");
        if (id == null || id.equals("")) {
            return "-1";
        }
        List<UserInfoSimple> list = roleService.queryUserInfoSimpleByRoleId(id);
        if (list == null) {
            return "-1";
        }
        return JSON.toJSONString(list);
    }

    /**
     * 请求全部的权限
     * @param req
     * @return
     */
    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqPermissions(HttpServletRequest req){
        List<TreeNode> list = roleService.queryAllPermissions();
        if(list==null){
            return "-1";
        }
        return JSON.toJSONString(list);
    }
}
