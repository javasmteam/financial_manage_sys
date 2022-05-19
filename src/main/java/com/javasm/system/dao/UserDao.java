package com.javasm.system.dao;

import com.javasm.system.bean.UserInfo;
import com.javasm.system.bean.vo.PageSelect;
import com.javasm.system.bean.vo.SetUserInfo;
import com.javasm.system.bean.vo.UserInfoVo;
import com.javasm.system.bean.vo.UserRoleMiddle;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

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

    /**
     * 添加用户 -- 事务
     * @param conn
     * @param userInfo
     * @return
     */
    public Integer add(Connection conn, UserInfo userInfo);

    /**
     * 添加用户角色
     * @param conn
     * @param ur
     * @return
     */
    public Integer addUserRole(Connection conn, UserRoleMiddle ur);

    /**
     * 添加用户角色
     * @param ur
     * @return
     */
    public Integer addUserRole(UserRoleMiddle ur);

    /**
     * 获取UserInfoVo对象
     * @param userId
     * @return
     */
    UserInfoVo getUserInfoVo(Integer userId);

    /**
     * 获取SetUserInfo对象
     * @param userId
     * @return
     */
    SetUserInfo getSetUserInfoVo(Integer userId);

    /**
     * 更新用户信息
     * @param setUserInfo
     * @return
     */
    Integer updateUserInfo(SetUserInfo setUserInfo);

    /**
     * 获取UserInfo对象
     * @param userId
     * @return
     */
    UserInfo getUserInfo(Integer userId);

    /**
     * 获取用户数量
     * @return
     */
    Integer getSize();

    /**
     * 分页条件查询用户
     * @param pageSelect
     * @return
     */
    List<UserInfoVo> queryPageUserInfoVo(PageSelect pageSelect);

    /**
     * 删除用户id
     * @param userId
     * @return
     */
    Integer delUser(String userId);

    /**
     * 条件的查询数据数量
     * @param pageSelect
     * @return
     */
    Integer selectSize(PageSelect pageSelect);
}
