package com.javasm.unicom.dao.impl;

import com.javasm.unicom.bean.HistoryFunding;
import com.javasm.unicom.bean.vo.HistoryFundingVo;
import com.javasm.unicom.dao.HistoryFundingDao;
import com.javasm.util.JDBCUtils;

/**
 * <h4>financial_manage_sys</h4>
 * <p></p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-19 19:55
 * @Version : 1.0
 **/
public class HistoryFundingDaoImpl implements HistoryFundingDao {
    @Override
    public HistoryFundingVo selectHistory(Integer comId) {
        StringBuilder sql = new StringBuilder("select c.com_name comName,h.fun_date funDate,h.fun_type funType,h.fun_amount funAmount,\n" +
                "       h.after_fun_val afterFunVal,h.total_shares totalShares,h.price_per_share pricePerShare\n" +
                "       from company_info c ,history_funding h where c.com_id = h.com_id and h.com_id = ?");
        return JDBCUtils.find(sql.toString(),HistoryFundingVo.class,comId);
    }
}
