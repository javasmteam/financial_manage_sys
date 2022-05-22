package com.javasm.unicom.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MakerPrice {


    /**
     * 主键
     */
    private Integer makerId;
    /**
     * 企业编号
     */
    private Integer comId;

    private Integer buyPriceOne ;
    private Integer buyNumberOne  ;
    private Integer buyPriceTwo   ;
    private Integer buyNumberTwo   ;
    private Integer buyPriceThree    ;
    private Integer buyNumberThree  ;

}
