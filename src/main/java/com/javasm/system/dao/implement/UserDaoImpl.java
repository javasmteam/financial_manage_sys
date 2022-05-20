package com.javasm.system.dao.implement;

import com.javasm.system.bean.UserInfo;
import com.javasm.system.bean.vo.PageSelectUser;
import com.javasm.system.bean.vo.SetUserInfo;
import com.javasm.system.bean.vo.UserInfoVo;
import com.javasm.system.bean.vo.UserRoleMiddle;
import com.javasm.system.dao.UserDao;
import com.javasm.util.DataUtil;
import com.javasm.util.JDBCUtils;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        return JDBCUtils.insert("user_info", userInfo);

    }

    public Integer add(Connection conn, UserInfo userInfo) {
        return JDBCUtils.insert(conn, "user_info", userInfo);

    }

    @Override
    public Integer addUserRole(Connection conn, UserRoleMiddle ur) {
        return JDBCUtils.insert(conn, "m_user_role", ur);
    }

    @Override
    public Integer addUserRole(UserRoleMiddle ur) {
        return JDBCUtils.insert("m_user_role", ur);
    }


    @Override
    public UserInfoVo getUserInfoVo(Integer userId) {
        String sql = JDBCUtils.getSql("GET_USER_INFO_VO");
        return JDBCUtils.find(sql, UserInfoVo.class, userId);
    }

    @Override
    public SetUserInfo getSetUserInfoVo(Integer userId) {
        String sql = JDBCUtils.getSql("GET_SET_USER_INFO");
        return JDBCUtils.find(sql, SetUserInfo.class, userId);
    }

    @Override
    public Integer updateUserInfo(SetUserInfo setUserInfo) {
        String sql = JDBCUtils.getSql("UPDATE_USER_INFO");
        return JDBCUtils.update(sql, setUserInfo.getUserName(), setUserInfo.getDes(), setUserInfo.getSex(),
                setUserInfo.getBirthday(), setUserInfo.getAvatarColor(), setUserInfo.getPhone(), setUserInfo.getRoles().getNowRole().getRoleId(),
                setUserInfo.getUserId());
    }

    @Override
    public UserInfo getUserInfo(Integer userId) {
        String sql = JDBCUtils.getSql("GET_USER_INFO");
        return JDBCUtils.find(sql, UserInfo.class, userId);
    }

    @Override
    public Integer getSize() {
        String sql = JDBCUtils.getSql("USER_INFO_SIZE");
        return JDBCUtils.size(sql);
    }

    @Override
    public List<UserInfoVo> queryPageUserInfoVo(PageSelectUser pageSelect) {
        ArrayList<Object> objects = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT\n" +
                "\tu.head_pic,\n" +
                "\tu.user_id,\n" +
                "\tu.user_act,\n" +
                "\tu.user_name,\n" +
                "\tu.des,\n" +
                "\tu.sex,\n" +
                "\tu.birthday,\n" +
                "\tu.avatar_color,\n" +
                "\tu.phone,\n" +
                "\tr.role_name,\n" +
                "\tu.last_login,\n" +
                "\tu.user_state \n" +
                "FROM\n" +
                "\tuser_info u,\n" +
                "\tuser_role r \n" +
                "WHERE\n" +
                "\tu.role_id = r.role_id \n" +
                "\tAND u.user_state > 0 ");
        if (pageSelect.getUserName() != null && !pageSelect.getUserName().equals("")) {
            sql.append(" and u.user_name = ? ");
            objects.add(pageSelect.getUserName());
        }
        if (pageSelect.getUserId() != null && !pageSelect.getUserId().equals("")) {
            sql.append(" and u.user_id = ? ");
            Integer integer = DataUtil.stringConvertToInteger(pageSelect.getUserId());
            objects.add(integer);
        }
        sql.append(" limit ?,?;");
        Integer index = (pageSelect.getNowPage() - 1) * pageSelect.getPageCount();
        objects.add(index);
        objects.add(pageSelect.getPageCount());
        Object[] objects1 = objects.toArray();
        List<UserInfoVo> query = JDBCUtils.query(sql.toString(), UserInfoVo.class, objects1);
        return query;

    }

    @Override
    public Integer delUser(String userId) {
        String sql = JDBCUtils.getSql("DEL_USER_INFO");
        return JDBCUtils.update(sql, userId);
    }

    @Override
    public Integer selectSize(PageSelectUser pageSelect) {
        ArrayList<Object> objects = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT\n" +
                "count(u.user_id) \n" +
                "FROM\n" +
                "\tuser_info u,\n" +
                "WHERE\n" +
                "\tAND u.user_state > 0 ");
        if (pageSelect.getUserName() != null && !pageSelect.getUserName().equals("")) {
            sql.append(" and u.user_name = ? ");
            objects.add(pageSelect.getUserName());
        }
        if (pageSelect.getUserId() != null && !pageSelect.getUserId().equals("")) {
            sql.append(" and u.user_id = ? ");
            Integer integer = DataUtil.stringConvertToInteger(pageSelect.getUserId());
            objects.add(integer);
        }
        return JDBCUtils.size(sql.toString());
    }


}
