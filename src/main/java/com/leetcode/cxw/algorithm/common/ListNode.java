package com.leetcode.cxw.algorithm.common;

/**
 * @author caixiaowei
 * @date 2020/12/10 9:32
 */

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ListNode listNode = (ListNode) o;

        if (val != listNode.val) {
            return false;
        }
        return next.equals(listNode.next);
    }

    @Override
    public int hashCode() {
        int result = val;
        result = 31 * result + next.hashCode();
        return result;
    }
}
