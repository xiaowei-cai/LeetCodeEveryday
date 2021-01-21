package com.leetcode.cxw.algorithm.tree;

import org.junit.Test;

import java.util.*;

/**
 * 二叉树遍历：递归思想 || 栈
 * ps:绝大多数可以用递归解决的问题,都可以用另一种数据结构来解决,这种数据结构就是栈.因为递归和栈都有回溯的特性
 *
 * @author caixiaowei
 * @date 2020/11/13 10:09
 */

public class BinaryTree {
    /**
     * 二叉树节点
     */
    private static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;

        TreeNode(int data) {
            this.data = data;
        }
    }

    /**
     * 构建二叉树
     *
     * @param inputList 输入序列
     */
    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        if (data != null) {
            node = new TreeNode(data);
            node.leftChild = createBinaryTree(inputList);
            node.rightChild = createBinaryTree(inputList);
        }
        return node;
    }

    /**
     * [递归实现]二叉树前序遍历：根左右
     *
     * @param node 二叉树节点
     */
    public static void perOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        perOrderTraverse(node.leftChild);
        perOrderTraverse(node.rightChild);
    }


    /**
     * [递归实现]二叉树中序遍历：左根右
     *
     * @param node 二叉树节点
     */
    public static void inOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.leftChild);
        System.out.println(node.data);
        inOrderTraverse(node.rightChild);
    }

    /**
     * [递归实现]二叉树后序遍历：左右根
     *
     * @param node 二叉树节点
     */
    public static void postOrderTraverse(TreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.leftChild);
        postOrderTraverse(node.rightChild);
        System.out.println(node.data);
    }


    /**
     * [栈]前序遍历
     */
    public static void perOrderTraverseByStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            //迭代访问节点的左孩子，并入栈
            while (treeNode != null) {
                System.out.println(treeNode.data);
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            //如果节点没有左孩子，则弹出栈顶节点，访问节点右孩子
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * [栈]中序遍历
     */
    public static void inOrderTraverseByStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.leftChild;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.println(treeNode.data);
                treeNode = treeNode.rightChild;
            }
        }
    }

    /**
     * [栈]后序遍历 --根右左 翻转变成 左右根
     */
    public static void postOrderTraverseByStack(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode treeNode = root;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                list.add(treeNode.data);
                treeNode = treeNode.rightChild;
            }
            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.leftChild;
            }
        }
        Collections.reverse(list);
        list.forEach(System.out::println);
    }

    /**
     * [队列]二叉树层序遍历
     */
    public static void levelOrderTraverseByQueue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        //offer新增、poll移除第一个、pick队列头部查询
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.println(node.data);
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
    }


    /**
     * 测试
     */
    @Test
    public void test() {
        LinkedList<Integer> inputList = new LinkedList<>(
                Arrays.asList(3, 2, 9, null, null, 10, null, null, 8, null, 4)
        );
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("[递归]前序遍历：");
        perOrderTraverse(treeNode);
        System.out.println("[递归]中序遍历：");
        inOrderTraverse(treeNode);
        System.out.println("[递归]后序遍历：");
        postOrderTraverse(treeNode);
        System.out.println("[栈]前序遍历：");
        perOrderTraverseByStack(treeNode);
        System.out.println("[栈]中序遍历：");
        inOrderTraverseByStack(treeNode);
        System.out.println("[栈]后序遍历：");
        postOrderTraverseByStack(treeNode);
        System.out.println("[队列]层序遍历：");
        levelOrderTraverseByQueue(treeNode);
    }
}
