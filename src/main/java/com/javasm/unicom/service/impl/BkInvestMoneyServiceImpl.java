package com.javasm.unicom.service.impl;

import com.javasm.unicom.bean.BkInvestMoney;
import com.javasm.unicom.bean.CompanyInfo;
import com.javasm.unicom.bean.PageInfo;
import com.javasm.unicom.dao.BkInvestMoneyDao;
import com.javasm.unicom.dao.impl.BkInvestMoneyDaoImpl;
import com.javasm.unicom.service.BkInvestMoneyService;

import java.util.List;

/**
 * <h4>financial_manage_sys</h4>
 * <p></p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-18 19:24
 * @Version : 1.0
 **/
public class BkInvestMoneyServiceImpl implements BkInvestMoneyService {
    private BkInvestMoneyDao bkInvestMoneyDao = new BkInvestMoneyDaoImpl();

    @Override
    public PageInfo<BkInvestMoney> getBkInvestMoneyByPage(String nowPage, String pageNum, BkInvestMoney bkInvestMoney) {
        Integer count = bkInvestMoneyDao.count(bkInvestMoney);
        PageInfo<BkInvestMoney> page = new PageInfo<>(nowPage,pageNum,count);
        List<BkInvestMoney> list =bkInvestMoneyDao.selectBkInvestMoney(page,bkInvestMoney);
        page.setDataList(list);
        return null;
    }
}
