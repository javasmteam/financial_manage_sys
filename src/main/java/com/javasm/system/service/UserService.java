package com.javasm.system.service;

import com.javasm.system.bean.UserInfo;
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
}
