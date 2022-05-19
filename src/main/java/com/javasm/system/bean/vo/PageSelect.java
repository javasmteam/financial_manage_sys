package com.javasm.system.bean.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * @author: 云勇
 * @date: 2022/5/19 14:48
 * @description:
 */
@Getter
@Setter
public class PageSelect {
    private String userName;
    private String userId;
    private Integer nowPage;
    private Integer pageCount;
}
