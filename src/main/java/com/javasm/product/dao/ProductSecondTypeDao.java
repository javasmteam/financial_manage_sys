package com.javasm.product.dao;

import com.javasm.product.bean.Value;

import java.util.List;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>产品二级分类dao</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-20 23:54
 * @Version : 1.0
 **/
public interface ProductSecondTypeDao {

    List<Value> queryAllSecondType();
}
