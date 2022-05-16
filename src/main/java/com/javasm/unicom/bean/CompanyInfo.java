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
    private Integer comId;//主键
    private String comName;//企业名称
    private String tradeCode ;//交易代码
    private String comLogo;//企业logo
    private String appLogo ;//app_logo
    private String comIndustry;//所属行业
    private String comCreateYear;//成立年份
    private String comCeo;//企业执行官
    private String comLocation;//企业所在地
    private Float comRate;//费率
    private Integer comSeqCode;//企业顺序码
    private String comIntro;//企业介绍
    private Integer comInfoState;//公司信息状态
}
