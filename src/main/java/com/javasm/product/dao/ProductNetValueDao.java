package com.javasm.product.dao;

import com.javasm.product.bean.ProductNetValue;


/**
 * <h4>Financial_manage_sys</h4>
 * <p>产品净值dao</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-19 07:12
 * @Version : 1.0
 **/
public interface ProductNetValueDao {


    /**
     * 添加产品净值信息
     *
     * @param productNetValue
     * @return
     */
    Boolean addProductNetValue(ProductNetValue productNetValue);


    /**
     * 修改产品净值信息
     *
     * @param productNetValue
     * @return
     */
    Boolean updateProductNetValue(ProductNetValue productNetValue);

}
