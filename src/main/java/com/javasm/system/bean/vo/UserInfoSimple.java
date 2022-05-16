package com.javasm.system.bean.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: 云勇
 * @date: 2022/5/16 17:25
 * @description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInfoSimple {
    /**
     * 用户Id
     * 用户名称
     * 用户状态
     * 用户最后登录时间
     * 用户头像
     */

    private Integer userId;
    private String userName;
    private Integer userState;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date lastLogin;
    private String headPic;
}
