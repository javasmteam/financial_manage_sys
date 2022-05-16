package com.javasm.system.service;

import com.javasm.system.bean.UserInfo;
import com.javasm.system.bean.vo.LoginUser;
import com.javasm.system.bean.vo.RegUser;
import com.javasm.system.bean.vo.RoleMenu;
import com.javasm.system.bean.vo.UserRoleVo;

/**
 * @author: 云勇
 * @date: 2022/5/16 19:44
 * @description:
 */
public interface LoginService {
    /**
     * 登录服务
     * @param loginUser 登录数据
     * @return  是否登录成功 -1:失败 1:成功
     */
    UserInfo login(LoginUser loginUser);

    /**
     * 注册服务
     * @param regUser   注册数据
     * @return  是否注册成功 -1:失败 1:成功
     */
    String reg(RegUser regUser);

    /**
     * 退出登录
     * @return -1:失败 1:成功
     */
    String signOut();

    /**
     * 选择角色
     * @param RoleId 选择角色id
     * @return 角色合集
     */
    UserRoleVo chooseRole(String RoleId);

    /**
     * 选择菜单
     * @param permissionId 菜单id
     * @return 菜单合集
     */
    RoleMenu chooseMenu(String permissionId);
}
