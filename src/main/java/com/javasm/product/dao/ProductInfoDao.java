package com.javasm.product.dao;

import com.javasm.product.bean.PageInfo;
import com.javasm.product.bean.ProductInfo;
import com.javasm.product.bean.ProductType;
import com.javasm.product.bean.vo.ProductInfoVO;
import com.javasm.product.bean.vo.ProductTypeVO;

import java.util.List;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>产品信息dao</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-15 20:41
 * @Version : 1.0
 **/
public interface ProductInfoDao {


    /**
     * 增加产品信息
     *
     * @param productInfo 产品信息
     * @return 影响行数
     */
    Boolean addProductInfo(ProductInfo productInfo);


    /**
     * 删除商品信息
     *
     * @param id
     * @return
     */
    Boolean deleteProductInfo(Integer id);

    /**
     * 更新产品信息
     *
     * @param productInfo 产品信息
     * @return 影响行数
     */
    Boolean updateProductInfo(ProductInfo productInfo);


    Integer count(ProductInfoVO productInfoVO);

    /**
     * 分页查询产品信息
     *
     * @param page          分页信息
     * @param productInfoVO 产品信息vo
     * @return 查询vo集合
     */
    List<ProductInfoVO> queryProductInfoByPage(PageInfo<ProductInfoVO> page, ProductInfoVO productInfoVO);
}
