package classify.list;

import tools.ListNode;

public class PartitionList {
    
    /**
     * 0ms      100.00%
     * 41.1MB   19.76%
     */
    public ListNode partition(ListNode head, int x) {
        ListNode lower = new ListNode(-1);
        ListNode bigger = new ListNode(-1);
        ListNode cur1 = lower, cur2 = bigger;
        
        while (head != null) {
            if (head.val < x) {
                cur1.next = new ListNode(head.val);
                cur1 = cur1.next;
            } else {
                cur2.next = new ListNode(head.val);
                cur2 = cur2.next;
            }
            head = head.next;
        }

        cur1.next = bigger.next;

        return lower.next;
    }
}
