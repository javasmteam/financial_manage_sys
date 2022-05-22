package com.javasm.product.bean.vo;

import com.alibaba.fastjson.annotation.JSONField;
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
    private Integer secId;
    private String secName;
    private String regulateBody;
    private String productChName;
    private String productTypeChName;
    private Float annualYield;
    private Integer currencyType;
    @JSONField(format = "yyyy-MM-dd")
    private Date openTime;
    private Integer subCycle;
    private Float fundManageFeeRate;
    private Float subRate;
    private Float initInvestAmount;
    private Integer subFeeCollectMethod;
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
