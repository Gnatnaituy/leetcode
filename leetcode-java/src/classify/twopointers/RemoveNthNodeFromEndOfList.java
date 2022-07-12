package classify.twopointers;

import tools.ListNode;

/**
 * @author yutiantang
 * @create 2021/3/28 4:44 PM
 */
public class RemoveNthNodeFromEndOfList {

    /**
     * 0ms 100.00%
     * 34.1MB 100.00%
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;

        while (n > 0) {
            fast = fast.next;
            n--;
        }

        if (fast == null) {
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
