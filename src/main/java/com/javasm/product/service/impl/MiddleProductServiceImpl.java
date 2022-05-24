package com.javasm.product.service.impl;

import com.javasm.product.bean.MiddleProduct;
import com.javasm.product.bean.vo.ProductNotRecommendVO;
import com.javasm.product.dao.MiddleProductDao;
import com.javasm.product.dao.impl.MiddleProductDaoImpl;
import com.javasm.product.service.MiddleProductService;
import com.javasm.util.DataUtil;
import com.javasm.util.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: zhaoyuanming
 * @License: (C) Copyright 2022, wtl Corporation Limited.
 * @Contact: 2448429318@qq.com
 * @Date: 2022/5/23 10:45
 * @Version: 1.0
 * @Description:
 */
public class MiddleProductServiceImpl implements MiddleProductService {
    private final MiddleProductDao middleProductDao = new MiddleProductDaoImpl();


    /**
     * 获得除了选中的id之外的产品列表
     *
     * @param id
     * @return
     */
    @Override
    public List<ProductNotRecommendVO> getProductWithoutId(Integer id) {
        return middleProductDao.getProductWithoutId(id);
    }

    /**
     * 添加关联产品
     * @param id
     * @param productBS
     * @return
     */
    @Override
    public Boolean addMiddleProduct(Integer id, String[] productBS) {
        Connection connection = JDBCUtils.getConn();
        try {
            connection.setAutoCommit(false);
            boolean f = true;
            for (int i = 0; i < productBS.length; i++) {
                MiddleProduct middleProduct1 = new MiddleProduct();
                Integer productB = DataUtil.stringConvertToInteger(productBS[i]);
                middleProduct1.setProductIdB(productB);
                middleProduct1.setProductIdA(id);
                middleProduct1.setProductIdB(productB);
                if (!middleProductDao.addMiddleProduct(connection, middleProduct1)) {
                    f = false;
                    return false;
                }
            }
            if (f) {
                connection.commit();
            } else {
                connection.rollback();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        return true;
    }

    /**
     * 获得选中的id
     *
     * @param id
     * @return
     */
    @Override
    public List<ProductNotRecommendVO> getProductId(Integer id) {
        return middleProductDao.getProductId(id);
    }
}
