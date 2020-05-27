package java.others.discover.algorithm.elementary.list;

import java.tools.ListNode;

public class RemoveNthNodeFromEndOfList {

    /**
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
        16ms 30.12%
         */
        ListNode cur = head;
        ListNode nth = head;

        while (n > 0) {
            cur = cur.next;
            n--;
        }

        if (cur == null) return head.next;

        while (cur.next != null) {
            cur = cur.next;
            nth = nth.next;
        }

        nth.next = nth.next.next;

        return head;
    }
}

