package com.javasm.system.dao.implement;

import com.javasm.system.bean.UserPermission;
import com.javasm.system.bean.vo.FirstMenu;
import com.javasm.system.bean.vo.PageSelectPermission;
import com.javasm.system.bean.vo.PermissionInfo;
import com.javasm.system.dao.UserPermissionDao;
import com.javasm.util.JDBCUtils;

import java.util.ArrayList;
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
        return JDBCUtils.query(sql, UserPermission.class);
    }

    @Override
    public List<UserPermission> getSecondaryMenu(Integer userId, int permissionId) {
        String sql = JDBCUtils.getSql("QUERY_USER_SECONDARY_MENU");
        return JDBCUtils.query(sql, UserPermission.class, userId, permissionId);
    }

    @Override
    public Integer getSize(PageSelectPermission pageSelect) {
        ArrayList<Object> objects = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select count(permission_id)\n" +
                "from user_permission\n" +
                "where permission_state > 0 and permission_id > 0 ");
        if (pageSelect.getPermissionId() != null && pageSelect.getPermissionId().equals("")) {
            sql.append(" and permission_id = ? ");
            Integer id = Integer.valueOf(pageSelect.getPermissionId());
            objects.add(id);
        }
        if(pageSelect.getPermissionName()!=null&&pageSelect.getPermissionName().equals("")){
            sql.append(" and permission_name = ? ");
            objects.add(pageSelect.getPermissionName());
        }
        Object[] objects1 = objects.toArray();
        return JDBCUtils.size(sql.toString(),objects1);
    }

    @Override
    public List<PermissionInfo> queryPagePermission(PageSelectPermission pageSelect) {
        ArrayList<Object> objects = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select u1.*,u2.permission_name parent_name\n" +
                "from user_permission u1 ,user_permission u2\n" +
                "WHERE u1.parent_id = u2.permission_id and u1.permission_state > 0 and u1.permission_id > 0 ");
        if (pageSelect.getPermissionId() != null && pageSelect.getPermissionId().equals("")) {
            sql.append(" and permission_id = ? ");
            Integer id = Integer.valueOf(pageSelect.getPermissionId());
            objects.add(id);
        }
        if(pageSelect.getPermissionName()!=null&&pageSelect.getPermissionName().equals("")){
            sql.append(" and permission_name = ? ");
            objects.add(pageSelect.getPermissionName());
        }
        sql.append(" limit ?,?;");
        Integer index = (pageSelect.getNowPage() - 1) * pageSelect.getPageCount();
        objects.add(index);
        objects.add(pageSelect.getPageCount());
        Object[] objects1 = objects.toArray();
        return JDBCUtils.query(sql.toString(),PermissionInfo.class,objects1);
    }

    @Override
    public List<FirstMenu> queryFirstMenu() {
        String sql = JDBCUtils.getSql("QUERY_FIRST_MENU");
        return JDBCUtils.query(sql,FirstMenu.class);
    }

    @Override
    public Integer findChildMenu(Integer permissionId) {
        String sql = JDBCUtils.getSql("QUERY_CHILD_MENU_NUM");
        return JDBCUtils.size(sql,permissionId);
    }

    @Override
    public Integer updatePermissionState(Integer permissionId) {
        String sql = JDBCUtils.getSql("DEL_USER_PERMISSION");
        return JDBCUtils.update(sql,permissionId);
    }

    @Override
    public Integer addPermissionInfo(UserPermission userPermission) {
        return JDBCUtils.insert("user_permission",userPermission);
    }

    @Override
    public Integer updatePermissionInfo(PermissionInfo permissionInfo) {
        String sql = JDBCUtils.getSql("UPDATE_USER_PERMISSION");
        return JDBCUtils.update(sql,permissionInfo.getPermissionImage(),
                permissionInfo.getPermissionName(),permissionInfo.getParentId(),permissionInfo.getPermissionPath(),
                permissionInfo.getPermissionId());
    }

    @Override
    public PermissionInfo getPermissionInfo(Integer id) {
        String sql = JDBCUtils.getSql("GET_PERMISSION_INFO");
        return JDBCUtils.find(sql,PermissionInfo.class,id);
    }
}
