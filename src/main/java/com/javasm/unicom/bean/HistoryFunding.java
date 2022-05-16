package com.javasm.unicom.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class HistoryFunding {

    //历史融资表
    /**
     * 主键
     */
    private Integer hyFunId;
    /**
     * 公司编号
     */
    private Integer comId;
    /**
     * 投资日期
     */
    private String funDate;
    /**
     * 投资方式
     */
    private String funType;
    /**
     * 投资金额（百万）
     */
    private Integer funAmount;
    /**
     * 投后估值（百万）
     */
    private Integer afterFunVal;
    /**
     * 总发行股数（百万）
     */
    private Integer totalShares;
    /**
     * 每股单价
     */
    private Integer pricePerShare;
    /**
     * 历史融资表状态
     */
    private Integer hyFunState;
}
