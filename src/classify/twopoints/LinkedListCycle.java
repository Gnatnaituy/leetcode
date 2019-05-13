package classify.twopoints;

import others.tools.ListNode;

public class LinkedListCycle {

    /**
     * 0ms 100.00%
     * 36.6MB 97.14%
     */
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (true) {
            if (fast == null || fast.next == null)
                return false;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
    }
}
