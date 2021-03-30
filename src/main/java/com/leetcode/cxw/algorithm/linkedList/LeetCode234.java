package com.leetcode.cxw.algorithm.linkedList;

import com.leetcode.cxw.algorithm.common.ListNode;

import java.util.Stack;

/**
 * 【回文链表】
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 *
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 */

public class LeetCode234 {
    /**
     * 借助一个栈，从链表头部依次遍历，将节点压入栈中
     * 接着比较链表头部和栈中弹出的每一个节点数据是否相等
     */
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode cur = head;
        while (cur != null) {
            stack.add(cur);
            cur = cur.next;
        }
        while (head != null) {
            if (head.val != stack.pop().val) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
