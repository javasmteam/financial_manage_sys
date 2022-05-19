package com.javasm.system.dao.implement;

import com.javasm.system.bean.UserRole;
import com.javasm.system.bean.vo.UserRoleVo;
import com.javasm.system.dao.UserRoleDao;
import com.javasm.util.JDBCUtils;

import java.util.List;

/**
 * @author: 云勇
 * @date: 2022/5/16 20:09
 * @description:
 */
public class UserRoleDaoImpl implements UserRoleDao {
    @Override
    public List<UserRole> queryUserAllRole(Integer userId) {
        String sql = JDBCUtils.getSql("QUERY_USER_ALL_ROLE");
        return JDBCUtils.query(sql,UserRole.class,userId);
    }

    @Override
    public UserRole get(Integer roleId) {
        String sql = JDBCUtils.getSql("GET_USER_ROLE");
        return JDBCUtils.find(sql,UserRole.class,roleId);
    }

    @Override
    public UserRoleVo getUserRoleVo(Integer userId) {
        //将用户的全部角色和用户当前角色封装为一个UserRoleVo对象,并保存到setUserInfo中
        List<UserRole> userRoles = queryUserAllRole(userId);
        UserRole userRole = get(userId);
        UserRoleVo userRoleVo = new UserRoleVo(userRole);
        userRoleVo.setUserRoles(userRoles);
        return userRoleVo;
    }
}
