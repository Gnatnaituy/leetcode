package others.easy.ctwenty;

import tools.ListNode;

/**
 * 203 Remove Linked List Elements
 *
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */

public class RemoveLinkedListElements {

    private static ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;

        head.next = removeElements(head.next, val);

        return head.val == val ? head.next : head;
    }
}
