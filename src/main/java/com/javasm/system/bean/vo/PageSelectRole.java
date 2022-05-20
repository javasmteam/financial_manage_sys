package com.javasm.system.bean.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: 云勇
 * @date: 2022/5/20 14:35
 * @description:
 */
@Getter
@Setter
public class PageSelectRole {
    private String RoleName;
    private String RoleId;
    private Integer nowPage;
    private Integer pageCount;
}
