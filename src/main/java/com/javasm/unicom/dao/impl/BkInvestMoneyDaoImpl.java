package com.javasm.unicom.dao.impl;

import com.javasm.unicom.bean.BkInvestMoney;
import com.javasm.unicom.dao.BkInvestMoneyDao;
import com.javasm.util.JDBCUtils;

/**
 * <h4>financial_manage_sys</h4>
 * <p></p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-17 17:38
 * @Version : 1.0
 **/
public class BkInvestMoneyDaoImpl implements BkInvestMoneyDao {
    @Override
    public Integer addBkInvestMoney(BkInvestMoney bkInvestMoney) {
        String sql = "insert into bk_invest_money values(investmoneyid,?,?,?,?,?,?,?,?,?,1)";
        return JDBCUtils.insert("bk_invest_money",bkInvestMoney);
    }
}
