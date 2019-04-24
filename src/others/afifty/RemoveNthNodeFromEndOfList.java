package others.afifty;

import others.tools.ListNode;

/**
 * 19. Remove Nth Node from End of List
 */

public class RemoveNthNodeFromEndOfList {

    private ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head, tail = head;
        
        for (int i = 0; i < n; i++) tail = tail.next;
        if (tail == null) {
            head = head.next;
            return head;
        }
        while (tail.next != null) {
            front = front.next;
            tail = tail.next;
        }
        
        front.next = front.next.next;
        
        return head;
    }
}
