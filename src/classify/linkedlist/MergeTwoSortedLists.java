package classify.linkedlist;

import others.tools.ListNode;

public class MergeTwoSortedLists {

    /**
     * 0ms 100.0%
     * 38.6MB 61.15%
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode res = new ListNode(l1.val < l2.val ? l1.val : l2.val);
        res.next = l1.val < l2.val ? mergeTwoLists(l1.next, l2) : mergeTwoLists(l1, l2.next);

        return res;
    }
}
