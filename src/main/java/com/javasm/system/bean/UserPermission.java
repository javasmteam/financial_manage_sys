package com.javasm.system.bean;

import com.javasm.system.bean.vo.PermissionInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: 云勇
 * @date: 2022/5/15 23:39
 * @description:
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPermission {
        /**
         * 权限Id
         * 权限名
         * 权限图片路径
         * 父级权限Id
         * 权限状态
         */
        private Integer permissionId;
        private String permissionName;
        private String permissionPath;
        private String permissionImage;
        private Integer parentId;
        private Integer permissionState;

    public UserPermission(PermissionInfo permissionInfo) {
        this.permissionId = permissionInfo.getPermissionId();
        this.permissionName = permissionInfo.getPermissionName();
        this.permissionPath = permissionInfo.getPermissionPath();
        this.permissionImage = permissionInfo.getPermissionImage();
        this.parentId = permissionInfo.getParentId();
        this.permissionState = permissionInfo.getPermissionState();
    }
}
