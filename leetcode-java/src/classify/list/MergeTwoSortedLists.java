package classify.list;

import tools.ListNode;

public class MergeTwoSortedLists {

    /**
     * 0ms 100.0%
     * 38.6MB 61.15%
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode res = new ListNode(Math.min(l1.val, l2.val));
        res.next = l1.val < l2.val ? mergeTwoLists(l1.next, l2) : mergeTwoLists(l1, l2.next);

        return res;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        /*
        12ms 74.58%
        三个月前写的
         */
        if (l1 == null) return l2;
        else if (l2 == null) return l1;
        else return l1.val < l2.val ? innerMergeTwoLists(l1, l2) : innerMergeTwoLists(l2, l1);
    }

    private static ListNode innerMergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cursor = l1;
        while (l2 != null && cursor.next != null) {
            if (l2.val < cursor.next.val) {
                ListNode temp = new ListNode(l2.val);
                temp.next = cursor.next;
                cursor = cursor.next = temp;
                l2 = l2.next;
            } else {
                cursor = cursor.next;
            }
        }
        if (l2 != null) cursor.next = l2;

        return l1;
    }

    /**
     * 0ms      100.00%
     * 38.4MB   69.92%
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        /*
        9ms
         */
        ListNode res = new ListNode(0);
        ListNode curr = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 == null) {
            curr.next = l2;
        }
        if (l2 == null) {
            curr.next = l1;
        }
        return res.next;
    }
}
