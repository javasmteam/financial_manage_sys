package com.javasm.product.service;

import com.javasm.product.bean.PageInfo;
import com.javasm.product.bean.ProductInfo;
import com.javasm.product.bean.ProductType;
import com.javasm.product.bean.vo.ProductInfoVO;
import com.javasm.product.bean.vo.ProductTypeVO;

import java.util.List;

/**
 * <h4>Financial_manage_sys</h4>
 * <p></p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-19 03:02
 * @Version : 1.0
 **/
public interface ProductInfoService {

    /**
     * 增加产品信息
     *
     * @param productInfo 产品信息
     * @return 影响行数
     */
    Boolean addProductInfo(ProductInfo productInfo);


    /**
     * 更新产品信息
     *
     * @param productInfo 产品信息
     * @return 影响行数
     */
    Boolean updateProductInfo(ProductInfo productInfo);

    /**
     * 查询商品信息总条数
     *
     * @param productInfoVO 产品信息vo类
     * @return 影响行数
     */
    Integer count(ProductInfoVO productInfoVO);


    /**
     * 分页查询商品信息
     *
     * @param nowPage
     * @param pageSize
     * @param productInfoVO
     * @return
     */
    PageInfo<ProductInfoVO> getProductInfoByPage(String nowPage, String pageSize, ProductInfoVO productInfoVO);
}
