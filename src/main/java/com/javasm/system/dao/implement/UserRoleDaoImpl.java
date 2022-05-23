package com.javasm.system.dao.implement;

import com.javasm.system.bean.UserRole;
import com.javasm.system.bean.vo.PageSelectRole;
import com.javasm.system.bean.vo.TreeNode;
import com.javasm.system.bean.vo.UserInfoSimple;
import com.javasm.system.bean.vo.UserRoleVo;
import com.javasm.system.dao.UserRoleDao;
import com.javasm.util.JDBCUtils;

import java.sql.Connection;
import java.util.ArrayList;
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

    @Override
    public List<TreeNode> queryChildPermissions(Integer i) {
        String sql = JDBCUtils.getSql("QUERY_CHILD_PERMISSIONS");
        return JDBCUtils.query(sql,TreeNode.class,i);
    }

    @Override
    public Integer selectSize(PageSelectRole pageSelect) {
        StringBuilder sql = new StringBuilder("select count(role_id)\n" +
                "from user_role where role_state>0 \n");
        String roleName = pageSelect.getRoleName();
        if(roleName!=null&&!roleName.equals("")){
            sql.append("and role_name = ?;");
            return JDBCUtils.size(sql.toString(),roleName);
        }
        sql.append(";");
        return JDBCUtils.size(sql.toString());
    }

    @Override
    public List<UserRole> queryPageSelect(PageSelectRole pageSelect) {
        StringBuilder sql = new StringBuilder("select user_role.*\n" +
                "from user_role where role_state>0 ");
        String roleName = pageSelect.getRoleName();
        List<Object> param = new ArrayList<>();
        if(roleName!=null&&!roleName.equals("")){
            sql.append(" and role_name = ? ");
            param.add(roleName);
        }
        sql.append(" limit ?,?;");
        Integer index = (pageSelect.getNowPage() - 1) * pageSelect.getPageCount();
        param.add(index);
        param.add(pageSelect.getPageCount());
        return JDBCUtils.query(sql.toString(),UserRole.class,param.toArray());
    }

    @Override
    public Integer delUserRole(Integer id) {
        String sql = JDBCUtils.getSql("DEL_USER_ROLE");
        return JDBCUtils.update(sql,id);
    }

    @Override
    public Integer updateRole(UserRole userRole) {
        String sql = JDBCUtils.getSql("UPDATE_ROLE");
        return JDBCUtils.update(sql,userRole.getRoleName());
    }

    @Override
    public List<Integer> findRolePermissions(Integer roleId) {
        List<Integer> list = new ArrayList<>();
        String sql = JDBCUtils.getSql("FIND_ROLE_PERMISSIONS");
        JDBCUtils.queryList(sql,list,roleId);
        return list;
    }

    @Override
    public Integer delRolePermissions(Connection conn, Integer roleId) {
        String sql = JDBCUtils.getSql("DEL_ALL_ROLE_PERMISSIONS");
        return JDBCUtils.update(conn,sql,roleId);
    }

    @Override
    public Integer addRolePermission(Connection conn, Integer roleId, Integer rolePermission) {
        String sql = JDBCUtils.getSql("ADD_ROLE_PERMISSIONS");
        return JDBCUtils.update(conn,sql,roleId,rolePermission);
    }

    @Override
    public Integer addUserRole(UserRole userRole) {
        return JDBCUtils.insert("user_role",userRole);
    }

    @Override
    public List<UserInfoSimple> queryUserInfoSimpleByRoleId(Integer roleId) {
        String sql = JDBCUtils.getSql("QUERY_USER_INFO_SIMPLE_BY_ROLE_ID");
        return JDBCUtils.query(sql,UserInfoSimple.class,roleId);
    }

    @Override
    public List<TreeNode> queryAllRole() {
        String sql = JDBCUtils.getSql("QUERY_ALL_ROLE_TREE");
        return JDBCUtils.query(sql,TreeNode.class);
    }
}
