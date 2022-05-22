package com.javasm.product.dao.impl;

import com.javasm.product.bean.vo.SecValueVO;
import com.javasm.product.dao.ProductSecondTypeDao;
import com.javasm.util.JDBCUtils;

import java.util.List;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>产品二级分类dao实现类</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-21 00:01
 * @Version : 1.0
 **/
public class ProductSecondTypeDaoImpl implements ProductSecondTypeDao {

    @Override
    public List<SecValueVO> queryAllSecondType() {
        String sql = JDBCUtils.getSql("findAllProductSecondType");
        return JDBCUtils.query(sql, SecValueVO.class);
    }
}
