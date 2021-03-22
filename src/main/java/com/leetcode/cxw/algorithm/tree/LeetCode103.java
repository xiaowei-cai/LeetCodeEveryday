package com.leetcode.cxw.algorithm.tree;

import com.leetcode.cxw.algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 【二叉树的锯齿形层序遍历】
 * 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-zigzag-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode103 {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root != null){
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                ArrayList<Integer> newLevel = new ArrayList<>();
                for(int i=0;i<size;i++){
                    TreeNode temp = queue.poll();

                    if((result.size()+1)%2 != 0){
                        //奇数层 -> 尾插
                        newLevel.add(temp.getVal());
                    }else{
                        //偶数层 -> 头插
                        newLevel.add(0,temp.getVal());
                    }

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
