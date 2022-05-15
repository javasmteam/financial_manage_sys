package com.javasm.bean;

import lombok.*;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>汇款信息</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-15 21:59
 * @Version : 1.0
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RemitInfo {
    private Integer remitId;
    private Integer productTypeId;
    private Integer userId;
    private String remitPostscript;
    private String remitInfoSummary;
    private String recBankName;
    private String swiftCode;
    private String bankCode;
    private String cnapsId;
    private String recBankArea;
    private String recBankCity;
    private String recAccountName;
    private String recAccount;
    private String recLocation;
    private Integer recState;
}
