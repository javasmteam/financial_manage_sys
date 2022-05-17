package com.javasm.system.bean;

import com.alibaba.fastjson.annotation.JSONField;
import com.javasm.system.bean.vo.RegUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: 云勇
 * @date: 2022/5/16 16:27
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    /**
     * 用户ID
     * 用户账号
     * 用户密码
     * 用户名
     * 用户头像
     * 用户签名
     * 用户性别
     * 用户生日
     * 用户爱好
     * 用户手机号
     * 用户当前角色Id
     * 用户创建时间
     * 用户最后登录时间
     * 用户状态
     */
    private Integer userId;
    private String userAct;
    private String userPwd;
    private String userName;
    private String headPic;
    private String des;
    private Integer sex;
    @JSONField(format = "yyyy-MM-dd")
    private Date birthday;
    private String avatarColor;
    private String phone;
    private Integer roleId;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date lastLogin;
    private Integer userState;

    public UserInfo(RegUser regUser) {
        this.userAct = regUser.getUserAct();
        this.userPwd = regUser.getUserPwd();
        this.userName = regUser.getUserName();
        this.birthday = regUser.getBirthday();
        this.sex = regUser.getSex();
        this.phone = regUser.getPhone();
        //新注册的用户角色默认为会员
        this.roleId = 5;
        this.createTime = new Date();
        this.userState = 1;

    }
}
