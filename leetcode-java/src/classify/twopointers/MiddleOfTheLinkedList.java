package classify.twopointers;

import tools.ListNode;

/**
 * 876 Middle of the Linked List
 */

public class MiddleOfTheLinkedList {

    /**
     * 0ms      100.00%
     * 39.4MB   5.02%
     */
    public ListNode middleNode(ListNode head) {
        int step = 0;
        ListNode res = head;

        while (head != null) {
            head = head.next;
            step++;
            if (step % 2 == 0) {
                res = res.next;
            }
        }

        return res;
    }

    /**
     * 0ms      100.00%
     * 38.7MB   88.63%
     */
    public ListNode middleNode2(ListNode head) {
        ListNode slow = head, fast = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
}
