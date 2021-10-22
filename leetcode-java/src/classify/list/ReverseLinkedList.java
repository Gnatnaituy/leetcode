package classify.list;

import tools.ListNode;

public class ReverseLinkedList {

    /**
     * 0ms 100.00%
     * 35.8MB 99.82%
     */
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode res = new ListNode(head.val);

        head = head.next;
        while (head != null) {
            ListNode node = new ListNode(head.val);
            node.next = res;
            res = node;
            head = head.next;
        }

        return res;
    }
}
