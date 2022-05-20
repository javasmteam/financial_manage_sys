package com.javasm.system.service;

import com.javasm.system.bean.PageInfo;
import com.javasm.system.bean.vo.FirstMenu;
import com.javasm.system.bean.vo.PageSelectPermission;
import com.javasm.system.bean.vo.PermissionInfo;

import java.util.List;

/**
 * @author: 云勇
 * @date: 2022/5/20 14:30
 * @description:
 */
public interface PermissionService {
    /**
     * 分页查询权限信息
     * @param pageSelect
     * @return
     */
    PageInfo<PermissionInfo> pageSelectPermission(PageSelectPermission pageSelect);

    /**
     * 查询一级菜单
     * @return
     */
    List<FirstMenu> queryFirstMenu();

    /**
     * 删除菜单
     * @param permissionInfo
     * @return
     */
    Integer delPermission(PermissionInfo permissionInfo);

    /**
     * 添加菜单
     * @param permissionInfo
     * @return
     */
    Integer addPermissionInfo(PermissionInfo permissionInfo);

    /**
     * 更新权限信息
     * @param permissionInfo
     * @return
     */
    Integer updateUserPermission(PermissionInfo permissionInfo);

    /**
     * 获取权限信息对象
     * @param permissionId
     * @return
     */
    PermissionInfo getPermissionInfo(String permissionId);
}
