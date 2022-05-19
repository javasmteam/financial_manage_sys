package com.javasm.system.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 云勇
 * @date: 2022/5/19 17:27
 * @description:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleMiddle {
    private Integer userId;
    private Integer roleId;
}
