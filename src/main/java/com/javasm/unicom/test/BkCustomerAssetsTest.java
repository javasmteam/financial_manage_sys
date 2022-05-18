package com.javasm.unicom.test;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.javasm.unicom.bean.BkCuntomerAssets;
import com.javasm.unicom.bean.BkInvestMoney;
import com.javasm.unicom.bean.BkUserInfo;
import com.javasm.unicom.dao.BkCustomerAssetsDao;
import com.javasm.unicom.dao.BkInvestMoneyDao;
import com.javasm.unicom.dao.BkUserInfoDao;
import com.javasm.unicom.dao.impl.BkCustomerAssetsDaoImpl;
import com.javasm.unicom.dao.impl.BkInvestMoneyDaoImpl;
import com.javasm.unicom.dao.impl.BkUserInfoDaoImpl;

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
        //充值提现
//         BkInvestMoneyDao bkInvestMoneyDao =new BkInvestMoneyDaoImpl();
//        String recharge = HttpUtil.get("http://192.168.6.249:8088/recharge.do?type=getInvest");
//
//        List<BkInvestMoney> bkInvestMonies = JSONUtil.toList(recharge, BkInvestMoney.class);
//        for (BkInvestMoney bkInvestMoney :bkInvestMonies){
//             bkInvestMoneyDao.addBkInvestMoney(bkInvestMoney);
//
////            bkInvestMonies.add(bkInvestMoney);
//        }

        //用户资产
//        BkUserInfoDao bkUserInfoDao =new BkUserInfoDaoImpl();
//        String recharge = HttpUtil.get("http://192.168.6.249:8088/user.do?type=getUserInfo");
//        System.out.println(recharge);
//
//        List<BkUserInfo> bkInvestMonies = JSONUtil.toList(recharge, BkUserInfo.class);
//        for (BkUserInfo bkUserInfo :bkInvestMonies){
//            bkUserInfoDao.addBkUserInfo(bkUserInfo);
//
////            bkInvestMonies.add(bkInvestMoney);
//        }


        BkCustomerAssetsDao bkCustomerAssetsDao =new BkCustomerAssetsDaoImpl();
        String recharge = HttpUtil.get("http://192.168.6.249:8088/assets.do?type=getCustomer");
        System.out.println(recharge);

        List<BkCuntomerAssets> bkInvestMonies = JSONUtil.toList(recharge, BkCuntomerAssets.class);
        for (BkCuntomerAssets bkCuntomerAssets :bkInvestMonies){
            bkCustomerAssetsDao.addBkCuntomerAssets(bkCuntomerAssets);

//            bkInvestMonies.add(bkInvestMoney);
        }



    }

}
