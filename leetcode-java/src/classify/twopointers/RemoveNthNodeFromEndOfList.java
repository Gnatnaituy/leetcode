package classify.twopointers;

import tools.ListNode;

/**
 * @author yutiantang
 * @create 2021/3/28 4:44 PM
 */
public class RemoveNthNodeFromEndOfList {

    /**
     * 0ms      100.00%
     * 36.2MB   90.16%
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode preHead = new ListNode(0);
        preHead.next = head;
        ListNode fast = head;
        ListNode slow = preHead;
        while (n-- > 0) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return preHead.next;
    }
}
