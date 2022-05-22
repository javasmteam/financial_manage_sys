package com.javasm.unicom.dao;

import com.javasm.unicom.bean.MakerPrice;
import com.javasm.unicom.bean.vo.MakerPriceVo;

import java.util.List;

public interface MakerPriceDao {


//    /**
//     * 添加
//     *
//     * @param makerPrice
//     * @return
//     */
//    List<MakerPrice> addMaker(MakerPrice makerPrice);


    /**
     * 修改挂单价
     *
     * @param makerPriceVo
     * @return
     */
    Boolean updatePrice (MakerPriceVo makerPriceVo);


}
