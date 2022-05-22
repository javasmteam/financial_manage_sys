package com.javasm.unicom.bean;

import lombok.*;

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
    /**
     * 最新挂牌价
     */
    private Float newMakerAmount;



    private Float buyPriceOne ;
    private Float buyNumberOne  ;
    private Float buyPriceTwo   ;
    private Float buyNumberTwo   ;
    private Float buyPriceThree    ;
    private Float buyNumberThree  ;

    public Integer getComId() {
        return comId;
    }

    public void setComId(Integer comId) {
        this.comId = comId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getTradeCode() {
        return tradeCode;
    }

    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }

    public String getComLogo() {
        return comLogo;
    }

    public void setComLogo(String comLogo) {
        this.comLogo = comLogo;
    }

    public String getAppLogo() {
        return appLogo;
    }

    public void setAppLogo(String appLogo) {
        this.appLogo = appLogo;
    }

    public String getComIndustry() {
        return comIndustry;
    }

    public void setComIndustry(String comIndustry) {
        this.comIndustry = comIndustry;
    }

    public String getComCreateYear() {
        return comCreateYear;
    }

    public void setComCreateYear(String comCreateYear) {
        this.comCreateYear = comCreateYear;
    }

    public String getComCeo() {
        return comCeo;
    }

    public void setComCeo(String comCeo) {
        this.comCeo = comCeo;
    }

    public String getComLocation() {
        return comLocation;
    }

    public void setComLocation(String comLocation) {
        this.comLocation = comLocation;
    }

    public Float getComRate() {
        return comRate;
    }

    public void setComRate(Float comRate) {
        this.comRate = comRate;
    }

    public Integer getComSeqCode() {
        return comSeqCode;
    }

    public void setComSeqCode(Integer comSeqCode) {
        this.comSeqCode = comSeqCode;
    }

    public String getComIntro() {
        return comIntro;
    }

    public void setComIntro(String comIntro) {
        this.comIntro = comIntro;
    }

    public Integer getComInfoState() {
        return comInfoState;
    }

    public void setComInfoState(Integer comInfoState) {
        this.comInfoState = comInfoState;
    }

    public Float getNewMakerAmount() {
        return newMakerAmount;
    }

    public void setNewMakerAmount(Float newMakerAmount) {
        this.newMakerAmount = newMakerAmount;
    }

    public Float getBuyPriceOne() {
        return buyPriceOne;
    }

    public void setBuyPriceOne(Float buyPriceOne) {
        this.buyPriceOne = buyPriceOne;
    }

    public Float getBuyNumberOne() {
        return buyNumberOne;
    }

    public void setBuyNumberOne(Float buyNumberOne) {
        this.buyNumberOne = buyNumberOne;
    }

    public Float getBuyPriceTwo() {
        return buyPriceTwo;
    }

    public void setBuyPriceTwo(Float buyPriceTwo) {
        this.buyPriceTwo = buyPriceTwo;
    }

    public Float getBuyNumberTwo() {
        return buyNumberTwo;
    }

    public void setBuyNumberTwo(Float buyNumberTwo) {
        this.buyNumberTwo = buyNumberTwo;
    }

    public Float getBuyPriceThree() {
        return buyPriceThree;
    }

    public void setBuyPriceThree(Float buyPriceThree) {
        this.buyPriceThree = buyPriceThree;
    }

    public Float getBuyNumberThree() {
        return buyNumberThree;
    }

    public void setBuyNumberThree(Float buyNumberThree) {
        this.buyNumberThree = buyNumberThree;
    }
}
