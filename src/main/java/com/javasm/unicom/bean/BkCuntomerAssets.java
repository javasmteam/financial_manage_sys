package com.javasm.unicom.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * <h4>financial_manage_sys</h4>
 * <p>银行客户资产类</p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-16 10:37
 * @Version : 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BkCuntomerAssets {
    /**
     * 主键
     */
    private Integer customerId;
    /**
     * 客户ID
     */
    private Integer userId;
    /**
     * 企业Id，用户持股票公司Id
     */
    private Integer coBusinessId;
    /**
     * 持有数量  1手=100股
     */
    private Integer holdNumber;
    /**
     * 成本价格，买入时每股单价
     */
    private Float holdMoney;
    /**
     * 状态  1：可用  0：删除
     */
    private Integer state;
}
