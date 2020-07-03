package others.discover.datastructure.linkedlist;

import tools.ListNode;

public class OldEvenLinkedList {

    /**
     * 6ms 72.74%
     */
    public static ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            ListNode temp = slow.next;
            slow.next = fast.next;
            fast.next = fast.next.next;
            slow.next.next = temp;
            slow = slow.next;
            fast = fast.next;
        }

        return head;
    }

    /**
     * 3ms
     */
    public ListNode oddEvenList2(ListNode head) {
        if (head == null) return null;

        ListNode odd = head, even = head.next, evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            odd = odd.next;
            even.next = even.next.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }
}
