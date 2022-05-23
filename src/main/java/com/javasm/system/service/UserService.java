package com.javasm.system.service;

import com.javasm.system.bean.PageInfo;
import com.javasm.system.bean.UserInfo;
import com.javasm.system.bean.vo.*;

import java.util.List;

/**
 * @author: 云勇
 * @date: 2022/5/16 19:42
 * @description:
 */
public interface UserService {
    /**
     * 获取用户vo对象
     * @param userId
     * @return
     */
    UserInfoVo showUserInfo(Integer userId);

    /**
     * 获取设置用户对象
     * @param user
     * @return
     */
    SetUserInfo getSetUserInfo(UserInfo user);

    /**
     * 更新用户数据
     * @param setUserInfo
     * @return
     */
    Integer updateUserInfo(SetUserInfo setUserInfo);

    /**
     * 获取设置用户对象  -- id
     * @param userId
     * @return
     */
    SetUserInfo getSetUserInfo(Integer userId);

    /**
     * 分页查询用户信息
     * @param pageSelect
     * @return
     */
    PageInfo<UserInfoVo> queryPageUser(PageSelectUser pageSelect);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    Integer delUser(String userId);

    /**
     * 查询全部角色
     * @return
     */
    List<TreeNode> queryAllRole();

    /**
     * 查询用户拥有的全部角色
     * @param userId
     * @return
     */
    List<Integer> findUserAllRoleId(Integer userId);

    /**
     * 设置用户的角色
     * @param setUserRole
     * @return
     */
    String setUserRole(SetUserRole setUserRole);

    /**
     * 设置用户密码
     * @param userId
     * @param newPwd
     * @return
     */
    Integer setPwd(Integer userId, String newPwd);
}
