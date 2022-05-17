package com.javasm.system.dao.implement;

import com.javasm.system.bean.UserPermission;
import com.javasm.system.dao.UserPermissionDao;
import com.javasm.util.JDBCUtils;

import java.util.List;

/**
 * @author: 云勇
 * @date: 2022/5/16 20:08
 * @description:
 */
public class UserPermissionDaoImpl implements UserPermissionDao {
    @Override
    public List<UserPermission> getAllHeadMenu() {
        String sql = JDBCUtils.getSql("QUERY_ALL_HEAd_MENU");
        return JDBCUtils.query(sql,UserPermission.class);
    }

    @Override
    public List<UserPermission> getSecondaryMenu(Integer userId, int permissionId) {
        String sql = JDBCUtils.getSql("QUERY_USER_SECONDARY_MENU");
        return JDBCUtils.query(sql,UserPermission.class,userId,permissionId);
    }
}
