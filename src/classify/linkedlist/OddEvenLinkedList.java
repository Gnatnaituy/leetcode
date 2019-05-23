package classify.linkedlist;

import others.tools.ListNode;

public class OddEvenLinkedList {

    /**
     * 0ms 100.00%
     * 36.4MB 99.14%
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode fast = head.next;
        ListNode slow = head;
        ListNode oddHead = head.next;

        while (fast != null && fast.next != null) {
            ListNode temp = fast.next;
            fast.next = temp.next;
            temp.next = oddHead;
            slow.next = temp;
            fast = fast.next;
            slow = slow.next;
        }

        return head;
    }
}
