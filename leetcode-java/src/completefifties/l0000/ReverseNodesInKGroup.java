package completefifties.l0000;

import tools.ListNode;

public class ReverseNodesInKGroup {

    /**
     * 25. Reverse Nodes in k-Group
     *
     * @return
     * k = 2: 2->1->4->3->5
     * k = 3: 3->2->1->4->5
     */
    private ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = null;
        ListNode check = head; // why check can't be declared before cur???
        int canProceed = 0;
        int count = 0;

        // check if the list can be reversed
        while (canProceed < k && check != null) {
            check = check.next;
            canProceed++;
        }

        // The list can be reversed
        if (canProceed == k) {
            while (count < k && cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
                count++;
            }
            if (next != null) {
                // head is the reversed list's tail
                head.next = reverseKGroup(next, k);
            }
            // prev is the reversed list's head
            return prev;
        } else {
            // The list can't be reversed, directly return the list itself
            return head;
        }
    }
}
