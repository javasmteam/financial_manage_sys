package com.javasm.product.dao;

import com.javasm.product.bean.PageInfo;
import com.javasm.product.bean.ProductType;
import com.javasm.product.bean.RemitInfo;
import com.javasm.product.bean.vo.ProductTypeVO;

import java.util.List;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>汇款信息dao</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-17 15:37
 * @Version : 1.0
 **/
public interface RemitInfoDao {


    /**
     * 增加汇款信息
     *
     * @param remitInfo 汇款信息
     * @return 影响行数
     */
    Boolean addRemitInfo(RemitInfo remitInfo);


    /**
     * 更新汇款信息
     *
     * @param remitInfo 汇款信息
     * @return 影响行数
     */
    Boolean updateRemitInfo(RemitInfo remitInfo);


}
