package com.javasm.system.bean.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.javasm.system.bean.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: 云勇
 * @date: 2022/5/18 15:44
 * @description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SetUserInfo {
    private Integer userId;
    private String userName;
    private String des;
    private Integer sex;
    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;
    private String avatarColor;
    private String phone;
    private UserRoleVo roles;

    public SetUserInfo(UserInfo userInfo){
        this.userId = userInfo.getUserId();
        this.userName = userInfo.getUserName();
        this.des = userInfo.getDes();
        this.sex = userInfo.getSex();
        this.birthday = userInfo.getBirthday();
        this.avatarColor = userInfo.getAvatarColor();
        this.phone = userInfo.getPhone();
    }
}
