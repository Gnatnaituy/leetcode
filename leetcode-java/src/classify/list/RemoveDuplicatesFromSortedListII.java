package classify.list;

import tools.ListNode;

public class RemoveDuplicatesFromSortedListII {

    /**
     * 0ms      100.00%
     * 41MB     7.49%
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(), dummyCur = dummy, cur = head;

        while (cur != null) {
            if (cur.next == null) {
                dummyCur.next = cur;
                return dummy.next;
            } else if (cur.val == cur.next.val) {
                int dup = cur.val;
                while (cur != null && cur.val == dup) {
                    cur = cur.next;
                }
            } else {
                dummyCur.next = cur;
                dummyCur = dummyCur.next;
                cur = cur.next;
            }
            dummyCur.next = null;
        }

        return dummy.next;
    }
}
