package com.javasm.product.dao.impl;

import com.javasm.product.bean.PageInfo;
import com.javasm.product.bean.ProductType;
import com.javasm.product.bean.vo.ProductTypeIdVO;
import com.javasm.product.bean.vo.ProductTypeVO;
import com.javasm.product.bean.vo.SecValueVO;
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
        return update(sql, productType.getProductParentId(), productType.getProductChannel(), productType.getProductTypeChName(), productType.getProductTypeEngName(), productType.getProductTypeState(), productType.getProductSeriesId()) > 0;
    }

    /**
     * 根据id连表修改状态
     *
     * @param id
     * @return
     */
    @Override
    public Boolean deleteProductTypeById(Integer id) {
        String sql = JDBCUtils.getSql("deleteProductType");

        return JDBCUtils.update(sql, id) > 0;
    }

    /**
     * 查询商品类别总条数
     *
     * @param productType 产品系列
     * @return 影响行数
     */
    @Override
    public Integer count(ProductType productType) {
        StringBuilder sql = new StringBuilder("select count(product_type.product_series_id)\n" + "from product_type,\n" + "     remit_info\n" + "where product_type.product_series_id = remit_info.product_series_id\n" + "  and product_type.product_type_state = 1\n" + "  and remit_state = 1");
        String appendSql = String.valueOf(appendLikeSql(productType, sql));
        return JDBCUtils.size(appendSql);
    }

    /**
     * 单表查询总条数
     *
     * @return
     */
    @Override
    public Integer count() {
        String sql = JDBCUtils.getSql("countProductType");
        ProductType productType = JDBCUtils.find(sql, ProductType.class);
        assert productType != null;
        return productType.getProductSeriesId();

    }


    /**
     * 分页查询信息
     *
     * @param page        分页信息
     * @param productType 产品系列
     * @return 影响行数
     */
    @Override
    public List<ProductTypeVO> queryProductTypesByPage(PageInfo<ProductTypeVO> page, ProductType productType) {
        StringBuilder sql = new StringBuilder("select product_type.product_series_id,\n" +
                "       product_type_ch_name,\n" + "       product_type_eng_name,\n" +
                "       remit_info_summary,\n" + "       rec_bank_name,\n" + "       " +
                "swift_code,\n" + "       bank_code,\n" + "       cnaps_id,\n" +
                "       rec_bank_area,\n" + "       rec_bank_city,\n" +
                "       rec_account_name,\n" + "       rec_account,\n" + "       rec_location,\n"
                + "       regulate_body\n" + "from  product_type left join \n" + "    remit_info \n" +
                "on product_type.product_series_id = remit_info.product_series_id\n" +
                "  where product_type.product_type_state = 1\n" + "  and remit_state = 1");
        StringBuilder appendSql = appendLikeSql(productType, sql).append(" limit ?,?");
        return query(appendSql.toString(), ProductTypeVO.class, page.getStartIndex(), page.getPageNum());
    }

    private StringBuilder appendLikeSql(ProductType productType, StringBuilder sql) {
        if (productType != null) {
            if (productType.getProductSeriesId() != null) {
                sql.append("  and product_type.product_series_id like '%").append(productType.getProductSeriesId()).append("%'");
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


    /**
     * @param productSeriesId
     * @return
     */
    @Override
    public ProductType findProductTypeById(Integer productSeriesId) {
        String sql = JDBCUtils.getSql("findProductTypeById");
        return JDBCUtils.find(sql, ProductType.class, productSeriesId);
    }

    /**
     * 寻找产品类型
     *
     * @return
     */
    @Override
    public List<ProductTypeIdVO> findProductTypeId() {
        String sql = JDBCUtils.getSql("findProductTypeId");
        return query(sql, ProductTypeIdVO.class);
    }

    /**
     * @return
     */
    @Override
    public List<ProductTypeIdVO> queryAllProductSeries() {
        String sql = JDBCUtils.getSql("findAllProductSeries");
        return JDBCUtils.query(sql, ProductTypeIdVO.class);
    }
}


