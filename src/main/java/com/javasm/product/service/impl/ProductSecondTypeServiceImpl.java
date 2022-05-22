package com.javasm.product.service.impl;


import com.javasm.product.bean.vo.SecValueVO;
import com.javasm.product.dao.ProductSecondTypeDao;
import com.javasm.product.dao.impl.ProductSecondTypeDaoImpl;
import com.javasm.product.service.ProductSecondTypeService;

import java.util.List;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>产品二级分类服务实现</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-21 00:15
 * @Version : 1.0
 **/
public class ProductSecondTypeServiceImpl implements ProductSecondTypeService {
    private final ProductSecondTypeDao productSecondTypeDao = new ProductSecondTypeDaoImpl();
    /**
     * @return
     */
    @Override
    public List<SecValueVO> getAllSecondType() {
        return productSecondTypeDao.queryAllSecondType();
    }
}
