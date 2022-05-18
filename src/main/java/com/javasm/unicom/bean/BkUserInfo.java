package com.javasm.unicom.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * <h4>financial_manage_sys</h4>
 * <p></p >
 *
 * @Author : huangshuai
 * @Date : 2022-05-17 16:02
 * @Version : 1.0
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BkUserInfo {

    //用户表（客户）
    /**
     * 主键
     */
    private Integer userid;
    /**
     *账号
     */
    private String username;
    /**
     *客户编号
     */
    private Integer usercode;
    /**
     *手机号
     */
    private String iphone;
    /**
     *密码
     */
    private String pwd;
    /**
     *昵称
     */
    private String nickname;
    /**
     *性别 1为男  0为女
     */
    private Integer sex;

    private String birthday;
    /**
     *爱好
     */
    private String avatarcolor;
    /**
     *等级
     */
    private Integer grade;
    /**
     *头像大图
     */
    private String headpic;
    /**
     *头像缩略图
     */
    private String headpicthumb;
    /**
     *状态 1为可用  0为删除
     */
    private Integer state;




}
