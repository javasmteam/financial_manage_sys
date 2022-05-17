package com.javasm.system.service;

import com.javasm.system.bean.UserInfo;
import com.javasm.system.bean.vo.LoginUser;
import com.javasm.system.bean.vo.RegUser;
import com.javasm.system.bean.vo.RoleMenu;
import com.javasm.system.bean.vo.UserRoleVo;

import java.util.List;

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
     * 获取用户角色形象
     * @param login 用户对象
     * @return  UserRoleVo 用户角色信息
     */
    UserRoleVo getUserRoleVo(UserInfo login);

    /**
     * 获取用户当前角色菜单
     * @param userId
     * @return
     */
    List<RoleMenu> getRoleMenu(Integer userId);
}
