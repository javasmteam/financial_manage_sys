package com.javasm.unicom.dao.impl;

import com.javasm.unicom.bean.BkInvestMoney;
import com.javasm.unicom.bean.CompanyInfo;
import com.javasm.unicom.bean.PageInfo;
import com.javasm.unicom.dao.BkInvestMoneyDao;
import com.javasm.util.JDBCUtils;

import java.util.List;

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

    @Override
    public Integer count(BkInvestMoney bkInvestMoney) {
        String sql = "select count(i.investmoneyid) from bk_invest_money i,bk_user_info u where i.userid=u.userid";
        return JDBCUtils.size(sql);
    }

    @Override
    public List<BkInvestMoney> selectBkInvestMoney(PageInfo<BkInvestMoney> page, BkInvestMoney bkInvestMoney) {
        StringBuilder sql = new StringBuilder("select i.userid,i.userCode,i.userName,i.investmoneytype,i.investmoney,i.investrequesttime,\n" +
                "       i.investhandletime,i.investbankcode,i.state,u.iphone from bk_invest_money i,bk_user_info u where i.userid = u.userid ");
        if (bkInvestMoney!=null){

            if (bkInvestMoney.getUserName() != null && !"".equals(bkInvestMoney.getUserName())){
                sql.append("  and i.userName  like '%"+bkInvestMoney.getUserName() +"%'");
            }
            if (bkInvestMoney.getIphone() != null && !"".equals(bkInvestMoney.getIphone())){
                sql.append("  and u.iphone  like '%"+bkInvestMoney.getIphone() +"%'");
            }
            if (bkInvestMoney.getInvestmoneytype() !=null && !"".equals(bkInvestMoney.getInvestmoneytype())){
                sql.append(" and i.investmoneytype like '%"+bkInvestMoney.getInvestmoneytype()+"%'");
            }
            if (bkInvestMoney.getInveststate() != null && !"".equals(bkInvestMoney.getInveststate())){
                sql.append(" and i.investstate ="+bkInvestMoney.getInveststate());
            }
        }
        sql.append(" limit ?,? ");
        return JDBCUtils.query(sql.toString(),BkInvestMoney.class,page.getStartIndex(),page.getPageNum());
    }
}
