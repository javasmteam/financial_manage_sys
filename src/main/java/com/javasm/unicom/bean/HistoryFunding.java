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
    private Integer hyFunId;//主键
    private Integer comId;//公司编号
    private String funDate;//投资日期
    private String funType;//投资方式
    private Integer funAmount;//投资金额（百万）
    private Integer afterFunVal;//投后估值（百万）
    private Integer totalShares;//总发行股数（百万）
    private Integer pricePerShare;//每股单价
    private Integer hyFunState;//历史融资表状态
}
