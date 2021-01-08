package com.leetcode.cxw.algorithm.linkedList;

import com.leetcode.cxw.algorithm.common.ListNode;

/**
 * 【删除链表的倒数第N个节点】
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * 给定的 n 保证是有效的。
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode019 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //先计算链表长度
        ListNode curNode = head;
        int length = 0;
        while (curNode != null) {
            length++;
            curNode = curNode.next;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy;
        //遍历前 length - n + 1
        for (int i = 1; i < length - n + 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return dummy.next;
    }
}
