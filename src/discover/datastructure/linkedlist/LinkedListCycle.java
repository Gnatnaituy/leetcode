package discover.datastructure.linkedlist;

import tools.ListNode;

public class LinkedListCycle {

    /**
     * 1ms 97.12%
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                ListNode start = head;
                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }
                return start;
            }
        }

        return null;
    }
}
