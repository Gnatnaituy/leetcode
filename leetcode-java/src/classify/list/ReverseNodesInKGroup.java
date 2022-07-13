package classify.list;

import tools.ListNode;

public class ReverseNodesInKGroup {

    /**
     * 0ms      100.00%
     * 41MB     66.20%
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null, next = null;
        ListNode cur = head, check = head;
        int remainNodes = 0, reverseNodes = 0;
        
        // check if remain nodes need reverse
        while (remainNodes < k && check != null) {
            check = check.next;
            remainNodes++;
        }

        if (remainNodes < k) {
            return head;
        }
        
        // reverse k remain nodes
        while (reverseNodes < k && cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            reverseNodes++;
        }

        // recursively reverse remain nodes
        if (next != null) {
            head.next = reverseKGroup(next, k);
        }

        return prev;
    }
}
