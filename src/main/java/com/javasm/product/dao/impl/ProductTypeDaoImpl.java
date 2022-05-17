package com.javasm.product.dao.impl;

import com.javasm.product.bean.PageInfo;
import com.javasm.product.bean.ProductType;
import com.javasm.product.bean.vo.ProductTypeVO;
import com.javasm.product.dao.ProductTypeDao;
import com.javasm.util.JDBCUtils;

import java.util.List;

import static com.javasm.util.JDBCUtils.query;
import static com.javasm.util.JDBCUtils.update;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>产品类别dao实现类</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-15 20:44
 * @Version : 1.0
 **/
public class ProductTypeDaoImpl implements ProductTypeDao {
    /**
     * 增加产品信息
     *
     * @param productType 产品系列
     * @return 影响行数
     */
    @Override
    public Boolean addProductType(ProductType productType) {
        return JDBCUtils.insert("product_type", productType) > 0;
    }

    /**
     * 更新产品类别
     *
     * @param productType 产品系列
     * @return 影响行数
     */
    @Override
    public Boolean updateProductType(ProductType productType) {
        String sql = JDBCUtils.getSql("changeProductType");
        return update(sql, productType.getProductParentId(), productType.getProductChannel(), productType.getProductTypeChName(),
                productType.getProductTypeEngName(), productType.getProductTypeState(), productType.getProductSeriesId()) > 0;
    }

    /**
     * 查询商品类别总条数
     *
     * @param productType 产品系列
     * @return 影响行数
     */
    @Override
    public Integer count(ProductType productType) {
        StringBuilder sql = new StringBuilder("select count(product_type.product_series_id)\n" +
                "from product_type\n" +
                "where product_type_lv = 1");
        String appendSql = String.valueOf(appendLikeSql(productType, sql));
        return Math.toIntExact(JDBCUtils.size(appendSql));
    }

    /**
     * 分页查询英雄信息
     *
     * @param page        分页信息
     * @param productType 产品系列
     * @return 影响行数
     */
    @Override
    public List<ProductTypeVO> queryProductTypesByPage(PageInfo<ProductTypeVO> page, ProductType productType) {
        StringBuilder sql = new StringBuilder("select product_type.product_series_id,\n" +
                "       product_type_ch_name,\n" +
                "       product_type_eng_name,\n" +
                "       remit_info_summary,\n" +
                "       rec_bank_name,\n" +
                "       swift_code,\n" +
                "       bank_code,\n" +
                "       cnaps_id,\n" +
                "       rec_bank_area,\n" +
                "       rec_bank_city,\n" +
                "       rec_account_name,\n" +
                "       rec_account,\n" +
                "       rec_location,\n" +
                "       regulate_body\n" +
                "from product_type,\n" +
                "     remit_info\n" +
                "where product_type.product_series_id = remit_info.product_series_id");
        StringBuilder appendSql = appendLikeSql(productType, sql).append(" limit ?,?");
        return query(appendSql.toString(), ProductTypeVO.class, page.getStartIndex(), page.getPageNum());
    }

    private StringBuilder appendLikeSql(ProductType productType, StringBuilder sql) {
        if (productType != null) {
            if (productType.getProductSeriesId() != null) {
                sql.append("  and product_series_id like '%").append(productType.getProductSeriesId()).append("%'");
            }
            if (productType.getProductTypeChName() != null && !"".equals(productType.getProductTypeChName())) {
                sql.append("  and product_type_ch_name like '%").append(productType.getProductTypeChName()).append("%'");
            }
            if (productType.getProductTypeEngName() != null && !"".equals(productType.getProductTypeEngName())) {
                sql.append("  and product_type_eng_name like '%").append(productType.getProductTypeEngName()).append("%'");
            }
        }
        return sql;
    }
}


