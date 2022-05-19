package com.javasm.system.dao;

import com.javasm.system.bean.UserRole;
import com.javasm.system.bean.vo.UserRoleVo;

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
}
