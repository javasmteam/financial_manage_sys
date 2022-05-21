package com.javasm.system.service;

import com.javasm.system.bean.PageInfo;
import com.javasm.system.bean.UserRole;
import com.javasm.system.bean.vo.PageSelectRole;
import com.javasm.system.bean.vo.SetRolePermissions;
import com.javasm.system.bean.vo.TreeNode;
import com.javasm.system.bean.vo.UserInfoSimple;

import java.util.List;

/**
 * @author: 云勇
 * @date: 2022/5/20 14:31
 * @description:
 */
public interface RoleService {
    /**
     * 递归查询全部的权限
     * @return
     */
    List<TreeNode> queryAllPermissions();

    /**
     * 分页查询角色
     * @param pageSelect
     * @return
     */
    PageInfo<UserRole> pageSelectRole(PageSelectRole pageSelect);

    /**
     * 删除指定id角色
     * @param id
     * @return
     */
    Integer delRole(String id);

    /**
     * 更新角色信息
     * @param userRole
     * @return
     */
    Integer updateRole(UserRole userRole);

    /**
     * 查找角色拥有的权限
     * @param id
     * @return
     */
    List<Integer> findRolePermissions(String id);



    /**
     * 添加角色
     * @param userRole
     * @return
     */
    Integer addUserRole(UserRole userRole);

    /**
     * 查询拥有此角色的用户信息
     * @param id
     * @return
     */
    List<UserInfoSimple> queryUserInfoSimpleByRoleId(String id);

    /**
     * 修改用户角色信息
     * @param setRolePermissions
     * @return
     */
    Integer setRolePermissions(SetRolePermissions setRolePermissions);
}
