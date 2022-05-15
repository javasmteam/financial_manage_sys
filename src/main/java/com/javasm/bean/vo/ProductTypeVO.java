package com.javasm.bean.vo;

import com.javasm.bean.ProductType;
import lombok.*;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>商品系列查询vo类</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-15 23:52
 * @Version : 1.0
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductTypeVO {
    private Integer productTypeId;
    private String productTypeChName;
    private String productTypeEngName;
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
}
