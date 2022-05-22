package com.javasm.unicom.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h4>financial_manage_sys</h4>
 * <p></p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-22 16:19
 * @Version : 1.0
 **/
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MakerPriceVo {
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
    /**
     * 最新挂牌价
     */
    private Float newMakerAmount;


    /**
     * 主键
     */
    private Integer makerId;


    private Float buyPriceOne ;
    private Float buyNumberOne  ;
    private Float buyPriceTwo   ;
    private Float buyNumberTwo   ;
    private Float buyPriceThree    ;
    private Float buyNumberThree  ;

}
