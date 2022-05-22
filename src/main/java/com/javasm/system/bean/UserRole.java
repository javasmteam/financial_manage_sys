package com.javasm.system.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 云勇
 * @date: 2022/5/16 16:28
 * @description:
 */
@AllArgsConstructor
@Data
public class UserRole {
    /**
     * 角色Id
     * 角色名
     * 角色状态
     */
    private Integer roleId;
    private String roleName;
    private Integer roleState;

    public UserRole() {
        this.roleState = 1;
    }
}
