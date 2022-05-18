package com.javasm.system.bean.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: 云勇
 * @date: 2022/5/18 15:43
 * @description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInfoVo {
    private String headPic;
    private Integer userId;
    private String userAct;
    private String userName;
    private String des;
    private Integer sex;
    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;
    private String avatarColor;
    private String phone;
    private String roleName;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date lastLogin;
    
}
