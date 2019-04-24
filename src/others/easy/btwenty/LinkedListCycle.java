package others.easy.btwenty;

import others.tools.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141 Linked List Cycle
 *
 * Given a linked list, determine if it has a cycle in it.
 *
 * Follow up:
 * Can you solve it without using extra space?
 */

public class LinkedListCycle {

    private static boolean hasCycle(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }
}
