package com.javasm.unicom.dao.impl;

import com.javasm.unicom.bean.MakerPrice;
import com.javasm.unicom.bean.vo.MakerPriceVo;
import com.javasm.unicom.dao.MakerPriceDao;
import com.javasm.util.JDBCUtils;

import java.util.List;

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
    public Boolean updatePrice(MakerPriceVo makerPriceVo) {
        String sql = "update maker_price set buyPriceOne=?,buyNumberOne=?,buyPriceTwo=?,buyNumberTwo=?,\n" +
                "                       buyPriceThree=?,buyNumberThree=? where com_id = ?";
        return JDBCUtils.update(sql,makerPriceVo.getBuyPriceOne(),makerPriceVo.getBuyNumberOne(),
                makerPriceVo.getBuyPriceTwo(),makerPriceVo.getBuyNumberTwo(),makerPriceVo.getBuyPriceThree(),
                makerPriceVo.getBuyNumberThree(),makerPriceVo.getComId())>0;
    }
}
