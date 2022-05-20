package com.javasm.system.bean.vo;

import com.javasm.system.bean.UserPermission;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author: 云勇
 * @date: 2022/5/20 14:36
 * @description:
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PermissionInfo extends UserPermission {
    private String parentName;
}
