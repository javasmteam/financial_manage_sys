package com.javasm.system.bean.vo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @author: 云勇
 * @date: 2022/5/18 15:44
 * @description:
 */
public class SetUserInfo {
    private String userName;
    private String des;
    private Integer sex;
    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;
    private String avatarColor;
    private String phone;
    private Integer roles;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date lastLogin;
}
