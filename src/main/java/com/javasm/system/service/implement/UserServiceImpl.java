package com.javasm.system.service.implement;

import com.javasm.system.bean.UserInfo;
import com.javasm.system.bean.UserRole;
import com.javasm.system.bean.vo.SetUserInfo;
import com.javasm.system.bean.vo.UserInfoVo;
import com.javasm.system.bean.vo.UserRoleVo;
import com.javasm.system.dao.UserDao;
import com.javasm.system.dao.UserRoleDao;
import com.javasm.system.dao.implement.UserDaoImpl;
import com.javasm.system.dao.implement.UserRoleDaoImpl;
import com.javasm.system.service.UserService;

import java.util.List;

/**
 * @author: 云勇
 * @date: 2022/5/16 19:43
 * @description:
 */
public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDaoImpl();
    UserRoleDao userRoleDao = new UserRoleDaoImpl();
    @Override
    public UserInfoVo showUserInfo(Integer userId) {
        UserInfoVo userInfo = userDao.getUserInfoVo(userId);
        return userInfo;
    }

    @Override
    public SetUserInfo getSetUserInfo(UserInfo user) {
        //通过当前用户信息构建用户对象
        SetUserInfo setUserInfo = new SetUserInfo(user);
        //将用户的全部角色和用户当前角色封装为一个UserRoleVo对象,并保存到setUserInfo中
        List<UserRole> userRoles = userRoleDao.queryUserAllRole(user.getUserId());
        UserRole userRole = userRoleDao.get(user.getRoleId());
        UserRoleVo userRoleVo = new UserRoleVo(userRole);
        userRoleVo.setUserRoles(userRoles);
        setUserInfo.setRoles(userRoleVo);
        return setUserInfo;
    }
}
