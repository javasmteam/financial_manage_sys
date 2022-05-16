package com.javasm.system.dao;

import com.javasm.system.bean.UserInfo;

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
}
