package com.javasm.unicom.bean.vo;

import com.javasm.unicom.bean.HistoryFunding;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h4>financial_manage_sys</h4>
 * <p></p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-21 16:08
 * @Version : 1.0
 **/
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HistoryFundingVo extends HistoryFunding {
    private String comName;
}
