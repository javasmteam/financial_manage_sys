package com.javasm.unicom.dao;

import com.javasm.unicom.bean.BkUserInfo;

/**
 * <h4>financial_manage_sys</h4>
 * <p></p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-17 16:49
 * @Version : 1.0
 **/
public interface BkUserInfoDao {

    /**
     * 添加用户表
     *
     * @param bkUserInfo
     * @return
     */
    Boolean addBkUserInfo(BkUserInfo bkUserInfo);
}
