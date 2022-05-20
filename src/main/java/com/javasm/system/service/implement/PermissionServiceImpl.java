package com.javasm.system.service.implement;

import com.javasm.system.bean.PageInfo;
import com.javasm.system.bean.UserPermission;
import com.javasm.system.bean.vo.FirstMenu;
import com.javasm.system.bean.vo.PageSelectPermission;
import com.javasm.system.bean.vo.PermissionInfo;
import com.javasm.system.dao.UserPermissionDao;
import com.javasm.system.dao.implement.UserPermissionDaoImpl;
import com.javasm.system.service.PermissionService;


import java.util.List;

/**
 * @author: 云勇
 * @date: 2022/5/20 14:31
 * @description:
 */
public class PermissionServiceImpl implements PermissionService {
    private UserPermissionDao userPermissionDao = new UserPermissionDaoImpl();

    @Override
    public PageInfo<PermissionInfo> pageSelectPermission(PageSelectPermission pageSelect) {
        Integer size = userPermissionDao.getSize(pageSelect);
        List<PermissionInfo> list = userPermissionDao.queryPagePermission(pageSelect);
        return new PageInfo<>(pageSelect.getNowPage(),pageSelect.getPageCount(),size,list);
    }

    @Override
    public List<FirstMenu> queryFirstMenu() {
        return userPermissionDao.queryFirstMenu();
    }

    @Override
    public Integer delPermission(PermissionInfo permissionInfo) {
        Integer count = userPermissionDao.findChildMenu(permissionInfo.getPermissionId());
        if(count>0){
            return -1;
        }
        return userPermissionDao.updatePermissionState(permissionInfo.getPermissionId());
    }

    @Override
    public Integer addPermissionInfo(PermissionInfo permissionInfo) {
        UserPermission userPermission = new UserPermission(permissionInfo);

        return userPermissionDao.addPermissionInfo(userPermission);
    }

    @Override
    public Integer updateUserPermission(PermissionInfo permissionInfo) {
        return userPermissionDao.updatePermissionInfo(permissionInfo);
    }

    @Override
    public PermissionInfo getPermissionInfo(String permissionId) {
        Integer id = Integer.valueOf(permissionId);
        return userPermissionDao.getPermissionInfo(id);
    }
}
