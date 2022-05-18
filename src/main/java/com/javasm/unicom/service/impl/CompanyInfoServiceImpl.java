package com.javasm.unicom.service.impl;

import com.javasm.unicom.bean.CompanyInfo;
import com.javasm.unicom.bean.PageInfo;
import com.javasm.unicom.bean.vo.CompanyInfoVo;
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
    public PageInfo<CompanyInfoVo> getCompanyInfoByPage(String nowPage, String pageNum, CompanyInfoVo companyInfo) {
        Integer count = companyInfoDao.count(companyInfo);
        PageInfo<CompanyInfoVo> page= new PageInfo<>(nowPage,pageNum,count);
        List<CompanyInfoVo> comList = companyInfoDao.selectCompanyInfoByPage(page,companyInfo);
        page.setDataList(comList);
        return page;
    }



}
