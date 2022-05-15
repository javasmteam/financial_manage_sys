package com.javasm.dao;

import com.javasm.bean.PageInfo;
import com.javasm.bean.ProductType;

import java.util.List;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>产品系列dao</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-15 20:42
 * @Version : 1.0
 **/
public interface ProductTypeDao {


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
     * 查询商品类别总条数
     *
     * @param productType 产品系列
     * @return 影响行数
     */
    Integer count(ProductType productType);


    /**
     * 分页查询英雄信息
     *
     * @param page        分页信息
     * @param productType 产品系列
     * @return 影响行数
     */
    List<ProductType> queryProductTypes(PageInfo<ProductType> page, ProductType productType);


}
