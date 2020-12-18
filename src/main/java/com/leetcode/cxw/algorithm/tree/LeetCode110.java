package com.leetcode.cxw.algorithm.tree;

import com.leetcode.cxw.algorithm.common.TreeNode;

/**
 * 【平衡二叉树】
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */

public class LeetCode110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.getLeft()) - height(root.getRight())) <= 1
                && isBalanced(root.getLeft())
                && isBalanced(root.getRight());
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
        }
    }
}
