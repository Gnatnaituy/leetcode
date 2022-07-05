package classify.list;

import tools.ListNode;

public class MergeTwoSortedLists {

    /**
     * 0ms 100.0%
     * 38.6MB 61.15%
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode res = new ListNode(Math.min(list1.val, list2.val));
        res.next = list1.val < list2.val ? mergeTwoLists(list1.next, list2) : mergeTwoLists(list1, list2.next);

        return res;
    }

    /**
     * 0ms      100.00%
     * 38.4MB   69.92%
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        if (list1 != null) {
            cur.next = list1;
        }

        if (list2 != null) {
            cur.next = list2;
        }

        return dummy.next;
    }
}
