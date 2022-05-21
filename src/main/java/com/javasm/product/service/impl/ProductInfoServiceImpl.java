package com.javasm.product.service.impl;

import com.javasm.product.bean.PageInfo;
import com.javasm.product.bean.ProductInfo;
import com.javasm.product.bean.vo.ProductInfoVO;
import com.javasm.product.dao.ProductInfoDao;
import com.javasm.product.dao.impl.ProductInfoDaoImpl;
import com.javasm.product.service.ProductInfoService;

import java.util.List;

/**
 * <h4>Financial_manage_sys</h4>
 * <p></p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-19 03:03
 * @Version : 1.0
 **/
public class ProductInfoServiceImpl implements ProductInfoService {
    private final ProductInfoDao productInfoDao = new ProductInfoDaoImpl();

    /**
     * 增加产品信息
     *
     * @param productInfo 产品信息
     * @return 影响行数
     */
    @Override
    public Boolean addProductInfo(ProductInfo productInfo) {
        return productInfoDao.addProductInfo(productInfo);
    }

    /**
     * 删除商品信息
     *
     * @param id
     * @return
     */
    @Override
    public Boolean deleteProductInfo(Integer id) {
        return productInfoDao.deleteProductInfo(id);
    }

    /**
     * 更新产品信息
     *
     * @param productInfo 产品信息
     * @return 影响行数
     */
    @Override
    public Boolean updateProductInfo(ProductInfo productInfo) {
        return null;
    }

    /**
     * 查询商品信息总条数
     *
     * @param productInfoVO 产品信息vo类
     * @return 影响行数
     */
    @Override
    public Integer count(ProductInfoVO productInfoVO) {
        return productInfoDao.count(productInfoVO);
    }


    /**
     * 分页查询产品信息
     *
     * @param nowPage
     * @param pageSize
     * @param productInfo
     * @return
     */
    @Override
    public PageInfo<ProductInfoVO> getProductInfoByPage(String nowPage, String pageSize, ProductInfoVO productInfo) {
        Integer count = productInfoDao.count(productInfo);
        PageInfo<ProductInfoVO> pageInfo = new PageInfo<>(nowPage, pageSize, count);
        List<ProductInfoVO> productInfoByPage = productInfoDao.queryProductInfoByPage(pageInfo, productInfo);
        pageInfo.setDataList(productInfoByPage);
        return pageInfo;
    }

}
