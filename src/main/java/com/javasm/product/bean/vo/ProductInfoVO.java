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
public class ProductInfoVO{

    private String productChName;
    private String productTypeChName;

    private Integer productTypeId;
    private Integer productParentId;

    private String regulateBody;
    private Date openTime;
    private String currencyType;
    private Integer auditState;
    private Float annualYield;
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
