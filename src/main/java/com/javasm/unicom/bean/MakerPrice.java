package com.javasm.unicom.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MakerPrice {

    //挂单价格表
    private Integer makerId;/*主键*/
    private Integer comId;/*企业编号*/
    private Integer makerAmount;/*挂单金额*/
    private Integer tradeAmount;/*交易数量*/
    private Integer makerState;/*挂单表状态  0：买入  1：卖出*/
}
