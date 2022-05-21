package com.javasm.unicom.bean.vo;

import com.javasm.unicom.bean.BkUserInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h4>financial_manage_sys</h4>
 * <p></p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-20 20:37
 * @Version : 1.0
 **/
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BkUserInfoVo extends BkUserInfo {
    private String comName;
    private Integer holdnumber;
    private Float holdmoney;

}
