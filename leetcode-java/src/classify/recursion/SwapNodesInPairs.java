package classify.recursion;

import tools.ListNode;

/**
 * @author yutiantang
 * @create 2021/4/6 22:36
 */
public class SwapNodesInPairs {

    /**
     * 0ms      100.00%
     * 36.1MB   37.73%
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode second = head.next;
        ListNode third = head.next.next;
        head.next = swapPairs(third);
        second.next = head;

        return second;
    }

    /**
     * 0ms      100.00%
     * 39.2MB   8.37%
     * @param  head 1->2->3->4->5
     * @return ListNode 2->1->4->3->5
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode cur = head, tempLeft = cur, tempRight;
        head = head.next;

        while (cur != null && cur.next != null) {
            tempRight = cur.next.next;

            tempLeft.next = cur.next;
            cur.next.next = cur;

            cur.next = tempRight;

            tempLeft = cur;
            cur = cur.next;
        }

        return head;
    }
}
