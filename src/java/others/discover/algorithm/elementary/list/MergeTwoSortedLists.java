package java.others.discover.algorithm.elementary.list;

import java.others.tools.ListNode;

public class MergeTwoSortedLists {

    /**
     * 将两个有序链表合并为一个新的有序链表并返回
     * 新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /*
        11ms 79.08%
         */
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        /*
        12ms 74.58%
        三个月前写的
         */
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        else return l1.val < l2.val ? innerMergeTwoLists(l1, l2) : innerMergeTwoLists(l2, l1);
    }

    private static ListNode innerMergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cursor = l1;
        while (l2 != null && cursor.next != null) {
            if (l2.val < cursor.next.val) {
                ListNode temp = new ListNode(l2.val);
                temp.next = cursor.next;
                cursor = cursor.next = temp;
                l2 = l2.next;
            } else {
                cursor = cursor.next;
            }
        }
        if (l2 != null) cursor.next = l2;

        return l1;
    }

    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        /*
        9ms
         */
        ListNode res = new ListNode(0);
        ListNode curr = res;
        while (l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr.next = l1;
                l1 = l1.next;
                curr = curr.next;
            }else {
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;
            }
        }
        if(l1 == null){
            curr.next = l2;
        }
        if(l2 == null){
            curr.next = l1;
        }
        return res.next;
    }
}
