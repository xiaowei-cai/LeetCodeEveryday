package com.leetcode.cxw.algorithm.tree;

import com.leetcode.cxw.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 */

public class LeetCode094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    public void inOrder(TreeNode root,List<Integer> res){
        if (root == null) {
            return;
        }
        inOrder(root.getLeft(), res);
        res.add(root.getVal());
        inOrder(root.getRight(), res);
    }
}
