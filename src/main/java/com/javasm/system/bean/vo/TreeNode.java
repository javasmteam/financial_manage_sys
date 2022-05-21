package com.javasm.system.bean.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author: 云勇
 * @date: 2022/5/21 15:26
 * @description:
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TreeNode {
    private Integer id;
    private String label;
    private List<TreeNode> TreeNodes;
}
