package com.javasm.system.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: 云勇
 * @date: 2022/5/23 6:07
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetUserRole {
    private Integer userId;
    private List<Integer> userAllRoleId;
}
