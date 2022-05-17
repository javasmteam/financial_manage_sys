package com.javasm.product.bean;

import lombok.*;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>产品类型</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-15 19:16
 * @Version : 1.0
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductType {
    private Integer productSeriesId;
    private Integer productParentId;
    private String productChannel;
    private String productTypeChName;
    private String productTypeEngName;
    private Integer productTypeLv;
    private Integer productTypeState;
}
