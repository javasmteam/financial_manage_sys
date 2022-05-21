package com.javasm.unicom.dao;

import com.javasm.unicom.bean.BkUserInfo;
import com.javasm.unicom.bean.PageInfo;
import com.javasm.unicom.bean.vo.BkUserInfoVo;

import java.util.List;

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
    Integer addBkUserInfo(BkUserInfo bkUserInfo);

    /**
     * 统计有多少条信息
     *
     * @param bkUserInfo
     * @return
     */
    Integer count(BkUserInfo bkUserInfo);


    /**
     * 分页查询
     *
     * @param pageInfo
     * @param bkUserInfo
     * @return
     */
    List<BkUserInfoVo> selectUserInfo(PageInfo<BkUserInfoVo> pageInfo,BkUserInfo bkUserInfo);
}
