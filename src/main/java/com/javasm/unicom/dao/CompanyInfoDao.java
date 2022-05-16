package com.javasm.unicom.dao;

import com.javasm.unicom.bean.CompanyInfo;

public interface CompanyInfoDao {

    /**
     * 添加独角兽公司信息
     *
     * @param companyInfo
     * @return
     */
    Boolean addCompanyInfo(CompanyInfo companyInfo);


}
