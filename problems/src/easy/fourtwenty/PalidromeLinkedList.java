package easy.fourtwenty;

import easy.twotwenty.ListNode;

/**
 * 234 Palindrome Linked List
 *
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 *
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 */

public class PalidromeLinkedList {

    private static boolean isPalindrome(ListNode head) {

        if (head == null)
            return true;

        ListNode origin = new ListNode(head.val);
        ListNode originCursor = origin;
        ListNode headCursor = head.next;
        while (headCursor != null) {
            originCursor.next = new ListNode(headCursor.val);
            originCursor = originCursor.next;
            headCursor = headCursor.next;
        }

        ListNode cursor = head;

        while (cursor.next != null) {
            ListNode temp = cursor.next;
            cursor.next = temp.next;
            temp.next = head;
            head = temp;
        }

        while (origin != null) {
            if (origin.val != head.val)
                return false;
            origin = origin.next;
            head = head.next;
        }

        return true;
    }
}
