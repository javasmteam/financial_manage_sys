package com.javasm.system.service.implement;

import com.javasm.system.bean.PageInfo;
import com.javasm.system.bean.UserInfo;
import com.javasm.system.bean.UserRole;
import com.javasm.system.bean.vo.PageSelect;
import com.javasm.system.bean.vo.SetUserInfo;
import com.javasm.system.bean.vo.UserInfoVo;
import com.javasm.system.bean.vo.UserRoleVo;
import com.javasm.system.dao.UserDao;
import com.javasm.system.dao.UserRoleDao;
import com.javasm.system.dao.implement.UserDaoImpl;
import com.javasm.system.dao.implement.UserRoleDaoImpl;
import com.javasm.system.service.UserService;
import com.javasm.util.JDBCUtils;

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
        UserRoleVo userRoleVo = userRoleDao.getUserRoleVo(user.getUserId());
        setUserInfo.setRoles(userRoleVo);
        return setUserInfo;
    }

    @Override
    public Integer updateUserInfo(SetUserInfo setUserInfo) {
        return userDao.updateUserInfo(setUserInfo);
    }

    @Override
    public SetUserInfo getSetUserInfo(Integer userId) {
        SetUserInfo setUserInfo = userDao.getSetUserInfoVo(userId);
        if (setUserInfo == null) {
            return null;
        }
        UserRoleVo userRoleVo = userRoleDao.getUserRoleVo(userId);
        setUserInfo.setRoles(userRoleVo);
        return setUserInfo;

    }

    @Override
    public PageInfo<UserInfoVo> queryPageUser(PageSelect pageSelect) {
        List<UserInfoVo> list = userDao.queryPageUserInfoVo(pageSelect);
        if (list == null || list.size() == 0){
            return null;
        }
        PageInfo<UserInfoVo> pageInfo = new PageInfo<>(pageSelect.getNowPage(),pageSelect.getPageCount(),list.size(),list);
        return pageInfo;
    }

    @Override
    public Integer delUser(String userId) {
        return userDao.delUser(userId);
    }
}
