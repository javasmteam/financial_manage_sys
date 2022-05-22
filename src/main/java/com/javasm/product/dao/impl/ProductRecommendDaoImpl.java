package com.javasm.product.dao.impl;

import com.javasm.product.bean.PageInfo;
import com.javasm.product.bean.ProductAudit;
import com.javasm.product.bean.ProductRecommend;
import com.javasm.product.bean.vo.ProductNotRecommendVO;
import com.javasm.product.bean.vo.ProductRecommendVO;
import com.javasm.product.bean.vo.ProductTypeIdVO;
import com.javasm.product.dao.ProductRecommendDao;
import com.javasm.util.JDBCUtils;

import java.util.List;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>产品推荐dao实现类</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-15 20:46
 * @Version : 1.0
 **/
public class ProductRecommendDaoImpl implements ProductRecommendDao {

    @Override
    public Integer count(ProductTypeIdVO productTypeIdVO) {
        StringBuilder sql = new StringBuilder("select count(product_info.product_id)\n" +
                "from product_recommend,\n" +
                "     product_info\n" +
                "where product_info.product_id = product_recommend.product_id\n" +
                "  and pro_info_state = 1\n" +
                "  and recommend_state = 1");
        if (productTypeIdVO.getProductSeriesId() != null) {
            sql.append("  and product_series_id = ").append(productTypeIdVO.getProductSeriesId());
        }
        if (productTypeIdVO.getProductTypeChName() != null && !"".equals(productTypeIdVO.getProductTypeChName())) {
            sql.append("  and product_ch_name like '%").append(productTypeIdVO.getProductTypeChName()).append("%'");
        }
        return JDBCUtils.size(sql.toString());
    }

    /**
     * 分页查询产品推荐数据
     *
     * @param page
     * @param productTypeIdVO
     * @return
     */
    @Override
    public List<ProductRecommendVO> queryProductRecommendsByPage(PageInfo<ProductRecommendVO> page, ProductTypeIdVO productTypeIdVO) {
        StringBuilder sql = new StringBuilder("select product_recommend.product_id, product_ch_name, recommend_lv, is_ipo, is_online_purchase\n" +
                "from product_info,\n" +
                "     product_recommend\n" +
                "\n" +
                "where product_info.product_id = product_recommend.product_id\n" +
                "  and pro_info_state = 1\n" +
                "  and recommend_state = 1");
        if (productTypeIdVO.getProductSeriesId() != null) {
            sql.append("  and product_series_id = ").append(productTypeIdVO.getProductSeriesId());
        }
        if (productTypeIdVO.getProductTypeChName() != null && !"".equals(productTypeIdVO.getProductTypeChName())) {
            sql.append("  and product_ch_name like '%").append(productTypeIdVO.getProductTypeChName()).append("%'");
        }
        sql.append(" limit ?,?;");
        return JDBCUtils.query(sql.toString(), ProductRecommendVO.class, page.getStartIndex(), page.getPageNum());
    }

    /**
     * 查找没有推荐过的产品信息
     *
     * @return
     */
    @Override
    public List<ProductNotRecommendVO> queryProductNotRecommends() {
        String sql = JDBCUtils.getSql("findNotRecommendProductInfo");
        return JDBCUtils.query(sql, ProductNotRecommendVO.class);
    }

    /**
     * @param productRecommend
     * @return
     */
    @Override
    public boolean addProductRecommend(ProductRecommend productRecommend) {
        return JDBCUtils.insert("product_recommend", productRecommend) > 0;
    }

    /**
     * @param productRecommend
     * @return
     */
    @Override
    public boolean updateProductRecommend(ProductRecommend productRecommend, String productChName) {
        String sql = JDBCUtils.getSql("changeProductRecommend");
        return JDBCUtils.update(sql, productChName, productRecommend.getRecommendLv(), productRecommend.getIsVisible(), productRecommend.getIsIpo(),
                productRecommend.getIsOnlinePurchase(), productRecommend.getRecommendReason(), productRecommend.getProductId()) > 0;
    }

    /**
     * @param productId
     * @return
     */
    @Override
    public ProductRecommend queryProductRecommendById(Integer productId) {
        String sql = JDBCUtils.getSql("findProductRecommendById");
        return JDBCUtils.find(sql, ProductRecommend.class, productId);
    }


}
