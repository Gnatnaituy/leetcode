package classify.twopointers;

import tools.ListNode;

/**
 * @author yutiantang
 * @create 2021/10/27 18:14
 * 剑指 Offer 18. 删除链表的节点
 * https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 */
public class RemoveNodeFromList {

    /**
     * 0ms      100.00%
     * 37.9MB   39.09%
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        ListNode acc = new ListNode(0);
        acc.next = head;
        ListNode prev = acc, cur = head;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
                break;
            }
            prev = cur;
            cur = cur.next;
        }

        return acc.next;
    }
}
