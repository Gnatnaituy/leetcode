package classify.twopoints;

import tools.ListNode;

import java.util.List;

/**
 * @author yutiantang
 * @create 2021/3/24 11:41 PM
 */
public class RotateList {

    /**
     * 1484ms   5.01%
     * 37.9MB   45.55%
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head;
        while (k > 0) {
            fast = fast.next == null ? head : fast.next;
            k--;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        ListNode newHead = slow.next == null ? head : slow.next;
        fast.next = head;
        slow.next = null;

        return newHead;
    }

    /**
     * 力扣官方题解
     * 0ms      100.00%
     * 38.2MB   5.11%
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight1(ListNode head, int k) {
        // base cases
        if (head == null) return null;
        if (head.next == null) return head;

        // close the linked list into the ring
        ListNode old_tail = head;
        int n;
        for(n = 1; old_tail.next != null; n++)
            old_tail = old_tail.next;
        old_tail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++)
            new_tail = new_tail.next;
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;
    }
}
