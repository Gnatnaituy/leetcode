package classify.twopointers;

import tools.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleII {

    /**
     * 6ms 20.81%
     * 35.1MB 11.00%
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        Set<ListNode> set = new HashSet<>();

        while (true) {
            if (fast == null) return null;
            if (set.contains(fast)) return fast;
            set.add(fast);
            fast = fast.next;
        }
    }

    /**
     * 0ms 100.00%
     * 35.4MB 5.33%
     */
    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            // slow 和 fast 不一定在环的起点相遇
            if (fast == slow) {
                ListNode slow2 = head;
                while (slow2 != slow) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }

                return slow;
            }
        }

        return null;
    }
}
