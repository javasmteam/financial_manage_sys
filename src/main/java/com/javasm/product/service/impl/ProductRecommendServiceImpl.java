package com.javasm.product.service.impl;


import com.javasm.product.bean.PageInfo;
import com.javasm.product.bean.ProductAudit;
import com.javasm.product.bean.ProductRecommend;
import com.javasm.product.bean.vo.ProductNotRecommendVO;
import com.javasm.product.bean.vo.ProductRecommendVO;
import com.javasm.product.bean.vo.ProductTypeIdVO;
import com.javasm.product.dao.ProductRecommendDao;
import com.javasm.product.dao.impl.ProductRecommendDaoImpl;
import com.javasm.product.service.ProductRecommendService;

import java.util.List;

/**
 * @author: zhaoyuanming
 * @License: (C) Copyright 2022, wtl Corporation Limited.
 * @Contact: 2448429318@qq.com
 * @Date: 2022/5/22 8:15
 * @Version: 1.0
 * @Description:
 */
public class ProductRecommendServiceImpl implements ProductRecommendService {
    private final ProductRecommendDao productRecommendDao = new ProductRecommendDaoImpl();

    /**
     * @param nowPage
     * @param pageSize
     * @param productTypeIdVO
     * @return
     */
    @Override
    public PageInfo<ProductRecommendVO> getProductTypesByPage(String nowPage, String pageSize, ProductTypeIdVO productTypeIdVO) {
        Integer count = productRecommendDao.count(productTypeIdVO);
        PageInfo<ProductRecommendVO> pageInfo = new PageInfo<>(nowPage, pageSize, count);
        List<ProductRecommendVO> recommendVOList = productRecommendDao.queryProductRecommendsByPage(pageInfo, productTypeIdVO);
        pageInfo.setDataList(recommendVOList);
        return pageInfo;
    }

    /**
     * 查找没有推荐过的产品信息
     *
     * @return
     */
    @Override
    public List<ProductNotRecommendVO> getProductNotRecommends() {
        return productRecommendDao.queryProductNotRecommends();
    }

    /**
     * @param productRecommend
     * @return
     */
    @Override
    public boolean addProductRecommend(ProductRecommend productRecommend) {
        return productRecommendDao.addProductRecommend(productRecommend);
    }

    /**
     * @param productRecommend
     * @return
     */
    @Override
    public boolean updateProductRecommend(ProductRecommend productRecommend, String productChName) {
        return productRecommendDao.updateProductRecommend(productRecommend,productChName);
    }

    /**
     * @param productId
     * @return
     */
    @Override
    public ProductRecommend getProductRecommendById(Integer productId) {
        return productRecommendDao.queryProductRecommendById(productId);
    }

}
