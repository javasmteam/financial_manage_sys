package com.javasm.product.dao.impl;

import com.javasm.product.bean.ProductNetValue;
import com.javasm.product.dao.ProductNetValueDao;
import com.javasm.util.JDBCUtils;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>产品净值dao实现类</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-19 07:12
 * @Version : 1.0
 **/
public class ProductNetValueDaoImpl implements ProductNetValueDao {
    /**
     * @param productNetValue
     * @return
     */
    @Override
    public Boolean addProductNetValue(ProductNetValue productNetValue) {
        return JDBCUtils.insert("product_net_value", productNetValue) > 0;
    }

    /**
     * 修改产品净值信息
     *
     * @param productNetValue
     * @return
     */
    @Override
    public Boolean updateProductNetValue(ProductNetValue productNetValue) {
        String sql = JDBCUtils.getSql("changeProductNetValue");
        return JDBCUtils.update(sql, productNetValue.getUnitNet(), productNetValue.getUnitDate(), productNetValue.getSumIncreaseRate(),
                productNetValue.getProductId()) > 0;
    }
}
