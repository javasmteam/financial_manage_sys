package com.javasm.system.control;

import com.alibaba.fastjson.JSON;
import com.javasm.annotation.ResponseTypeAnnotation;
import com.javasm.myEnum.ResponseEnum;
import com.javasm.system.bean.PageInfo;
import com.javasm.system.bean.vo.FirstMenu;
import com.javasm.system.bean.vo.PageSelectPermission;
import com.javasm.system.bean.vo.PermissionInfo;
import com.javasm.system.service.PermissionService;
import com.javasm.system.service.implement.PermissionServiceImpl;
import com.javasm.util.BaseUtil;
import com.javasm.util.DataUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.security.Permission;
import java.util.List;

/**
 * @author: 云勇
 * @date: 2022/5/20 14:22
 * @description:
 */

@WebServlet("/menuManage")
public class MenuManageServlet {
    private PermissionService permissionService = new PermissionServiceImpl();

    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqSetMenuInfo(HttpServletRequest req) {
        String permissionId = req.getParameter("permissionId");
        Integer id = DataUtil.stringConvertToInteger(permissionId);
        PermissionInfo permissionInfo = permissionService.getPermissionInfo(permissionId);
        if (permissionInfo == null) {
            return "-1";
        } else {
            return JSON.toJSONString(permissionInfo);
        }
    }

    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqSetMenu(HttpServletRequest req) {
        PermissionInfo permissionInfo = BaseUtil.readBean(req, PermissionInfo.class);
        Integer i = permissionService.updateUserPermission(permissionInfo);
        if (i > 0) {
            return "1";
        } else {
            return "-1";
        }
    }

    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqAddMenu(HttpServletRequest req) {
        PermissionInfo permissionInfo = BaseUtil.readBean(req, PermissionInfo.class);
        Integer i = permissionService.addPermissionInfo(permissionInfo);
        if (i > 0) {
            return "1";
        } else {
            return "-1";
        }
    }

    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqDelMenu(HttpServletRequest req) {
        PermissionInfo permissionInfo = BaseUtil.readBean(req, PermissionInfo.class);
        Integer i = permissionService.delPermission(permissionInfo);
        if (i > 0) {
            return "1";
        } else {
            return "-1";
        }
    }

    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqParentMenu(HttpServletRequest req) {
        List<FirstMenu> firstMenus = permissionService.queryFirstMenu();
        if (firstMenus == null || firstMenus.size() < 1) {
            return "-1";
        }else {
            return JSON.toJSONString(firstMenus);
        }
    }

    @ResponseTypeAnnotation(ResponseEnum.AJAX)
    public String reqPageSelect(HttpServletRequest req) {
        PageSelectPermission pageSelect = BaseUtil.readBean(req, PageSelectPermission.class);
        PageInfo<PermissionInfo> pageInfo = permissionService.pageSelectPermission(pageSelect);
        if(pageInfo==null){
            return "-1";
        }else {
            return JSON.toJSONString(pageInfo);
        }
    }


}
