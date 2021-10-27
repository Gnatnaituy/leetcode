package classify.twopointers;

import tools.ListNode;

/**
 * @author yutiantang
 * @create 2021/10/27 18:20
 * 剑指 Offer 22. 链表中倒数第k个节点
 * https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 */
public class NthNodeFromEndOfList {

    /**
     * 0ms      100.00%
     * 36.4MB   8.00%
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = head;
        while (k-- > 0 && fast != null) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
