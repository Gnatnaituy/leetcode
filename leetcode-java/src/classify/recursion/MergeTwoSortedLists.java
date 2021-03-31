package classify.recursion;

import tools.ListNode;

/**
 * @author yutiantang
 * @create 2021/3/31 22:04
 */
public class MergeTwoSortedLists {

    /**
     * 0ms      100.00%
     * 37.8MB   73.30%
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode bigger;
        if (l1.val < l2.val) {
            bigger = new ListNode(l1.val);
            bigger.next = mergeTwoLists(l1.next, l2);
        } else {
            bigger = new ListNode(l2.val);
            bigger.next = mergeTwoLists(l1, l2.next);
        }

        return bigger;
    }
}
