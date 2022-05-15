package com.javasm.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BkInvestMoney {

    //充值提现管理
    private Integer investMoneyId;//主键
    private Integer userId;//客户ID
    private Integer investMoneyType;//交易类型  1：提现   0：充值
    private Float investMoney;//交易金额   单位：千
    private String investRequestTime;//请求时间
    private String investHandleTime;//处理时间
    private Integer investBankCode;//银行代码
    private Integer investState ;//汇款状态  0：未汇款   1：已到PTN账号
    private Integer state;//状态  1：可用   0：删除


}
