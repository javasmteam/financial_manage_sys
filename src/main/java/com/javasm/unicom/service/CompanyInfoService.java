package com.javasm.unicom.service;

import com.javasm.unicom.bean.CompanyInfo;
import com.javasm.unicom.bean.PageInfo;

import java.util.List;

/**
 * <h4>financial_manage_sys</h4>
 * <p></p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-16 19:43
 * @Version : 1.0
 **/
public interface CompanyInfoService {
    /**
     * 添加独角兽公司信息
     *
     * @param companyInfo
     * @return
     */
    Integer addCompanyInfo(CompanyInfo companyInfo);


    /**
     * 分页查询
     *
     * @param nowPage
     * @param pageNum
     * @param companyInfo
     * @return
     */
    PageInfo<CompanyInfo> getCompanyInfoByPage(String nowPage, String pageNum, CompanyInfo companyInfo);


    /**
     * 修改
     *
     * @param companyInfo
     * @return
     */
    Boolean updateCompany(CompanyInfo companyInfo);


}
