package com.javasm.unicom.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CompanyInfo {

    //独角兽公司信息表
    /**
     * 主键
     */
    private Integer comId;
    /**
     * 企业名称
     */
    private String comName;
    /**
     * 交易代码
     */
    private String tradeCode ;
    /**
     * 企业logo
     */
    private String comLogo;
    /**
     * app_logo
     */
    private String appLogo ;
    /**
     * 所属行业
     */
    private String comIndustry;
    /**
     * 成立年份
     */
    private String comCreateYear;
    /**
     * 企业执行官
     */
    private String comCeo;
    /**
     * 企业所在地
     */
    private String comLocation;
    /**
     * 费率
     */
    private Float comRate;
    /**
     * 企业顺序码
     */
    private Integer comSeqCode;
    /**
     * 企业介绍
     */
    private String comIntro;
    /**
     * 公司信息状态
     */
    private Integer comInfoState;
}
