package com.javasm.unicom.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BkInvestMoney {

    //充值提现管理
    /**
     * 主键
     */
    private Integer investmoneyid;
    /**
     * 客户ID
     */
    private Integer userid;
    /**
     * 交易类型  1：提现   0：充值
     */
    private Integer investmoneytype;
    /**
     * 交易金额   单位：千
     */
    private Float investmoney;
    /**
     * 请求时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date investrequesttime;
    /**
     * 处理时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date investhandletime;
    /**
     * 银行代码
     */
    private Integer investbankcode;
    /**
     * 汇款状态  0：未汇款   1：已到PTN账号  2:已到汇款到用户
     */
    private Integer investstate ;
    /**
     * 状态  1：可用   0：删除
     */
    private Integer state;

    private String userName;

    private String userCode;



}
