package com.javasm.system.dao;

import com.javasm.system.bean.UserInfo;

import java.util.Date;

/**
 * @author: 云勇
 * @date: 2022/5/16 20:06
 * @description:
 */
public interface UserDao {
    /**
     * 根据用户密码查找用户
     * @param userAct   用户账号
     * @param userPwd   用户密码
     * @return  用户对象
     */
    UserInfo find(String userAct, String userPwd);

    /**
     * 更新用户最后登录时间
     * @param userId
     * @return
     */
    Integer updateLastLogin(Integer userId, Date lastLogin);

    /**
     * 添加用户
     * @param userInfo
     * @return
     */
    Integer add(UserInfo userInfo);
}
