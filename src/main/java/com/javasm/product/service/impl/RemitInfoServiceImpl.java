package com.javasm.product.service.impl;

import com.javasm.product.bean.RemitInfo;
import com.javasm.product.dao.RemitInfoDao;
import com.javasm.product.dao.impl.RemitInfoDaoImpl;
import com.javasm.product.service.RemitInfoService;

/**
 * <h4>Financial_manage_sys</h4>
 * <p></p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-19 02:51
 * @Version : 1.0
 **/
public class RemitInfoServiceImpl implements RemitInfoService {
    private final RemitInfoDao remitInfoDao = new RemitInfoDaoImpl();

    /**
     * 增加汇款信息
     *
     * @param remitInfo 汇款信息
     * @return 影响行数
     */
    @Override
    public Boolean addRemitInfo(RemitInfo remitInfo) {

        return remitInfoDao.addRemitInfo(remitInfo);
    }

    /**
     * 更新汇款信息
     *
     * @param remitInfo 汇款信息
     * @return 影响行数
     */
    @Override
    public Boolean updateRemitInfo(RemitInfo remitInfo) {
        return remitInfoDao.updateRemitInfo(remitInfo);
    }
}
