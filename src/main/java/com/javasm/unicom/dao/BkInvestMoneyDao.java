package com.javasm.unicom.dao;

import com.javasm.unicom.bean.BkInvestMoney;
import com.javasm.unicom.bean.CompanyInfo;
import com.javasm.unicom.bean.PageInfo;

import java.util.List;

public interface BkInvestMoneyDao {

    /**
     * 添加充值提现信息
     *
     * @param bkInvestMoney
     * @return
     */
    Integer addBkInvestMoney(BkInvestMoney bkInvestMoney);


    /**
     * 统计总条数
     *
     * @param bkInvestMoney
     * @return
     */
    Integer count(BkInvestMoney bkInvestMoney);


    /**
     * 分页查询
     *
     * @param page
     * @param bkInvestMoney
     * @return
     */
    List<BkInvestMoney> selectBkInvestMoney(PageInfo<BkInvestMoney> page,BkInvestMoney bkInvestMoney);



}
