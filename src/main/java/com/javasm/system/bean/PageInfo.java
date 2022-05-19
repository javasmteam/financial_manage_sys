package com.javasm.system.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 云勇
 * @date: 2022/5/19 14:45
 * @description:
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PageInfo<T> {
    private Integer nowPage;
    private Integer pageCount;
    private Integer allCount;
    private List<T> dataList;

}
