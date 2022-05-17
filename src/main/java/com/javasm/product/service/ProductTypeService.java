package com.javasm.product.service;

import com.javasm.product.bean.PageInfo;
import com.javasm.product.bean.ProductType;
import com.javasm.product.bean.RemitInfo;
import com.javasm.product.bean.vo.ProductTypeVO;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>产品类别服务类</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-16 09:32
 * @Version : 1.0
 **/
public interface ProductTypeService {

    /**
     * 增加产品信息
     *
     * @param productType 产品系列
     * @return 影响行数
     */
    Boolean addProductType(ProductType productType);


    /**
     * 更新产品信息
     *
     * @param productType 产品系列
     * @return 影响行数
     */
    Boolean updateProductType(ProductType productType);


    /**
     * 查询所有英雄信息
     *
     * @param nowPage     当前页
     * @param pageSize    每页数据量
     * @param productType 产品系列
     * @return 查询到的集合
     */
    PageInfo<ProductTypeVO> getProductTypesByPage(String nowPage, String pageSize, ProductType productType);

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
