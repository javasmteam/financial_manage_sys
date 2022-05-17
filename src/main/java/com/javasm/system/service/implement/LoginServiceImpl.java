package com.javasm.system.service.implement;

import cn.hutool.core.codec.Base64;
import com.javasm.system.bean.UserInfo;
import com.javasm.system.bean.vo.LoginUser;
import com.javasm.system.bean.vo.RegUser;
import com.javasm.system.bean.vo.RoleMenu;
import com.javasm.system.bean.vo.UserRoleVo;
import com.javasm.system.dao.UserDao;
import com.javasm.system.dao.UserPermissionDao;
import com.javasm.system.dao.UserRoleDao;
import com.javasm.system.dao.implement.UserDaoImpl;
import com.javasm.system.dao.implement.UserPermissionDaoImpl;
import com.javasm.system.dao.implement.UserRoleDaoImpl;
import com.javasm.system.service.LoginService;

import java.util.Date;

/**
 * @author: 云勇
 * @date: 2022/5/16 19:44
 * @description:
 */
public class LoginServiceImpl implements LoginService {
    private UserDao userDao = new UserDaoImpl();
    private UserRoleDao userRoleDao = new UserRoleDaoImpl();
    private UserPermissionDao userPermissionDao = new UserPermissionDaoImpl();


    @Override
    public UserInfo login(LoginUser loginUser) {
        UserInfo userInfo = userDao.find(loginUser.getUserAct(), Base64.encode(loginUser.getUserPwd()));
        if(userInfo== null){
            return userInfo;
        }
        userInfo.setLastLogin(new Date());
        userDao.updateLastLogin(userInfo.getUserId(),userInfo.getLastLogin());
        return userInfo;
    }

    @Override
    public String reg(RegUser regUser) {
        UserInfo userInfo = new UserInfo(regUser);
        Integer i = userDao.add(userInfo);
        if(i>0){
            return "1";
        }
        return "-1";
    }

    @Override
    public String signOut() {
        return null;
    }

    @Override
    public UserRoleVo chooseRole(String RoleId) {
        return null;
    }

    @Override
    public RoleMenu chooseMenu(String permissionId) {
        return null;
    }
}
