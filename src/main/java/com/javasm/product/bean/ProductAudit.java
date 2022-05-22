package com.javasm.product.bean;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>产品审核表</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-15 17:30
 * @Version : 1.0
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductAudit {
    private Integer auditId;
    private Integer productId;
    private String auditor;
    private String auditorOpinion;
    private Date firstCreateTime;
    private Date latestModifyTime;
    private Integer auditType;
    private Integer auditState;
}
