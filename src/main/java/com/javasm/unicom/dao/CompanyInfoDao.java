package com.javasm.unicom.dao;

import com.javasm.unicom.bean.CompanyInfo;
import com.javasm.unicom.bean.PageInfo;


import java.util.List;

public interface CompanyInfoDao {

    /**
     * 添加独角兽公司信息
     *
     * @param companyInfo
     * @return
     */
    Integer addCompanyInfo(CompanyInfo companyInfo);


    /**
     * 统计多少家公司
     *
     * @param companyInfo
     * @return
     */
    Integer count(CompanyInfo companyInfo);


    /**
     * 分页查询
     *
     * @param page
     * @param companyInfo
     * @return
     */
    List<CompanyInfo> selectCompanyInfoByPage(PageInfo<CompanyInfo> page, CompanyInfo companyInfo);


    /**
     * 修改
     *
     * @param companyInfo
     * @return
     */
    Boolean updateCompany(CompanyInfo companyInfo);




}
