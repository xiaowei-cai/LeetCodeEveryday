package com.leetcode.cxw.algorithm.linkedList;

import com.leetcode.cxw.algorithm.common.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 【排序链表】
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 进阶：
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  
 * 示例 1：
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode148 {
    /**
     * 思路：
     * 自底向上归并排序
     * 使用自底向上的方法实现归并排序，则可以达到 O(1)的空间复杂度。
     * 首先求得链表的长度 length，然后将链表拆分成子链表进行合并。
     * 具体做法如下:
     * 1、用subLength表示每次需要排序的子链表的长度，初始时subLength=1。
     * 2、每次将链表拆分成若干个长度为 subLength的子链表（最后一个子链表的长度可以小于subLength），按照每两个子链表一组进行合并，
     * 合并后即可得到若干个长度为subLength×2的有序子链表（最后一个子链表的长度可以小于subLength×2）。
     * 合并两个子链表仍然使用「LeetCode21：合并两个有序链表」的做法。
     * 3、将 subLength的值加倍，重复第 2 步，对更长的有序子链表进行合并操作，直到有序子链表的长度大于或等于length，整个链表排序完毕。
     *
     * 如何保证每次合并之后得到的子链表都是有序的呢？可以通过数学归纳法证明。
     * 1、初始时subLength=1，每个长度为1的子链表都是有序的。
     * 2、如果每个长度为subLength的子链表已经有序，合并两个长度为subLength的有序子链表，得到长度为subLength×2的子链表，一定也是有序。
     * 3、当最后一个子链表的长度小于subLength 时，该子链表也是有序的，合并两个有序子链表之后得到的子链表一定也是有序的。
     * 因此可以保证最后得到的链表是有序的。
     */
    //思路一：归并排序
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return null;
        }
        //首先计算链表长度
        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        //定义dummyHead空链表指向head
        ListNode dummyHead = new ListNode(0, head);
        // a<<=1表示a左移一位，即乘2
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            ListNode prev = dummyHead;
            ListNode curr = dummyHead.next;
            while (curr != null) {
                ListNode head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                prev.next = merge(head1, head2);
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 合并两个有序链表
     */
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if (head1 != null) {
            temp.next = head1;
        } else if (head2 != null) {
            temp.next = head2;
        }
        return dummyHead.next;
    }


    //思路二：转换成列表排序
    public ListNode sortList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //先计算长度
        List<Integer> list = new ArrayList<>();
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            length++;
            cur = cur.next;
        }
        //排序列表
        list.sort((a, b) -> a - b);
        //生成新的链表返回
        ListNode temp = head;
        for (int i = 0; i < length; i++) {
            temp.val = list.get(i);
            temp = temp.next;
        }
        return head;
    }


    //递归+归并
    public ListNode sortInList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        //使用快慢指针找到中点
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //分割为两个链表
        ListNode newList = slow.next;
        slow.next = null;
        //将两个链表继续分割
        ListNode left = sortInList(head);
        ListNode right = sortInList(newList);

        ListNode lhead = new ListNode(-1);
        ListNode res = lhead;
        //归并排序
        while (left != null && right != null) {
            if (left.val < right.val) {
                lhead.next = left;
                left = left.next;
            } else {
                lhead.next = right;
                right = right.next;
            }
            lhead = lhead.next;
        }
        //判断左右链表是否为空
        lhead.next = left != null ? left : right;
        return res.next;
    }
}
