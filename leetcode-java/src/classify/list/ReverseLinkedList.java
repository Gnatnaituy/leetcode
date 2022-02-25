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

    /**
     * 0ms      100.00%
     * 41.4M    5.60%
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode next = head.next, temp;
        head.next = null;
        while (next != null) {
            temp = next.next;
            next.next = head;
            head = next;
            next = temp;
        }

        return head;
    }
}
