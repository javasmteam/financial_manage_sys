package com.javasm.unicom.service;

import com.javasm.unicom.bean.BkUserInfo;
import com.javasm.unicom.bean.PageInfo;
import com.javasm.unicom.bean.vo.BkUserInfoVo;

/**
 * <h4>financial_manage_sys</h4>
 * <p></p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-20 21:58
 * @Version : 1.0
 **/
public interface BkUserInfoService {


    /**
     * 分页查询
     *
     * @param nowPage
     * @param pageNum
     * @param bkUserInfo
     * @return
     */
    PageInfo<BkUserInfoVo> selectBkUserInfo(String nowPage, String pageNum, BkUserInfo bkUserInfo);
}
