package com.leetcode.cxw.algorithm.tree;

import com.leetcode.cxw.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 【二叉树的层序遍历】
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层序遍历结果：
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root != null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                List<Integer> newLevel = new ArrayList<>();
                for(int i=0;i<size;i++){
                    TreeNode temp = queue.poll();
                    newLevel.add(temp.getVal());
                    if(temp.getLeft() != null){
                        queue.offer(temp.getLeft());
                    }
                    if(temp.getRight() != null){
                        queue.offer(temp.getRight());
                    }
                }
                result.add(newLevel);
            }
        }
        return result;
    }
}
