package com.javasm.system.service.implement;

import com.javasm.system.bean.PageInfo;
import com.javasm.system.bean.UserRole;
import com.javasm.system.bean.vo.PageSelectRole;
import com.javasm.system.bean.vo.SetRolePermissions;
import com.javasm.system.bean.vo.TreeNode;
import com.javasm.system.bean.vo.UserInfoSimple;
import com.javasm.system.dao.UserRoleDao;
import com.javasm.system.dao.implement.UserRoleDaoImpl;
import com.javasm.system.service.RoleService;
import com.javasm.util.DataUtil;
import com.javasm.util.JDBCUtils;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.util.List;

/**
 * @author: 云勇
 * @date: 2022/5/20 14:32
 * @description:
 */
public class RoleServiceImpl implements RoleService {
    UserRoleDao userRoleDao = new UserRoleDaoImpl();

    @Override
    public List<TreeNode> queryAllPermissions() {
        return queryChildPermissions(0);
    }

    @Override
    public PageInfo<UserRole> pageSelectRole(PageSelectRole pageSelect) {
        Integer count = userRoleDao.selectSize(pageSelect);
        List<UserRole> list = userRoleDao.queryPageSelect(pageSelect);
        return new PageInfo<>(pageSelect.getNowPage(), pageSelect.getPageCount(), count, list);
    }

    @Override
    public Integer delRole(String id) {
        Integer roleId = DataUtil.stringConvertToInteger(id);
        return userRoleDao.delUserRole(roleId);
    }

    @Override
    public Integer updateRole(UserRole userRole) {
        return userRoleDao.updateRole(userRole);
    }

    @Override
    public List<Integer> findRolePermissions(String id) {
        Integer roleId = DataUtil.stringConvertToInteger(id);
        return userRoleDao.findRolePermissions(roleId);
    }

    @Override
    public Integer setRolePermissions(SetRolePermissions setRolePermissions) {
        Connection conn = JDBCUtils.getConn();
        Integer m = userRoleDao.delRolePermissions(conn,setRolePermissions.getRoleId());
        for (Integer rolePermission : setRolePermissions.getPermissions()) {
            Integer n = userRoleDao.addRolePermission(conn,setRolePermissions.getRoleId(),rolePermission);
            if(n<1){
                DbUtils.rollbackAndCloseQuietly(conn);
                return -1;
            }
        }
        DbUtils.rollbackAndCloseQuietly(conn);
        return 1;

    }

    @Override
    public Integer addUserRole(UserRole userRole) {
        return userRoleDao.addUserRole(userRole);
    }

    @Override
    public List<UserInfoSimple> queryUserInfoSimpleByRoleId(String id) {
        Integer roleId = DataUtil.stringConvertToInteger(id);
        return userRoleDao.queryUserInfoSimpleByRoleId(roleId);
    }


    private List<TreeNode> queryChildPermissions(Integer i) {
        List<TreeNode> list = userRoleDao.queryChildPermissions(i);
        if (list.isEmpty()) {
            return null;
        } else {
            for (TreeNode treeNode : list) {
                List<TreeNode> list1 = queryChildPermissions(treeNode.getId());
                if (list1 != null) {
                    treeNode.setChildren(list1);
                }
            }
            return list;
        }
    }

}
