package com.javasm.product.dao.impl;

import com.javasm.product.bean.RemitInfo;
import com.javasm.product.dao.RemitInfoDao;
import com.javasm.util.JDBCUtils;

import java.util.List;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>汇款信息dao实现类</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-17 15:37
 * @Version : 1.0
 **/
public class RemitInfoDaoImpl implements RemitInfoDao {
    /**
     * 增加汇款信息
     *
     * @param remitInfo 汇款信息
     * @return 影响行数
     */
    @Override
    public Boolean addRemitInfo(RemitInfo remitInfo) {
        return JDBCUtils.insert("remit_info", remitInfo) > 0;
    }

    /**
     * 更新汇款信息
     *
     * @param remitInfo 汇款信息
     * @return 影响行数
     */
    @Override
    public Boolean updateRemitInfo(RemitInfo remitInfo) {
        String sql = JDBCUtils.getSql("changeRemitInfo");
        return JDBCUtils.update(sql, remitInfo.getRecBankName(), remitInfo.getSwiftCode(), remitInfo.getBankCode(), remitInfo.getCnapsId()
                , remitInfo.getRecBankArea(), remitInfo.getRecBankCity(), remitInfo.getRecAccountName(), remitInfo.getRecAccount(),
                remitInfo.getRecLocation(), remitInfo.getRegulateBody(), remitInfo.getRemitInfoSummary(), remitInfo.getRemitState(),
                remitInfo.getProductSeriesId()) > 0;
    }


}
