package com.javasm.system.bean.vo;

import com.javasm.system.bean.UserInfo;
import com.javasm.system.bean.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: 云勇
 * @date: 2022/5/16 17:17
 * @description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRoleVo {
    /**
     * 用户当前角色
     * 用户拥有的全部角色
     */
    private UserRole nowRole;
    private List<UserRole> userRoles;

    public UserRoleVo(UserRole nowRole) {
        this.nowRole = nowRole;
        this.userRoles = new ArrayList<>();
    }
}
