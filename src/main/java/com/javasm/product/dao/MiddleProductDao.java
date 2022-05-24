package com.javasm.product.dao;

import com.javasm.product.bean.MiddleProduct;
import com.javasm.product.bean.vo.ProductNotRecommendVO;

import java.sql.Connection;
import java.util.List;

/**
 * @author: zhaoyuanming
 * @License: (C) Copyright 2022, wtl Corporation Limited.
 * @Contact: 2448429318@qq.com
 * @Date: 2022/5/23 10:42
 * @Version: 1.0
 * @Description:
 */
public interface MiddleProductDao {


    /**
     * 添加关联产品表
     *
     * @param middleProduct
     * @return
     */
    Boolean addMiddleProduct(Connection conn, MiddleProduct middleProduct);


    /**
     * 获得除了选中的id之外的产品列表
     *
     * @param id
     * @return
     */
    public List<ProductNotRecommendVO> getProductWithoutId(Integer id);


    /**
     * 获得选中的id
     *
     * @param id
     * @return
     */
    public List<ProductNotRecommendVO> getProductId(Integer id);
}
