package com.javasm.system.dao.implement;

import com.javasm.system.bean.UserInfo;
import com.javasm.system.dao.UserDao;
import com.javasm.util.JDBCUtils;

/**
 * @author: 云勇
 * @date: 2022/5/16 20:07
 * @description:
 */
public class UserDaoImpl implements UserDao {
    @Override
    public UserInfo find(String userAct, String userPwd) {
        String sql = JDBCUtils.getSql("FIND_USER_BY_ACT_PWD");
        JDBCUtils.find(sql)
    }
}
