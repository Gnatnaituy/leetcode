package java.classify.linkedlist;

import java.tools.ListNode;

public class RemoveDuplicatesFromSortedList {

    /**
     * 0ms 100.00%
     * 35.5MB 99.92%
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;

        while (cur != null) {
            if (cur.next == null) {
                return head;
            } else if (cur.next.val == cur.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return null;
    }
}
