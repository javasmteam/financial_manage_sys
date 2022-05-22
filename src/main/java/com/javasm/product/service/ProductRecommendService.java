package com.javasm.product.service;

import com.javasm.product.bean.PageInfo;
import com.javasm.product.bean.ProductAudit;
import com.javasm.product.bean.ProductRecommend;
import com.javasm.product.bean.ProductType;
import com.javasm.product.bean.vo.ProductNotRecommendVO;
import com.javasm.product.bean.vo.ProductRecommendVO;
import com.javasm.product.bean.vo.ProductTypeIdVO;
import com.javasm.product.bean.vo.ProductTypeVO;

import java.util.List;

/**
 * @author: zhaoyuanming
 * @License: (C) Copyright 2022, wtl Corporation Limited.
 * @Contact: 2448429318@qq.com
 * @Date: 2022/5/22 8:15
 * @Version: 1.0
 * @Description:
 */
public interface ProductRecommendService {


    /**
     * 分页查询产品推荐信息
     *
     * @param nowPage
     * @param pageSize
     * @param productTypeIdVO
     * @return
     */
    PageInfo<ProductRecommendVO> getProductTypesByPage(String nowPage, String pageSize, ProductTypeIdVO productTypeIdVO);


    /**
     * 查找没有推荐过的产品信息
     *
     * @return
     */
    List<ProductNotRecommendVO> getProductNotRecommends();


    boolean addProductRecommend(ProductRecommend productRecommend);

    boolean updateProductRecommend(ProductRecommend productRecommend, String productChName);



    ProductRecommend getProductRecommendById(Integer productId);
}
