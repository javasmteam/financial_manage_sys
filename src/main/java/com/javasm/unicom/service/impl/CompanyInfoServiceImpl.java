package com.javasm.unicom.service.impl;

import com.javasm.unicom.bean.CompanyInfo;
import com.javasm.unicom.bean.PageInfo;
import com.javasm.unicom.dao.CompanyInfoDao;
import com.javasm.unicom.dao.impl.CompanyInfoDaoImpl;
import com.javasm.unicom.service.CompanyInfoService;

import java.util.List;

/**
 * <h4>financial_manage_sys</h4>
 * <p></p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-16 19:44
 * @Version : 1.0
 **/
public class CompanyInfoServiceImpl implements CompanyInfoService {
    private CompanyInfoDao companyInfoDao = new CompanyInfoDaoImpl();


    @Override
    public Integer addCompanyInfo(CompanyInfo companyInfo) {
        return companyInfoDao.addCompanyInfo(companyInfo);
    }

    @Override
    public PageInfo<CompanyInfo> getCompanyInfoByPage(String nowPage, String pageNum, CompanyInfo companyInfo) {
        Integer count = companyInfoDao.count(companyInfo);
        PageInfo<CompanyInfo> page= new PageInfo<>(nowPage,pageNum,count);
        List<CompanyInfo> comList = companyInfoDao.selectCompanyInfoByPage(page,companyInfo);
        page.setDataList(comList);
        return page;
    }



}
