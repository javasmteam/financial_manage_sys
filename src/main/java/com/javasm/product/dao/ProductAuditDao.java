package com.javasm.product.dao;

import com.javasm.product.bean.ProductAudit;
import com.javasm.product.bean.ProductInfo;
import com.javasm.product.bean.vo.ProductInfoVO;


/**
 * <h4>Financial_manage_sys</h4>
 * <p>产品审批dao</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-15 20:46
 * @Version : 1.0
 **/
public interface ProductAuditDao {


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
