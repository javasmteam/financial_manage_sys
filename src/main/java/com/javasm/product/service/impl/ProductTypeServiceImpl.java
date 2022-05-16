package com.javasm.product.service.impl;

import com.javasm.product.bean.PageInfo;
import com.javasm.product.bean.ProductType;
import com.javasm.product.bean.vo.ProductTypeVO;
import com.javasm.product.dao.ProductTypeDao;
import com.javasm.product.dao.impl.ProductTypeDaoImpl;
import com.javasm.product.service.ProductTypeService;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>产品类别服务实现类</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-16 09:33
 * @Version : 1.0
 **/
public class ProductTypeServiceImpl implements ProductTypeService {
    private final ProductTypeDao productTypeDao = new ProductTypeDaoImpl();

    /**
     * 增加产品信息
     *
     * @param productType 产品系列
     * @return 影响行数
     */
    @Override
    public Boolean addProductType(ProductType productType) {
        return productTypeDao.addProductType(productType);
    }

    /**
     * 更新产品信息
     *
     * @param productType 产品系列
     * @return 影响行数
     */
    @Override
    public Boolean updateProductType(ProductType productType) {
        return productTypeDao.updateProductType(productType);
    }

    /**
     * 查询所有英雄信息
     *
     * @param nowPage     当前页
     * @param pageSize    每页数据量
     * @param productType 产品系列
     * @return 查询到的集合
     */
    @Override
    public PageInfo<ProductTypeVO> getProductTypesByPage(String nowPage, String pageSize, ProductType productType) {
    }
}
