package com.leetcode.cxw.algorithm.tree;

import java.util.Arrays;
import java.util.List;

/**
 * @author caixiaowei
 * @date 2020/12/09 11:59
 *
 * 二叉搜索树：BinarySearchTree(BST)
 *
 * 二叉搜索树，是指一棵空树或者具有下列性质的二叉树：
 * (1)若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；
 * (2)若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；
 * (3)任意节点的左，右子树也分别为二叉搜索树；
 * (4)没有键值相等的节点。
 *
 * 二叉搜索树的中序遍历结果刚好是将数组按照正序排列
 */

public class BinarySearchTree {
    /**
     *
     */
    private static class Node {
        /**
         * 数据域
         */
        int data;
        /**
         * 右子树
         */
        Node right;
        /**
         * 左子树
         */
        Node left;
    }

    /**
     * 树根节点
     */
    private Node root;

    /**
     * 创建树
     */
    public void insert(int key) {
        //待插入的节点
        Node p = new Node();
        p.data = key;

        if (root == null) {
            root = p;
        } else {
            Node parent;
            Node current = root;
            while (true) {
                parent = current;
                if (key > current.data) {
                    // 右子树
                    current = current.right;
                    if (current == null) {
                        parent.right = p;
                        return;
                    }
                } else {
                    // 左子树
                    current = current.left;
                    if (current == null) {
                        parent.left = p;
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 1, 2, 4, 5, 6, 7, 8, 9, 10);
        BinarySearchTree bst = new BinarySearchTree();
        for (int i = 0; i < list.size(); i++) {
            bst.insert(list.get(i));
        }
    }
}
