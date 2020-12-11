package com.leetcode.cxw.algorithm.common;

import lombok.Data;

/**
 * @author caixiaowei
 * @date 2020/12/09 11:04
 */

@Data
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
