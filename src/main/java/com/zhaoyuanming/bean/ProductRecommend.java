package com.zhaoyuanming.bean;

import lombok.*;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>产品推荐</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-15 18:27
 * @Version : 1.0
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductRecommend {
    private Integer recommendId;
    private Integer productId;
    private Integer recommendLv;
    private Integer isVisible;
    private Integer isIpo;
    private Integer isOnlinePurchase;
    private String recommendReason;
}
