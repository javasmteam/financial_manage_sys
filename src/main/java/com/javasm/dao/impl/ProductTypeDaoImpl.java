package com.javasm.dao.impl;

import com.javasm.bean.PageInfo;
import com.javasm.bean.ProductType;
import com.javasm.dao.ProductTypeDao;

import java.util.List;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>产品类别dao实现类</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-15 20:44
 * @Version : 1.0
 **/
public class ProductTypeDaoImpl implements ProductTypeDao {
    /**
     * 增加产品信息
     *
     * @param productType 产品系列
     * @return 影响行数
     */
    @Override
    public Integer addProductType(ProductType productType) {
        String sql = "";
        return null;
    }

    /**
     * 更新产品信息
     *
     * @param productType 产品系列
     * @return 影响行数
     */
    @Override
    public Integer updateProductType(ProductType productType) {
        return null;
    }

    /**
     * 查询商品类别总条数
     *
     * @param productType 产品系列
     * @return 影响行数
     */
    @Override
    public Integer count(ProductType productType) {
        return null;
    }

    /**
     * 分页查询英雄信息
     *
     * @param page        分页信息
     * @param productType 产品系列
     * @return 影响行数
     */
    @Override
    public List<ProductType> queryProductTypes(PageInfo<ProductType> page, ProductType productType) {
        return null;
    }
}
