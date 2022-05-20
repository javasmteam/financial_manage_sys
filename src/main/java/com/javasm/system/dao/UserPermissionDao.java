package com.javasm.system.dao;

import com.javasm.system.bean.UserPermission;
import com.javasm.system.bean.vo.FirstMenu;
import com.javasm.system.bean.vo.PageSelectPermission;
import com.javasm.system.bean.vo.PermissionInfo;

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

    /**
     * 获取符合条件查询的数据数量
     * @param pageSelect
     * @return
     */
    Integer getSize(PageSelectPermission pageSelect);

    /**
     * 分页查询数据
     * @param pageSelect
     * @return
     */
    List<PermissionInfo> queryPagePermission(PageSelectPermission pageSelect);

    /**
     * 获取一级菜单
     * @return
     */
    List<FirstMenu> queryFirstMenu();

    /**
     * 查找子级菜单数量
     * @param permissionId
     * @return
     */
    Integer findChildMenu(Integer permissionId);

    /**
     * 更新权限状态 -- 删除
     * @param permissionId
     * @return
     */
    Integer updatePermissionState(Integer permissionId);

    /**
     * 添加权限
     * @param userPermission
     * @return
     */
    Integer addPermissionInfo(UserPermission userPermission);

    /**
     * 更新权限信息
     * @param permissionInfo
     * @return
     */
    Integer updatePermissionInfo(PermissionInfo permissionInfo);

    /**
     * 获取单个权限对象
     * @param id
     * @return
     */
    PermissionInfo getPermissionInfo(Integer id);
}
