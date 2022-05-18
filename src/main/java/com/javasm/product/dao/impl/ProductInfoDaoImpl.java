package com.javasm.product.dao.impl;

import com.javasm.product.bean.PageInfo;
import com.javasm.product.bean.ProductType;
import com.javasm.product.bean.vo.ProductTypeVO;
import com.javasm.product.dao.ProductInfoDao;

import java.util.List;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>产品信息dao实现类</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-15 20:42
 * @Version : 1.0
 **/
public class ProductInfoDaoImpl implements ProductInfoDao {
    /**
     * 增加产品信息
     *
     * @param productType 产品系列
     * @return 影响行数
     */
    @Override
    public Boolean addProductType(ProductType productType) {
        return null;
    }

    /**
     * 更新产品信息
     *
     * @param productType 产品系列
     * @return 影响行数
     */
    @Override
    public Boolean updateProductType(ProductType productType) {
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
    public List<ProductTypeVO> queryProductTypesByPage(PageInfo<ProductTypeVO> page, ProductType productType) {
        return null;
    }
}
