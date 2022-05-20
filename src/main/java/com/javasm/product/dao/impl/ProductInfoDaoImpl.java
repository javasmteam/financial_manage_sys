package com.javasm.product.dao.impl;

import com.javasm.product.bean.PageInfo;
import com.javasm.product.bean.ProductInfo;
import com.javasm.product.bean.vo.ProductInfoVO;
import com.javasm.product.dao.ProductInfoDao;
import com.javasm.util.JDBCUtils;

import java.util.List;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>产品信息dao实现类</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-15 20:42
 * @Version : 1.0
 **/
public class ProductInfoDaoImpl implements ProductInfoDao {

    /**
     * 增加产品信息
     *
     * @param productInfo 产品信息
     * @return 影响行数
     */
    @Override
    public Boolean addProductInfo(ProductInfo productInfo) {
        return JDBCUtils.insert("product_info", productInfo) > 0;
    }

    /**
     * 删除产品信息
     *
     * @param id
     * @return
     */
    @Override
    public Boolean deleteProductInfo(Integer id) {
        String sql = JDBCUtils.getSql("deleteProductInfo");
        return JDBCUtils.update(sql, id) > 0;
    }

    /**
     * 更新产品信息
     *
     * @param productInfo 产品信息
     * @return 影响行数
     */
    @Override
    public Boolean updateProductInfo(ProductInfo productInfo) {
        String sql = JDBCUtils.getSql("changeProductInfo");
        return JDBCUtils.update(sql, productInfo) > 0;
    }

    /**
     * 查询商品信息总条数
     *
     * @param productInfoVO 产品信息vo
     * @return 影响行数
     */
    @Override
    public Integer count(ProductInfoVO productInfoVO) {
        StringBuilder sql = new StringBuilder("select count(*)\n" +
                "from (select product_info.product_id,\n" +
                "             product_ch_name,\n" +
                "             product_type_ch_name,\n" +
                "             sec_name,\n" +
                "             regulate_body,\n" +
                "             open_time,\n" +
                "             currency_type,\n" +
                "             audit_type,\n" +
                "             unit_net,\n" +
                "             unit_date,\n" +
                "             sum_increase_rate,\n" +
                "             annual_yield,\n" +
                "             sub_cycle,\n" +
                "             fund_manage_fee_rate,\n" +
                "             sub_rate,\n" +
                "             init_invest_amount,\n" +
                "             sub_fee_collect_method,\n" +
                "             red_cycle,\n" +
                "             red_init_amount,\n" +
                "             red_amount,\n" +
                "             lock_period,\n" +
                "             auditor\n" +
                "      from product_info,\n" +
                "           product_audit,\n" +
                "           product_net_value,\n" +
                "           product_type,\n" +
                "           product_second_type\n" +
                "      where product_info.product_id = product_audit.product_id\n" +
                "        and product_info.product_series_id = product_type.product_series_id\n" +
                "        and product_info.product_id = product_audit.product_id\n" +
                "        and product_info.sec_id = product_second_type.sec_id\n" +
                "        and audit_state = 1\n" +
                "        and pro_info_state = 1\n" +
                "        and net_value_state = 1\n" +
                "        and audit_state = 1");
        StringBuilder appendSql = appendSql(productInfoVO, sql);
        appendSql.append("      group by product_id\n" +
                "      limit ?,?) as pipa;");
        return JDBCUtils.size(appendSql.toString());
    }

    /**
     * 分页查询产品信息
     *
     * @param page          分页信息
     * @param productInfoVO 产品信息vo
     * @return 查询vo集合
     */
    @Override
    public List<ProductInfoVO> queryProductInfoByPage(PageInfo<ProductInfoVO> page, ProductInfoVO productInfoVO) {
        StringBuilder sql = new StringBuilder("select product_info.product_id,\n" +
                "       product_ch_name,\n" +
                "       product_type_ch_name,\n" +
                "       product_info.product_series_id,\n" +
                "       product_info.product_type_id,\n" +
                "       regulate_body,\n" +
                "       open_time,\n" +
                "       currency_type,\n" +
                "       audit_type,\n" +
                "       unit_net,\n" +
                "       unit_date,\n" +
                "       sum_increase_rate,\n" +
                "       annual_yield,\n" +
                "       sub_cycle,\n" +
                "       fund_manage_fee_rate,\n" +
                "       sub_rate,\n" +
                "       init_invest_amount,\n" +
                "       sub_fee_collect_method,\n" +
                "       red_cycle,\n" +
                "       red_init_amount,\n" +
                "       red_amount,\n" +
                "       lock_period,\n" +
                "       auditor\n" +
                "from product_info,\n" +
                "     product_audit,\n" +
                "     product_net_value,\n" +
                "     product_type\n" +
                "where product_info.product_id = product_audit.product_id\n" +
                "  and product_info.product_series_id = product_type.product_series_id\n" +
                "  and product_info.product_id = product_audit.product_id\n" +
                "  and audit_state = 1\n" +
                "  and pro_info_state = 1\n" +
                "  and net_value_state = 1\n" +
                "  and audit_state = 1");
        StringBuilder appendSql = appendSql(productInfoVO, sql);
        appendSql.append(" group by product_id\n" +
                "limit ?,?;");
        return JDBCUtils.query(appendSql.toString(), ProductInfoVO.class, page.getStartIndex(), page.getPageNum());
    }

    private StringBuilder appendSql(ProductInfoVO productInfoVO, StringBuilder sql) {
        if (productInfoVO.getProductChName() != null && !"".equals(productInfoVO.getProductChName())) {
            sql.append("  and product_ch_name like '%").append(productInfoVO.getProductChName()).append("%'");
        }
        if (productInfoVO.getSecId() != null) {
            sql.append("  and product_info.sec_id = ?").append(productInfoVO.getSecId());
        }
        if (productInfoVO.getAuditType() != null) {
            sql.append("  and audit_type = ?").append(productInfoVO.getAuditType());
        }
        return sql;
    }
}
