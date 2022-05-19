package com.javasm.system.service;

import com.javasm.system.bean.PageInfo;
import com.javasm.system.bean.UserInfo;
import com.javasm.system.bean.vo.PageSelect;
import com.javasm.system.bean.vo.SetUserInfo;
import com.javasm.system.bean.vo.UserInfoVo;

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
    PageInfo<UserInfoVo> queryPageUser(PageSelect pageSelect);

    /**
     * 删除用户
     * @param userId
     * @return
     */
    Integer delUser(String userId);
}
