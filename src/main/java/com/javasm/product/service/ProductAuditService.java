package com.javasm.product.service;

import com.javasm.product.bean.ProductAudit;
import com.javasm.product.bean.vo.ProductInfoVO;

/**
 * @author: zhaoyuanming
 * @License: (C) Copyright 2022, wtl Corporation Limited.
 * @Contact: 2448429318@qq.com
 * @Date: 2022/5/21 22:52
 * @Version: 1.0
 * @Description:
 */
public interface ProductAuditService {
    /**
     * 添加产品审核信息
     *
     * @param productAudit
     * @return
     */
    Boolean addProductAudit(ProductAudit productAudit);


    /**
     * 产品审核
     *
     * @param productAudit
     * @return
     */
    Boolean updateProductAuditInfo(ProductAudit productAudit);

    /**
     * 修改产品审核
     *
     * @param productInfoVO
     * @return
     */
    boolean updateProductAudit(ProductInfoVO productInfoVO);
}
