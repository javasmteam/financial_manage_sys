package com.javasm.product.bean;

import lombok.*;

import java.util.Date;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>商品信息</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-15 12:27
 * @Version : 1.0
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductInfo {
    private Integer productId;
    private Integer productTypeId;
    private String regulateBody;
    private String productChName;
    private String productEngName;
    private Float annualYield;
    private String currencyType;
    private Date openTime;
    private Integer subCycle;
    private Float subRate;
    private Float fundManageFeeRate;
    private Float initInvestAmount;
    private String subFeeCollectMethod;
    private Integer redCycle;
    private Float redInitAmount;
    private Float redAmount;
    private Integer lockPeriod;
    private Integer proInfoState;
}
