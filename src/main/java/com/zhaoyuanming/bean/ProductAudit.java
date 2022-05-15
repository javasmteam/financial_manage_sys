package com.zhaoyuanming.bean;

import java.security.Timestamp;

/**
 * <h4>Financial_manage_sys</h4>
 * <p>产品审核表</p>
 *
 * @Author : zhao Yuanming
 * @Date : 2022-05-15 17:30
 * @Version : 1.0
 **/
public class ProductAudit {
    private Integer auditId;
    private Integer productId;
    private String auditor;
    private String auditorOpinion;
    private Timestamp firstCreateTime;
    private Timestamp latestModifyTime;
    private Integer auditState;
}
