package com.leetcode.cxw.algorithm.stackAndQueue;

import com.leetcode.cxw.algorithm.common.ListNode;

/**
 * 【用链表实现队列】
 */

public class LinkedListForQueue {
    //队头
    private ListNode head;
    //队尾
    private ListNode tail;

    //构造函数
    public LinkedListForQueue() {
        this.head = null;
        this.tail = null;
    }

    /**
     * 入队
     */
    public boolean inQueue(int t) {
        //先生成一个新节点
        ListNode p = new ListNode(t);
        if (head == null) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
        }
        return true;
    }

    /**
     * 出队
     */
    public int outQueue() {
        if (head == null) {
            return 0;
        } else {
            int ans = head.val;
            head = head.next;
            return ans;
        }
    }


    /**
     * 查队头
     */
    public int peek() {
        if (head == null) {
            return 0;
        } else {
            return head.val;
        }
    }

    /**
     * 判空
     */
    public boolean isEmpty() {
        return head == null;
    }
}
