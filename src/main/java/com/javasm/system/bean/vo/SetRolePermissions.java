package com.javasm.system.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: 云勇
 * @date: 2022/5/21 22:17
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SetRolePermissions {
    private Integer roleId;
    private List<Integer> permissions;
}
