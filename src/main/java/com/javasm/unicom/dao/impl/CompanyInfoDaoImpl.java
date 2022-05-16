package com.javasm.unicom.dao.impl;

import com.javasm.unicom.bean.CompanyInfo;
import com.javasm.unicom.dao.CompanyInfoDao;
import com.javasm.util.JDBCUtils;

/**
 * <h4>financial_manage_sys</h4>
 * <p></p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-16 17:04
 * @Version : 1.0
 **/
public class CompanyInfoDaoImpl implements CompanyInfoDao {
    @Override
    public Boolean addCompanyInfo(CompanyInfo companyInfo) {
        String sql = "insert into company_info values (com_id,?,?,?,?,?,?,?,?,?,?,?,com_info_state)";
        return JDBCUtils.update(sql,companyInfo.getComName(),companyInfo.getTradeCode(),companyInfo.getComLogo(),
                companyInfo.getAppLogo(),companyInfo.getComIndustry(),companyInfo.getComCreateYear(),companyInfo.getComCeo(),
                companyInfo.getComLocation(),companyInfo.getComRate(),companyInfo.getComSeqCode(),
                companyInfo.getComIntro())>0;
    }
}
