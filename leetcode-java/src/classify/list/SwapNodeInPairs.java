package classify.list;

import tools.ListNode;

public class SwapNodeInPairs {

    /**
     * 0ms      100.00%
     * 36.1MB   37.73%
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode second = head.next;
        ListNode third = head.next.next;
        head.next = swapPairs(third);
        second.next = head;

        return second;
    }

    /**
     * 0ms 100.00%
     * 33.6MB 100.00%
     */
    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(1, head);
        ListNode cur = dummy, first, second, third;

        while (cur.next != null && cur.next.next != null) {
            first = cur.next;
            second = first.next;
            third = second.next;

            cur.next = second;
            second.next = first;
            first.next = third;

            cur = cur.next.next;
        }

        return dummy.next;
    }
}
