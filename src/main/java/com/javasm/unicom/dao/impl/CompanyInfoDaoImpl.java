package com.javasm.unicom.dao.impl;

import com.javasm.unicom.bean.CompanyInfo;
import com.javasm.unicom.bean.PageInfo;
import com.javasm.unicom.dao.CompanyInfoDao;
import com.javasm.util.JDBCUtils;

import java.util.List;

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

    @Override
    public Integer count(CompanyInfo companyInfo) {
        StringBuilder sql = new StringBuilder("select count(c.com_id) from company_info c,maker_price m where c.com_id=m.com_id");
        return  Math.toIntExact(JDBCUtils.size(sql.toString()));
    }

    @Override
    public List<CompanyInfo> selectCompanyInfoByPage(PageInfo<CompanyInfo> page, CompanyInfo companyInfo) {
        StringBuilder sql = new StringBuilder("select c.com_name,c.trade_code,c.com_seq_code,m.maker_amount from " +
                " company_info c,maker_price m " +
                "where c.com_id=m.com_id");
        if (companyInfo != null ){
            if (companyInfo.getComName()!=null && !"".equals(companyInfo.getComName())){
                sql.append(" and h.hero_name like '%"+companyInfo.getComName() +"%' ");
            }
        }
        sql.append(" limit ?,? ");
        return JDBCUtils.query(sql.toString(),CompanyInfo.class,page.getStartIndex(),page.getPageNum());
    }
}
