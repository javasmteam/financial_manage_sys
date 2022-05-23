package com.javasm.system.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author: 云勇
 * @date: 2022/5/23 5:11
 * @description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SetPwdInfo {
    private String userId;
    private String oldPwd;
    private String newPwd;
}
