package com.javasm.system.dao;

import com.javasm.system.bean.UserRole;

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
}
