package com.javasm.product.service;

import com.javasm.product.bean.ProductNetValue;

/**
 * @author: zhaoyuanming
 * @License: (C) Copyright 2022, wtl Corporation Limited.
 * @Contact: 2448429318@qq.com
 * @Date: 2022/5/22 0:47
 * @Version: 1.0
 * @Description:
 */
public interface ProductNetValueService {
    /**
     * 添加产品净值信息
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
