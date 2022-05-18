package com.javasm.system.dao;

import com.javasm.system.bean.UserPermission;

import java.util.List;

/**
 * @author: 云勇
 * @date: 2022/5/16 20:07
 * @description:
 */
public interface UserPermissionDao {
    /**
     * 获取全部的一级权限
     * @return
     */
    List<UserPermission> getAllHeadMenu();

    /**
     * 获取用户的次级权限
     * @param roleId    用户当前角色id
     * @param permissionId  父级id
     * @return
     */
    List<UserPermission> getSecondaryMenu(Integer roleId, int permissionId);
}
