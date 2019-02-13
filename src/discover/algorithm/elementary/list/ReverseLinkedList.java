package discover.algorithm.elementary.list;

import tools.ListNode;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        /*
        0ms
         */
        if (head == null) return null;

        ListNode cursor = head;
        while (cursor.next != null) {
            ListNode temp = cursor.next;
            cursor.next = temp.next;
            temp.next = head;
            head = temp;
        }

        return head;
    }
}
