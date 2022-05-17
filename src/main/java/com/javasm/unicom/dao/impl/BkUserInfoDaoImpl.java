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
    public Boolean addBkUserInfo(BkUserInfo bkUserInfo) {
        String sql = "insert into bk_user_info values(user_id,?,?,?,?,?,?,?,?,?,?,?,1)";
        return JDBCUtils.update(sql,bkUserInfo.getUserName(),bkUserInfo.getUserCode(),bkUserInfo.getIphone(),
                bkUserInfo.getPwd(),bkUserInfo.getNickName(),bkUserInfo.getSex(),bkUserInfo.getBirthday(),
                bkUserInfo.getAvatarocolor(),bkUserInfo.getGrade(),bkUserInfo.getHeadpic(),bkUserInfo.getHeadpicThumb())>0;
    }
}
