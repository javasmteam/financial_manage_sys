package com.javasm.unicom.bean;

/**
 * @author: 云勇
 * @date: 2022/5/15 23:39
 * @description:
 */

/**
 * permissionId:    权限id
 * permissionCode:  权限代码
 * permissionName:  权限名
 * permissionPath:  权限页面路径
 * permissionImage: 权限图标路径
 * parentPermission:    上级权限id
 * permissionState: 权限状态    0:删除 1:生效
 */
public class Permission {
    private int permissionId;
    private String permissionCode;
    private String permissionName;
    private String permissionPath;
    private String permissionImage;
    private int parentPermission;
    private int permissionState;
}
