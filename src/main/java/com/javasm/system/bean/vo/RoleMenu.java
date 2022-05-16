package com.javasm.system.bean.vo;

import com.javasm.system.bean.UserPermission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: 云勇
 * @date: 2022/5/15 23:34
 * @description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleMenu {
    /**
     * 当前权限
     *  当前角色拥有的全部权限
     */
    private UserPermission nowPermission;
    private List<UserPermission> permissions;
}
