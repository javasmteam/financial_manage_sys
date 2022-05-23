package com.javasm.system.service.implement;

import cn.hutool.core.codec.Base64;
import com.javasm.constant.Cons;
import com.javasm.system.bean.UserInfo;
import com.javasm.system.bean.UserPermission;
import com.javasm.system.bean.UserRole;
import com.javasm.system.bean.vo.*;
import com.javasm.system.dao.UserDao;
import com.javasm.system.dao.UserPermissionDao;
import com.javasm.system.dao.UserRoleDao;
import com.javasm.system.dao.implement.UserDaoImpl;
import com.javasm.system.dao.implement.UserPermissionDaoImpl;
import com.javasm.system.dao.implement.UserRoleDaoImpl;
import com.javasm.system.service.LoginService;
import com.javasm.util.JDBCUtils;
import org.apache.commons.dbutils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
        if (userInfo == null) {
            return userInfo;
        }
        userInfo.setLastLogin(new Date());
        userDao.updateLastLogin(userInfo.getUserId(), userInfo.getLastLogin());
        return userInfo;
    }

    @Override
    public String reg(RegUser regUser) {
        UserInfo userInfo = new UserInfo(regUser);
        Connection conn = JDBCUtils.getConn();
        Integer id = userDao.add(conn, userInfo);
        Integer i = null;
        if (id > 0) {
            UserRoleMiddle ur = new UserRoleMiddle(id, Cons.DEFAULT_ROLE);
            i = userDao.addUserRole(conn, ur);
        }
        if(i>0&&id>0){
            DbUtils.commitAndCloseQuietly(conn);
            return "1";
        }
        DbUtils.rollbackAndCloseQuietly(conn);
        return "-1";


    }


    @Override
    public UserRoleVo getUserRoleVo(UserInfo login) {
        //查询用户当前角色对象
        UserRole nowRole = userRoleDao.get(login.getRoleId());
        //根据对象创建角色信息对象
        UserRoleVo userRoleVo = new UserRoleVo(nowRole);
        //获取用户全部角色
        List<UserRole> list = userRoleDao.queryUserAllRole(login.getUserId());
        userRoleVo.setUserRoles(list);
        return userRoleVo;
    }

    @Override
    public List<RoleMenu> getRoleMenu(Integer roleId) {
        //创建一级菜单集合
        List<RoleMenu> roleMenus = new ArrayList<>();
        //获取全部的一级菜单
        List<UserPermission> list = userPermissionDao.getAllHeadMenu();
        //遍历一级菜单
        for (UserPermission userPermission : list) {
            //获取一级菜单的次级菜单
            List<UserPermission> secondaryMenu = userPermissionDao.getSecondaryMenu(roleId, userPermission.getPermissionId());
            ;
            //判断是否有次级菜单
            if (secondaryMenu.size() > 0) {
                //若有次级菜单则封装在RoleMenu对象中,并添加到一级菜单集合中
                RoleMenu roleMenu = new RoleMenu();
                roleMenu.setHerdPermission(userPermission);
                roleMenu.setPermissions(secondaryMenu);
                roleMenus.add(roleMenu);
            }
        }
        //防护菜单集合
        return roleMenus;
    }




}
