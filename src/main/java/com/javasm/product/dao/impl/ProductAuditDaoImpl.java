package com.javasm.product.dao.impl;

import com.javasm.product.bean.ProductAudit;
import com.javasm.product.bean.vo.ProductInfoVO;
import com.javasm.product.dao.ProductAuditDao;
import com.javasm.util.JDBCUtils;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>产品审批dao实现类</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-15 20:47
 * @Version : 1.0
 **/
public class ProductAuditDaoImpl implements ProductAuditDao {
    /**
     * 添加产品审核信息
     *
     * @param productAudit
     * @return
     */
    @Override
    public Boolean addProductAudit(ProductAudit productAudit) {

        return JDBCUtils.insert("product_audit", productAudit) > 0;
    }

    /**
     * 产品审核
     *
     * @param productAudit
     * @return
     */
    @Override
    public Boolean updateProductAuditInfo(ProductAudit productAudit) {
        String sql = JDBCUtils.getSql("updateProductAuditInfo");
        return JDBCUtils.update(sql, productAudit.getAuditType(), productAudit.getAuditorOpinion(), productAudit.getProductId()) > 0;
    }

    /**
     * 修改产品审核
     *
     * @param productInfoVO
     * @return
     */
    @Override
    public boolean updateProductAudit(ProductInfoVO productInfoVO) {
        String sql = JDBCUtils.getSql("changeProductAuditInfo");
        return JDBCUtils.update(sql, productInfoVO.getAuditor(), productInfoVO.getProductId()) > 0;
    }
}
