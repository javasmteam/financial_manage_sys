package com.javasm.product.service;

import com.javasm.product.bean.RemitInfo;

/**
 * <h4>Financial_manage_sys</h4>
 * <p></p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-19 02:51
 * @Version : 1.0
 **/
public interface RemitInfoService {

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
