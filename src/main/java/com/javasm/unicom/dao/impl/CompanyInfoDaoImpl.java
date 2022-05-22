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
    public Integer addCompanyInfo(CompanyInfo companyInfo) {
        String sql = "insert into company_info values (com_id,?,?,?,?,?,?,?,?,?,?,?,1)";
        return JDBCUtils.insert("company_info",companyInfo);
    }

    @Override
    public Integer count(CompanyInfo companyInfo) {
        StringBuilder sql = new StringBuilder("select count(c.com_id) " +
                " from company_info as c, maker_price as p\n" +
                " where  c.com_id =  p.com_id " +
                " and c.com_info_state =1  ");
        return  JDBCUtils.size(sql.toString());
    }

    @Override
    public List<CompanyInfo> selectCompanyInfoByPage(PageInfo<CompanyInfo> page, CompanyInfo companyInfo) {
        StringBuilder sql = new StringBuilder("select c.com_id comId,c.com_name comName,c.trade_code tradeCode,\n" +
                "       c.com_logo comLogo,c.app_logo appLogo,c.com_industry comIndustry,\n" +
                "       c.com_create_year comCreateYear,c.com_ceo comCeo,c.com_location comLocation,\n" +
                "       c.com_rate comRate,c.new_maker_amount newMakerAmount,c.com_seq_code comSeqCode,\n" +
                "       c.com_intro comIntro,m.buyPriceOne,m.buyNumberOne,m.buyPriceTwo,m.buyNumberTwo,\n" +
                "       m.buyPriceThree,m.buyNumberThree\n" +
                " from company_info c,maker_price m where c.com_id = m.com_id and c.com_info_state =1");
        if (companyInfo != null ){
            if (companyInfo.getComName()!=null && !"".equals(companyInfo.getComName())){
                sql.append(" and c.com_name  like '%"+companyInfo.getComName() +"%' ");
            }
        }
        sql.append(" limit ?,? ");
        return JDBCUtils.query(sql.toString(),CompanyInfo.class,page.getStartIndex(),page.getPageNum());
    }

    @Override
    public Boolean updateCompany(CompanyInfo companyInfo) {
        String sql = "update company_info set com_name=?,trade_code=?,com_logo=?,app_logo=?," +
                "com_industry=?,com_create_year=?,com_ceo=?,com_location=?,com_rate=?," +
                "new_maker_amount=?,com_seq_code=?,com_intro=?,com_info_state=? where com_id=? ";
        return JDBCUtils.update(sql,companyInfo.getComName(),companyInfo.getTradeCode(),companyInfo.getComLogo(),
                companyInfo.getAppLogo(),companyInfo.getComIndustry(),companyInfo.getComCreateYear(),companyInfo.getComCeo(),
                companyInfo.getComLocation(),companyInfo.getComRate(),companyInfo.getNewMakerAmount(),
                companyInfo.getComSeqCode(),companyInfo.getComIntro(),companyInfo.getComInfoState(),companyInfo.getComId())>0;
    }

    @Override
    public CompanyInfo selectCompanyById(Integer comId) {
        String sql = "select c.com_id comId,c.com_name comName,c.trade_code tradeCode,\n" +
                "       c.com_logo comLoge,c.app_logo appLogo,c.com_industry comIndustry,\n" +
                "       c.com_create_year comCreateYear,c.com_ceo comCeo,c.com_location comLocation,\n" +
                "       c.com_rate comRate,c.new_maker_amount newMakerAmount,c.com_seq_code comSeqCode,\n" +
                "       c.com_intro comIntro from company_info c where c.com_id = ?";
        return JDBCUtils.find(sql,CompanyInfo.class,comId);
    }

    @Override
    public Boolean deleteCompany(Integer comId) {
        String sql = JDBCUtils.getSql("deleteCompany");
        return JDBCUtils.update(sql,comId)>0;
    }
}
