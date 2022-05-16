package com.javasm.system.bean;

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
        private int permissionId;
        private String permissionName;
        private String permissionPath;
        private String permissionImage;
        private int parentId;
        private int permissionState;
}
