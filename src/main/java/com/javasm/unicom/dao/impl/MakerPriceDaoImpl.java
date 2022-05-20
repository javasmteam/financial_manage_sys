package com.javasm.unicom.dao.impl;

import com.javasm.unicom.bean.MakerPrice;
import com.javasm.unicom.dao.MakerPriceDao;
import com.javasm.util.JDBCUtils;

/**
 * <h4>financial_manage_sys</h4>
 * <p></p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-19 19:48
 * @Version : 1.0
 **/
public class MakerPriceDaoImpl implements MakerPriceDao {
    @Override
    public Boolean addMaker(MakerPrice makerPrice) {
        String sql = "insert into maker_price\n" +
                "values (maker_id, ?, ?, ?, 1);";
        return JDBCUtils.insert("maker_price",makerPrice)>0;
    }
}
