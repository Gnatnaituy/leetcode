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
        ListNode third = head.next.next;
        ListNode second = head.next;
        head.next = swapPairs(third);
        second.next = head;

        return second;
    }
}
