package com.javasm.system.bean.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: 云勇
 * @date: 2022/5/16 17:29
 * @description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegUser {
    /**
     * 用户账号
     * 用户密码
     * 用户姓名
     * 用户生日
     * 用户手机号
     */
    private String userAct;
    private String userPwd;
    private String userName;
    private Date birthday;
    private String phone;
}
