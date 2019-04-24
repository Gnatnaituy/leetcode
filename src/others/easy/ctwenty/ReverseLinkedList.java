package others.easy.ctwenty;

import others.tools.ListNode;

/**
 * 206 Reverse Linked List
 *
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

public class ReverseLinkedList {

    private static ListNode reverseList(ListNode head) {
        if (head == null)
            return null;

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
