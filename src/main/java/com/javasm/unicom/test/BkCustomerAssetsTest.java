package com.javasm.unicom.test;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.javasm.unicom.bean.BkInvestMoney;
import com.javasm.unicom.dao.BkInvestMoneyDao;
import com.javasm.unicom.dao.impl.BkInvestMoneyDaoImpl;

import java.util.List;

/**
 * <h4>financial_manage_sys</h4>
 * <p></p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-17 19:17
 * @Version : 1.0
 **/
public class BkCustomerAssetsTest {

    public static void main(String[] args) {
         BkInvestMoneyDao bkInvestMoneyDao =new BkInvestMoneyDaoImpl();
        String recharge = HttpUtil.get("http://192.168.6.249:8088/recharge.do?type=getInvest");

        List<BkInvestMoney> bkInvestMonies = JSONUtil.toList(recharge, BkInvestMoney.class);
        for (BkInvestMoney bkInvestMoney :bkInvestMonies){
             bkInvestMoneyDao.addBkInvestMoney(bkInvestMoney);

//            bkInvestMonies.add(bkInvestMoney);
        }


    }

}
