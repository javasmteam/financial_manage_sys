package com.javasm.system.dao;

import com.javasm.system.bean.UserRole;
import com.javasm.system.bean.vo.PageSelectRole;
import com.javasm.system.bean.vo.TreeNode;
import com.javasm.system.bean.vo.UserInfoSimple;
import com.javasm.system.bean.vo.UserRoleVo;

import java.sql.Connection;
import java.util.List;

/**
 * @author: 云勇
 * @date: 2022/5/16 20:08
 * @description:
 */
public interface UserRoleDao {
    /**
     * 获取用户全部角色
     * @param userId 用户id
     * @return  用户全部角色集合
     */
    List<UserRole> queryUserAllRole(Integer userId);

    /**
     * 获取指定id的角色
     * @param roleId
     * @return
     */
    UserRole get(Integer roleId);

    /**
     * 获取用户全部集合的vo类
     * @param userId
     * @return
     */
    UserRoleVo getUserRoleVo(Integer userId);

    /**
     * 获取子级权限
     * @param i
     * @return
     */
    List<TreeNode> queryChildPermissions(Integer i);

    /**
     * 查询符合条件的数据数量
     * @param pageSelect
     * @return
     */
    Integer selectSize(PageSelectRole pageSelect);

    /**
     * 分页查询角色
     * @param pageSelect
     * @return
     */
    List<UserRole> queryPageSelect(PageSelectRole pageSelect);

    /**
     * 删除指定角色
     * @param id
     * @return
     */
    Integer delUserRole(Integer id);

    /**
     * 更新角色信息
     * @param userRole
     * @return
     */
    Integer updateRole(UserRole userRole);

    /**
     * 查找角色
     * @param roleId
     * @return
     */
    List<Integer> findRolePermissions(Integer roleId);

    Integer delRolePermissions(Connection conn, Integer roleId);

    Integer addRolepermission(Connection conn, Integer roleId, Integer rolePermission);

    Integer addUserRole(UserRole userRole);

    List<UserInfoSimple> queryUserInfoSimpleByRoleId(Integer roleId);
}
