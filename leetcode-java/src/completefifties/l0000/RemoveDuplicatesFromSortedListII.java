package completefifties.l0000;

import tools.ListNode;

public class RemoveDuplicatesFromSortedListII {

    /**
     * 2ms 76.35%
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        if (head.val == head.next.val) {
            ListNode node = head.next;
            while (node != null && node.val == head.val) {
                node = node.next;
            }

            return deleteDuplicates(node);
        } else {
            head.next = deleteDuplicates(head.next);

            return head;
        }
    }


    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            if (cur.next != null && cur.val == next.val) {
                ListNode toBeDel = cur;
                while (toBeDel != null && toBeDel.val == cur.val) {
                    next = toBeDel.next;
                    toBeDel = next;
                }
                if (prev == null) {
                    head = next;
                } else {
                    prev.next = next;
                }
                cur = next;
            } else {
                prev = cur;
                cur = cur.next;
            }
        }

        return head;
    }
}
