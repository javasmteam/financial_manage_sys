package com.javasm.product.service;

import com.javasm.product.bean.MiddleProduct;
import com.javasm.product.bean.vo.ProductNotRecommendVO;

import java.util.List;

/**
 * @author: zhaoyuanming
 * @License: (C) Copyright 2022, wtl Corporation Limited.
 * @Contact: 2448429318@qq.com
 * @Date: 2022/5/23 10:45
 * @Version: 1.0
 * @Description:
 */
public interface MiddleProductService {








    /**
     * 获得除了选中的id之外的产品列表
     *
     * @param id
     * @return
     */
    public List<ProductNotRecommendVO> getProductWithoutId(Integer id);

    Boolean addMiddleProduct(Integer id, String[] productBS);
}
