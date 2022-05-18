package com.javasm.unicom.bean.vo;

import com.javasm.unicom.bean.CompanyInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * <h4>financial_manage_sys</h4>
 * <p></p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-18 20:45
 * @Version : 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CompanyInfoVo extends CompanyInfo {
    private Float makerAmount;


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
