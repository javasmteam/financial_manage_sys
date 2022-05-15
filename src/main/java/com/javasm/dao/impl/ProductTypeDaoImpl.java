package com.javasm.dao.impl;

import com.javasm.bean.PageInfo;
import com.javasm.bean.ProductType;
import com.javasm.dao.ProductTypeDao;

import java.util.List;

import static com.javasm.util.JDBCUtils.update;

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
    public Boolean addProductType(ProductType productType) {
        String sql = "insert into product_type\n" +
                "values (product_type_id, ?, ?, ?, ?, ?, product_type_state);";
        return update(sql, productType.getProductParentId(), productType.getProductChannel(), productType.getProductTypeChName(),
                productType.getProductTypeEngName(), productType.getProductTypeLv(), productType.getProductTypeState()) > 0;
    }

    /**
     * 更新产品信息
     *
     * @param productType 产品系列
     * @return 影响行数
     */
    @Override
    public Boolean updateProductType(ProductType productType) {
        String sql = "update product_type\n" +
                "set product_parent_id    = ?,\n" +
                "    product_channel      = ?,\n" +
                "    product_type_ch_name=?,\n" +
                "    product_type_eng_name= ?,\n" +
                "    product_type_lv      = ?,\n" +
                "    product_type_state   = ?\n" +
                "where product_type_id = ?";
        return update(sql, productType.getProductParentId(), productType.getProductChannel(),
                productType.getProductTypeChName(), productType.getProductTypeEngName(),
                productType.getProductTypeLv(), productType.getProductTypeState(), productType.getProductTypeId()) > 0;
    }

    /**
     * 查询商品类别总条数
     *
     * @param productType 产品系列
     * @return 影响行数
     */
    @Override
    public Integer count(ProductType productType) {
        StringBuilder sql = new StringBuilder("select count(product_type.product_type_id)\n" +
                "from product_type,\n" +
                "     remit_info\n" +
                "where product_type.product_type_id = remit_info.product_type_id");

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
