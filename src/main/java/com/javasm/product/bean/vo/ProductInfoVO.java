package com.javasm.product.bean.vo;

import lombok.*;

import java.util.Date;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>产品信息vo类</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-16 17:07
 * @Version : 1.0
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductInfoVO {
    private Integer productId;
    private Integer productSeriesId;
    private String regulateBody;
    private String productChName;
    private Float annualYield;
    private String currencyType;
    private Date openTime;
    private Integer subCycle;
    private Float fundManageFeeRate;
    private Float subRate;
    private Float initInvestAmount;
    private String subFeeCollectMethod;
    private Integer redCycle;
    private Float redInitAmount;
    private Float redAmount;
    private Integer lockPeriod;
    private Integer proInfoState;
    private Integer auditType;
    private String auditor;
    private Float unitNet;
    private Date unitDate;
    private Float sumIncreaseRate;
}
