package com.javasm.product.service.impl;

import com.javasm.product.bean.ProductAudit;
import com.javasm.product.bean.vo.ProductInfoVO;
import com.javasm.product.dao.ProductAuditDao;
import com.javasm.product.dao.impl.ProductAuditDaoImpl;
import com.javasm.product.service.ProductAuditService;

/**
 * @author: zhaoyuanming
 * @License: (C) Copyright 2022, wtl Corporation Limited.
 * @Contact: 2448429318@qq.com
 * @Date: 2022/5/21 22:52
 * @Version: 1.0
 * @Description:
 */
public class ProductAuditServiceImpl implements ProductAuditService {
    private final ProductAuditDao productAuditDao = new ProductAuditDaoImpl();

    /**
     * 添加产品审核信息
     *
     * @param productAudit
     * @return
     */
    @Override
    public Boolean addProductAudit(ProductAudit productAudit) {
        return productAuditDao.addProductAudit(productAudit);
    }


    /**
     * 产品审核
     *
     * @param productAudit
     * @return
     */
    @Override
    public Boolean updateProductAuditInfo(ProductAudit productAudit) {
        return productAuditDao.updateProductAuditInfo(productAudit);
    }

    /**
     * 修改产品审核
     *
     * @param productInfoVO
     * @return
     */
    @Override
    public boolean updateProductAudit(ProductInfoVO productInfoVO) {
        return productAuditDao.updateProductAudit(productInfoVO);
    }


}
