package others.easy.ltwenty;

import tools.ListNode;

/**
 * 876 Middle of the Linked List
 */

public class MiddleOfTheLinkedList {
    
    public ListNode middleNode(ListNode head) {
        int step = 0;
        ListNode res = head;
        
        while (head != null) {
            head = head.next;
            step++;
            if (step % 2 == 0)
                res = res.next;
        }
        
        return res;
    }
}
