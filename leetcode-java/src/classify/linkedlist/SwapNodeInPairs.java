package classify.linkedlist;

import tools.ListNode;

public class SwapNodeInPairs {

    /**
     * 0ms 100.00%
     * 33.6MB 100.00%
     */
    public ListNode swapPairs(ListNode head) {
        ListNode fakeHead = new ListNode(1);
        fakeHead.next = head;
        ListNode cur = fakeHead;

        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next;
            cur.next = cur.next.next;
            temp.next = cur.next.next;
            cur.next.next = temp;
            cur = cur.next.next;
        }

        return fakeHead.next;
    }
}
