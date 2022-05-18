package com.javasm.unicom.service;

import com.javasm.unicom.bean.BkInvestMoney;
import com.javasm.unicom.bean.CompanyInfo;
import com.javasm.unicom.bean.PageInfo;

/**
 * <h4>financial_manage_sys</h4>
 * <p></p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-18 17:58
 * @Version : 1.0
 **/
public interface BkInvestMoneyService {
    /**
     * 分页查询
     *
     * @param nowPage
     * @param pageNum
     * @param bkInvestMoney
     * @return
     */
    PageInfo<BkInvestMoney> getBkInvestMoneyByPage(String nowPage, String pageNum, BkInvestMoney bkInvestMoney);
}
