package com.javasm.unicom.dao.impl;

import com.javasm.unicom.bean.BkCuntomerAssets;
import com.javasm.unicom.dao.BkCustomerAssetsDao;
import com.javasm.util.JDBCUtils;

/**
 * <h4>financial_manage_sys</h4>
 * <p></p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-16 16:58
 * @Version : 1.0
 **/
public class BkCustomerAssetsDaoImpl implements BkCustomerAssetsDao {
    @Override
    public Boolean addBkCuntomerAssets(BkCuntomerAssets bkCuntomerAssets) {
        String sql = "insert into bk_customer_assets values (customer_id,?,?,?,?,1)";
        return JDBCUtils.update(sql,BkCuntomerAssets.class,bkCuntomerAssets.getUserId(),bkCuntomerAssets.getCoBusinessId(),
                bkCuntomerAssets.getHoldNumber(),bkCuntomerAssets.getHoldMoney())>0;
    }
}
