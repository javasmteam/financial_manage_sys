package com.javasm.system.dao.implement;

import com.javasm.system.bean.UserRole;
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
}
