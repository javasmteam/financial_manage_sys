package com.javasm.product.service.impl;

import com.javasm.product.bean.ProductNetValue;
import com.javasm.product.dao.ProductNetValueDao;
import com.javasm.product.dao.impl.ProductNetValueDaoImpl;
import com.javasm.product.service.ProductNetValueService;

/**
 * @author: zhaoyuanming
 * @License: (C) Copyright 2022, wtl Corporation Limited.
 * @Contact: 2448429318@qq.com
 * @Date: 2022/5/22 0:47
 * @Version: 1.0
 * @Description:
 */
public class ProductNetValueServiceImpl implements ProductNetValueService {
    private final ProductNetValueDao productNetValueDao = new ProductNetValueDaoImpl();

    /**
     * 添加产品净值信息
     *
     * @param productNetValue
     * @return
     */
    @Override
    public Boolean addProductNetValue(ProductNetValue productNetValue) {
        return productNetValueDao.addProductNetValue(productNetValue);
    }

    /**
     * 修改产品净值信息
     *
     * @param productNetValue
     * @return
     */
    @Override
    public Boolean updateProductNetValue(ProductNetValue productNetValue) {
        return productNetValueDao.updateProductNetValue(productNetValue);
    }
}
