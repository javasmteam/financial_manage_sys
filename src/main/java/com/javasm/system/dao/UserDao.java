package com.javasm.system.dao;

import com.javasm.system.bean.UserInfo;
import com.javasm.system.bean.vo.PageSelectUser;
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
    List<UserInfoVo> queryPageUserInfoVo(PageSelectUser pageSelect);

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
    Integer selectSize(PageSelectUser pageSelect);

    /**
     * 设置用户密码
     * @param userId
     * @param newPwd
     * @return
     */
    Integer setPwd(Integer userId, String newPwd);

    /**
     * 删除用户全部角色
     * @param conn
     * @param userId
     */
    void delUserAllRole(Connection conn, Integer userId);

    /**
     * 保存用户上传的头像
     * @param userId
     * @param uploadPath
     * @return
     */
    Integer saveImage(Integer userId, String uploadPath);
}
