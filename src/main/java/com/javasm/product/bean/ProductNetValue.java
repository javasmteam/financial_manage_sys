package com.javasm.product.bean;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

import java.util.Date;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>产品净值类</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-16 17:05
 * @Version : 1.0
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductNetValue {
    private Integer proNetValueId;
    private Integer productId;
    private Float unitNet;
    private Date unitDate;
    private Float sumIncreaseRate;
    private Integer netValueState;
}
