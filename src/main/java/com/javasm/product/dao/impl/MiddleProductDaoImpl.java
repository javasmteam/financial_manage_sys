package com.javasm.product.dao.impl;

import com.javasm.product.bean.MiddleProduct;
import com.javasm.product.bean.vo.ProductNotRecommendVO;
import com.javasm.product.dao.MiddleProductDao;
import com.javasm.util.JDBCUtils;

import java.sql.Connection;
import java.util.List;

/**
 * @author: zhaoyuanming
 * @License: (C) Copyright 2022, wtl Corporation Limited.
 * @Contact: 2448429318@qq.com
 * @Date: 2022/5/23 10:43
 * @Version: 1.0
 * @Description:
 */
public class MiddleProductDaoImpl implements MiddleProductDao {
    /**
     * 添加关联产品表
     *
     * @param middleProduct
     * @return
     */
    @Override
    public Boolean addMiddleProduct(Connection conn, MiddleProduct middleProduct) {
        String sql = JDBCUtils.getSql("addMiddleProduct");
        return JDBCUtils.update(conn, sql, middleProduct.getProductIdA(), middleProduct.getProductIdB()) > 0;
    }

    /**
     * 获得除了选中的id之外的产品列表
     *
     * @param id
     * @return
     */
    @Override
    public List<ProductNotRecommendVO> getProductWithoutId(Integer id) {
        String sql = JDBCUtils.getSql("getProductId");
        return JDBCUtils.query(sql, ProductNotRecommendVO.class, id, id);
    }

    /**
     * 获得选中的id
     *
     * @param id
     * @return
     */
    @Override
    public List<ProductNotRecommendVO> getProductId(Integer id) {
        String sql = JDBCUtils.getSql("getSelectProductId");
        return JDBCUtils.query(sql, ProductNotRecommendVO.class, id, id);
    }


}
