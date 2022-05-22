package com.javasm.product.bean.vo;

import lombok.*;

/**
 * @author: zhaoyuanming
 * @License: (C) Copyright 2022, wtl Corporation Limited.
 * @Contact: 2448429318@qq.com
 * @Date: 2022/5/22 8:26
 * @Version: 1.0
 * @Description:
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductRecommendVO {
    private String productChName;
    private Integer productId;
    private Integer recommendLv;
    private Integer isVisible;
    private Integer isIpo;
    private Integer isOnlinePurchase;
    private String recommendReason;
    private Integer recommendState;
}

