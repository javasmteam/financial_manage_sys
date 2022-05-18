package com.javasm.system.dao.implement;

import com.javasm.system.bean.UserInfo;
import com.javasm.system.bean.vo.SetUserInfo;
import com.javasm.system.bean.vo.UserInfoVo;
import com.javasm.system.dao.UserDao;
import com.javasm.util.JDBCUtils;

import java.util.Date;

/**
 * @author: 云勇
 * @date: 2022/5/16 20:07
 * @description:
 */
public class UserDaoImpl implements UserDao {
    @Override
    public UserInfo find(String userAct, String userPwd) {
        String sql = JDBCUtils.getSql("FIND_USER_BY_ACT_PWD");
        return JDBCUtils.find(sql, UserInfo.class, userAct, userPwd);
    }

    @Override
    public Integer updateLastLogin(Integer userId, Date lastLogin) {
        String sql = JDBCUtils.getSql("UPDATE_USER_LAST_TIME");
        return JDBCUtils.update(sql, lastLogin, userId);
    }

    @Override
    public Integer add(UserInfo userInfo) {
        return JDBCUtils.insert("bk_user_info", userInfo);

    }

    @Override
    public UserInfoVo getUserInfoVo(Integer userId) {
        String sql = JDBCUtils.getSql("GET_USER_INFO_VO");
        return JDBCUtils.find(sql,UserInfoVo.class,userId);
    }

    @Override
    public SetUserInfo getSetUserInfoVo(Integer userId) {
        String sql = JDBCUtils.getSql("GET_SET_USER_INFO");
        return JDBCUtils.find(sql,SetUserInfo.class,userId);
    }

    @Override
    public Integer updateUserInfo(SetUserInfo setUserInfo) {
        String sql = JDBCUtils.getSql("UPDATE_USER_INFO");
        return JDBCUtils.update(sql,setUserInfo.getUserName(),setUserInfo.getDes(),setUserInfo.getSex(),
                setUserInfo.getBirthday(),setUserInfo.getAvatarColor(),setUserInfo.getPhone(),setUserInfo.getRoles().getNowRole().getRoleId(),
                setUserInfo.getUserId());
    }


}
