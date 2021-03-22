package com.leetcode.cxw.algorithm.linkedList;

import com.leetcode.cxw.algorithm.common.ListNode;

/**
 * 【删除排序链表中的重复元素II】
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->3->4->4->5
 * 输出: 1->2->5
 * 示例 2:
 *
 * 输入: 1->1->1->2->3
 * 输出: 2->3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode082 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead = new ListNode(0, head);
        ListNode prev = dummyHead;
        ListNode cur = prev.next;
        while (cur != null) {
            int curRepeatNum = 0;
            ListNode diffNode = cur;
            //找到和cur指向的结点值不同的结点
            while (diffNode != null && diffNode.val == cur.val) {
                curRepeatNum++;
                diffNode = diffNode.next;
            }
            //如果curRepeatNum的值大于1，则表示cur指向的结点重复出现了
            if (curRepeatNum > 1) {
                prev.next = diffNode;
            } else {
                //cur指向的结点没有重复出现，则将变量prev指向cur所指向的结点
                prev = cur;
            }
            cur = diffNode;
        }
        return dummyHead.next;
    }
}
