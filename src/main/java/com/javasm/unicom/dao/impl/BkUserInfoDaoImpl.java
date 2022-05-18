package com.javasm.unicom.dao.impl;

import com.javasm.unicom.bean.BkUserInfo;
import com.javasm.unicom.dao.BkUserInfoDao;
import com.javasm.util.JDBCUtils;

/**
 * <h4>financial_manage_sys</h4>
 * <p></p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-17 17:45
 * @Version : 1.0
 **/
public class BkUserInfoDaoImpl implements BkUserInfoDao {
    @Override
    public Integer addBkUserInfo(BkUserInfo bkUserInfo) {
        String sql = "insert into bk_user_info values(userid,?,?,?,?,?,?,?,?,?,?,?,1)";
        return JDBCUtils.insert("bk_user_info",bkUserInfo);
    }
}
