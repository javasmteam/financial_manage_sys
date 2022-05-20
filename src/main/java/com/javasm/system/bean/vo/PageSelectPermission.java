package com.javasm.system.bean.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: 云勇
 * @date: 2022/5/20 14:34
 * @description:
 */
@Getter
@Setter
public class PageSelectPermission {
    private String permissionName;
    private String permissionId;
    private Integer nowPage;
    private Integer pageCount;
}
