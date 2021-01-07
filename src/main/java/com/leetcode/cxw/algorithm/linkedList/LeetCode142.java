package com.leetcode.cxw.algorithm.linkedList;

import com.leetcode.cxw.algorithm.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 【环形链表II】
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * 说明：不允许修改给定的链表。
 *
 * 进阶：
 * 你是否可以使用 O(1) 空间解决此题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode142 {
    public ListNode detectCycle(ListNode head) {
        //哈希表
        Set<ListNode> set = new HashSet<>();
        ListNode node = head;
        while(node != null){
            if(set.contains(node)){
                return node;
            }else{
                set.add(node);
                node = node.next;
            }
        }
        return null;
    }
}
