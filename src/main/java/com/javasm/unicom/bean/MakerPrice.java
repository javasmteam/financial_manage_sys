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


    /**
     * 主键
     */
    private Integer makerId;
    /**
     * 企业编号
     */
    private Integer comId;
    /**
     * 挂单金额
     */
    private Integer makerAmount;
    /**
     * 交易数量
     */
    private Integer tradeAmount;
    /**
     * 挂单表状态  0：买入  1：卖出
     */
    private Integer makerState;
}
