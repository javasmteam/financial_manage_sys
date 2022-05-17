package com.javasm.system.bean.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: 云勇
 * @date: 2022/5/16 17:33
 * @description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginUser {
    /**
     * 用户账号
     * 用户密码
     * 用户验证码
     * 是否记住密码
     */
    private String userAct;
    private String userPwd;
    private String userVri;
    private Boolean isMemory;
}
