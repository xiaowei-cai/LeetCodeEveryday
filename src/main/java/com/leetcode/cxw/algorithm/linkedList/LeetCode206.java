package com.leetcode.cxw.algorithm.linkedList;

import com.leetcode.cxw.algorithm.common.ListNode;

/**
 * 【反转链表】
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 限制：
 * 0 <= 节点个数 <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */

public class LeetCode206 {
    public static ListNode reverseList(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        //这里的cur就是最后一个节点
        ListNode cur = reverseList(head.next);
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }


    public ListNode reverseList1(ListNode head) {
        //申请节点pre和cur,pre指向null,cur指向head
        ListNode pre = null;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur != null) {
            //记录当前节点的下一个节点
            tmp = cur.next;
            //然后将当前节点指向pre
            cur.next = pre;
            //pre和cur节点都前进一位
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        } else {
            ListNode currNode = head;
            int length = 0;
            while (currNode != null) {
                length++;
                currNode = currNode.next;
            }
            int[] result = new int[length];

            currNode = head;
            while (currNode != null) {
                result[length - 1] = currNode.val;
                length--;
                currNode = currNode.next;
            }
            //生成链表的根节点，并将数组的第一个元素的值赋给链表的根节点
            ListNode root = new ListNode(result[0]);
            //生成另一个节点，并让other指向root节点，other在此作为一个临时变量，相当于指针
            ListNode other = root;
            //由于已给root赋值，所以i从1开始
            for (int i = 1; i < result.length; i++) {
                //每循环一次生成一个新的节点,并给当前节点赋值
                ListNode temp = new ListNode(result[i]);
                //将other的下一个节点指向生成的新的节点
                other.next = temp;
                //将other指向最后一个节点(other的下一个节点)  other=other.getNext();
                other = temp;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        System.out.println(reverseList(node1));
    }
}
