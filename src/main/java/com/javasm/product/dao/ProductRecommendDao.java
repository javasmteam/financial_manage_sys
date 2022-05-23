package com.javasm.product.dao;

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
 * <h4>Financial_manage_sys</h4>
 * <p>产品推荐dao</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-15 20:45
 * @Version : 1.0
 **/
public interface ProductRecommendDao {


    /**
     * 查询商品推荐总条数
     *
     * @param productTypeIdVO 产品推荐
     * @return 影响行数
     */
    Integer count(ProductTypeIdVO productTypeIdVO);


    /**
     * 分页查询产品推荐数据
     *
     * @param page
     * @param productTypeIdVO
     * @return
     */
    List<ProductRecommendVO> queryProductRecommendsByPage(PageInfo<ProductRecommendVO> page, ProductTypeIdVO productTypeIdVO);


    /**
     * 查找没有推荐过的产品信息
     *
     * @return
     */
    List<ProductNotRecommendVO> queryProductNotRecommends();


    /**
     * 添加产品推荐
     *
     * @param productRecommend
     * @return
     */
    boolean addProductRecommend(ProductRecommend productRecommend);


    /**
     * 更新产品推荐
     *
     * @param productRecommend
     * @param productChName
     * @return
     */
    boolean updateProductRecommend(ProductRecommend productRecommend, String productChName);


    /**
     * 根据id查询产品推荐
     *
     * @param productId
     * @return
     */
    ProductRecommend queryProductRecommendById(Integer productId);


}
