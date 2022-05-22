package com.javasm.unicom.service.impl;

import com.javasm.unicom.bean.CompanyInfo;
import com.javasm.unicom.bean.HistoryFunding;
import com.javasm.unicom.bean.MakerPrice;
import com.javasm.unicom.bean.PageInfo;
import com.javasm.unicom.bean.vo.HistoryFundingVo;
import com.javasm.unicom.bean.vo.MakerPriceVo;
import com.javasm.unicom.dao.CompanyInfoDao;
import com.javasm.unicom.dao.HistoryFundingDao;
import com.javasm.unicom.dao.MakerPriceDao;
import com.javasm.unicom.dao.impl.CompanyInfoDaoImpl;
import com.javasm.unicom.dao.impl.HistoryFundingDaoImpl;
import com.javasm.unicom.dao.impl.MakerPriceDaoImpl;
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
    private HistoryFundingDao historyFundingDao = new HistoryFundingDaoImpl();
    private MakerPriceDao makerPriceDao = new MakerPriceDaoImpl();

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

    @Override
    public Boolean updateCompany(CompanyInfo companyInfo) {
        return companyInfoDao.updateCompany(companyInfo);
    }

    @Override
    public List<HistoryFunding> selectHistory(Integer comId) {
        return historyFundingDao.selectHistory(comId);
    }

    @Override
    public Boolean deleteCompany(Integer comId) {
        return companyInfoDao.deleteCompany(comId);
    }

    @Override
    public CompanyInfo selectCompanyById(Integer comId) {
        return companyInfoDao.selectCompanyById(comId);
    }

    @Override
    public Boolean updatePrice(MakerPriceVo makerPriceVo) {
        return makerPriceDao.updatePrice(makerPriceVo);
    }

//    @Override
//    public List<MakerPrice> addMaker(MakerPrice makerPrice) {
//        return makerPriceDao.addMaker(makerPrice);
//    }



}
